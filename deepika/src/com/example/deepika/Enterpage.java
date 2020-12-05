package com.example.deepika;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Enterpage extends Activity {
	
	private EditText username;
	private EditText password;
	private Button login;
	private ImageView image;
	private ImageView contact;
	private ImageView whatsapp;
	private ImageView call;
	private ImageView email;
	private TextView forgot;
	private Button secret1;
	private Button secret2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enterpage);
        
		image =(ImageView)findViewById(R.id.imageView1);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Enterpage.this, Info.class));
		}
		});
		
		contact =(ImageView)findViewById(R.id.contact);
		contact.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Enterpage.this, Contactus.class));
		}
		});
		
		email =(ImageView)findViewById(R.id.email);
		email.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String mailto = "mailto:info@deepikaonline.de";
				Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
				emailIntent.setData(Uri.parse(mailto));
				try {
					  startActivity(emailIntent);
					} catch (ActivityNotFoundException e) {
					  //TODO: Handle case where no email app is available
					}
		}
		});
		
		call =(ImageView)findViewById(R.id.call);
		call.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				String phone = "+49 211 8604 2150";
				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
				startActivity(intent);
		}
		});
		
		forgot =(TextView)findViewById(R.id.checkedTextView1);
		forgot.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Enterpage.this, Mail.class));
		}
		}); 

		
//ÝPTAL EDÝLECEK		//-----------------------------------------------	
		
		secret1 =(Button)findViewById(R.id.button3);
		secret1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Enterpage.this, Greatpage.class));
		}
		});
		secret2 =(Button)findViewById(R.id.test);
		secret2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Enterpage.this, Testpage.class));
		}
		});

//ÝPTAL EDÝLECEK		//-----------------------------------------------	

		
		whatsapp =(ImageView)findViewById(R.id.whatsapp);
		whatsapp.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			String phoneNumberWithCountryCode = "+4915779130000";
			String message = "";
			startActivity(new Intent(Intent.ACTION_VIEW,
			Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s",phoneNumberWithCountryCode, message))
		));
		}
		});
		
// BURADAN SONRASI KULLANICI ADI VE ÞÝFRESÝ ÝLE BAÐLANTILI YAPILACAK 
		username = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		{
			login = (Button) findViewById(R.id.button1);
			login.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
			{
			startActivity(new Intent(Enterpage.this, Greatpage.class));
			Toast.makeText(getApplicationContext(), "Login Successful!", 
			Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(getApplicationContext(), "Invalid UserID or Password!", 
						Toast.LENGTH_SHORT).show();
			}
			}
			});
		} 
	}
// BURADAN ÖNCESÝ KULLANICI ADI VE ÞÝFRESÝ ÝLE BAÐLANTILI YAPILACAK

	public void onBackPressed() 
	{
			new AlertDialog.Builder(this)
			.setTitle("EXIT")
			.setMessage("Do You Want To Exit The Program?")
			.setPositiveButton("Yes",
			new DialogInterface.OnClickListener() 
			{
			public void onClick(DialogInterface arg0, int arg1) 
			{
    			moveTaskToBack(true);
    			android.os.Process.killProcess(android.os.Process.myPid());
			}
			})
			.setNegativeButton("No",null)
			.create().show();
	}
    
}
