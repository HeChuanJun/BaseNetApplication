package com.hcj.baseapplication.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hcj.baseapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author tangzhifei on 16/7/2.
 */
public class CommonTitleView extends RelativeLayout {

    @BindView(R.id.backImageView)
    ImageView backImageView;
    @BindView(R.id.leftTextView)
    TextView leftTextView;
    @BindView(R.id.rightImageView)
    ImageView rightImageView;
    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.rightTextView)
    TextView rightTextView;

    @BindView(R.id.leftLl)
    LinearLayout leftLl;
    @BindView(R.id.rightLl)
    LinearLayout rightLl;
    @BindView(R.id.commonTitle_rl)
    RelativeLayout commonTitleRl;

    public CommonTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(getContext(), R.layout.common_title, this);
        ButterKnife.bind(this);
    }

    public void setBackground(int rgb) {
        commonTitleRl.setBackgroundResource(rgb);
    }

    public void setBackgroundAlpha(int alpha) {
        commonTitleRl.setAlpha(alpha);
    }


    public void setLeftVis(boolean vis) {
        if (vis) {
            backImageView.setVisibility(VISIBLE);
        } else {
            backImageView.setVisibility(GONE);
        }
    }

    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    public void setTitleColor(int color) {
        titleTextView.setTextColor(color);
    }

    public ImageView getBackImageView() {
        return backImageView;
    }

    public void showLeftTextView(String leftText) {
        if (!TextUtils.isEmpty(leftText)) {
            leftTextView.setText(leftText);
        }
    }

    public void hiddenLeftView() {
        leftLl.setVisibility(GONE);
    }

    public TextView getRightTextView() {
        return rightTextView;
    }

    public void showRightTextView(String strId) {
        rightTextView.setText(strId);
        rightTextView.setVisibility(VISIBLE);
    }

    public void showRightTextView(String strId, int rgb) {
        rightTextView.setText(strId);
        rightTextView.setTextColor(rgb);
        rightTextView.setVisibility(VISIBLE);
    }

    public ImageView getRightImageView() {
        return rightImageView;
    }

    public void showRightImageView(int bgRes) {
        rightImageView.setImageResource(bgRes);
        rightImageView.setVisibility(VISIBLE);
    }

    public void showBackImageView(int bgRes) {
        backImageView.setImageResource(bgRes);
    }

    public void setLeftOnClickListener(OnClickListener leftOnClickListener) {
        leftLl.setOnClickListener(leftOnClickListener);
    }

    public void setRightOnClickListener(OnClickListener rightOnClickListener) {
        rightLl.setOnClickListener(rightOnClickListener);
    }

    public LinearLayout getLeftLl() {
        return leftLl;
    }

    public LinearLayout getRightLl() {
        return rightLl;
    }
}
