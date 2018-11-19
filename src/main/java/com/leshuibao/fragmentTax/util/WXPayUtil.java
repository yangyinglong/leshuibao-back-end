package com.leshuibao.fragmentTax.util;

import com.alibaba.fastjson.JSON;
import com.google.zxing.WriterException;
import jxl.demo.XML;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.DefaultDocument;
import sun.security.provider.MD5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.leshuibao.fragmentTax.util.XMLUtil.map2xml;

public class WXPayUtil {

    /**
     * 生成签名
     * @return
     */
    public static String CreateUnifiedOrderSign(String appId, String mchId, String nonceStr, String timeStamp, String productId, String key, String spbillCreateIP, String notifyUrl, String tradeType, String body, double titalFee){

        String sign = "appId=" + appId +
                "&body=" + body +
                "&mchId=" + mchId +
                "&nonceStr=" + nonceStr +
                "&notifyUrl" + notifyUrl +
                "&productId" + productId +
                "&spbillCreateIP=" + spbillCreateIP +
                "&timeStamp=" + timeStamp +
                "&titalFee=" + titalFee +
                "&tradeType=" + tradeType +
                "&key=" + key;
        sign = MDUtil.jdkMD5(sign);
        return sign;
    }

    public static String CreateQueryOrderSign(String appId, String mchId, String nonceStr, String productId, String key){

        String sign = "appId=" + appId +
                "&mchId=" + mchId +
                "&nonceStr=" + nonceStr +
                "&productId" + productId +
                "&key=" + key;
        sign = MDUtil.jdkMD5(sign);
        return sign;
    }

    /**
     * 根据信息生成微信支付的请求参数 xml 格式
     */
    public static String getParas(String body,
                                     String productId,
                                     double titalFee) throws IOException, WriterException, DocumentException {

        Map<String, Object> paras = new HashMap<>();

        String appId = PropertiesUtil.prop("wx_pay_app_id");
        String mchId = PropertiesUtil.prop("wx_pay_mch_id");
        String nonceStr = UUIDUtil.RBase(UUIDUtil.BASECHAR, 10);
        String timeStamp = DateUtil.getSysDatetimeString();
        String key = PropertiesUtil.prop("wx_pay_key");
        String spbillCreateIP = PropertiesUtil.prop("wx_pay_spbill_create_ip");
        String notifyUrl = PropertiesUtil.prop("wx_pay_notify_url");
        String tradeType = "NATIVE";
        String sign = CreateUnifiedOrderSign(appId, mchId, nonceStr, timeStamp, productId, key, spbillCreateIP, notifyUrl, tradeType, body, titalFee);

        paras.put("appid", appId);
        paras.put("mch_id", mchId);
        paras.put("nonce_str", nonceStr);
        paras.put("sign", sign);
        paras.put("body", body);
        paras.put("out_trade_no", productId);
        paras.put("total_fee", titalFee);
        paras.put("spbill_create_ip", spbillCreateIP);
        paras.put("notify_url", notifyUrl);
        paras.put("trade_type", tradeType);

        Document doc = map2xml(paras, "xml");
        System.out.println(XMLUtil.formatXml(doc));

        return XMLUtil.formatXml(doc);



//        System.out.println(WXPayUrl);
//        QRUtil.createQrCode(PropertiesUtil.prop("qr_code_path")+productId+".jpg", WXPayUrl, 4900);
    }

    /**
     *  请求头
     * @return
     */
    private static Map<String, String> getHeaders() {

        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type","application/xml");

        return headers;
    }

    public static Map<String, Object> postWxApi(String body,
                                String productId,
                                double titalFee) throws DocumentException, IOException, WriterException {
        Map<String, Object > resp = new HashMap<>();
        String apiUrl = PropertiesUtil.prop("wx_pay_url");
        String returnXml = HttpUtils.doPost(apiUrl, getHeaders(), getParas(body, productId, titalFee));
        Map<String, Object> map = XMLUtil.xml2mapWithAttr(returnXml, true);
        Map<String, String> xmlMap = (Map)map.get("xml");
        if (xmlMap.get("return_code").equals("FAIL")) {
            resp.put("c", 201);
            resp.put("r", xmlMap.get("return_msg"));
            return resp;
        } else {
            if (xmlMap.get("result_code").equals("FALL")) {
                resp.put("c", 202);
                resp.put("r", xmlMap.get("err_code"));
                return resp;
            } else {
                resp.put("c", 200);
                resp.put("r", xmlMap.get("code_url"));
                return resp;
            }
        }
    }





    public static void main(String[] args) throws IOException, WriterException, DocumentException {
//        String apiUrl = PropertiesUtil.prop("wx_pay_url");
////        CreateWXPayQR("乐税宝", "0000001", 0.01);
//        String postString = HttpUtils.doPost(apiUrl, getHeaders(), getParas("乐税宝", "0000001", 0.01));
//        System.out.println(postString);
        System.out.println(postWxApi("乐税宝", "0000001", 0.01));
//        Map<String, Object> resp = postWxApi("乐税宝", "0000001", 0.01);
    }
}
