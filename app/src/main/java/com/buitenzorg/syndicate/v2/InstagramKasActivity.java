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
import de.hdodenhof.circleimageview.*;
import android.widget.EditText;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.webkit.WebViewClient;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class InstagramKasActivity extends  AppCompatActivity  { 
	
	
	private String instaid = "";
	private String timeanddate = "";
	private String pathApk = "";
	private String apk = "";
	private String PackageName = "";
	private String fontName = "";
	private String typeace = "";
	private String rege = "";
	private String data = "";
	private double second_part = 0;
	private double first_part = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear_lengkung1;
	private LinearLayout linear22;
	private LinearLayout linear24;
	private LinearLayout linear23;
	private ImageView imageview1;
	private TextView textview1;
	private CircleImageView image2;
	private ImageView imageview3;
	private LinearLayout linear_lengkung2;
	private TextView textview9;
	private LinearLayout linear20;
	private TextView textview12;
	private EditText edittext1;
	private TextView textview11;
	private WebView webview1;
	private TextView textview13;
	private TextView textview14;
	
	private Calendar calendar = Calendar.getInstance();
	private Intent intent = new Intent();
	private RequestNetwork requestNet;
	private RequestNetwork.RequestListener _requestNet_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.instagram_kas);
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
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		image2 = (CircleImageView) findViewById(R.id.image2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear_lengkung2 = (LinearLayout) findViewById(R.id.linear_lengkung2);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		textview12 = (TextView) findViewById(R.id.textview12);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview11 = (TextView) findViewById(R.id.textview11);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview14 = (TextView) findViewById(R.id.textview14);
		requestNet = new RequestNetwork(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(InstagramKasActivity.this);
				
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
		
		image2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Popup();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(InstagramKasActivity.this);
				
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
				t2.setText("aplikasi ini adalah aplikasi yang tersedia untuk mendownload yang ada di sosial media.\n\ncontoh penggunaan :\nmasukan linknya seperti ini : https://www.instagram.com/p/Bz3fhTynRQl/?igshid=j1n789hccxft.\nlalu tekan find video, tunggu beberapa saat dan pastikan jaringan anda lancar. lalu klik download video dan tunggu sampai selesai. terima kasih.\n\nSalam : Admin@Prakasa_Jr64");
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
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview9.setText("Loading...");
				requestNet.startRequestNetwork(RequestNetworkController.GET, edittext1.getText().toString(), "", _requestNet_request_listener);
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Download(rege, "/igd");
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!_charSeq.contains("instagram.com")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter URL from Instagram.");
				}
				else {
						
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request webview1a = new DownloadManager.Request(Uri.parse(url));
				String webview1b = CookieManager.getInstance().getCookie(url);
				webview1a.addRequestHeader("cookie", webview1b);
				webview1a.addRequestHeader("User-Agent", userAgent);
				webview1a.setDescription("Downloading file...");
				webview1a.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				webview1a.allowScanningByMediaScanner(); webview1a.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); webview1a.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager webview1c = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				webview1c.enqueue(webview1a);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				textview11.setVisibility(View.VISIBLE);
				webview1.setVisibility(View.GONE);
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				textview11.setVisibility(View.GONE);
				webview1.setVisibility(View.VISIBLE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_requestNet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try {
						data = _response;
						first_part = data.lastIndexOf("og:video:secure_url") + 30;
						second_part = data.lastIndexOf("og:video:type") + -25;
						rege = data.substring((int)(first_part), (int)(second_part));
						webview1.loadUrl(rege);
						textview12.setVisibility(View.VISIBLE);
				}
				catch(Exception e) {
						  //  Block of code to handle errors
						
						SketchwareUtil.showMessage(getApplicationContext(), "Username not exist");
						
				}
				textview9.setText("Find video");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
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
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		_DARK_ICONS();
		_SetCornerRadius(linear_lengkung1, 14, 10, "#FFFFFF");
		_SetCornerRadius(linear_lengkung2, 14, 10, "#FFFFFF");
		_SetCornerRadius(linear24, 14, 10, "#FFFFFF");
		_RippleEffects("#EEEEEE", imageview1);
		_RippleEffects("#EEEEEE", image2);
		_RippleEffects("#EEEEEE", imageview3);
		_copy_prakasa(textview1);
		_copy_prakasa(textview13);
		_copy_prakasa(textview14);
		_rippleRoundStroke(textview9, "#FFFFFFFF", "#EEEEEE", 8, 4, "#2962FF");
		_rippleRoundStroke(textview12, "#FFFFFFFF", "#EEEEEE", 8, 4, "#2962FF");
		_rippleRoundStroke(edittext1, "#00000000", "#000000", 15, 3, "#EEEEEE");
		textview11.setVisibility(View.GONE);
		textview12.setVisibility(View.GONE);
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
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(InstagramKasActivity.this);
		
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
				SketchwareUtil.showMessage(getApplicationContext(), "Status Admin");
				popup.dismiss();
			} });
		
		lin2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Prakasa Putra");
				popup.dismiss();
			} });
		
		lin3.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.instagram.com/prakasa_jr644"));
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
	
	
	public void _Download (final String _url, final String _path) {
		FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
		
		FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
		
		android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
						
						
						final String urlDownload = _url;
						
						DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
						
						final String fileName = URLUtil.guessFileName(urlDownload, null, null);
						
						request.setDescription("URL - " + urlDownload);
						
						request.setTitle(fileName);
						
						request.allowScanningByMediaScanner();
						
						request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
						
						request.setDestinationInExternalPublicDir(_path, fileName);
						
						final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
						
						final long downloadId = manager.enqueue(request);
						
						final ProgressDialog prog = new ProgressDialog(this);
						prog.setMax(100);
						prog.setIndeterminate(true);
						prog.setCancelable(false);
						prog.setCanceledOnTouchOutside(false);
						
						prog.setTitle("Please Wait...");
						prog.setMessage("Downloading the " + fileName + ".\n\nProgress - 0%");
						prog.show();
						
						new Thread(new Runnable() {
										@Override
										public void run() {
														
														boolean downloading = true;
														
														while (downloading) {
																		
																		DownloadManager.Query q = new DownloadManager.Query();
																		
																		q.setFilterById(downloadId);
																		
																		android.database.Cursor cursor = manager.query(q);
																		
																		cursor.moveToFirst();
																		
																		int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
																		
																		int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
																		
																		if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
																						
																						downloading = false;
																						
																		}
																		
																		final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
																		
																		runOnUiThread(new Runnable() {
																						@Override
																						public void run() {
																										
																										prog.setTitle("Please Wait...");
																										prog.setMessage("Downloading the " + fileName + ".\n\nProgress - " + dl_progress + "%");
																										prog.show();
																										
																										if (dl_progress == 100) {
																												    textview11.setVisibility(View.GONE);
																textview12.setVisibility(View.GONE);
																webview1.setVisibility(View.GONE);
																													    showMessage("Download Success");
															rege = "";
									webview1.loadUrl("");															prog.dismiss();
																										}
																										
																						} });
														} } }).start();
						
						
		} else {
						showMessage("No Internet Connection.");
		}
	}
	
	
	public void _copy_prakasa (final TextView _textview) {
		_textview.setTextIsSelectable(true);
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