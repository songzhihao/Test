package com.epsoft.efastpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.umeng.analytics.AnalyticsConfig;

/**
 * Created by xielingyong on 16/3/30.
 */
public class YkfConfig {
	/**
	 * 获取当前版本号
	 * @param mContext
	 * @return
	 * @throws Exception
	 */
	public static String getVersionName(Context mContext){
		// 获取packagemanager的实例
		PackageManager packageManager = mContext.getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = null;
		try {
			packInfo = packageManager.getPackageInfo(mContext.getPackageName(),0);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		String version = packInfo.versionName;
		return version;
	}

	/**
	 * 获取 versionCode
	 * @param context
	 * @return
	 */
	public static String getVersionCode(Context context){
		String versionCode=null;
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);

			versionCode= String.valueOf(info.versionCode);

		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionCode;
	}

	/**
	 * 获取渠道ID
	 * @param context
	 * @return
	 */
	public static String getChannelNo(Context context){
		String channel = AnalyticsConfig.getChannel(context);
		return channel;
	}
}
