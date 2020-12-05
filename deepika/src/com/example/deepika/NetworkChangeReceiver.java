package com.example.deepika;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;
	 
	public class NetworkChangeReceiver extends BroadcastReceiver {
	 private static final String LOG_TAG = "Otomatik internet Kontrol¸";
	 static boolean isConnected = false;
	 
	   @Override
	   public void onReceive(final Context context, final Intent intent) {
	 
	    isNetworkAvailable(context); //receiver çalýþtýðý zaman çaðýrýlacak method
	 
	   }
	 
	 
	   private boolean isNetworkAvailable(Context context) {
	    ConnectivityManager connectivity = (ConnectivityManager) 
	      context.getSystemService(Context.CONNECTIVITY_SERVICE); //Sistem aðýný dinliyor internet var mý yok mu
	    
	    if (connectivity != null) {
	     NetworkInfo[] info = connectivity.getAllNetworkInfo();
	     if (info != null) {
	      for (int i = 0; i < info.length; i++) {
	       if (info[i].getState() == NetworkInfo.State.CONNECTED) {
	        
	     	if(!isConnected){ //internet varsa
	         isConnected = true;
	         Log.v(LOG_TAG, "Internet Connection Available!");
	         Toast.makeText(context, "Internet Connection Available!", Toast.LENGTH_LONG).show();
	        }
	        return true;
	       }
	      }
	     }
	    }
	    isConnected = false;
	       Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
	       Log.v(LOG_TAG, "No Internet Connection!");
	    return false;
	   }
	 }
