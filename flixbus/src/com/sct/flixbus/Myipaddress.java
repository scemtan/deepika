// DEAKTÝF
package com.sct.flixbus;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

public class Myipaddress extends Activity {
	
	String myipaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
	    AsyncHttpClient client=new AsyncHttpClient();
	   	 RequestParams parametre=new RequestParams();
	    client.get("https://api.ipify.org",new TextHttpResponseHandler() 
	    //client.get("http://www.ip-api.com/json",new TextHttpResponseHandler() 
	    {
			public void onFailure(int statusCode, Header[] headers,
					String responseBody, Throwable error) {
				// TODO Auto-generated method stub
				super.onFailure(statusCode, headers, responseBody, error);
			}
			public void onSuccess(int statusCode, Header[] headers,
					String jsonSonuc) {
		    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.web);
		      	  	myAwesomeTextView.setText(""+ jsonSonuc);
			}
	    }
	    );
	    }
}