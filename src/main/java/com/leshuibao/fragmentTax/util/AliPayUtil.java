package com.leshuibao.fragmentTax.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;

public class AliPayUtil {

    public static AlipayClient initAlipayClient() {

        String FORMAT = "json";
        String CHARSET = "UTF-8";
        String SIGN_TYPE = "RSA2";
        String APP_ID = PropertiesUtil.prop("app_id");
        String APP_PRIVATE_KEY = PropertiesUtil.prop("app_private_key");
        String ALIPAY_PUBLIC_KEY = PropertiesUtil.prop("alipay_public_key");
        String URL = PropertiesUtil.prop("alipay_url");

        AlipayClient alipayClient = new DefaultAlipayClient(URL,
                APP_ID,
                APP_PRIVATE_KEY,
                FORMAT,
                CHARSET,
                ALIPAY_PUBLIC_KEY,
                SIGN_TYPE);
        return  alipayClient;
    }


    public static String createFrom(AlipayClient alipayClient, String orderId, double price){

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
//        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址

        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":" + orderId  +
                ",    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + price +
                ",    \"subject\":\"发票订单\"," +
                "    \"body\":\"订单\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
//        httpResponse.setContentType("text/html;charset=" + CHARSET);
//        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
//        httpResponse.getWriter().flush();
//        httpResponse.getWriter().close();
    }

    public static String query(AlipayClient alipayClient, String orderId) throws AlipayApiException {
       AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":" + orderId +
                "  }");
        String response = "";
        try {
            response = alipayClient.execute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }

    public static void main(String[] args) throws AlipayApiException {

        AlipayClient alipayClient = initAlipayClient();

        String form1 = createFrom(alipayClient,"101010101", 43.90);

        String re = query(alipayClient, "101010101");

//        String appId = "2016092000557827";
//        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCQZDSue0tLZnDrjKSL2G8L6W9HT17pMshPhwNwV7e2PR3c8DMxf4G5kLRPsZsQV0f1UG0KvjUK6cKZ7LZjNVpnZyzdXM7pR5LVg8u2fGp7mFKgSven4KIWqMPy0bZpX9jcaPS33+0SZP91wZvbEAke+WxFZPUHYXbOAKWF/ByUN9RE4rvfulc890vbk9HqwWm9/1+TLYU8RKjN1N/iw+6LmSEZHwZyb18OmQeCdLOzOcC3Xl44wxRIEk5ERcOcQ+jfvondGPOQkK5JFjbcZRGOgb/xAwAAJf2kTc21oMIiWDcSEmODV2VsOa6SWYKlut+6mMX65AbUgXKBE2dfZRipAgMBAAECggEBAIUjwOf6TC1UYl7wKnHAunRTZQZuC2ggKVAbgHJAj+d8Z2LoIWxM1ENVSM4LSJ5CvNlYtZMoXCSZ85SXDn5gHeIm4tmi0C+OjbhPdLHp+w3IILgpKD8mBI+8QiJOeVKkzIRASxaZZjKF6oCca6gNGzvyZYF/W+jYWAIP2pC3LWsExO0iHZBPyloZWoeKLFDiLvISIuMNOmihQb9x5ACzWo9KP2O/7ztWI6+bie52Loefq+G1xV7FJN4w2P1l601lSpVEF4APLsNEr3k8vmdgB/sbGS+z8Om3m1um1wKcZlOctayEQyuUMoacdHxr9fT5KKGHWr4hY9/4dGvrVeFtLmECgYEAx1Mk/HjHTo5vvyCDGnKbUL3EyW9GvQs0gvmIeJp6Us3/Qzg4WD7TmxGPu3yNR25UAAueoeOg5IYaizfTmFHls/XHksxZKO7vya3/MptDksfnvY0cf7hvqoUpxc10+C39ownT3pPN4jqz7VgZRidYb6AuDDrNNjup4c3ahgecorUCgYEAuXJ2EQAEsCKL1Y65osH+dqf04v+uOsafgLZIEVvuBcXMkopBKfBQKykWtghK9HnGMbk9JIjw/wAocvKO7BRI6BlOixKnEsyWQ+OffreRUco01AH8cUskM5KhTdvwaKnXXazZtHnn9MyeM71ar6qbWaGDRQRRidp6XWWWssYxkqUCgYA6c+yNyZGRPP4SS6OG1wMrK2uRMvvIpoeQvULDM3IZ5GUuPkdvwYTmncDL15vKzdT+amnrycg+HAGewBFiQuoc2z/akei3s1JIj6keGyA25D7WfJJV9i1xEToN0tGxkjMmY9RpGmkvJc3sFYDb7N/nZE78sSXK+LY6DNc/pO3PXQKBgFwVJ+cdGTbUkJbEPg1BQrdsgr7Mspjg04a3/GUSPsiDBSemmuDWQRiNWIee6okmhnFeR6wCi5gzXeJl6u3yzJjjKAsKggdlqx+ewS3MvM3eGAlFyzH+W8V4A7yDf4aY/yW2lIt3FOSLTernFUaw8l65QlNc55gJ8kS6EvBGVYs5AoGBAISfWjS4IZb93O+VS4nveIcLoVgN8A+pNYN3d0GplP0y7OoiwLZdlzRhkRnfx/5BC6nPjY7DZhUDX1nJrbrVk6C53dTkpJ/RECqWu0959C6Rg2oRq+5x9rHtpFebypSWPqBi9GJySzSotWX67fujxxODg+8OIedXlHryNjmwbPRB";
//        String alipayPK = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
//                appId,privateKey,
//                "JSON","utf-8",alipayPK,
//                "RSA");
//
//        System.out.println(alipayClient);
//        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
//        request.setBizContent("{" +
//                "\"out_biz_no\":\"cx100121232143\"," +
//                "\"payee_type\":\"ALIPAY_USERID\"," +
//                "\"payee_account\":\"2088102176528141\"," +
//                "\"amount\":\"0.01\"," +
//                "\"payer_show_name\":\"沙箱环境\"," +
//                "\"payee_real_name\":\"wevitr8539@sandbox.com\"," +
//                "\"remark\":\"转账备注\"" +
//                "}");
//        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
    }
}
