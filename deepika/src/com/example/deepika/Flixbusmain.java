package com.example.deepika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Flixbusmain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flixbusmain);
    }
	public void onBackPressed() 
	{
			startActivity(new Intent(Flixbusmain.this, Greatpage.class));
	}
}