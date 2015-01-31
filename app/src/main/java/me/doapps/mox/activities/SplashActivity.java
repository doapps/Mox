package me.doapps.mox.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shamanland.fab.FloatingActionButton;

import me.doapps.mox.R;
import me.doapps.mox.utils.UtilFonts;

/**
 * Created by jonathan on 29/01/2015.
 */
public class SplashActivity extends ActionBarActivity implements Animation.AnimationListener {
    private TextView txtSplash;
    private Animation animSlideUp;
    private FloatingActionButton fabSplash;
    private ImageView imgCover;
    private Typeface fontTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        fontTitle = UtilFonts.setBadaboom(this);

        SpannableString s = new SpannableString("example");
        s.setSpan(UtilFonts.setBadaboom(this), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3bbeed")));

        txtSplash = (TextView)findViewById(R.id.txtSplash);
        txtSplash.setTypeface(UtilFonts.setBadaboom(this));
        txtSplash.setShadowLayer(2,5,5,Color.BLACK);

        imgCover = (ImageView)findViewById(R.id.imgCover);

        animSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        animSlideUp.setAnimationListener(this);

        fabSplash = (FloatingActionButton)findViewById(R.id.fabSplash);
        fabSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCover.startAnimation(animSlideUp);
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        fabSplash.setVisibility(View.GONE);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3bbeed")));
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
