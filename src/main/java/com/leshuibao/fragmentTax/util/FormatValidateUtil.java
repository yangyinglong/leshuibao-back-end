package com.leshuibao.fragmentTax.util;

import java.io.IOException;
import java.util.regex.Pattern;

public class FormatValidateUtil {

    /**
     * 手机号码验证
     *
     * @param mobileNo
     * @return 验证通过返回true
     */
    public static boolean IsMobileNo(String mobileNo) {
        return Pattern
                .compile("^(0?1[3,4,5,7,8])\\d{9}$")
                .matcher(mobileNo.replace("-", ""))
                .matches();

    }

    /**
     * 固定电话号码验证
     *
     * @param telephoneNo
     * @return 验证通过返回true
     */
    public static boolean IsTelephoneNo(String telephoneNo) {

        return Pattern
                .compile("^((010|02\\d|0[3-9]\\d{2})\\W)?[1-9]\\d{6,7}(\\W\\d{1,9})?$")
                .matcher(telephoneNo)
                .matches();
    }

    public static void main(String[] args) throws IOException {

        System.out.println(FormatValidateUtil.IsMobileNo("12016155153"));
        System.out.println(FormatValidateUtil.IsMobileNo("13345697895"));
        System.out.println(FormatValidateUtil.IsMobileNo("013345697895"));
        System.out.println(FormatValidateUtil.IsTelephoneNo("12016155153"));
        System.out.println(FormatValidateUtil.IsTelephoneNo("021-2149568"));
        System.out.println(FormatValidateUtil.IsTelephoneNo("021-2149568-009"));
        System.out.println(FormatValidateUtil.IsTelephoneNo("411111111"));
        System.out.println(FormatValidateUtil.IsTelephoneNo("2149568"));

    }

}
