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

public class Deneme extends Activity {
	
	String myipaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);
        
	    AsyncHttpClient client=new AsyncHttpClient();
	   	 RequestParams parametre=new RequestParams();
	    
	   	client.get("https://www.sofortpins.de/SFTP/TestPrnt_80.php",new TextHttpResponseHandler()
	    //client.get("http://ip-api.com/json",new TextHttpResponseHandler() 
	    
	    {

			public void onFailure(int statusCode, Header[] headers,
					String responseBody, Throwable error) {
				// TODO Auto-generated method stub
				super.onFailure(statusCode, headers, responseBody, error);
			}


			public void onSuccess(int statusCode, Header[] headers,
					String jsonSonuc) {
		    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.textcustomer);
		      	  	myAwesomeTextView.setText("DOCUMENT: "+ jsonSonuc);
			}
	    	
	    }
	    );
	    }
}

/*
///////////////////////////////////////////////////////////////////////////////
import android.app.Activity;
import android.os.Bundle;

public class Deneme extends Activity {
	
	 //TextView isp;  
	 //String IPaddress;
	 //TextView info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);
        //isp=(TextView) findViewById(R.id.textView1);
        //IPaddress = BufferedReader;
        //isp.setText("ISP IP     : "+IPaddress);
        //String ipAddress = GetpublicIp;

    }
   }
/*

https://bitbucket.org/stevenjeffries/java-ipify/src/master/src/org/ipify/Ipify.java


// https://www.ipify.org/
try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
    System.out.println("My current IP address is " + s.next());
} catch (java.io.IOException e) {
    e.printStackTrace();
}

*/

/*

TextView tv=
(TextView) findViewById(R.id.textView1);
tv.setText (inetAddress.getHostAddress());

providers.add("http://checkip.amazonaws.com");
providers.add("http://icanhazip.com/");
providers.add("http://myip.dnsomatic.com/");
providers.add("https://fastfoodcoding.com/webapps/what-is-my-ip-address/api");

*/