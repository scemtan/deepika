package com.sct.flixbus;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

public class Search extends Activity {

	private WebView webView;
	TextView web, date_time;
	ImageView image;
	int i = 0;
	String myipaddress, url_adres, formattedDate, s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(false);
		webView.getSettings().setSupportZoom(false);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAppCacheEnabled(true);
		webView.setBackgroundColor(Color.TRANSPARENT);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl(getIntent().getExtras().getString("ara"));
		web = (TextView) findViewById(R.id.web);
		url_adres = (getIntent().getExtras().getString("ara"));
		

		// ------------------------------------------------------------------------------------------------------------//
		//--------------------UPDATE DATE TIME--------------------//
		Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String formattedDate = df.format(c.getTime());
        formattedDate = df.format(c.getTime()); 
		// ------------------------------------------------------------------------------------------------------------//
      //--------------------PUBLIC IP GET--------------------//
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams parametre = new RequestParams();
		client.get("https://api.ipify.org", new TextHttpResponseHandler()
		// client.get("http://www.ip-api.com/json",new TextHttpResponseHandler()
				{
					public void onFailure(int statusCode, Header[] headers,
							String responseBody, Throwable error) {
						// TODO Auto-generated method stub
						super.onFailure(statusCode, headers, responseBody,
								error);
					}

					public void onSuccess(int statusCode, Header[] headers,
							String jsonSonuc) {
						//TextView myAwesomeTextView = (TextView) findViewById(R.id.web);
						web.setText(url_adres + "  " + jsonSonuc+ "  " + formattedDate);
					}
				});
		// ------------------------------------------------------------------------------------------------------------//
		
		// ------------------------------------------------------------------------------------------------------------//
		// ---- logo buton olarak ayarlandý ve link adresi text içine gömüldü
		// ----\\
		image = (ImageView) findViewById(R.id.imageView1);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				i++;
				if (i == 5) {
					web.setVisibility(View.VISIBLE);
				} else if (i == 10) {
					web.setVisibility(View.GONE);
					i = 0;
				} else {

				}
			}
		});
		// ------------------------------------------------------------------------------------------------------------//

		// ------------------------------------------------------------------------------------------------------------//
		// ---- bu bölümde üst satýrda yer alan kullanýcý bilgileri iþlendi
		// ----\\
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
				.build());
		JSONObject json = null;

		// -------------------------------------------------------------------------//
		// ///////////////////////////////////////////////////////////
		/* veri ana activity den geliyor */
		SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
		s1 = sh.getString("name", "");
		// ///////////////////////////////////////////////////////////
		// -------------------------------------------------------------------------//

		String str = "";
		String res = null;
		String URL = "http://scemtan.xyz/flixbusDB/users_DB/users.php?username="
				+ (s1);
		HttpResponse response;
		HttpClient myClient = new DefaultHttpClient();
		HttpGet myConnection = new HttpGet(URL);
		try {
			response = myClient.execute(myConnection);
			str = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e("URL ClientProtocol error", "ERROR!!!! CLIENT PROTOCOL URL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			int id = 0;
			JSONArray jArray = new JSONArray(str);
			json = jArray.getJSONObject(id);
			TextView fullname = (TextView) findViewById(R.id.username);
			fullname.setText(json.getString("fullname"));
			TextView credits = (TextView) findViewById(R.id.credits);
			credits.setText((json.getString("credits")) + "  €");
			TextView transaction = (TextView) findViewById(R.id.transaction);
			transaction.setText(json.getString(("transaction")) + "  Sales");
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("json error", "ERROR!!!! JSON-GET_STRING DOCUMENT");
		}

		// ------------------------------------------------------------------------------------------------------------//

	}

	public void onBackPressed() {
		startActivity(new Intent(Search.this, HomePage.class));
	}
}