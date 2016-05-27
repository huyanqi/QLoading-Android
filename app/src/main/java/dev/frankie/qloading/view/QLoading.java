package dev.frankie.qloading.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import dev.frankie.qloading.R;

/**
 * Created by Frankie on 2016/4/26.
 */
public class QLoading extends Dialog {

    private Context mContext;
    private ObjectAnimator lightInAni,lightOutAni,lightOutScaleXAni,lightOutScaleYAni, cloudAni;
    private ImageView lightIn,lightOut,cloud;
    private int duration = 8 * 1000;

    public QLoading(Context context) {
        super(context, R.style.q_dialog);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_view, null);
        setContentView(view);

        lightIn = (ImageView) view.findViewById(R.id.loading_light_in);
        lightOut = (ImageView) view.findViewById(R.id.loading_light_out);
        cloud = (ImageView) view.findViewById(R.id.loading_cloud);

        lightInAni = ObjectAnimator.ofFloat(lightIn,"rotation",0f,360f).setDuration(duration);
        lightInAni.setInterpolator(new LinearInterpolator());
        lightInAni.setRepeatCount(ValueAnimator.INFINITE);

        lightOutAni = ObjectAnimator.ofFloat(lightOut,"rotation",360f,0f);
        lightOutAni.setInterpolator(new LinearInterpolator());
        lightOutAni.setRepeatCount(ValueAnimator.INFINITE);

        lightOutScaleXAni = ObjectAnimator.ofFloat(lightOut,"scaleX",1f,1.1f,1f);
        lightOutScaleXAni.setInterpolator(new LinearInterpolator());
        lightOutScaleXAni.setRepeatCount(ValueAnimator.INFINITE);

        lightOutScaleYAni = ObjectAnimator.ofFloat(lightOut,"scaleY",1f,1.1f,1f);
        lightOutScaleYAni.setInterpolator(new LinearInterpolator());
        lightOutScaleYAni.setRepeatCount(ValueAnimator.INFINITE);

        cloudAni = ObjectAnimator.ofFloat(cloud,"rotation",0f,360f).setDuration(4 * 1000);
        cloudAni.setInterpolator(new LinearInterpolator());
        cloudAni.setRepeatCount(ValueAnimator.INFINITE);

        lightInAni.start();
        cloudAni.start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(lightOutAni).with(lightOutScaleXAni).with(lightOutScaleYAni);
        animatorSet.setDuration(duration);
        animatorSet.start();

    }

}
