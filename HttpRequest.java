package com.epsoft.efastpay.utils;

import android.content.Context;
import android.text.TextUtils;

import com.epsoft.efastpay.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;

public class HttpRequest {
    private static final String LOG_CAT = HttpRequest.class.getSimpleName();
    private OnHttpRequestListener mListener;
    private Context mContext;
    private boolean update=true;
    public HttpRequest(Context context) {
        mContext = context;
//        asyncHttpClient = new AsyncHttpClient();
//        if (asyncHttpClient == null) {
//            SchemeRegistry schReg = new SchemeRegistry();
//            SSLSocketFactory sslSocketFactory = SSLCustomSocketFactory.getSocketFactory(context);
//            sslSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);//允许所有主机的验证
//            schReg.register(new Scheme("https", sslSocketFactory, 9443));
//            schReg.register(new Scheme("https", sslSocketFactory, 443));
//            schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
//
//            asyncHttpClient.setConnectTimeout(30000);
//        }
    }

    public interface OnHttpRequestListener {
         void onFailure(String url, String errorMsg);

         void onSuccess(String url, String result);
    }

    public void setOnHttpRequestListener(OnHttpRequestListener listener) {
        mListener = listener;
    }

//    public void get(final String fullUrl, Map<String, String> data) {
//        RequestParams params = new RequestParams();
//        for (Map.Entry<String, String> entry : data.entrySet()) {
//            params.put(entry.getKey(), entry.getValue());
//        }
//        asyncHttpClient.get(fullUrl, params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
//                if (responseBody == null)
//                    return;
//                String result = new String(responseBody);
//                if (TextUtils.isEmpty(result))
//                    ToastHelper.showToast("未获取到数据！");
//                if (fullUrl.contains("sync") || fullUrl.contains("submit123") || fullUrl.contains("bookRegist123") || fullUrl.contains("cancel")
//                        || fullUrl.contains("expressCheckOut") || fullUrl.contains("expressCheckOut") || fullUrl.contains("preSettlement")) {
//                } else {
//                    if (!DisplayUtil.showTip(mContext, result)) {
//                        return;
//                    }
//                }
//                if (mListener != null) {
//                    mListener.onSuccess(fullUrl, result);
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
//                if (responseBody == null)
//                    return;
//                String strMsg = new String(responseBody);
//                if (mListener != null) {
//                    mListener.onFailure(fullUrl, statusCode, strMsg);
//                }
//            }
//
//        });
//    }

    public void post(final String fullUrl, Map<String, String> code_data) {
        OkHttpUtils.post()
                .url(fullUrl)
                .params(code_data)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ToastHelper.showToast(R.string.connection_error);
                        if (e.getMessage() == null)return;
                        if (mListener != null) {
                            mListener.onFailure(fullUrl,e.getMessage());
                        }
                    }

                    @Override
                    public void onResponse(String response) {
                        if (TextUtils.isEmpty(response)) {
                            ToastHelper.showToast("未获取到数据！");
                            return;
                        }
                        if (fullUrl.contains("sync") || fullUrl.contains("submit123") ||
                                fullUrl.contains("bookRegist123")
                                || fullUrl.contains("cancel")|| fullUrl.contains("expressCheckOut")||
                                fullUrl.contains("preSettlement")|| fullUrl.contains("queryOrder")||
                                fullUrl.contains("patient/checkIdCard") || fullUrl.contains("user/updatePaypwd")) {
                        } else {
                            DisplayUtil.showTip(mContext, response);
                        }
                        if (mListener != null) {
                            mListener.onSuccess(fullUrl, response);
                        }
                    }
                });
//        asyncHttpClient.post(fullUrl, params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
//                if (responseBody == null)
//                    return;
//                String result = new String(responseBody);
//                if (TextUtils.isEmpty(result))
//                    ToastHelper.showToast("未获取到数据！");
//                if (fullUrl.contains("sync") || fullUrl.contains("submit123") || fullUrl.contains("bookRegist123") || fullUrl.contains("cancel")
//                        || fullUrl.contains("expressCheckOut") || fullUrl.contains("expressCheckOut") || fullUrl.contains("preSettlement")) {
//                } else {
//                    if (!DisplayUtil.showTip(mContext, result)) {
//                        return;
//                    }
//                }
//                if (mListener != null) {
//                    mListener.onSuccess(fullUrl, result);
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
//                if (responseBody == null)
//                    return;
//                String strMsg = new String(responseBody);
//                if (mListener != null) {
//                    mListener.onFailure(fullUrl, statusCode, strMsg);
//                }
//            }
//        });
    }

//    public void postWithParams(final String fullUrl, RequestParams params) {
//        asyncHttpClient.post(fullUrl, params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
//                if (responseBody == null)
//                    return;
//                String result = new String(responseBody);
//                if (TextUtils.isEmpty(result))
//                    ToastHelper.showToast("未获取到数据！");
//                if (fullUrl.contains("sync") || fullUrl.contains("submit123") || fullUrl.contains("bookRegist123") || fullUrl.contains("cancel")
//                        || fullUrl.contains("expressCheckOut") || fullUrl.contains("expressCheckOut") || fullUrl.contains("preSettlement")) {
//                } else {
//                    if (!DisplayUtil.showTip(mContext, result)) {
//
//                        return;
//                    }
//                }
//                if (mListener != null) {
//                    mListener.onSuccess(fullUrl, result);
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
//                if (responseBody == null)
//                    return;
//                String strMsg = new String(responseBody);
//                if (mListener != null) {
//                    mListener.onFailure(fullUrl, statusCode, strMsg);
//                }
//            }
//
//        });
//    }
}
