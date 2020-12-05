package com.example.deepika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.net.ConnectivityManager;
import android.content.IntentFilter;
import android.util.Log;


public class Mainpage extends Activity {
	
	private static final String LOG_TAG = "Automatic Internet Control,";
	private NetworkChangeReceiver receiver;//Network dinleyen receiver objemizin referans˝
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mainpage);
  	  //Receiverımızı register ediyoruz
  	  //Yani Çalıştırıyoruz
  	  IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
  	  receiver = new NetworkChangeReceiver();
  	  registerReceiver(receiver, filter);
        Thread myThread = new Thread() {
        	@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					startActivity(new Intent(Mainpage.this, Enterpage.class));
				}
			}

		};
		myThread.start();
    }

	 @Override
	 protected void onDestroy() { //Activity Kapatıldığı zaman receiver durduralacak.Uygulama arka plana alındığı zamanda receiver çalışmaya devam eder
	  Log.v(LOG_TAG, "onDestory");
	  super.onDestroy();
	   
	  unregisterReceiver(receiver);//receiver durduruluyor
	 
	 }
    
   
}