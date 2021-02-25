package com.buitenzorg.syndicate.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class IntroYoutubeActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear_animation1;
	private TextView textview1;
	
	private RequestNetwork koneksi;
	private RequestNetwork.RequestListener _koneksi_request_listener;
	private Intent intent = new Intent();
	private TimerTask time1;
	private ObjectAnimator ani = new ObjectAnimator();
	private TimerTask time;
	private Intent nokoneksi = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.intro_youtube);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear_animation1 = (LinearLayout) findViewById(R.id.linear_animation1);
		textview1 = (TextView) findViewById(R.id.textview1);
		koneksi = new RequestNetwork(this);
		
		_koneksi_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				ani.setTarget(textview1);
				ani.setPropertyName("translationY");
				ani.setFloatValues((float)(0), (float)(100));
				ani.setDuration((int)(1000));
				ani.setRepeatMode(ValueAnimator.REVERSE);
				ani.setInterpolator(new LinearInterpolator());
				ani.start();
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								ani.setTarget(textview1);
								ani.setPropertyName("translationY");
								ani.setFloatValues((float)(0), (float)(0));
								ani.setDuration((int)(1000));
								ani.setRepeatMode(ValueAnimator.REVERSE);
								ani.setInterpolator(new LinearInterpolator());
								ani.start();
								time.cancel();
							}
						});
					}
				};
				_timer.schedule(time, (int)(2000));
				time1 = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								intent.setClass(getApplicationContext(), YoutubeKasActivity.class);
								startActivity(intent);
								time1.cancel();
								finish();
							}
						});
					}
				};
				_timer.schedule(time1, (int)(3000));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				nokoneksi.setClass(getApplicationContext(), NoInternetkasActivity.class);
				startActivity(nokoneksi);
				finish();
			}
		};
	}
	
	private void initializeLogic() {
		koneksi.startRequestNetwork(RequestNetworkController.GET, "https://blog-prakasasocial.biz.id/", "A", _koneksi_request_listener);
		//Code By Developer Prakasa_Jr64
		
		com.airbnb.lottie.LottieAnimationView lottieview = new com.airbnb.lottie.LottieAnimationView(IntroYoutubeActivity.this);
		
		
		
		lottieview.setAnimation("fonts/buitenzorg_youtube.ttf");
		
		
		lottieview.playAnimation();
		
		
		linear_animation1.addView(lottieview);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}