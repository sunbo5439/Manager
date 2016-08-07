package cn.pku.meizi.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunbo on 16/6/18.
 */
class TelphoneCheck {
    public static boolean check(String phonenumber)
    {
        String phone = "1\\d{10}";
        Pattern p = Pattern.compile(phone);
        Matcher m = p.matcher(phonenumber);
        return m.matches();
    }
}
