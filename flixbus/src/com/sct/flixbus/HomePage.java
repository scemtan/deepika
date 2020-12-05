package com.sct.flixbus;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import android.widget.DatePicker;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.Dialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import android.support.v4.widget.SwipeRefreshLayout;

public class HomePage extends Activity implements View.OnClickListener {

	SwipeRefreshLayout SwipeRefreshLayout;

	int quantityA = 0;
	int quantityB = 0;
	int quantityC = 0;
	int backRide;
	String user_name;
	String backRideDate_string = "";
	String backRide_string = "";
	EditText editName = null;
	EditText editPassword = null;
	EditText mEdit;
	EditText date, return_date;
	ImageView image;
	TextView from, to, adults, children, bikes;
	Button search, plusA, minusA, plusB, minusB, plusC, minusC, date_btn,
			return_date_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);

		search = (Button) findViewById(R.id.search);
		plusA = (Button) findViewById(R.id.plusA);
		minusA = (Button) findViewById(R.id.minusA);
		plusB = (Button) findViewById(R.id.plusB);
		minusB = (Button) findViewById(R.id.minusB);
		plusC = (Button) findViewById(R.id.plusC);
		minusC = (Button) findViewById(R.id.minusC);
		date_btn = (Button) findViewById(R.id.date_btn);
		return_date_btn = (Button) findViewById(R.id.return_date_btn);
		date = (EditText) findViewById(R.id.date);
		return_date = (EditText) findViewById(R.id.return_date);
		date_btn.setOnClickListener(this);
		return_date_btn.setOnClickListener(this);
		from = (TextView) findViewById(R.id.autoCompleteTextView1);
		to = (TextView) findViewById(R.id.autoCompleteTextView2);
		SwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.Swipe);
		
		image = (ImageView) findViewById(R.id.imageView1);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(HomePage.this, Update.class));
			}
		});

		plusA.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the plus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityA >= -1) {
					quantityA += 1;
				}
				displayQuantityA(quantityA);
			}
		});
		minusA.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the minus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityA >= 1) {
					quantityA -= 1;
				}
				displayQuantityA(quantityA);
			}
		});
		plusB.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the plus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityB >= -1) {
					quantityB += 1;
				}
				displayQuantityB(quantityB);
			}
		});
		minusB.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the minus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityB >= 1) {
					quantityB -= 1;
				}
				displayQuantityB(quantityB);
			}
		});
		plusC.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the plus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityC >= -1) {
					quantityC += 1;
				}
				displayQuantityC(quantityC);
			}
		});
		minusC.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method is called when the minus button is clicked.
			 */
			public void onClick(View v) {
				if (quantityC >= 1) {
					quantityC -= 1;
				}
				displayQuantityC(quantityC);
			}
		});

		search.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (backRide == 1) {
					backRideDate_string = ("&backRideDate=" + (return_date
							.getText().toString()));
					backRide_string = ("&backRide=" + (backRide));
				}

				String URL = "https://shop.global.flixbus.com/search?"
						+ "departureCity="
						+ "88" // from Station id.
						+ "&arrivalCity="
						+ "94" // to Station id.
						+ "&route=" + (from.getText().toString()) + "-"
						+ (to.getText().toString()) + "&rideDate="
						+ (date.getText().toString()) + (backRideDate_string)
						+ "&adult=" + (quantityA) + "&children=" + (quantityC)
						+ "&bike_slot=" + (quantityB) + "&_locale=en"
						+ (backRide_string) + "&currency=EUR";
				startActivity(new Intent(HomePage.this, Search.class));
				// ///////////////////////////////////////////////////////////
				/* veri ana activity den geliyor */
				Intent intent = new Intent(HomePage.this, Search.class);
				intent.putExtra("ara", URL.toString());
				startActivity(intent);
				// ///////////////////////////////////////////////////////////
			}
		});
		{
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
					.detectAll().build());
			JSONObject json = null;

			// -------------------------------------------------------------------------//
			// ///////////////////////////////////////////////////////////
			/* veri ana activity den geliyor */
			SharedPreferences sh = getSharedPreferences("MySharedPref",
					MODE_APPEND);
			String s1 = sh.getString("name", "");
			// ///////////////////////////////////////////////////////////
			// -------------------------------------------------------------------------//

			String str = "";
			String res = null;
			String URL = "http://scemtan.xyz/flixbusDB/users_DB/users.php?username="
					+ (s1);
			HttpResponse response;
			HttpClient myClient = new DefaultHttpClient();
			HttpGet myConnection = new HttpGet(URL);
			try {
				response = myClient.execute(myConnection);
				str = EntityUtils.toString(response.getEntity(), "UTF-8");
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				Log.e("URL ClientProtocol error",
						"ERROR!!!! CLIENT PROTOCOL URL");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				JSONArray jArray = new JSONArray(str);
				json = jArray.getJSONObject(0);
				TextView fullname = (TextView) findViewById(R.id.username);
				fullname.setText(json.getString("fullname"));
				TextView credits = (TextView) findViewById(R.id.credits);
				credits.setText((json.getString("credits")) + "  €");
				TextView transaction = (TextView) findViewById(R.id.transaction);
				transaction
						.setText(json.getString(("transaction")) + "  Sales");
			} catch (JSONException e) {
				e.printStackTrace();
				Log.e("json error", "ERROR!!!! JSON-GET_STRING DOCUMENT");
			}

			SwipeRefreshLayout
					.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
						@Override
						public void onRefresh() {
							{
								StrictMode
										.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
												.build());
								StrictMode
										.setVmPolicy(new StrictMode.VmPolicy.Builder()
												.detectAll().build());
								JSONObject json = null;

								// -------------------------------------------------------------------------//
								// ///////////////////////////////////////////////////////////
								/* veri ana activity den geliyor */
								SharedPreferences sh = getSharedPreferences(
										"MySharedPref", MODE_APPEND);
								String s1 = sh.getString("name", "");
								// ///////////////////////////////////////////////////////////
								// -------------------------------------------------------------------------//

								String str = "";
								String res = null;
								String URL = "http://scemtan.xyz/flixbusDB/users_DB/users.php?username="
										+ (s1);
								HttpResponse response;
								HttpClient myClient = new DefaultHttpClient();
								HttpGet myConnection = new HttpGet(URL);
								try {
									response = myClient.execute(myConnection);
									str = EntityUtils.toString(
											response.getEntity(), "UTF-8");
								} catch (ClientProtocolException e) {
									e.printStackTrace();
									Log.e("URL ClientProtocol error",
											"ERROR!!!! CLIENT PROTOCOL URL");
								} catch (IOException e) {
									e.printStackTrace();
								}
								try {
									JSONArray jArray = new JSONArray(str);
									json = jArray.getJSONObject(0);
									TextView fullname = (TextView) findViewById(R.id.username);
									fullname.setText(json.getString("fullname"));
									TextView credits = (TextView) findViewById(R.id.credits);
									credits.setText((json.getString("credits"))
											+ "  €");
									TextView transaction = (TextView) findViewById(R.id.transaction);
									transaction.setText(json
											.getString(("transaction"))
											+ "  Sales");
								} catch (JSONException e) {
									e.printStackTrace();
									Log.e("json error",
											"ERROR!!!! JSON-GET_STRING DOCUMENT");
								}

							}
							new Handler().postDelayed(new Runnable() {
								@Override
								public void run() {
									SwipeRefreshLayout.setRefreshing(false);
								}

							}, 2000);
						}
					});

		}
	}

	public void onClick(View v) {
		if (v == date_btn) {
			final SimpleDateFormat dateFormatter = new SimpleDateFormat(
					"dd.MM.yyyy");
			// Get Current Date
			final Calendar c = Calendar.getInstance();
			int mYear = c.get(Calendar.YEAR);
			int mMonth = c.get(Calendar.MONTH);
			int mDay = c.get(Calendar.DATE);
			DatePickerDialog datePickerDialog = new DatePickerDialog(this,
					new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							Calendar newDate = Calendar.getInstance();
							newDate.set(year, monthOfYear, dayOfMonth);
							date.setText(dateFormatter.format(newDate.getTime()));
						}
					}, mYear, mMonth, mDay);
			datePickerDialog.show();
		}
		if (v == return_date_btn) {
			final SimpleDateFormat dateFormatter = new SimpleDateFormat(
					"dd.MM.yyyy");
			// Get Current Date
			final Calendar c = Calendar.getInstance();
			int mYear = c.get(Calendar.YEAR);
			int mMonth = c.get(Calendar.MONTH);
			int mDay = c.get(Calendar.DATE);
			DatePickerDialog datePickerDialog = new DatePickerDialog(this,
					new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							Calendar newDate = Calendar.getInstance();
							newDate.set(year, monthOfYear, dayOfMonth);
							return_date.setText(dateFormatter.format(newDate
									.getTime()));
						}
					}, mYear, mMonth, mDay);
			datePickerDialog.show();
		}
	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		int id = view.getId();
		if (id == R.id.oneway) {
			if (checked) {
				return_date.setVisibility(View.GONE);
				return_date_btn.setVisibility(View.GONE);
				backRide = 0;
			}
		} else if (id == R.id.roundtrip) {
			if (checked) {
				return_date.setVisibility(View.VISIBLE);
				return_date_btn.setVisibility(View.VISIBLE);
				backRide = 1;
			}
		}
	}

	private void displayQuantityA(int number) {
		TextView quantityTextView = (TextView) findViewById(R.id.number_Adults);
		quantityTextView.setText("" + number);
	}

	private void displayQuantityB(int number) {
		TextView quantityTextView = (TextView) findViewById(R.id.number_Bikes);
		quantityTextView.setText("" + number);
	}

	private void displayQuantityC(int number) {
		TextView quantityTextView = (TextView) findViewById(R.id.number_Children);
		quantityTextView.setText("" + number);
	}

	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setTitle("EXIT")
				.setMessage("Are You Sure Signed Out?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {
								setContentView(R.layout.activity_main);
								editName = (EditText) findViewById(R.id.editName);
								editPassword = (EditText) findViewById(R.id.editPassword);
								editName.getText().clear();
								editPassword.getText().clear();
								editName.setText("");
								editPassword.setText("");
								startActivity(new Intent(HomePage.this,
										Login.class));
								Log.e("LOGOUT", "LOGOUT");
								Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_LONG).show();
								moveTaskToBack(true);
								android.os.Process
										.killProcess(android.os.Process.myPid());
							}
						}).setNegativeButton("No", null).create().show();
	}
}