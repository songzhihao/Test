package com.epsoft.efastpay.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import com.epsoft.efastpay.R;
import com.epsoft.efastpay.activity.LoginActivity;
import com.epsoft.efastpay.activity.OneKeyPayActivity;
import com.epsoft.efastpay.activity.TabsActivity;
import com.epsoft.efastpay.activity.myreport.MyReportListAllActivity;
import com.epsoft.efastpay.activity.reservation.MyReservationListActivity;
import com.epsoft.efastpay.infoclass.UserInfo;
import com.epsoft.efastpay.widget.TipDialog;
import org.json.JSONException;
import org.json.JSONObject;

//import me.drakeet.materialdialog.MaterialDialog;

public class DisplayUtil {



    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @param context

     * （DisplayMetrics类中属性density）
     * @return
     */
    private static final int TYPE_PAY = 0, TYPE_RESERVATION = 1,TYPE_LIST=-1;

    public static int pageType =2;
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue
     * @param context  （DisplayMetrics类中属性density）
     * @return
     */
    public static int dp2px(Context context, double dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                res.getDisplayMetrics());
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param context （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param context （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获得屏幕的宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获得屏幕的高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }


    public static boolean showTip(Context context, String result) {
        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("code")) {

                    if (json.getInt("code") == 2) {
                        showAlertDialog(context, json.getString("errorMsg"));
                        return false;
                    } else if (json.getInt("code") == 1) {
                        showAlert(context, json.getString("errorMsg"));
                        return false;
                    } else if (json.getInt("code") == -1) {
                        showErrorMsg(context, result);
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                // ToastHelper.showToast("");
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
        return false;

    }

    public static boolean showTipSync(Context context, String result) {

        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("code")) {

                    if (json.getInt("code") == 2) {
                        showAlertDialog(context, json.getString("errorMsg"));
                        return false;
                    } else if (json.getInt("code") == 1) {
                        showAlertSync(context, result);
                        return false;
                    } else if (json.getInt("code") == -1) {
                        showAlertSync(context, result);
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
        return false;

    }

    //点击“我知道了”，界面消失
    public static boolean showTipBill(Context context, String result) {
        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("code")) {

                    if (json.getInt("code") == 2) {
                        showAlertDialog(context, json.getString("errorMsg"));
                        return false;
                    } else if (json.getInt("code") == 1) {
                        showAlertBill(context, result);
                        return false;
                    } else if (json.getInt("code") == -1) {
                        showAlertBill(context, result);
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
        return false;

    }


    public static boolean showTipBillTwo(Context context, String result) {
        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("code")) {

                    if (json.getInt("code") == 2) {
                        showAlertDialog(context, json.getString("errorMsg"));
                        return false;
                    } else if (json.getInt("code") == 1) {
                        showAlertBill(context, result);
                        return false;
                    } else if (json.getInt("code") == -1) {
                        showErrorMsg(context, result);
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
        return false;

    }


    /**
     * 弹出立即登陆对话框
     *
     * @param context
     * @param tip
     */
    public static void showAlertDialog(final Context context, String tip) {
        if (!Constants.isload) {
            return;
        }
        if (TextUtils.isEmpty(tip)) {
            tip = context.getResources().getString(R.string.singal_login_tip);
        }
        Constants.isload = false;
        DialogHelp.getMessageDialog(context, tip, "立即登录", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                try {
                    Activity activity = (Activity) context;
                    //当activity来自于以下几个时，点击登陆的返回键直接返回到主页
                    if (activity instanceof MyReportListAllActivity || activity instanceof MyReportListAllActivity
                            ||activity instanceof OneKeyPayActivity
                            ) {
                        intent.putExtra("isToFirstPage", true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //说明是ApplicationContext
                }
                context.startActivity(intent);
                UserInfo.getInstance().setAutoLogin(false);
                Constants.isload = false;
                UserInfo.getInstance().saveUserInfo();
            }

        }).setTitle("提示")
                .show();

    }

    /**
     * @param context
     * @param error
     */
    public static void showAlert(final Context context, String error) {
        if (TextUtils.isEmpty(error) || error.equals("null")) {
            error = "系统繁忙，请稍后重试";
        } else {
            if (error.contains("请先登录") || error.contains("密码可能已泄露")) {
                return;
            }
            error = error.replace("null", "");

        }
        DialogHelp.getMessageDialog(context, error, "我知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                errMesgStartActiviy(context);
            }
        }).setTitle("温馨提示")
                .show();
    }


    /**
     * @param context
     * @param result
     */
    public static void showAlertSync(final Context context, String result) {
        String errormsg = null, errorcode = null;
        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("errorMsg")) {
                    errormsg = json.getString("errorMsg");
                    if (errormsg.contains("请先登录") || errormsg.contains("密码可能已泄露")) {
                        return;
                    }
                    if (json.has("errorCode")) {
                        errorcode = json.getString("errorCode");
                    }
                    if (TextUtils.isEmpty(errormsg) || errormsg.equals("null")) {
                        if (TextUtils.isEmpty(errorcode) || "null".equals(errorcode)) {
                            errormsg = "系统繁忙，请稍后重试";
                        } else {
                            errormsg = "系统繁忙，请稍后重试" + "[" + errorcode + "]";
                        }
                    } else {
                        if (!TextUtils.isEmpty(errorcode) && !"null".equals(errorcode)) {
                            errormsg = errormsg + "[" + errorcode + "]";
                        }
                    }

                } else {
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            errormsg = "接口返回result为空";
        }
        DialogHelp.getMessageDialog(context, errormsg, "我知道了", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //消息错误时才能跳转页面,不等于2时才调用此处的逻辑，因为只有去过一键支付页面才修改过其值
                errMesgStartActiviy(context);
            }
        }).setTitle("温馨提示")
                .show();
    }
    /**
     *
     *消息错误时才能跳转页面,不等于2时才调用此处的逻辑，因为只有去过一键支付页面才修改过其值
     * 一键支付见面才能进去，因为里面DisplayUtil.pageType被修改
     */

   /* private static void errMesgStartActiviy(Context context) {
        if (DisplayUtil.pageType != 2) {
            Intent intent = new Intent();
            if (DisplayUtil.pageType == TYPE_PAY) {
                //跳转到首页，我的账单页面
                //intent.setClass(context, TabsActivity.class);
                intent.setClass(context, MyBillActivity.class);
                //intent.putExtra("value",2);
            } else if (DisplayUtil.pageType == TYPE_RESERVATION) {
                intent.setClass(context, TabsActivity.class);
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
            //之后恢复原值
            DisplayUtil.pageType=2;
        }
    }*/
    private static void errMesgStartActiviy(Context context) {
        if (DisplayUtil.pageType != 2) {
            Intent intent = new Intent();
            if (DisplayUtil.pageType == TYPE_PAY) {
                //首页之我的账单
                intent.setClass(context, TabsActivity.class);
                intent.putExtra("value",2);
            } else if (DisplayUtil.pageType == TYPE_RESERVATION) {
                intent.setClass(context, TabsActivity.class);
            }else if (DisplayUtil.pageType == TYPE_LIST) {
                //我的挂号单列表
                intent.setClass(context, MyReservationListActivity.class);
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
            //之后恢复原值
            DisplayUtil.pageType=2;
        }
    }

    /**
     * @param context
     * @param result
     */
    public static void showAlertBill(final Context context, String result) {
        String errormsg = null, errorcode = null;
        if (!TextUtils.isEmpty(result)) {
            try {
                JSONObject json = new JSONObject(result);
                if (json.has("errorMsg")) {
                    errormsg = json.getString("errorMsg");
                    if (errormsg.contains("请先登录") || errormsg.contains("密码可能已泄露")) {
                        return;
                    }
                    if (json.has("errorCode")) {
                        errorcode = json.getString("errorCode");
                    }

                    if (TextUtils.isEmpty(errormsg) || errormsg.equals("null")) {


                        if (TextUtils.isEmpty(errorcode) || "null".equals(errorcode)) {
                            errormsg = "系统繁忙，请稍后重试";
                        } else {
                            errormsg = "系统繁忙，请稍后重试" + "[" + errorcode + "]";
                        }
                    } else {
                        if (!TextUtils.isEmpty(errorcode) && !"null".equals(errorcode)) {
                            errormsg = errormsg + "[" + errorcode + "]";
                        }
                    }

                } else {
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            errormsg = "接口返回result为空";
        }
        DialogHelp.getMessageDialog(context, errormsg, "我知道了", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ((Activity) context).finish();
                //错误时跳转
                errMesgStartActiviy(context);
            }
        }).setTitle("温馨提示")
                .show();
    }


    public void showTipDialog(Context context, String error) {
        if (TextUtils.isEmpty(error)) {
            new TipDialog(context, R.style.DefaultDialogStyle, "系统繁忙，请稍后重试").show();
        } else {
            new TipDialog(context, R.style.DefaultDialogStyle, error).show();
        }

    }

    public static void showErrorMsg(Context context, String result) {
        if (!TextUtils.isEmpty(result)) {
            try {
                String errormsg = null, errorcode = null;
                JSONObject json = new JSONObject(result);
                if (json.has("errorMsg")) {
                    errormsg = json.getString("errorMsg");
                    if (json.has("errorCode")) {
                        errorcode = json.getString("errorCode");
                    }
                    if (TextUtils.isEmpty(errormsg) || errormsg.equals("null")) {
                        if (TextUtils.isEmpty(errorcode) || "null".equals(errorcode)) {
                            ToastHelper.showToast("系统繁忙，请稍后重试");
                        } else {
                            ToastHelper.showToast("系统繁忙，请稍后重试" + "[" + errorcode + "]");
                        }
                    } else {
                        if (TextUtils.isEmpty(errorcode) || "null".equals(errorcode)) {
                            ToastHelper.showToast(errormsg);
                        } else {
                            ToastHelper.showToast(errormsg + "[" + errorcode + "]");
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            ToastHelper.showToast("接口返回result为空");
        }

    }
    //toast错误弹出
    public static boolean ToastErrorMsg(String result) {
        try {
            JSONObject json = new JSONObject(result);
            if (json.has("code")) {
                if (json.getInt("code") == 0) {
                    return false;
                } else {
                    ToastHelper.showToast(json.getString("errorMsg"));
                    return true;
                }
            }
        } catch (JSONException e) {
            ToastHelper.showToast("系统繁忙，稍后重试");
            e.printStackTrace();
            return true;
        }
        ToastHelper.showToast("系统繁忙，稍后重试");
        return true;
    }
}
