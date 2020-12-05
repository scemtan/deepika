package com.example.deepika;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class Print_webview extends Activity {
	int Result_code = 1;
	private WebView webView;
	private ImageView image;
	ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.print_webview);
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("https://www.sofortpins.de/SFTP/show_testprint.php");
     	image =(ImageView)findViewById(R.id.imageView1);
     	image.setOnClickListener(new OnClickListener() {
     		public void onClick(View v) {
     		    PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
     		    PrintDocumentAdapter printAdapter;
     		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
     		        printAdapter = webView.createPrintDocumentAdapter("sofortpins.pdf");
     		    } else {
     		        printAdapter = webView.createPrintDocumentAdapter();
     		    }
     		    String jobName = getString(R.string.app_name) + " Document";

     		    PrintAttributes attributes = new PrintAttributes.Builder()
     		            .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
     		            .setResolution(new PrintAttributes.Resolution("id", Context.PRINT_SERVICE, 200, 200))
     		            .setColorMode(PrintAttributes.COLOR_MODE_COLOR)
     		            .setMinMargins(PrintAttributes.Margins.NO_MARGINS)
     		            .build();
     		    printManager.print(jobName, printAdapter, attributes);
     		    Toast.makeText(getApplicationContext(), "PRINTING", 
     		    		Toast.LENGTH_SHORT).show();
     			}
     		});
}
}