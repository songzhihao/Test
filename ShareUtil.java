package com.epsoft.efastpay.utils;

import android.content.Context;
import android.widget.Toast;
import com.epsoft.efastpay.infoclass.ShareData;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

import java.io.File;

/** 分享功能的相关设置工具类 */
public class ShareUtil
{

	private static UMSocialService mController;

	private static Context con;
	private static int shareType = -1;
	private static final int SINA_SHARE = 0, WEIXIN_SHARE = 1, WEIXIN_CIRCLE_SHARE = 2;

	public static UMSocialService getController(Context context)
	{
		if (mController == null)
		{
			initShareConfig(context);
		}
		return mController;
	}

	public static void initShareConfig(Context context)
	{
		if (mController == null)
		{
			con = context;
//			initMyDialog();
			mController = UMServiceFactory.getUMSocialService("com.umeng.share");
			// 设置新浪SSO handler
			mController.getConfig().setSsoHandler(new SinaSsoHandler());
			mController.getConfig().closeToast();

			String appId = "wx5bfda3123f88c817";
			String appSecret = "ef3ec763c4e454453c7faae8270a55bc";
			// 添加微信平台
			UMWXHandler wxHandler = new UMWXHandler(context, appId, appSecret);
			wxHandler.addToSocialSDK();
			// 支持微信朋友圈
			UMWXHandler wxCircleHandler = new UMWXHandler(context, appId, appSecret);
			wxCircleHandler.setToCircle(true);
			wxCircleHandler.addToSocialSDK();
		}
	}

	public static void shareToWeiXin(ShareData data, Context context)
	{
		if (data != null)
		{
			shareType = WEIXIN_SHARE;
			// 设置微信好友分享内容
			WeiXinShareContent weixinContent = new WeiXinShareContent();
			weixinContent.setShareContent(StringUtil.getEmptyOrSrc(data.getContent()));
			if (!StringUtil.isNullOrEmpty(data.getTitle()))
			{
				weixinContent.setTitle(data.getTitle());
			}
			else
			{
				weixinContent.setTitle(data.getDefaultTitle());
			}
			if (!StringUtil.isNullOrEmpty(data.getUrl()))
			{
				weixinContent.setTargetUrl(data.getUrl());
			}
			else
			{
				weixinContent.setTargetUrl(Constants.APK_DOWNLOAD_URL);
			}
			if (!StringUtil.isNullOrEmpty(data.getImgPath()))
			{
				weixinContent.setShareImage(new UMImage(context, data.getImgPath()));
			}
			if (!StringUtil.isNullOrEmpty(data.getLocalImgPath()))
			{
				weixinContent.setShareImage(new UMImage(context, new File(data.getLocalImgPath())));
			}
			mController.setShareMedia(weixinContent);
			postShare(SHARE_MEDIA.WEIXIN, context);
		}
	}

	public static void shareTextToWeiXin(String text, Context context)
	{
		// 设置微信好友分享内容
		shareType = WEIXIN_SHARE;
		WeiXinShareContent weixinContent = new WeiXinShareContent();
		weixinContent.setShareContent(text);
		mController.setShareMedia(weixinContent);
		postShare(SHARE_MEDIA.WEIXIN, context);
	}

	public static void sharePicToWeiXin(String picPath, Context context)
	{
		// 设置微信好友分享内容
		shareType = WEIXIN_SHARE;
		WeiXinShareContent weixinContent = new WeiXinShareContent();
		weixinContent.setShareImage(new UMImage(context, new File(picPath)));
		mController.setShareMedia(weixinContent);
		postShare(SHARE_MEDIA.WEIXIN, context);
	}

	public static void shareToWeiXinCircle(ShareData data, Context context)
	{
		if (data != null)
		{
			shareType = WEIXIN_CIRCLE_SHARE;
			CircleShareContent circleContent = new CircleShareContent();
			circleContent.setShareContent(StringUtil.getEmptyOrSrc(data.getContent()));
			if (!StringUtil.isNullOrEmpty(data.getTitle()))
			{
				circleContent.setTitle(data.getTitle());
			}
			else
			{
				circleContent.setTitle(data.getDefaultTitle());
			}
			if (!StringUtil.isNullOrEmpty(data.getUrl()))
			{
				circleContent.setTargetUrl(data.getUrl());
			}
			else
			{
				circleContent.setTargetUrl(Constants.APK_DOWNLOAD_URL);
			}
			if (!StringUtil.isNullOrEmpty(data.getImgPath()))
			{
				circleContent.setShareImage(new UMImage(context, data.getImgPath()));
			}
			else
			{
				circleContent.setShareImage(new UMImage(context, "http://www.nextdoors.com.cn/images/f1.gif"));
			}
			if (!StringUtil.isNullOrEmpty(data.getLocalImgPath()))
			{
				circleContent.setShareImage(new UMImage(context, new File(data.getLocalImgPath())));
			}
			mController.setShareMedia(circleContent);
			postShare(SHARE_MEDIA.WEIXIN_CIRCLE, context);
		}
	}

	public static void shareToSina(ShareData data, Context context)
	{
		if (data != null)
		{
			shareType = SINA_SHARE;
			StringBuilder strbuld = new StringBuilder();
			strbuld.append("【分享自医快付APP】");
			float len = 0;
			SinaShareContent sinaContent = new SinaShareContent();
			sinaContent.setShareContent(StringUtil.getEmptyOrSrc(data.getContent()));
			if (!StringUtil.isNullOrEmpty(data.getTitle()))
			{
				sinaContent.setTitle(data.getTitle());
			}
			else
			{
				sinaContent.setTitle(data.getDefaultTitle());
			}
			if (!StringUtil.isNullOrEmpty(data.getImgPath()))
			{
				sinaContent.setShareImage(new UMImage(context, data.getImgPath()));
			}
				strbuld.append(data.getContent());
				strbuld.append("（阅读全部：");
//			}
			strbuld.append(data.getUrl());
			strbuld.append(" 下载客户端：http://nextdoors.com.cn/down.php）");
			sinaContent.setShareContent(StringUtil.getEmptyOrSrc(strbuld.toString()));
			mController.setShareMedia(sinaContent);
			postShare(SHARE_MEDIA.SINA, context);
		}
	}

	public static void postShare(SHARE_MEDIA platform, final Context context)
	{
		mController.postShare(context, platform, new SnsPostListener()
		{

			@Override
			public void onStart()
			{
			}

			@Override
			public void onComplete(SHARE_MEDIA arg0, int arg1, SocializeEntity arg2)
			{
				if (arg1 == 200)
				{
					Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();

				}
			}
		});
	}


}
