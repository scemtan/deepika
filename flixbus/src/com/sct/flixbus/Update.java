package com.sct.flixbus;

import java.io.IOException;
import java.net.URLEncoder;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class Update extends Activity {

	EditText editEmail, editPassword, editFullname, editTelephone;
	TextView editUsername;
	Button btnUpdate;
	ImageView email_p, user_p, tlphn_p, mail;
	static String json = "";
	String username, password, email, fullname, telephone, id, s1, get_id;
	JSONParser jsonParser = new JSONParser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);

		editEmail = (EditText) findViewById(R.id.editEmail);
		editUsername = (TextView) findViewById(R.id.editUsername);
		editFullname = (EditText) findViewById(R.id.editFullname);
		editTelephone = (EditText) findViewById(R.id.editTelephone);
		editPassword = (EditText) findViewById(R.id.editPassword);
		email_p = (ImageView) findViewById(R.id.imageView4);
		user_p = (ImageView) findViewById(R.id.imageView5);
		tlphn_p = (ImageView) findViewById(R.id.imageView6);
		mail = (ImageView) findViewById(R.id.mail);
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		

// ----------GET SECTOR----------//
// ----------GET START----------//
{
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
				.build());
		JSONObject json = null;

		// -------------------------------------------------------------------------//
		// ///////////////////////////////////////////////////////////
		/* veri ana activity den geliyor */
		SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
		s1 = sh.getString("name", "");
		// ///////////////////////////////////////////////////////////
		// -------------------------------------------------------------------------//

		String str = "";
		String res = null;
		String URL_GET = "http://scemtan.xyz/flixbusDB/users_DB/users.php?username="
				+ (s1);
		HttpResponse response;
		HttpClient myClient = new DefaultHttpClient();
		HttpGet myConnection = new HttpGet(URL_GET);
		try {
			response = myClient.execute(myConnection);
			str = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e("URL ClientProtocol error", "ERROR!!!! CLIENT PROTOCOL URL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			JSONArray jArray = new JSONArray(str);
			json = jArray.getJSONObject(0);
			get_id = (json.getString("id"));
			editEmail.setText(json.getString("email"));
			editUsername.setText(json.getString("username"));
			editFullname.setText(json.getString("fullname"));
			editTelephone.setText(json.getString("telephone"));
			Log.e("UPDATE ID NUMBER", get_id);
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("json error", "ERROR!!!! JSON-GET_STRING DOCUMENT");
		}
}
// ----------GET STOP----------//
// ----------GET SECTOR----------//
		mail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(Update.this, Mail.class));
			}
		});
		
		{
// ----------UPDATE SECTOR----------//
// ----------UPDATE START----------//

			btnUpdate.setOnClickListener(new View.OnClickListener() {
				@SuppressWarnings({ "resource", "deprecation", "unused" })
				@Override
				public void onClick(View view) {

					StrictMode
							.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
									.build());
					StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
							.detectAll().build());
					JSONObject json = null;
					String str = "";
					String res = null;
					email = editEmail.getText().toString();
					username = editUsername.getText().toString();
					fullname = editFullname.getText().toString();
					telephone = editTelephone.getText().toString();
					password = editPassword.getText().toString();
					String URL_POST = "http://scemtan.xyz/flixbusDB/users_DB/change.php?user_id="
							+ get_id
							+ "&username="
							+ URLEncoder.encode(username)
							+ "&password="
							+ URLEncoder.encode(password)
							+ "&email="
							+ URLEncoder.encode(email)
							+ "&fullname="
							+ URLEncoder.encode(fullname)
							+ "&telephone="
							+ URLEncoder.encode(telephone);
					//Log.e("URL_POST", URL_POST);
					HttpResponse response_post;
					HttpClient myClient_post = new DefaultHttpClient();
					HttpGet myConnection_post = new HttpGet(URL_POST);
					try {
						response_post = myClient_post.execute(myConnection_post);
						str = EntityUtils.toString(response_post.getEntity(),
								"UTF-8");
					} catch (ClientProtocolException e) {
						e.printStackTrace();
						Log.e("URL ClientProtocol error",
								"ERROR!!!! CLIENT PROTOCOL URL");
					} catch (IOException e) {
						e.printStackTrace();
					}
					try 
					{
						JSONArray jArray = new JSONArray(str);
						json = jArray.getJSONObject(0);
						String change = json.getString("change");
						Log.e("Change", change);
						int a;
						a = Integer.valueOf(change.toString());
						if (a != 0) 
						{
							startActivity(new Intent(Update.this, Login.class));
							Log.e("HTTP", "200 OK");
							Toast.makeText(getApplicationContext(),
									"Update Successful!", Toast.LENGTH_LONG)
									.show();
						} 
						else 
						{
							Log.e("Change", change);
							Log.e("TRANSFER", "error");
							Log.e("HTTP", "400 Bad Request");
							Toast.makeText(getApplicationContext(),
									"Update Failed!", Toast.LENGTH_LONG).show();
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
// ----------UPDATE STOP----------//
// ----------UPDATE SECTOR----------//

	}
}
