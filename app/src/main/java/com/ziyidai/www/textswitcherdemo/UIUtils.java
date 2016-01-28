package com.ziyidai.www.textswitcherdemo;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class UIUtils {
	public static void showLongToast(final Activity context,final String msg){
		if("main".equals(Thread.currentThread().getName())){
			Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		}else{
			context.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
				}
			});
		}
	}

	public static void showShortToast(final Activity context,final String msg){
		if("main".equals(Thread.currentThread().getName())){
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}else{
			context.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
	

	/** dip转换px */
	public static int dip2px(Activity context,int dip) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/** pxz转换dip */
	public static int px2dip(Activity context,int px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
	/**sp转px*/
	 public static int sp2px(float spValue, float fontScale) {
		  return (int) (spValue * fontScale + 0.5f);
		 }

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 *
	 * @param pxValue
	 * @param fontScale
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	public static int sp2px(Context context,float spValue) {
		return (int) (spValue * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
	}

}
