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



public class Register extends Activity {

	EditText editEmail, editPassword, editUsername, editFullname, editTelephone;
	Button btnSignIn, btnRegister;
	ImageView email_p, user_p, tlphn_p, mail;
	static String json = "";
	String username, password, email, fullname, telephone;

	JSONParser jsonParser = new JSONParser();

	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		editEmail = (EditText) findViewById(R.id.editEmail);
		editUsername = (EditText) findViewById(R.id.editUsername);
		editFullname = (EditText) findViewById(R.id.editFullname);
		editTelephone = (EditText) findViewById(R.id.editTelephone);
		editPassword = (EditText) findViewById(R.id.editPassword);
		email_p = (ImageView) findViewById(R.id.imageView4);
		user_p = (ImageView) findViewById(R.id.imageView5);
		tlphn_p = (ImageView) findViewById(R.id.imageView6);
		mail = (ImageView) findViewById(R.id.mail);
		btnSignIn = (Button) findViewById(R.id.btnSignIn);
		btnRegister = (Button) findViewById(R.id.btnRegister);

		mail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(Register.this, Mail.class));
			}
		});
		
		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
					StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
					StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().build());
					JSONObject json = null;
					String str = "";
					String res = null;
					email = editEmail.getText().toString();
					username = editUsername.getText().toString();
					fullname = editFullname.getText().toString();
					telephone = editTelephone.getText().toString();
					password = editPassword.getText().toString();
					String URL = "http://scemtan.xyz//flixbusDB/users_DB/add.php?username=" + username + "&password=" + password + "&fullname=" + fullname + "&email=" + email + "&telephone=" + telephone;
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
						String add = json.getString("add");
						Log.e("Add", add);
						int a;
						a = Integer.valueOf(add.toString());
						if (a != 0) 
						{
							startActivity(new Intent(Register.this, Login.class));
							Log.e("HTTP", "200 OK");
							Toast.makeText(getApplicationContext(),"User Registration Created",Toast.LENGTH_LONG).show();
						} 
						else 
						{
							Log.e("Add", add);
							Log.e("TRANSFER", "error");
							Log.e("HTTP", "400 Bad Request");
							Toast.makeText(getApplicationContext(),"User Registration Could Not Be Created Or Missing Information Login.",Toast.LENGTH_LONG).show();
						}
					} 
					catch (JSONException e) 
					{
						e.printStackTrace();
						Log.e("HTTP", "400 Bad Request");
						//Log.e("json error", "ERROR!!!! JSON-GET_STRING DOCUMENT");
					}}
			});
	}
}