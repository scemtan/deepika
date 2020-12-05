package com.sct.flixbus;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editEmail, editPassword, editName, editFullname, editTelephone;
	Button btnSignIn, btnRegister;
	ImageView email_p, user_p, tlphn_p, mail;
	static String json = "";
	String URL = "http://scemtan.xyz/flixbusDB/index.php";

	JSONParser jsonParser = new JSONParser();

	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editEmail = (EditText) findViewById(R.id.editEmail);
		editName = (EditText) findViewById(R.id.editName);
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
				startActivity(new Intent(MainActivity.this, Mail.class));
			}
		});

		btnSignIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AttemptLogin attemptLogin = new AttemptLogin();
				attemptLogin.execute(editName.getText().toString(),
						editPassword.getText().toString(), "", "", "");
			}
		});

		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if (i == 0) {
					i = 1;
					editEmail.setVisibility(View.VISIBLE);
					email_p.setVisibility(View.VISIBLE);
					editFullname.setVisibility(View.VISIBLE);
					user_p.setVisibility(View.VISIBLE);
					editTelephone.setVisibility(View.VISIBLE);
					tlphn_p.setVisibility(View.VISIBLE);
					btnSignIn.setVisibility(View.GONE);
					btnRegister.setText("CREATE ACCOUNT");
				} else {

					btnRegister.setText("REGISTER");
					editEmail.setVisibility(View.GONE);
					email_p.setVisibility(View.GONE);
					editFullname.setVisibility(View.GONE);
					user_p.setVisibility(View.GONE);
					editTelephone.setVisibility(View.GONE);
					tlphn_p.setVisibility(View.GONE);
					btnSignIn.setVisibility(View.VISIBLE);
					i = 0;

					AttemptLogin attemptLogin = new AttemptLogin();
					attemptLogin.execute(editName.getText().toString(),
							editPassword.getText().toString(), editEmail
									.getText().toString(), editFullname
									.getText().toString(), editTelephone
									.getText().toString(), "");

				}
			}
		});

	}

	private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected JSONObject doInBackground(String... args) {

			String telephone = args[4];
			String fullname = args[3];
			String email = args[2];
			String password = args[1];
			String name = args[0];

			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", name));
			params.add(new BasicNameValuePair("password", password));
			if (email.length() > 0)
			params.add(new BasicNameValuePair("email", email));
			params.add(new BasicNameValuePair("fullname", fullname));
			params.add(new BasicNameValuePair("telephone", telephone));

			JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);

			return json;

		}

		protected void onPostExecute(JSONObject result) {
			try {
				if (result != null) {

					Toast.makeText(getApplicationContext(),
							result.getString("message"), Toast.LENGTH_LONG)
							.show();
					json = result.getString("username");
					Log.d("API12345", json);
					result.getString("login");
					String a = "login";
					if (a != null) {
						{
							startActivity(new Intent(MainActivity.this,
									HomePage.class));

							// -------------------------------------------------------------------------//
							// ///////////////////////////////////////////////////////////
							/* veri diðer activity ye gönderiliyor */
							SharedPreferences sharedPreferences = getSharedPreferences(
									"MySharedPref", MODE_PRIVATE);
							SharedPreferences.Editor myEdit = sharedPreferences
									.edit();
							myEdit.putString("name", json);
							myEdit.commit();
							// ///////////////////////////////////////////////////////////
							// -------------------------------------------------------------------------//

						}
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"'E0001' Server Error, No Data Received",
							Toast.LENGTH_LONG).show();
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
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
