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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class WhatsappKasActivity extends  AppCompatActivity  { 
	
	
	private double n = 0;
	private String file_name = "";
	private String Files = "";
	private HashMap<String, Object> Map = new HashMap<>();
	private boolean booleankas = false;
	private String PackageName = "";
	private String pathApk = "";
	private String apk = "";
	
	private ArrayList<String> l = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> maplist1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> data = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear_lengkung1;
	private GridView gridview1;
	private ImageView imageview1;
	private TextView textview1;
	private CircleImageView image2;
	private ImageView imageview3;
	
	private Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.whatsapp_kas);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear_lengkung1 = (LinearLayout) findViewById(R.id.linear_lengkung1);
		gridview1 = (GridView) findViewById(R.id.gridview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		image2 = (CircleImageView) findViewById(R.id.image2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "MENU PILIHAN");
				return true;
				}
			 });
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(WhatsappKasActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p1,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				TextView menu1 = (TextView) bottomSheetView.findViewById(R.id.menu1);
				
				TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
				
				TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
				
				TextView t3 = (TextView) bottomSheetView.findViewById(R.id.t3);
				
				TextView t4 = (TextView) bottomSheetView.findViewById(R.id.t4);
				
				TextView t5 = (TextView) bottomSheetView.findViewById(R.id.t5);
				
				TextView t6 = (TextView) bottomSheetView.findViewById(R.id.t6);
				
				TextView t7 = (TextView) bottomSheetView.findViewById(R.id.t7);
				
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
				
				ImageView i2 = (ImageView) bottomSheetView.findViewById(R.id.i2);
				
				ImageView i3 = (ImageView) bottomSheetView.findViewById(R.id.i3);
				menu1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
				t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				i1.setImageResource(R.drawable.ic_buitenzsyndicate_29);
				i2.setImageResource(R.drawable.ic_buitenzsyndicate_9);
				i3.setImageResource(R.drawable.ic_buitenzsyndicate_20);
				menu1.setText("Menu Yang Tersedia Saat Ini");
				t1.setText("WhatsApp Messen");
				t2.setText("WhatsApp Business");
				t3.setText("Instagram F & V");
				t4.setText("YouTube MP3 & MP4");
				t5.setText("Facebook Video");
				t6.setText("MediaFire & Facebook");
				t7.setText("Bagikan Aplikasi Ke Teman");
				_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
				_rippleRoundStroke(t1, "#009688", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t2, "#009688", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t3, "#1A237E", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t4, "#D32F2F", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t5, "#0D47A1", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t6, "#2196F3", "#40FFFFFF", 15, 0, "#000000");
				_rippleRoundStroke(t7, "#E91E63", "#40FFFFFF", 15, 0, "#000000");
				t1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						intent.setClass(getApplicationContext(), IntroWhatsappActivity.class);
						startActivity(intent);
						finish();
					}
				});
				t2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						intent.setClass(getApplicationContext(), IntroBusinesskasActivity.class);
						startActivity(intent);
						finish();
					}
				});
				t3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						intent.setClass(getApplicationContext(), IntroInstagramActivity.class);
						startActivity(intent);
						finish();
					}
				});
				t4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						intent.setClass(getApplicationContext(), IntroYoutubeActivity.class);
						startActivity(intent);
						finish();
					}
				});
				t6.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						intent.setClass(getApplicationContext(), IntroMediafirekasActivity.class);
						startActivity(intent);
						finish();
					}
				});
				t7.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						PackageName = "com.buitenzorg.syndicate.v2";
						pathApk = FileUtil.getExternalStorageDir().concat("/".concat("Buitenzorg Story/".concat(PackageName.concat(".apk"))));
						String apk = "";
						String uri = PackageName;
						
						try {
							android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
							
							apk = pi.applicationInfo.publicSourceDir;
							
							FileUtil.copyFile(apk, pathApk);
						} catch (Exception e) {
							SketchwareUtil.showMessage(getApplicationContext(), e.toString());
						}
						
						Intent iten = new Intent(Intent.ACTION_SEND);
						iten.setType("*/*");
						iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(pathApk)));
						
						startActivity(Intent.createChooser(iten, " APK"));
					}
				});
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
		
		image2.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "PROFIL ADMIN");
				return true;
				}
			 });
		
		image2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Popup();
			}
		});
		
		imageview3.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "INFORMASI");
				return true;
				}
			 });
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(WhatsappKasActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p3,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
				
				TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
				
				TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
				
				ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
				
				ImageView i2 = (ImageView) bottomSheetView.findViewById(R.id.i2);
				
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 1);
				t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
				i1.setImageResource(R.drawable.ic_buitenzorgsyndicate_kas);
				i2.setImageResource(R.drawable.ic_icon_buitenzorg_38);
				t1.setText("Informasi Aplikasi Buitenzorg");
				t2.setText("aplikasi ini adalah aplikasi yang tersedia untuk mendownload yang ada di sosial media.\n\ndan aplikasi ini juga di sediakan secara online dan offline, untuk kenyamanan anda. aplikasi ini juga tidak memakan kuota banyak, jadi anda bisa menghemat kuota anda.\n\nSalam : Admin@Prakasa_Jr64");
				b1.setText("Terima Kasih Atas Infonya");
				_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
				_rippleRoundStroke(b1, "#263238", "#EEEEEE", 10, 2.5d, "#FFFFFF");
				b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
					}
				});
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
	}
	
	private void initializeLogic() {
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		
		if(Build.VERSION.SDK_INT>=24){
			
			try{
				java.lang.reflect.Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
				m.invoke(null);
				
			}
			catch(Exception e){
				showMessage(e.toString());
			}
		}
		_homekas();
		_SetCornerRadius(linear_lengkung1, 14, 10, "#FFFFFF");
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		_DARK_ICONS();
		if (FileUtil.isExistFile("/Buitenzorg Story/")) {
			
		}
		else {
			FileUtil.makeDir("/Buitenzorg Story/");
		}
		if (FileUtil.isExistFile("/Buitenzorg Story/Status Foto/")) {
			
		}
		else {
			FileUtil.makeDir("/Buitenzorg Story/Status Foto/");
		}
		if (FileUtil.isExistFile("/Buitenzorg Story/Status Video/")) {
			
		}
		else {
			FileUtil.makeDir("/Buitenzorg Story/Status Video/");
		}
		_RippleEffects("#EEEEEE", imageview1);
		_RippleEffects("#EEEEEE", image2);
		_RippleEffects("#EEEEEE", imageview3);
		_copy_prakasa(textview1);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(WhatsappKasActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p2,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
		
		TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
		
		TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
		
		TextView b2 = (TextView) bottomSheetView.findViewById(R.id.b2);
		
		LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
		
		LinearLayout b3 = (LinearLayout) bottomSheetView.findViewById(R.id.b3);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		t1.setText("Yakin Mau Keluar ?");
		t2.setText("jika anda mau keluar dari aplikasi ini anda bisa menekan \"Saya Keluar\" atau jika tidak anda bisa menekan \"Tidak Jadi\".");
		b1.setText("Tidak Jadi");
		b2.setText("Saya Keluar");
		_rippleRoundStroke(b3, "#D50000", "#000000", 360, 0, "#000000");
		_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
		_rippleRoundStroke(b1, "#FFFFFF", "#EEEEEE", 10, 2.5d, "#EEEEEE");
		_rippleRoundStroke(b2, "#F44336", "#40FFFFFF", 10, 0, "#000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				finish();
			}
		});
		bottomSheetDialog.setCancelable(true);
		bottomSheetDialog.show();
	}
	public void _SetCornerRadius (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
		
		//Add More block in OnCreateActivity :
	}
	
	
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _DARK_ICONS () {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
	}
	
	
	public void _custom_smart_toast (final String _text_message, final String _colour, final double _round, final String _colours) {
		LayoutInflater inflater = getLayoutInflater(); View toastLayout = inflater.inflate(R.layout.tostt, null);
		
		TextView textview1 = (TextView) toastLayout.findViewById(R.id.textview1);
		textview1.setText(_text_message);
		LinearLayout linear1 = (LinearLayout) toastLayout.findViewById(R.id.linear1);
		
		Toast toast = new Toast(getApplicationContext()); toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(toastLayout);
		toast.show();
		
		 android.graphics.drawable.GradientDrawable HEIFBEG = new android.graphics.drawable.GradientDrawable();
		HEIFBEG.setColor(Color.parseColor(_colour));
		HEIFBEG.setCornerRadius((int)_round);
		HEIFBEG.setStroke(5, Color.parseColor(_colours));
		linear1.setBackground(HEIFBEG);
		
		//Created By Prakasa_Jr64
	}
	
	
	public void _homekas () {
		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/WhatsApp/Media/.Statuses/"), l);
		n = 0;
		for(int _repeat76 = 0; _repeat76 < (int)(l.size()); _repeat76++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("media", l.get((int)(n)));
				maplist1.add(_item);
			}
			
			n++;
		}
		gridview1.setAdapter(new Gridview1Adapter(maplist1));
		gridview1.setNumColumns((int)2);
		gridview1.setColumnWidth((int)160);
		gridview1.setHorizontalSpacing((int)2);
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
	
	
	public void _Popup () {
		View popupView = getLayoutInflater().inflate(R.layout.myview, null);
		final PopupWindow popup = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
		TextView tx1 = popupView.findViewById(R.id.tx1);
		
		TextView tx2 = popupView.findViewById(R.id.tx2);
		
		TextView tx3 = popupView.findViewById(R.id.tx3);
		
		
		LinearLayout ly = popupView.findViewById(R.id.ly);
		
		LinearLayout lin1 = popupView.findViewById(R.id.lin1);
		
		LinearLayout lin2 = popupView.findViewById(R.id.lin2);
		
		LinearLayout lin3 = popupView.findViewById(R.id.lin3);
		
		tx1.setTextColor(0xFF388E3C);
		tx2.setTextColor(0xFF1976D2);
		tx3.setTextColor(0xFF673AB7);
		lin1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Status Founder");
				popup.dismiss();
			} });
		
		lin2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Gilang Fajar Purnama");
				popup.dismiss();
			} });
		
		lin3.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.instagram.com/iamkinggilang"));
				startActivity(intent);
				popup.dismiss();
			} });
		
		popup.setAnimationStyle(android.R.style.Animation_Dialog);
		
		popup.showAsDropDown(image2, 0,0);
		
		android.graphics.drawable.GradientDrawable ln = new android.graphics.drawable.GradientDrawable ();
		ln.setColor (Color.parseColor("#FFFFFF"));
		
		ln.setCornerRadius (10);
		
		ly.setBackground (ln);
		
		ly.setElevation(10);
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _copy_prakasa (final TextView _textview) {
		_textview.setTextIsSelectable(true);
	}
	
	
	public class Gridview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.whatsapp, null);
			}
			
			final LinearLayout linear_lengkung1 = (LinearLayout) _view.findViewById(R.id.linear_lengkung1);
			final LinearLayout linear_lengkung2 = (LinearLayout) _view.findViewById(R.id.linear_lengkung2);
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview_nama = (TextView) _view.findViewById(R.id.textview_nama);
			final ImageView imageview4 = (ImageView) _view.findViewById(R.id.imageview4);
			final LinearLayout linear_lengkung3 = (LinearLayout) _view.findViewById(R.id.linear_lengkung3);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			
			_SetCornerRadius(linear_lengkung1, 14, 10, "#FFFFFF");
			_SetCornerRadius(linear_lengkung2, 14, 10, "#2962FF");
			_SetCornerRadius(linear_lengkung3, 14, 10, "#EF5350");
			Animation animation;
			animation = AnimationUtils.loadAnimation(
			                     getApplicationContext(), android.R.anim.slide_in_left
			                 );
			animation.setDuration(300); linear_lengkung1.startAnimation(animation); animation = null;
			textview1.setText(Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment());
			if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
				textview_nama.setText("Video");
				Bitmap bMap = ThumbnailUtils.createVideoThumbnail(maplist1.get(_position).get("media").toString(), android.provider.MediaStore.Video.Thumbnails.MICRO_KIND); imageview4.setImageBitmap(bMap);
			}
			else {
				textview_nama.setText("Foto");
				imageview4.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(maplist1.get((int)_position).get("media").toString(), 1024, 1024));
			}
			if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
				linear_lengkung3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Video/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			else {
				linear_lengkung3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Foto/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
				imageview3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Video/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			else {
				imageview3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Foto/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
				textview3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Video/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			else {
				textview3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						file_name = Uri.parse(maplist1.get((int)_position).get("media").toString()).getLastPathSegment();
						Files = FileUtil.getExternalStorageDir().concat("/Buitenzorg Story/Status Foto/".concat(file_name));
						FileUtil.copyFile(maplist1.get((int)_position).get("media").toString(), Files);
						if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
							_custom_smart_toast("Video Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
						else {
							_custom_smart_toast("Foto Telah Di Simpan", "#FFFFFF", 25, "#2962FF");
						}
					}
				});
			}
			imageview4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (maplist1.get((int)_position).get("media").toString().endsWith(".mp4")) {
						intent.setClass(getApplicationContext(), ViewStorykasActivity.class);
						intent.putExtra("prakasa", maplist1.get((int)_position).get("media").toString());
						startActivity(intent);
					}
					else {
						intent.setClass(getApplicationContext(), ViewfotokasActivity.class);
						intent.putExtra("prakasa1", maplist1.get((int)_position).get("media").toString());
						startActivity(intent);
					}
				}
			});
			cardview1.setCardBackgroundColor(0xFFFFFFFF);
			cardview1.setRadius((float)14);
			
			return _view;
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