package com.epsoft.efastpay.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.net.wifi.ScanResult;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.epsoft.efastpay.application.EPayApplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static Dialog dialog;
    private static Context context = null;

    public static void showToast(Context cont, String msg) {
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context cont, int msg) {
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context cont, String msg, int time) {
        Toast.makeText(cont, msg, time).show();
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy年MM月dd日");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    public static String getNowDateMouth() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "MM");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowDateTwo() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowDatethree() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    @SuppressLint("SimpleDateFormat")
    public static String getNowDateFour() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * @param sourDateFormat 要转换成的日期格式
     * @param sourDate       要转换的日期
     * @return
     */

    @SuppressLint("SimpleDateFormat")
    public static String getDateFormat(String sourDateFormat, String sourDate) {
        // 分析从 ParsePosition 给定的索引处开始的文本。如果分析成功，则将 ParsePosition
        // 的索引更新为所用最后一个字符后面的索引
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sourDateFormat);
        Date dateValue = simpleDateFormat.parse(sourDate, position);
        String returnString = simpleDateFormat.format(dateValue);
        return returnString;
    }


    public static String transferLongToDate(String dateFormat, long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * @param str 需要转换的日期 转换成 yyyy-MM-dd HH:mm
     * @return
     */
    public static String StrToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }


    public static String StrToDateFive(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("format");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String longToDateStr1(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sd = sdf.format(new Date(date));
        return sd;
    }


    public static String StrToDateYear(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String getNowDateYear() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    public static String getCurrentTimeStr() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * @param str 需要转换的日期 转换成 yyyy-MM-dd HH:mm
     * @return
     */
    public static String StrToDatetwo(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String StrToDateFour(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd日 HH:mm");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String StrToDatethree(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String StrToDatetwoSix(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String StrToDatetwoSeven(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }

    public static String StrToDatehour(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String sd = sdf.format(new Date(Long.parseLong(str)));
        return sd;
    }


    /**
     * 检测SD卡是否可用
     *
     * @return
     */
    public static boolean isExternalStorageAvailable() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 对数据list进行排序
     */
    @SuppressWarnings("rawtypes")
    public static void sort_list(List<ScanResult> list) {
        Comparator comp = new Comparator() {
            public int compare(Object o1, Object o2) {
                ScanResult p1 = (ScanResult) o1;
                ScanResult p2 = (ScanResult) o2;
                if (Math.abs(p1.level) < Math.abs(p2.level))
                    return 1;
                else if (Math.abs(p1.level) > Math.abs(p2.level))
                    return -1;
                return 0;
            }
        };
        Collections.sort(list, comp);
    }

    public static String encodeJSON(Object src) throws JsonSyntaxException {
        Gson gson = new Gson();
        return gson.toJson(src);
    }
    //解析json
    public static <T> T decodeJSON(String jsonString, Class<T> cls)
            throws JsonSyntaxException {
        Gson gson = new Gson();
        T model = gson.fromJson(jsonString, cls);
        return model;
    }

    public static <T> T decodeJSON(String jsonString, Type typeOfT)
            throws JsonSyntaxException {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, typeOfT);
    }

    /**
     * 检测输入的是否是手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (TextUtils.isEmpty(mobiles)){
            return false;
        }
        Pattern p = Pattern
                .compile("^((13[0-9])|(14[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断身份证号码是否有效
     *
     * @param IDStr
     * @return
     * @throws ParseException
     */
    public static String iDCardValidate(String IDStr) {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4",
                "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2"};
        String Ai = "";
        if (IDStr.equals("")) {
            errorInfo = "身份证号码不得为空";
            return errorInfo;
        }
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (!isNumeric(Ai)) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (!isDate(strYear + "-" + strMonth + "-" + strDay)) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围。";
                return errorInfo;
            }
        } catch (NumberFormatException | java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (!Ai.equals(IDStr)) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }

    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        return m.matches();
    }

    public static int getAgeByIdCardNo(String idCardNo) {
        if (TextUtils.isEmpty(idCardNo))
            return 0;
        Calendar c = Calendar.getInstance();
        int current_year = c.get(Calendar.YEAR);
        String year_str = "0";
        if (idCardNo.length() == 18)// 342401198805128218
            year_str = idCardNo.substring(6, 10);
        else if (idCardNo.length() == 15) {
            year_str = idCardNo.substring(6, 7);// 130503670401001
            year_str = "19" + year_str;
        }
        int year = Integer.parseInt(year_str);
        return current_year - year;
    }

    /**
     * 是否连接网络
     *
     * @param pContext
     * @return
     */
    public static boolean isConnectInternet(Context pContext) {
        ConnectivityManager conManager = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
//return true;
    }

    private static Context getContext() {
        if (context == null) {
            context = EPayApplication.getAppContext();
        }
        return context;
    }

    public static String getIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imei = "";
        imei = telephonyManager.getDeviceId();
        return imei;
    }

    public static void writeSerializableObject(Object object, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(
                    EPayApplication.APP_PATH + filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readSerializableObject(String filename) {
        try {
            FileInputStream fs = new FileInputStream(EPayApplication.APP_PATH + filename);
            ObjectInputStream ois = new ObjectInputStream(fs);
            Object object = ois.readObject();
            ois.close();
            return object;
        } catch (Exception ex) {
            return null;
        }
    }

    public static int dayForWeek(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tmpDate = null;
        try {
            tmpDate = format.parse(pTime);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(tmpDate);
//        cal.set(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());
//        int i = cal.get(Calendar.DAY_OF_WEEK);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
   
}
