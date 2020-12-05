// DEAKTÝF
package com.example.deepika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Flixbus extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flixbus);
        Thread myThread = new Thread() {

			@Override
			public void run() {
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					startActivity(new Intent(Flixbus.this, Flixbusmain.class));
				}
			}

		};
		myThread.start();
    }
// #73d700    
   
}