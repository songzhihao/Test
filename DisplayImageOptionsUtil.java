package com.epsoft.efastpay.utils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
/**
 * 图片加载缓存
 * @author admin
 *
 */
public class DisplayImageOptionsUtil {

	public static DisplayImageOptions getDisplayImageOptions(int res,
			ImageScaleType type) {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(res).showImageForEmptyUri(res)
				.showImageOnFail(res).cacheInMemory(true).cacheOnDisk(true)
				.imageScaleType(type).considerExifParams(true).build();
		return options;
	}
}
