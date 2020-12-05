package com.example.deepika;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Button;

public class Greatpage extends Activity {

	ImageView info;
	ImageView contact;
	ImageView exit;
	Button credit;
	Button password;
	Button order;
	Button print_test;
	Button flixbus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greatpage);
		info =(ImageView)findViewById(R.id.imageView2);
		info.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent info = new Intent(Greatpage.this, Info.class);
				startActivity(info);
		}
		});
		contact =(ImageView)findViewById(R.id.imageView4);
		contact.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent contact = new Intent(Greatpage.this, Contactus.class);
				startActivity(contact);
		}
		});
		
        exit =(ImageView)findViewById(R.id.imageView3);
        exit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final AlertDialog.Builder builder = new AlertDialog.Builder(Greatpage.this);
    			builder.setTitle("EXIT")
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
    			.create().show();}
    	});

		credit =(Button)findViewById(R.id.button1);
		credit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent credit = new Intent(Greatpage.this, Cardlist.class);
				startActivity(credit);
		}
		});		
		
		password =(Button)findViewById(R.id.button2);
		password.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent password = new Intent(Greatpage.this, Password.class);
				startActivity(password);
		}
		});		
		
		order =(Button)findViewById(R.id.button3);
		order.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent order = new Intent(Greatpage.this, Web.class);
				startActivity(order);
		}
		});

		print_test =(Button)findViewById(R.id.button4);
		print_test.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent print_test = new Intent(Greatpage.this, Print_webview.class);
				startActivity(print_test);
		}
		});
		
		flixbus =(Button)findViewById(R.id.button5);
		flixbus.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent print_test = new Intent(Greatpage.this, Flixbus.class);
				startActivity(print_test);
		}
		});
	}
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

