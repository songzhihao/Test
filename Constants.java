package com.epsoft.efastpay.utils;

import com.epsoft.efastpay.R;

public class Constants {
	/**
	 * true为已登录，false为未登录
	 */
	public static boolean isload = false;
    public static boolean pay = false;
	public static final int RESULT_OK = 0;
	/** 消息类型：获取验证码倒计时 */
	public static final int VERIFICATION_CODE_COUNTDOWN = 0;

	public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	
//	public static final String ACTION_SINGAL_LOGIN_SERVICE = "com.epsoft.efastpay.activity.SingalLoginService";

	public enum SystemMessageType {
		UN_PAY_NOTIFICATION("账单缴费提醒", R.drawable.icon_message_1), 
		PAY_SUCCESS_NOTIFICATION("账单付款成功", R.drawable.icon_message_2), 
		CARD_INSERT_NOTIFICATION("社保卡插卡提醒",R.drawable.icon_message_2),
		CHECK_ORDER_NOTIFICATION("检查预约提醒", R.drawable.icon_message_3);

		SystemMessageType(String name, int id) {
			_name = name;
			_id = id;
		}

		private String _name;
		private int _id;

		public String getName() {
			return _name;
		}

		public int getId() {
			return _id;
		}

		public static SystemMessageType getSystemMessageType(int value) {
			switch (value) {
			case 0:
				return SystemMessageType.UN_PAY_NOTIFICATION;
			case 1:
				return SystemMessageType.PAY_SUCCESS_NOTIFICATION;
			case 2:
				return SystemMessageType.CHECK_ORDER_NOTIFICATION;
			default:
				return SystemMessageType.UN_PAY_NOTIFICATION;
			}
		}
	}

	public enum AgeBrgdType {
		AGE0TO16("0-16岁", R.drawable.si_card_green_bg), AGE17TO69("17-69岁",
				R.drawable.si_card_blue_bg), AGE70ABOVE("70及以上",
				R.drawable.si_card_gray_bg);

		AgeBrgdType(String name, int id) {
			_name = name;
			_id = id;
		}

		private String _name;
		private int _id;

		public String getName() {
			return _name;
		}

		public int getId() {
			return _id;
		}

		public static int getBrgdByAge(int age) {
			return getType(age).getId();
		}

		public static AgeBrgdType getType(int age) {
			if (age >= 0 && age <= 16)
				return AgeBrgdType.AGE0TO16;
			else if (age >= 17 && age <= 69)
				return AgeBrgdType.AGE17TO69;
			else if (age >= 70)
				return AgeBrgdType.AGE70ABOVE;
			else
				return AgeBrgdType.AGE0TO16;
		}
	}

//	public enum IndexAgeBrgdType {
//		AGE0TO16("0-16岁", R.drawable.bg_green), AGE17TO69("17-69岁",
//				R.drawable.bg_blue), AGE70ABOVE("70及以上", R.drawable.bg_yellow);
//
//		IndexAgeBrgdType(String name, int id) {
//			_name = name;
//			_id = id;
//		}
//
//		private String _name;
//		private int _id;
//
//		public String getName() {
//			return _name;
//		}
//
//		public int getId() {
//			return _id;
//		}
//
//		public static int getBrgdByAge(int age) {
//			return getType(age).getId();
//		}
//
//		public static IndexAgeBrgdType getType(int age) {
//			if (age >= 0 && age <= 16)
//				return IndexAgeBrgdType.AGE0TO16;
//			else if (age >= 17 && age <= 69)
//				return IndexAgeBrgdType.AGE17TO69;
//			else if (age >= 70)
//				return IndexAgeBrgdType.AGE70ABOVE;
//			else
//				return IndexAgeBrgdType.AGE0TO16;
//		}
//	}

	public static final String APK_DOWNLOAD_URL = "";

}
