package com.example.deepika;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.net.InetAddress;
import java.util.Enumeration;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.Log;
import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import org.json.JSONArray; 
 
public class Info extends Activity {

	 TextView mobile;
	 TextView wireless;
	 TextView isp; 
	 String IPaddress1;
	 String IPaddress2;
	 Boolean IPValue;
	 String myipaddress;

    private TextView mac,model,manufacturer,serial,build,imei,simserial,operatorname;
    @SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info); 
        // public ip baþlangýç
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
		    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.textView09);
		      	  	myAwesomeTextView.setText(":     "+ jsonSonuc); // PUBLIC IP     : 
			}
	    }
	    );
	    
	 // public ip bitiþ
	    
	    
        model=(TextView) findViewById(R.id.textView02); // model 2
        mac=(TextView) findViewById(R.id.textView03); //mac 3
        manufacturer=(TextView) findViewById(R.id.textView01); //üretici 1
        serial=(TextView) findViewById(R.id.textView05); //seri numarasý 5
        build=(TextView) findViewById(R.id.textView06); //yapý numarasý 6
   	 	mobile=(TextView) findViewById(R.id.textView07); // mobile ip 7
   	 	wireless=(TextView) findViewById(R.id.textView08); // wifi ip 8
   	 	isp=(TextView) findViewById(R.id.textView09); // public ip 9
   	 	imei=(TextView) findViewById(R.id.textView010); // imei numarasý 10
   	 	simserial=(TextView) findViewById(R.id.textView011); // sim seri numarasý 11
   	 	operatorname=(TextView) findViewById(R.id.textView012); // operatör adý 12
        model.setText(":     "+ Build.MODEL); // MODEL     : 
        String mac_adresi=getMacAddr();
        mac.setText(":     "+mac_adresi); //MAC ADDRESS     : 
        manufacturer.setText(":     "+Build.MANUFACTURER); // MANUFACTURER     : 
        serial.setText(":     "+Build.SERIAL); // SERIAL NUMBER     : 
        build.setText(":     "+Build.ID); // BUILD NUMBER     : 
   	 	NetwordDetect();
   	 	TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   	 	
   	 	String IMEINumber=tm.getDeviceId();  
   	 	String SIMSerialNumber=tm.getSimSerialNumber();
   	 	String OperatorName=tm.getNetworkOperatorName();
   	 	
        String strphoneType="";  
        
        int phoneType=tm.getPhoneType();  
  
        switch (phoneType)   
        {  
                case (TelephonyManager.PHONE_TYPE_CDMA):  
                           strphoneType="CDMA";  
                               break;  
                case (TelephonyManager.PHONE_TYPE_GSM):   
                           strphoneType="GSM";                
                               break;  
                case (TelephonyManager.PHONE_TYPE_NONE):  
                            strphoneType="NONE";                
                                break;  
         }  
          
        //getting information if phone is in roaming  
        boolean isRoaming=tm.isNetworkRoaming();  
          
        String info2 = "";
        String info4 = "";
        String info11 = "";
        //String info="Phone Details:\n";  
        info2+=":     "+IMEINumber; // IMEI NUMBER     : 
        //info+="\n SubscriberID:"+subscriberID;  
        info4+=":     "+SIMSerialNumber; // SIM SERIAL NUMBER     : 
        //info+="\n Network Country ISO:"+networkCountryISO;  
        //info+="\n SIM Country ISO:"+SIMCountryISO;  
        //info+="\n Software Version:"+softwareVersion;  
        //info+="\n Voice Mail Number:"+voiceMailNumber;  
        //info+="\n Phone Network Type:"+strphoneType;  
        //info+="\n In Roaming? :"+isRoaming;  
        info11+=":     "+OperatorName; // OPERATOR NAME     : 
          
        imei.setText(info2);//displaying the information in the textView
        simserial.setText(info4);
        operatorname.setText(info11);
    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }

  //Check the internet connection.
    private void NetwordDetect() {
    
    boolean WIFI = false;
    
    boolean MOBILE = false;
    
    ConnectivityManager CM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    
    NetworkInfo[] networkInfo = CM.getAllNetworkInfo();
    
    for (NetworkInfo netInfo : networkInfo) {
    
    if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))
    
    if (netInfo.isConnected())
    
    WIFI = true;
    
    if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
    
    if (netInfo.isConnected())
    
    MOBILE = true;
    }
    
    if(WIFI == true)
    
    {
    IPaddress2 = GetDeviceipWiFiData();
    wireless.setText(":     "+IPaddress2); // WIFI IP     : 
    }
    
    if(MOBILE == true)
    	
    {
    IPaddress1 = GetDeviceipMobileData();
    mobile.setText(":     "+IPaddress1); // MOBILE IP     : 
    }
    
    }
    public String GetDeviceipMobileData(){
    try {
    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); 
    en.hasMoreElements();) {
    NetworkInterface networkinterface = en.nextElement();
    for (Enumeration<InetAddress> enumIpAddr = networkinterface.getInetAddresses(); enumIpAddr.hasMoreElements();) {
    InetAddress inetAddress = enumIpAddr.nextElement();
    if (!inetAddress.isLoopbackAddress()) {
    return inetAddress.getHostAddress().toString();
    }
    }
    }
    } catch (Exception ex) {
    Log.e("Current IP", ex.toString());
    }
    return null;
    }
    
    public String GetDeviceipWiFiData()
    {
    
    WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
    
    @SuppressWarnings("deprecation")
    
    String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    
    return ip;
    }
}    