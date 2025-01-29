package com.example.loginapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyValidator {

    public  static String mobileRegex="^[6-9]\\d{9}$";
    public static boolean isValidName(String name)
    {
        if(name!=null && !name.isBlank() && name.length()>1)
        {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isValidMobile(String mobile)
    {


        Pattern pattern=Pattern.compile(mobileRegex);
        Matcher matcher=pattern.matcher(mobile);

        return matcher.matches();
    }

}
