package com.epsoft.efastpay.utils;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.Html;
import android.text.Spanned;

public class StringUtil {
	public static final boolean isNullOrEmpty(String str) {
		return str == null || "".equals(str);
	}
	
	public static final boolean isNullOrWhiteSpace(String str) {
		return str == null || "".equals(str.trim());
	}
	
	public static final String getEmptyOrSrc(String src) {
		return isNullOrEmpty(src) ? "分享" : src;
	}
	

	public static final Spanned fromHttpToString(String str) {
//		return Html.fromHtml("<html><span>" + str.replace("<", "&lt;") + "</span></html>");
		return Html.fromHtml("<html>" + str.replace("<", "&lt;") + "</html>");
	}


	public static final String StringFromHtml(String str) {
		return Html.fromHtml(str).toString();
	}
	
	public static final Spanned SpanFromHtml(String str) {
		return Html.fromHtml(str);
	}
	
	public static final String convertToPercentNum(double d){
		NumberFormat num = NumberFormat.getPercentInstance(); 
		num.setMaximumIntegerDigits(3); 
		num.setMaximumFractionDigits(2); 
		return num.format(d);
	}
	
	 /**
     * 判断输入的是否为手机号码，判断规则为：11位且全为数字并且第一位数字为1
     * 
     * @param number 输入的内容
     * @return true:是手机号码, false:不是手机号码
     */
    public static boolean isPhoneNumber(String number)
    {
        if (number.length() != 11 || '1' != number.charAt(0)){
            return false;
        } else {
            for (int i = 0; i < 11; i++)
            {
                if (number.charAt(i) > '9' || number.charAt(i) < '0')
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isEmailFormat(String email) {
    	String style =
    			 "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern ptt = Pattern.compile(style);
        Matcher mch=ptt.matcher(email);
        if ((email == null || email.equals(""))) {
        	return false;
        } else if (!mch.matches()) {
           return false;
        }
        return true;
    }

    /**
     * 拼接用户头像地址
     * @param pic
     * @return
     */
    public static String initUserPic(String pic) {
    	if(pic.contains("http://")){
    		return pic;
    	}
    	final String userPic = "http://file.ihou.com/img/Avatar/%s_120.jpg";
    	return String.format(userPic, pic);
    }	

    /**
     * 判断记录时间是否失效
     * @param time
     * @param limitTime
     * @return
     */
	public static boolean judgeRecordTimeInterval(String time,long limitTime) {
		if (null != time) {
			if ((System.currentTimeMillis() - Long.valueOf(time) < limitTime)) {
				return false;
			}
		}
		return true;
	}
	
	public static long StringToTimestamp(String user_time){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date d;
		try {
			d = sdf.parse(user_time);
			return d.getTime();
		} catch (ParseException e) {
			return 0;
		}
	}
	
	public static String getFileNameByTimestamp() {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String path = "image" + sDateFormat.format(new java.util.Date());
		File file = new File(path);
		if(file.exists()){
			file.delete();
			file = null;
		}
		return path;
	}
	
	/**
     * 从短信内容中提取出验证码以及校验码
     * 
     * @param message 短信内容
     * @return 验证码和校验码
     */
    public static String[] getIdentifyingCode(String message)
    {
        boolean hasFindNum = false;
        String[] numbers = new String[2];
        numbers[0] = "";
        numbers[1] = "";
        message = message.trim();
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) >= '0' && message.charAt(i) <= '9')
            {
                numbers[0] += message.charAt(i);
                hasFindNum = true;
            }
            else if (hasFindNum)
            {
                hasFindNum = false;
                break;
            }
        }

        int length = 0;
        int index = 0;
        for (int j = message.length() - 1; j > 0; j--)
        {
            if (message.charAt(j) >= '0' && message.charAt(j) <= '9')
            {
                index = j;
                length++;
                hasFindNum = true;
            }
            else if (hasFindNum)
            {
                numbers[1] = message.substring(index,
                    index + length);
                break;
            }
        }
        return numbers;
    }
    
    public static boolean isPinyin(String reg){
    	boolean flag = true;
    	if(!StringUtil.isNullOrWhiteSpace(reg)){
    		char pinyin[] = reg.toCharArray();
    		for(int i=0;i<pinyin.length;i++){
    			if(!(pinyin[i] >= 'A' && pinyin[i] <='z')){
    				flag = false;
    				break;
    			}
    		}
    	}else{
    		flag = false;
    	}
    	return flag;
    }
    
    /**
     * 新房和二手房3G页面添加参数app=1，屏蔽不需要的东西
     * @param url
     * @return
     */
    public static String getMobileUrl(String url){
    	if(!isNullOrEmpty(url)){
    		if(url.indexOf("?") != -1){
    			url = url+"&app=1";
    		}else{
    			url = url+"?app=1";
    		}
    	}
    	return url;
    }
    
    /**
     * 获取从相册读取图片的图片名称
     * @param path
     * @return
     */
    public static String getAlbumFileName(String path){
    	if(null == path) return null;
    	File tmpFile = new File(path.trim());
    	String name = tmpFile.getName();
    	if(name.contains(".")){
    		name = name.substring(0, name.lastIndexOf("."));
    	}
    	if(isNullOrEmpty(name)) return tmpFile.getName();
    	return name;
    }
    
    public static long parseLongStr(String str){
    	long value = -1;
    	try{
    		value = Long.parseLong(str);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return value;
    }
    
    public static double parseDoubleStr(String str){
    	double value = -1;
    	try{
    		value = Double.parseDouble(str);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return value;
    }
    
    public static int parseIntStr(String str){
    	int value = -1;
    	try{
    		value = Integer.parseInt(str);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return value;
    }
    
    public static float parseFloatStr(String str){
    	float value = 0;
    	try{
    		value = Float.parseFloat(str);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return value;
    }
    
    public static String getCode(String code){
    	if (!StringUtil.isNullOrEmpty(code) && code.length() == 12) {
			if (code.length() == 12) {
				return code.substring(0, 4)+" "+code.substring(4, 8)+" "+code.substring(8, 12);
			} else {
				return code;
			}
		} else {
			return "";
		}
    }
}
