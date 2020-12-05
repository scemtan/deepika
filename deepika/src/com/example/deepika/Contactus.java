package com.example.deepika;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Contactus extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) { // Bu metod uygulama açýldýðýnda çalýþtýrýlan metod.

		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);

		// webView'i tasarýmdakiyle baðlýyoruz.
		webView = (WebView) findViewById(R.id.webView1);

		// webView'i JavaScript kodlarýný çalýþtýracak þekilde set ediyoruz.
		webView.getSettings().setJavaScriptEnabled(true);

		// Sayfanýn yüklendiðinin anlaþýlmasý için ProgressDialog açýyoruz.
		final ProgressDialog progressDialog = ProgressDialog.show(this, "sofortpins.de",
				"Loading...", true);

		webView.setWebViewClient(new WebViewClient() {

			// Sayfa Yüklenirken bir hata oluþursa kullanýcýyý uyarýyoruz.
			public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
				Toast.makeText(getApplicationContext(), "Failed to Load Page!",
						Toast.LENGTH_SHORT).show();
			}

			// Sayfanýn yüklenme iþlemi bittiðinde progressDialog'u kapatýyoruz.
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				if (progressDialog.isShowing())
					progressDialog.dismiss();
			}
		});

		//Web sayfamýzýn url'ini webView'e yüklüyoruz.
		webView.loadUrl("http://www.deepikaonline.de/contact_us.php");

	}
}