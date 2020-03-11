package com.wpt.exclude;


import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;


/**
 * author : wpt
 * date   : 2020-03-10 17:51
 * desc   : 默认没有上下留白的textView
 */
public class ExcludePaddingTextView extends AppCompatTextView {

    public ExcludePaddingTextView(Context context) {
        super(context);
    }

    public ExcludePaddingTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ExcludePaddingTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExcludePaddingTextView);
        String type = typedArray.getString(R.styleable.ExcludePaddingTextView_exText);
        setExText(type);
        typedArray.recycle();
        setIncludeFontPadding(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setExText(CharSequence text){
        if (text == null){
            return;
        }
        int textHeight = (int) getTextSize();
        SpannableStringBuilder ssb;
        if (text instanceof SpannableStringBuilder){
            ssb = (SpannableStringBuilder) text;
            ssb.setSpan(new ExcludePaddingSpaceSpan(textHeight),0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            ssb = new SpannableStringBuilder(text);
            ssb.setSpan(new ExcludePaddingSpaceSpan(textHeight),0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        setText(ssb);
    }
}
