package me.mehdi.android3animations;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnimationActivity extends AppCompatActivity {

    Egg mEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mEgg = findViewById(R.id.egg);

        mEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(v, View.SCALE_X, 2)
                        .start();
                ObjectAnimator.ofFloat(v, "scaleY", 3)
                        .start();
                ObjectAnimator.ofFloat(v, View.ALPHA, 0).setDuration(1000)
                        .start();
            }
        });
    }
}
