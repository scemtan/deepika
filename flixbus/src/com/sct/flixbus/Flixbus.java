package com.sct.flixbus;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

public class Flixbus extends Activity {
	
	// internet control start
	
		private static final String LOG_TAG = "Automatic Internet Control";
		private NetworkChangeReceiver receiver;//Network dinleyen receiver objemizin referans
		
		// internet control stop
		
		
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flixbus);
		
		// internet control start

	  	  //Receiverýmýzý register ediyoruz
	  	  //Yani Çalýþtýrýyoruz
	  	  IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
	  	  receiver = new NetworkChangeReceiver();
	  	  registerReceiver(receiver, filter);
	  	 
	  	// internet control stop

        Thread myThread = new Thread() {

			@Override
			public void run() {
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					startActivity(new Intent(Flixbus.this, Login.class));
				}
			}

		};
		myThread.start();
    }
// #73d700

	
	// internet control start
	
	@Override
	protected void onDestroy() { // Activity Kapatýldýðý zaman receiver
									// durduralacak.Uygulama arka plana alýndýðý
									// zamanda receiver çalýþmaya devam eder
		Log.v(LOG_TAG, "onDestory");
		super.onDestroy();

		unregisterReceiver(receiver);// receiver durduruluyor

	}
	
	// internet control stop
   
}