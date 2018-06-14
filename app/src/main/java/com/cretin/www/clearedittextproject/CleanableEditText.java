package com.cretin.www.clearedittextproject;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author zhuzhipeng
 * @time 2018/6/14 11:36
 * 这是一个自定义的可清楚内容的editText控件
 */
public class CleanableEditText extends android.support.constraint.ConstraintLayout{

    private AppCompatEditText widgetEt;
    private ImageView ivDelete;
    private boolean showClose;

    public CleanableEditText(Context context) {
        super(context);
    }

    public CleanableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CleanableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.cleanable_edit_text, this);

        widgetEt = findViewById(R.id.widget_et);
        ivDelete = findViewById(R.id.widget_iv_delete);

        widgetEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showClose = !TextUtils.isEmpty(s);
                if(showClose) {
                    ivDelete.setVisibility(VISIBLE);
                } else {
                    ivDelete.setVisibility(GONE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        ivDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                widgetEt.setText("");
            }
        });
    }
}
