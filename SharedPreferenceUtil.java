package com.epsoft.efastpay.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author aiisen(http://www.aiisen.com)
 * @version 1.0
 * @created 2014-3-15
 */
public class SharedPreferenceUtil {
	private SharedPreferences sp;

	private SharedPreferences.Editor editor;

	private String last_update_date_undo;

	private String last_update_date_hasdo;

	private String shop_status;

	public SharedPreferenceUtil(Context context, String key) {
		sp = context.getSharedPreferences(key, context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// 用户的ID
	public void setUser_id(String user_id) {
		editor.putString("user_id", user_id);
		editor.commit();
	}

	public String getUser_id() {
		return sp.getString("user_id", "");
	}

	// 用户的密码
	public void setPasswd(String passwd) {
		editor.putString("passwd", passwd);
		editor.commit();
	}

//	// 判断Notification
//	public void setNotification(boolean flag) {
//		editor.putBoolean("notification", flag);
//		editor.commit();
//	}

	// 获取Notification
	public boolean getNotification() {
		return sp.getBoolean("notification",true);
	}

	public String getPasswd() {
		return sp.getString("passwd", "");
	}

	/**
	 * 登陆用户名称
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		editor.putString("username", username);
		editor.commit();
	}

	public String getUsername() {
		return sp.getString("username", "");
	}

	// 用户的昵称
	public String getName() {
		return sp.getString("name", "");
	}

	public void setName(String name) {
		editor.putString("name", name);
		editor.commit();
	}

	// 用户的邮箱
	public String getEmail() {
		return sp.getString("email", "");
	}

	public void setEmail(String email) {
		editor.putString("email", email);
		editor.commit();
	}

	// 用户自己的头像
	public Integer getImg() {
		return sp.getInt("img", 0);
	}

	public void setImg(int i) {
		editor.putInt("img", i);
		editor.commit();
	}

	// 通知请求时间
	public void setNoticeOrderTime(String noticeOrderTime) {
		editor.putString("noticeordertime", noticeOrderTime);
		editor.commit();
	}

	public String getNoticeOrderTime() {
		return sp.getString("noticeordertime", "");
	}

	// 是否在后台运行标记
	public void setIsStart(boolean isStart) {
		editor.putBoolean("isStart", isStart);
		editor.commit();
	}

	public boolean getIsStart() {
		return sp.getBoolean("isStart", false);
	}

	// 是否第一次运行本应用
	public void setIsFirst(boolean isFirst) {
		editor.putBoolean("isFirst", isFirst);
		editor.commit();
	}

	public boolean getisFirst() {
		return sp.getBoolean("isFirst", true);
	}

	public String getLast_update_date_undo() {
		return sp.getString("last_update_date_undo", "");
	}

	public void setLast_update_date_undo(String last_update_date_undo) {
		editor.putString("last_update_date_undo", last_update_date_undo);
		editor.commit();
	}

	public String getLast_update_date_hasdo() {
		return sp.getString("last_update_date_hasdo", "");
	}

	public void setLast_update_date_hasdo(String last_update_date_hasdo) {
		editor.putString("last_update_date_hasdo", last_update_date_hasdo);
		editor.commit();
	}

	public String getShop_status() {
		return sp.getString("shop_status", "");
	}

	public void setShop_status(String shop_status) {
		editor.putString("shop_status", shop_status);
		editor.commit();
	}

}
