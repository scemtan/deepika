// DEAKTÝF
package com.example.deepika;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Register extends Activity {

	Button confirm;
	
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.register);		
	  confirm =(Button)findViewById(R.id.button1);
	  confirm.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			Intent info = new Intent(Register.this, Web.class);
			startActivity(info);
	}
	});
	  
	 }
}