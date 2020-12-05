package com.sct.flixbus;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;

public class Mail extends Activity {
	private TextView edittext_recipient_id, object, notes,name, mail, telephone, address, mac, serial, pip;
    Button btn_send_mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
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
		    	    TextView myAwesomeTextView = (TextView)findViewById(R.id.textView4);
		      	  	myAwesomeTextView.setText("Public IP     : "+ jsonSonuc);
			}
	    }
	    );
        //initialize view  by find view by id
        edittext_recipient_id = (TextView) findViewById(R.id.edittext_recipient_id);
        object = (TextView) findViewById(R.id.object);
        name = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mail);
        telephone = (EditText) findViewById(R.id.telephone);
        address = (EditText) findViewById(R.id.address);
        notes = (EditText) findViewById(R.id.notes);
        pip = (TextView) findViewById(R.id.textView4);
        btn_send_mail = (Button) findViewById(R.id.btn_send_mail);
        //set onclick listner on button
        btn_send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get  input data from view
                String mRecipientMail = edittext_recipient_id.getText().toString();
                String mObject = object.getText().toString();
                String mName = name.getText().toString();
                String mMail = mail.getText().toString();
                String mTelephone = telephone.getText().toString();
                String mAddress = address.getText().toString();
                String mNotes = notes.getText().toString();
                String mSerial = serial.getText().toString();
                String mMac = mac.getText().toString();
                String mPip = pip.getText().toString();
                //String mPublic = pip.getText().toString();
                String mTopla = (mName + "\n" + mMail + "\n" + mTelephone + "\n" + mAddress + "\n"+ mNotes + "\n"  + mSerial + "\n" + mMac+ "\n" + mPip);
                new SendMailAsynTask(Mail.this, mRecipientMail, mObject, mTopla).execute();//call send mail  cunstructor asyntask by  sending perameter
                
                try {
                    Thread.sleep(2500);
                    startActivity(new Intent(Mail.this, MainActivity.class));
                    
                   } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                   }
            }
        });
        mac=(TextView) findViewById(R.id.textView3);
        serial=(TextView) findViewById(R.id.textView2);
        String mac_adresi=getMacAddr();
        mac.setText("MAC Address   : "+mac_adresi);
        serial.setText("Serial Number : "+Build.SERIAL);
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
}
