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
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class IntropagekasActivity extends  AppCompatActivity  { 
	
	
	private double current_page = 0;
	
	private LinearLayout linear_parent;
	private LinearLayout linear_page_box;
	private LinearLayout linear1;
	private LinearLayout trash;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout base;
	private ImageView imageview1;
	private LinearLayout linear_animation1;
	private TextView textview1;
	private TextView textview3;
	private TextView textview4;
	private TextView textview8;
	private LinearLayout linear_animation2;
	private TextView textview2;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private ImageView imageview2;
	private LinearLayout linear_dots_box;
	private ImageView dot1;
	private ImageView dot2;
	
	private Intent intent = new Intent();
	private SharedPreferences save;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.intropagekas);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear_parent = (LinearLayout) findViewById(R.id.linear_parent);
		linear_page_box = (LinearLayout) findViewById(R.id.linear_page_box);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		trash = (LinearLayout) findViewById(R.id.trash);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		base = (LinearLayout) findViewById(R.id.base);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear_animation1 = (LinearLayout) findViewById(R.id.linear_animation1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear_animation2 = (LinearLayout) findViewById(R.id.linear_animation2);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear_dots_box = (LinearLayout) findViewById(R.id.linear_dots_box);
		dot1 = (ImageView) findViewById(R.id.dot1);
		dot2 = (ImageView) findViewById(R.id.dot2);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		trash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dot1.setImageResource(R.drawable.ic_brightness_1_grey);
				dot2.setImageResource(R.drawable.ic_panorama_fisheye_grey);
				imageview2.setVisibility(View.VISIBLE);
				layout1.setVisibility(View.VISIBLE);
				layout2.setVisibility(View.GONE);
				imageview1.setVisibility(View.GONE);
			}
		});
		
		base.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dot1.setImageResource(R.drawable.ic_panorama_fisheye_grey);
				dot2.setImageResource(R.drawable.ic_brightness_1_grey);
				imageview2.setVisibility(View.GONE);
				layout1.setVisibility(View.GONE);
				layout2.setVisibility(View.VISIBLE);
				imageview1.setVisibility(View.VISIBLE);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dot1.setImageResource(R.drawable.ic_brightness_1_grey);
				dot2.setImageResource(R.drawable.ic_panorama_fisheye_grey);
				imageview2.setVisibility(View.VISIBLE);
				layout1.setVisibility(View.VISIBLE);
				layout2.setVisibility(View.GONE);
				imageview1.setVisibility(View.GONE);
			}
		});
		
		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				save.edit().putString("save", "login").commit();
				intent.setClass(getApplicationContext(), IntroWhatsappActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dot1.setImageResource(R.drawable.ic_panorama_fisheye_grey);
				dot2.setImageResource(R.drawable.ic_brightness_1_grey);
				imageview2.setVisibility(View.GONE);
				layout1.setVisibility(View.GONE);
				layout2.setVisibility(View.VISIBLE);
				imageview1.setVisibility(View.VISIBLE);
			}
		});
	}
	
	private void initializeLogic() {
		imageview1.setVisibility(View.GONE);
		layout2.setVisibility(View.GONE);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		_rippleRoundStroke(textview7, "#FFFFFFFF", "#EEEEEE", 8, 4, "#2962FF");
		//Code By Developer Prakasa_Jr64
		
		com.airbnb.lottie.LottieAnimationView lottieview = new com.airbnb.lottie.LottieAnimationView(IntropagekasActivity.this);
		
		
		
		lottieview.setAnimation("fonts/buitenzorg_marketing.ttf");
		
		
		lottieview.playAnimation();
		
		
		linear_animation1.addView(lottieview);
		//Code By Developer Prakasa_Jr64
		
		com.airbnb.lottie.LottieAnimationView lottieview1 = new com.airbnb.lottie.LottieAnimationView(IntropagekasActivity.this);
		
		
		
		lottieview1.setAnimation("fonts/buitenzorg_sosial.ttf");
		
		
		lottieview1.playAnimation();
		
		
		linear_animation2.addView(lottieview1);
		_copy_prakasa(textview1);
		_copy_prakasa(textview3);
		_copy_prakasa(textview4);
		_copy_prakasa(textview8);
		_copy_prakasa(textview2);
		_copy_prakasa(textview5);
		_copy_prakasa(textview6);
		_RippleEffects("#EEEEEE", imageview1);
		_RippleEffects("#EEEEEE", imageview2);
		if (save.getString("save", "").equals("")) {
			
		}
		else {
			intent.setClass(getApplicationContext(), IntroWhatsappActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _copy_prakasa (final TextView _textview) {
		_textview.setTextIsSelectable(true);
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
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