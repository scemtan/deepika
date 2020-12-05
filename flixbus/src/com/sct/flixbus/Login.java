package com.sct.flixbus;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class Login extends Activity {

	EditText etEmail;
	EditText etPassword;
	Button btnSignIn, btnRegister;
	String username, password;
	ImageView email_p, user_p, tlphn_p, mail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Get Reference to variables
		etEmail = (EditText) findViewById(R.id.editName);
		etPassword = (EditText) findViewById(R.id.editPassword);
		btnSignIn = (Button) findViewById(R.id.btnSignIn);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		mail = (ImageView) findViewById(R.id.mail);
		
		mail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(Login.this, Mail.class));
			}
		});
		
		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(Login.this, Register.class));
			}
		});

		btnSignIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
				StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().build());
				JSONObject json = null;
				String str = "";
				String res = null;
				username = etEmail.getText().toString();
				password = etPassword.getText().toString();
				String URL = "http://scemtan.xyz//flixbusDB/users_DB/login.php?username=" + username + "&password=" + password;
				//Log.e("API12345", URL);
				HttpResponse response;
				HttpClient myClient = new DefaultHttpClient();
				HttpGet myConnection = new HttpGet(URL);
				try 
				{
					response = myClient.execute(myConnection);
					str = EntityUtils.toString(response.getEntity(), "UTF-8");
				} catch (ClientProtocolException e) 
				{
					e.printStackTrace();
					Log.e("URL ClientProtocol error","ERROR!!!! CLIENT PROTOCOL URL");
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				try 
				{
					JSONArray jArray = new JSONArray(str);
					json = jArray.getJSONObject(0);
					String veri = json.getString("username");
					//Log.e("username", veri);
					SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
					SharedPreferences.Editor myEdit = sharedPreferences.edit();
					myEdit.putString("name", veri);
					myEdit.commit();
					String login = json.getString("login");
					Log.e("Login", login);
					int a;
					a = Integer.valueOf(login.toString());
					if (a != 0) 
					{
						String id = json.getString("id");
						Log.e("=>=>=>=>", id);
						String username = json.getString("username");
						Log.e("username", username);
						startActivity(new Intent(Login.this, HomePage.class));
						Log.e("HTTP", "200 OK");
						Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
					} else 
					{
						//Log.e("TRANSFER", "error");
						Log.e("HTTP", "400 Bad Request");
						//Toast.makeText(getApplicationContext(),"'E0001' Server Error, No Data Received",Toast.LENGTH_LONG).show();
						Toast.makeText(getApplicationContext(),"Username & Password Incorrect",Toast.LENGTH_LONG).show();
					}
				} 
				catch (JSONException e) 
				{
					e.printStackTrace();
					Log.e("CONECTION ERROR", "Username & Password Incorrect");
					Log.e("HTTP", "400 Bad Request");
					Toast.makeText(getApplicationContext(),"Username & Password Incorrect",Toast.LENGTH_LONG).show();
					//Log.e("json error", "ERROR!!!! JSON-GET_STRING DOCUMENT");
				}
			}
		});
	}
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setTitle("EXIT")
				.setMessage("Are You Sure Signed Out?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {
								Log.e("LOGOUT", "LOGOUT");
								Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_LONG).show();
								moveTaskToBack(true);
								android.os.Process
										.killProcess(android.os.Process.myPid());
							}
						}).setNegativeButton("No", null).create().show();
	}
}
