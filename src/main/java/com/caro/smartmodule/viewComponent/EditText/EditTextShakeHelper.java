/*
 * Copyright (c) 2014, 青岛司通科技有限公司 All rights reserved.
 * File Name：EditTextShakeHelper.java
 * Version：V1.0
 * Author：zhaokaiqiang
 * Date：2014-11-21
 */

package com.caro.smartmodule.viewComponent.EditText;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

/**
 * http://blog.csdn.net/zhaokaiqiang1992/article/details/41344937
 * @ClassName: com.example.sharkdemo.EditTextShakeHelper
 * @Description:输入框震动效果帮助类
 * @author zhaokaiqiang
 * @date 2014-11-21 上午9:56:15
 *  使用之前不要忘记加上震动的权限
*<uses-permission android:name="android.permission.VIBRATE" />
 * useage:
 * eg:
 * EditText et = (EditText) findViewById(R.id.et_shake);
 * 				if (TextUtils.isEmpty(et.getText().toString())) {
  *            new EditTextShakeHelper(MainActivity.this).shake(et);
    *         }
 */
public class EditTextShakeHelper {

	// 震动动画
	private Animation shakeAnimation;
	// 插值器
	private CycleInterpolator cycleInterpolator;
	// 振动器
	private Vibrator shakeVibrator;

	public EditTextShakeHelper(Context context) {

		// 初始化振动器
		shakeVibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		// 初始化震动动画
		shakeAnimation = new TranslateAnimation(0, 10, 0, 0);
		shakeAnimation.setDuration(300);
		cycleInterpolator = new CycleInterpolator(8);
		shakeAnimation.setInterpolator(cycleInterpolator);

	}

	/**
	 * 开始震动
	 * 
	 * @param editTexts
	 */
	public void shake(EditText... editTexts) {
		for (EditText editText : editTexts) {
			editText.startAnimation(shakeAnimation);
		}

		shakeVibrator.vibrate(new long[] { 0, 500 }, -1);

	}

}
