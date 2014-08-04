package com.exae.shaastra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	LinearLayout ll;
	LayoutParams params;
	JSONArray json_array;
	String username,password;
	DataLoader loader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ll=(LinearLayout) findViewById(R.id.container);
		params=new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		String array[]={"url_link"};
		loader = new DataLoader();
		loader.execute(array);
	}

	
	public void updateLayout() {

		try {

			for (int i = 0; i < json_array.length(); i++) {
				JSONObject object = json_array.getJSONObject(i);
				username = object.getString("title");
				password = object.getString("author");
				tv=new TextView(this);
				tv.setText("Username :"+username+"Password :"+password);
				ll.addView(tv, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public class DataLoader extends AsyncTask<String, JSONArray, JSONArray> {
		ProgressDialog progress;
		StringBuilder cont = new StringBuilder();
		String source;
		int result_code;
		JSONArray array = new JSONArray();
		Drawable d = null;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progress = new ProgressDialog(MainActivity.this);
			progress.setTitle("Loading The Data...");
			progress.show();

		}

		@Override
		protected JSONArray doInBackground(String... params) {
			// TODO Auto-generated method stub

			try {
				String url1 = params[0], proxy = "hproxy.iitm.ac.in", port = "3128", username = "username", password = "password";
				// Authenticator.setDefault(new SimpleAuthenticator(
				// username,password));
				URL url = new URL(url1);
				// Properties systemProperties = System.getProperties();
				// systemProperties.setProperty("http.proxyHost",proxy);
				// systemProperties.setProperty("http.proxyPort",port);
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();

				result_code = con.getResponseCode();

				BufferedReader mReader = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "UTF-8"));

				String line = "";
				while ((line = mReader.readLine()) != null) {
					cont.append(line);

					cont.append(System.getProperty("\n"));
				}
				array = new JSONArray(cont.toString());
				publishProgress(array);

			} catch (Exception e) {
				Log.d("error", "error");
				e.printStackTrace();
			}

			return array;
		}

		@Override
		protected void onProgressUpdate(JSONArray... values) {
			super.onProgressUpdate(values);
			// json_array=values[0];
			// getMe();

		}

		@Override
		protected void onPostExecute(JSONArray result) {
			super.onPostExecute(result);
			json_array = result;
			updateLayout();
			progress.dismiss();

		}

	}


}
