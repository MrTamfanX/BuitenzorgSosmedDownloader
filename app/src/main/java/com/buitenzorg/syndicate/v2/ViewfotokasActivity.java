package com.buitenzorg.syndicate.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ViewfotokasActivity extends  AppCompatActivity  { 
	
	
	private FloatingActionButton _fab;
	private String photo = "";
	private String str = "";
	
	private LinearLayout linear1;
	private ImageView imageview1;
	
	private Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.viewfotokas);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_fab.getRotation()==0) {
					_fab.animate().setDuration(200).rotation(45);
					_showCustom(true);
				} else {
					_fab.animate().setDuration(200).rotation(0);
					_showCustom(false);
				};
			}
		});
	}
	
	private void initializeLogic() {
		str = getIntent().getStringExtra("prakasa1");
		imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(getIntent().getStringExtra("prakasa1"), 1024, 1024));
		View cv1 = getLayoutInflater().inflate(R.layout.akas_fab, null);
		
		l1 = (LinearLayout)cv1.findViewById(R.id.linear1);
		
		_removeView(l1);
		
		((ViewGroup)_fab.getParent()).addView(l1);
		TextView add_url = (TextView)l1.findViewById(R.id.textview1);
		
		_setRoundCorner(add_url, "#388E3C", (int)getDip(20));
		
		add_url.setElevation(8f);
		
		add_url.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("image/jpeg");
				intent.putExtra("android.intent.extra.STREAM", Uri.parse(ViewfotokasActivity.this.str));
				intent.setPackage("com.whatsapp");
				startActivity(Intent.createChooser(intent, "Share Image"));
			}
		});
		TextView add_image = (TextView)l1.findViewById(R.id.textview2);
		
		_setRoundCorner(add_image, "#0D47A1", (int)getDip(20));
		
		add_image.setElevation(8f);
		
		
		add_image.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("image/jpeg");
				intent.putExtra("android.intent.extra.STREAM", Uri.parse(ViewfotokasActivity.this.str));
				intent.setPackage("com.facebook.lite");
				startActivity(Intent.createChooser(intent, "Share Image"));
			}
		});
		TextView add_text = (TextView)l1.findViewById(R.id.textview3);
		
		_setRoundCorner(add_text, "#0D47A1", (int)getDip(20));
		
		add_text.setElevation(8f);
		
		add_text.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("image/jpeg");
				intent.putExtra("android.intent.extra.STREAM", Uri.parse(ViewfotokasActivity.this.str));
				intent.setPackage("com.facebook.mlite");
				startActivity(Intent.createChooser(intent, "Share Image"));
			}
		});
		_showCustom(false);
	}
	
	private LinearLayout l1;
	
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setRoundCorner (final View _view, final String _color, final double _radius) {
		android.graphics.drawable.GradientDrawable gdr = new android.graphics.drawable.GradientDrawable();
		
		gdr.setColor(Color.parseColor(_color));
		
		gdr.setCornerRadius((int)_radius);
		
		if (_view!=null) {
			_view.setBackground(gdr);
		};
	}
	
	
	public void _removeView (final View _view) {
		((ViewGroup)_view.getParent()).removeView(_view);
	}
	
	
	public void _showCustom (final boolean _show) {
		if (_show) {
			l1.setVisibility(View.VISIBLE);
			l1.setTranslationY((int)getDip(50));
			
			l1.setAlpha(0);
			
			l1.animate().setDuration(200).alpha(1f).translationY(0);
			
			_fab.animate().setDuration(200).rotation(45);
		}
		else {
			l1.setVisibility(View.GONE);
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