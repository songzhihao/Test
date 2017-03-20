package com.epsoft.efastpay.utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import com.afollestad.materialdialogs.AlertDialogWrapper;

/**
 * 对话框辅助类
 * Created by gene
 *  on 15/6/19.
 */
public class DialogHelp {

    /***
     * 获取一个dialog
     * @param context
     * @return
     */
    public static AlertDialogWrapper.Builder getDialog(Context context) {
        AlertDialogWrapper.Builder builder = new AlertDialogWrapper.Builder(context);
        return builder;
    }

    /***
     * 获取一个耗时等待对话框
     * @param context
     * @param message
     * @return
     */
    public static ProgressDialog getWaitDialog(Context context, String message) {
        ProgressDialog waitDialog = new ProgressDialog(context);
        if (!TextUtils.isEmpty(message)) {
            waitDialog.setMessage(message);
        }
        return waitDialog;
    }

    /***
     * 获取一个信息对话框，注意需要自己手动调用show方法显示
     * @param context
     * @param message
     * @param onClickListener
     * @return
     */
    public static AlertDialogWrapper.Builder getMessageDialog(Context context, String message,String confirm,
                                                              DialogInterface.OnClickListener onClickListener) {
        AlertDialogWrapper.Builder builder = getDialog(context);
        builder.setMessage(message);
        builder.setPositiveButton(confirm, onClickListener);
        return builder;
    }

    public static AlertDialogWrapper.Builder getMessageDialog(Context context, String message,String confirm) {
        return getMessageDialog(context, message,confirm, null);
    }

    public static AlertDialogWrapper.Builder getConfirmDialog(Context context, String message,
                                                              DialogInterface.OnClickListener onClickListener,String pos,String neg) {
        AlertDialogWrapper.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton(pos, onClickListener);
        builder.setNegativeButton(neg, null);
        return builder;
    }

    public static AlertDialogWrapper.Builder getConfirmDialog(Context context, String message,
                                                              String pos,String neg,
                                                              DialogInterface.OnClickListener onOkClickListener,
                                                              DialogInterface.OnClickListener onCancleClickListener) {
        AlertDialogWrapper.Builder builder = getDialog(context);
        builder.setMessage(message);
        builder.setPositiveButton(pos, onOkClickListener);
        builder.setNegativeButton(neg, onCancleClickListener);
        return builder;
    }

    public static AlertDialogWrapper.Builder getSelectDialog(Context context, String title, String[] arrays, String pos,
                                                             DialogInterface.OnClickListener onClickListener) {
        AlertDialogWrapper.Builder builder = getDialog(context);
        builder.setItems(arrays, onClickListener);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setPositiveButton(pos, null);
        return builder;
    }

    public static AlertDialogWrapper.Builder getSelectDialog(Context context, String[] arrays, String pos,
                                                             DialogInterface.OnClickListener onClickListener) {
        return getSelectDialog(context, "", arrays, pos,onClickListener);
    }

    public static AlertDialogWrapper.Builder getSingleChoiceDialog(Context context, String title, String[] arrays,
                                                                   int selectIndex, String neg,
                                                                   DialogInterface.OnClickListener onClickListener) {
        AlertDialogWrapper.Builder builder = getDialog(context);
        builder.setSingleChoiceItems(arrays, selectIndex, onClickListener);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setNegativeButton(neg, null);
        return builder;
    }

    public static AlertDialogWrapper.Builder getSingleChoiceDialog(Context context, String[] arrays,
                                                                   int selectIndex, String choice,
                                                                   DialogInterface.OnClickListener onClickListener) {
        return getSingleChoiceDialog(context, "", arrays, selectIndex, choice,onClickListener);
    }
}
