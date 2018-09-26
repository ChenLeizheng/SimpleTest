package com.simpletest.rxjava;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;


/**
 * Created by Lei on 2018/3/21.
 */

public class DialogUtils {

    public DialogUtils() {
    }

    public static void showPwdDialog(Activity activity, Context context, DialogClickCallback dialogClickCallback) {
        View contentView = View.inflate(context, R.layout.dialog_paw, null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //去掉动画
        popupWindow.setAnimationStyle(0);
        //点击back和外部区域pw消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        StringBuilder pwdBuffer = new StringBuilder();
        EditText etManage = contentView.findViewById(R.id.etPassword);
        contentView.findViewById(R.id.iv0).setOnClickListener(view -> etManage.setText(pwdBuffer.append("0")));
        contentView.findViewById(R.id.bt1).setOnClickListener(view -> etManage.setText(pwdBuffer.append("1")));
        contentView.findViewById(R.id.bt2).setOnClickListener(view -> etManage.setText(pwdBuffer.append("2")));
        contentView.findViewById(R.id.bt3).setOnClickListener(view -> etManage.setText(pwdBuffer.append("3")));
        contentView.findViewById(R.id.bt4).setOnClickListener(view -> etManage.setText(pwdBuffer.append("4")));
        contentView.findViewById(R.id.bt5).setOnClickListener(view -> etManage.setText(pwdBuffer.append("5")));
        contentView.findViewById(R.id.bt6).setOnClickListener(view -> etManage.setText(pwdBuffer.append("6")));
        contentView.findViewById(R.id.bt7).setOnClickListener(view -> etManage.setText(pwdBuffer.append("7")));
        contentView.findViewById(R.id.bt8).setOnClickListener(view -> etManage.setText(pwdBuffer.append("8")));
        contentView.findViewById(R.id.bt9).setOnClickListener(view -> etManage.setText(pwdBuffer.append("9")));
        contentView.findViewById(R.id.ivBack).setOnClickListener(view -> {
            //返回
            popupWindow.dismiss();
            dialogClickCallback.cancelClicked();
        });
        contentView.findViewById(R.id.ivSure).setOnClickListener(view -> {
            //确定输入密码
            popupWindow.dismiss();
            dialogClickCallback.sureClicked(etManage.getText().toString());
        });
        contentView.findViewById(R.id.ivDelete).setOnClickListener(view -> {
            //删除密码
            if (pwdBuffer.length() > 0) {
                if (pwdBuffer.length() > 6) {
                    pwdBuffer.delete(6, pwdBuffer.length());
                }
                pwdBuffer.deleteCharAt(pwdBuffer.length() - 1);
            }
            etManage.setText(pwdBuffer.toString());
        });
        contentView.findViewById(R.id.ivClear).setOnClickListener(view -> {
            //清空所有
            etManage.setText("");
            pwdBuffer.delete(0, pwdBuffer.length());
        });
    }

}
