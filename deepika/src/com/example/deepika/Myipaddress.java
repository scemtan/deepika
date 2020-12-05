// DEAKTÝF
package com.example.deepika;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import org.json.JSONArray; 

public class Myipaddress extends Activity {
	
	String myipaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
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
		    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.textbankbalance);
		      	  	myAwesomeTextView.setText("PUBLIC IP     : "+ jsonSonuc);
			}
	    }
	    );
	    }
}

/*/ public ip baþlangýç
AsyncHttpClient client=new AsyncHttpClient();
	 RequestParams parametre=new RequestParams();
client.get("https://api.ipify.org",new TextHttpResponseHandler() 
{
	public void onFailure(int statusCode, Header[] headers,
			String responseBody, Throwable error) {
		// TODO Auto-generated method stub
		super.onFailure(statusCode, headers, responseBody, error);
	}
	public void onSuccess(int statusCode, Header[] headers,
			String jsonSonuc) {
    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.textView9);
      	  	myAwesomeTextView.setText("PUBLIC IP     : "+ jsonSonuc);
	}
}
);

// public ip bitiþ */

