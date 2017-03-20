package com.epsoft.efastpay.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolder {
	SparseArray<View> mViews;
	View mConvertView;
	int layoutID;// 记录ViewHolder对应的布�?

	private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
		this.mViews = new SparseArray<View>();
		layoutID = layoutId;
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			// convertView为空，直接new�?�?
			return new ViewHolder(context, parent, layoutId, position);
		}
		// convertView不为空，取出convertView中的ViewHolder
		ViewHolder holder = (ViewHolder) convertView.getTag();
		// 如果是相同布�?的ViewHolder，可以复用，直接返回holder
		if (holder.layoutID == layoutId) {
			return holder;
		}
		// 如果是不同布�?的，new�?个返�?
		else {
			return new ViewHolder(context, parent, layoutId, position);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {

		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 
	 * @param resId
	 * @param text
	 * @return
	 */
	public ViewHolder setTextToTextView(int resId, String text) {
		((TextView) getView(resId)).setText(text);
		return this;
	}

	/**
	 * 
	 * @param resId
	 * @param imageId
	 * @return
	 */
	public ViewHolder setBackGroundResourceToView(int resId, int imageId) {
		getView(resId).setBackgroundResource(imageId);
		return this;
	}

	public void setVisibility(int resId, int visibility) {
		getView(resId).setVisibility(visibility);
	}

}
