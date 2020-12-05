// DEAKTÝF
package com.example.deepika;

import java.io.File;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class Service extends Activity {
	WebView webView;
	private ImageView image;
	ProgressDialog pDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testweb);
		init();
     	listener();
        image =(ImageView)findViewById(R.id.imageView1);
        image.setOnClickListener(new OnClickListener() {
     	public void onClick(View v) {
     		Toast.makeText(getApplicationContext(), "PRINTING", 
     		Toast.LENGTH_SHORT).show();
     		
     		//XXX(editText.getText().toString());
     		
     	}	
        });
    }
    private void init() {

    	webView = (WebView) findViewById(R.id.webView1);
     	webView.getSettings().setJavaScriptEnabled(true);

     	pDialog = new ProgressDialog(Service.this);
     	//pDialog.setTitle("PDF");
     	pDialog.setMessage("Loading...");
     	pDialog.setIndeterminate(false);
     	pDialog.setCancelable(false);
     	webView.loadUrl("https://www.sofortpins.de/SFTP/show_testprint.php");
    }

    private void listener() {
    	webView.setWebViewClient(new WebViewClient() {
     		@Override
     		public void onPageStarted(WebView view, String url, Bitmap favicon) {
     			super.onPageStarted(view, url, favicon);
     			pDialog.show();
     		}

     		@Override
     		public void onPageFinished(WebView view, String url) {
     			super.onPageFinished(view, url);
     			pDialog.dismiss();
     		}
     	});
    }







}
