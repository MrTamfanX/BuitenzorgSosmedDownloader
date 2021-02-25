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
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.widget.EditText;
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


public class YoutubeKasActivity extends  AppCompatActivity  { 
	
	
	private String link = "";
	private String pathApk = "";
	private String PackageName = "";
	private String apk = "";
	
	private LinearLayout linear1;
	private LinearLayout linear_lengkung1;
	private LinearLayout linear_lengkung2;
	private LinearLayout linear_lengkung3;
	private LinearLayout linear2;
	private WebView webview1;
	private ImageView imageview1;
	private TextView textview1;
	private CircleImageView image2;
	private ImageView imageview3;
	private EditText edittext1;
	private WebView akas_view;
	private TextView buttonkas1;
	private TextView buttonkas2;
	
	private Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.youtube_kas);
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
		linear_lengkung2 = (LinearLayout) findViewById(R.id.linear_lengkung2);
		linear_lengkung3 = (LinearLayout) findViewById(R.id.linear_lengkung3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		image2 = (CircleImageView) findViewById(R.id.image2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		akas_view = (WebView) findViewById(R.id.akas_view);
		akas_view.getSettings().setJavaScriptEnabled(true);
		akas_view.getSettings().setSupportZoom(true);
		buttonkas1 = (TextView) findViewById(R.id.buttonkas1);
		buttonkas2 = (TextView) findViewById(R.id.buttonkas2);
		
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
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(YoutubeKasActivity.this);
				
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
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(YoutubeKasActivity.this);
				
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
				t2.setText("aplikasi ini adalah aplikasi yang tersedia untuk mendownload yang ada di sosial media.\n\ncontoh penggunaan :\ndisini anda bisa menggunakan url atau id nya saja, contoh :\nURL : https://youtu.be/4k4sgan73n6\nID : 4k4sgan73n6\n\nlalu anda bisa pilih sesuai yang kalian mau entah itu mp3 atau mp4 dan pastikan koneksi internet anda lacar. terima kasih.\n\nSalam : Admin@Prakasa_Jr64");
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
		
		//webviewOnProgressChanged
		akas_view.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		akas_view.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request akas_viewa = new DownloadManager.Request(Uri.parse(url));
				String akas_viewb = CookieManager.getInstance().getCookie(url);
				akas_viewa.addRequestHeader("cookie", akas_viewb);
				akas_viewa.addRequestHeader("User-Agent", userAgent);
				akas_viewa.setDescription("Downloading file...");
				akas_viewa.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				akas_viewa.allowScanningByMediaScanner(); akas_viewa.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); akas_viewa.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager akas_viewc = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				akas_viewc.enqueue(akas_viewa);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		akas_view.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		buttonkas1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_lengkung3.setVisibility(View.VISIBLE);
				link = "https://youtu.be/".concat(edittext1.getText().toString());
				if (link.contains("https://m.youtube.com/watch?")) {
					webview1.loadUrl(link.replace("&feature=youtu.be", "").replace("&", "").replace("https://m.youtube.com/watch?", "https://ycapi.org/button/?").concat("&f=mp3&t=1&fc=#000000&bc=#FFFFFF"));
				}
				else {
					webview1.loadUrl(link.replace("&feature=youtu.be", "").replace("&", "").replace("https://youtu.be/", "https://ycapi.org/button/?v=").concat("&f=mp3&t=1&fc=#000000&bc=#FFFFFF"));
				}
				akas_view.loadUrl("data:text/html,".concat("<iframe width=\"360\" height=\"260\" src=\"https://www.youtube.com/embed/".concat(edittext1.getText().toString().concat("\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"))));
			}
		});
		
		buttonkas2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear_lengkung3.setVisibility(View.VISIBLE);
				link = "https://youtu.be/".concat(edittext1.getText().toString());
				if (link.contains("https://m.youtube.com/watch?")) {
					webview1.loadUrl(link.replace("&feature=youtu.be", "").replace("&", "").replace("https://m.youtube.com/watch?", "https://ycapi.org/button/?").concat("&f=mp4&t=1&fc=#000000&bc=#FFFFFF"));
				}
				else {
					webview1.loadUrl(link.replace("&feature=youtu.be", "").replace("&", "").replace("https://youtu.be/", "https://ycapi.org/button/?v=").concat("&f=mp4&t=1&fc=#000000&bc=#FFFFFF"));
				}
				akas_view.loadUrl("data:text/html,".concat("<iframe width=\"360\" height=\"260\" src=\"https://www.youtube.com/embed/".concat(edittext1.getText().toString().concat("\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"))));
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
		_Edittexts_Logic();
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		_DARK_ICONS();
		linear_lengkung3.setVisibility(View.GONE);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		buttonkas1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 1);
		buttonkas2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 1);
		_SetCornerRadius(linear_lengkung1, 14, 10, "#FFFFFF");
		_SetCornerRadius(linear_lengkung2, 14, 10, "#FFFFFF");
		_SetCornerRadius(linear_lengkung3, 0, 10, "#FFFFFF");
		_rippleRoundStroke(buttonkas1, "#FFFFFFFF", "#EEEEEE", 8, 4, "#2196F3");
		_rippleRoundStroke(buttonkas2, "#FFFFFFFF", "#EEEEEE", 8, 4, "#2962FF");
		_downloadkas("/Buitenzorg Story/Download");
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				String cookies = CookieManager.getInstance().getCookie(url);
				request.addRequestHeader("cookie", cookies);
				request.addRequestHeader("User-Agent", userAgent);
				request.setDescription("Mengunduh File...");
				request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				java.io.File aatv = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/Warung Cyber/Download");if(!aatv.exists()){if (!aatv.mkdirs()){ Log.e("TravellerLog ::","Problem creating Image folder");}} request.setDestinationInExternalPublicDir("/Warung Cyber/Download", URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
				showMessage("Mengunduh File...");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Unduhan Selesai :D");
						unregisterReceiver(this);
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		_copy_prakasa(textview1);
		_RippleEffects("#EEEEEE", imageview1);
		_RippleEffects("#EEEEEE", image2);
		_RippleEffects("#EEEEEE", imageview3);
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
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(YoutubeKasActivity.this);
		
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
	public void _downloadkas (final String _path) {
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat(_path))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat(_path));
		}
	}
	
	
	public void _EditTexts (final TextView _et, final TextView _title, final View _line) {
		_et.setOnFocusChangeListener(new OnFocusChangeListener() { @Override public void onFocusChange(View v, boolean hasFocus) {
				  if (hasFocus) {
					_title.setTextColor(0xFF00B0FF);
					_et.setTextColor(0xFF212121);
					final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(_line,
					                                                                       "backgroundColor",
					                                                                       new ArgbEvaluator(),
					                                                                       0xffEEEEEE,
					                                                                       0xff00B0FF);
					backgroundColorAnimator.setDuration(500);
					backgroundColorAnimator.start();
				} 
				 else { 
					_title.setTextColor(0xFF616161);
					_et.setTextColor(0xFF616161);
					final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(_line,
					                                                                       "backgroundColor",
					                                                                       new ArgbEvaluator(),
					                                                                       0xff00B0FF,
					                                                                       0xff616161);
					backgroundColorAnimator.setDuration(500);
					backgroundColorAnimator.start();
				} } });
	}
	
	
	public void _Edittexts_Logic () {
		_EditTexts(edittext1, textview1, linear_lengkung2);
	}
	
	
	public void _SetCornerRadius (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
		
		//Add More block in OnCreateActivity :
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
	
	
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _DARK_ICONS () {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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