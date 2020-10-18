package com.nitish.typewriterview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class TypeWriterView extends AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 40; //Default delay in ms
    private Boolean isAnimationRunning = false;
    private OnAnimationChangeListener mAnimationChangeListener;
    private Boolean avoidTextOverflowAtEdge = true;

    public TypeWriterView(Context context) {
        super(context);
    }

    public TypeWriterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
                isAnimationRunning = true;
            }else {
                isAnimationRunning = false;
                if (mAnimationChangeListener != null) mAnimationChangeListener.onAnimationEnd();
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = generateText(text.toString());
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void stopAnimation(){
        if (isAnimationRunning) {
            isAnimationRunning = false;
            mHandler.removeCallbacks(characterAdder);
            setText(mText);
            if (mAnimationChangeListener != null) mAnimationChangeListener.onAnimationEnd();
        }
    }

    public boolean isAnimationRunning(){
        return isAnimationRunning;
    }

    public boolean isTextInitialised() {
        return mText != null;
    }

    //To Explicitly Change the Delay
    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }

    public String generateText(String mText){
        if (avoidTextOverflowAtEdge){
            return generateFormattedSequence(mText);
        }
        return mText;
    }

    public String generateFormattedSequence(String mText){
        String[] words = mText.split(" ");
        int viewWidth = getMeasuredWidth();
        StringBuilder finalSequence = new StringBuilder();
        for (String word : words){
            String temp = finalSequence.substring(Math.max(finalSequence.lastIndexOf("\n"), 0)) + " " + word;
            float textWidth = getPaint().measureText(temp);
            if (textWidth >= viewWidth)
                finalSequence.append("\n").append(word);
            else if (finalSequence.length() <= 0)
                finalSequence.append(word);
            else
                finalSequence.append(" ").append(word);
        }
        return finalSequence.toString();
    }

    //Explicitly turnoff "avoidTextOverflowAtEdge" to avoid weird text formatting in few cases (when view size is dynamic).
    public void avoidTextOverflowAtEdge(boolean avoidTextOverflowAtEdge) {
        this.avoidTextOverflowAtEdge = avoidTextOverflowAtEdge;
    }

    public interface OnAnimationChangeListener {
        void onAnimationEnd();
    }

    public void setOnAnimationChangeListener(OnAnimationChangeListener onAnimationChangeListener) {
        mAnimationChangeListener = onAnimationChangeListener;
    }
}
