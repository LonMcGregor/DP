package com.lonm.dp.dpandroid;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExerciseH229 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_h229);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exercise_h229, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_visitdptask) {
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://redd.it/3irzsi")));
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onExecute(View view){
		ConsoleOutput c = new ConsoleOutput();
		c.doInBackground();
	}
	
	private class ConsoleOutput extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... params) {
			for(int i=0; i <10; i++){
				int x = 0;
				for(int j=0; j < 100000000; j++){
					x = j*i;
				}
				publishProgress(""+x);
			}
			EditText editText = (EditText) findViewById(R.id.editText_inputField);
			String power = editText.getText().toString();
			onProgressUpdate("tapped button, with value "+power);
			return null;
		}
		protected void onProgressUpdate(String... values) {
			TextView textView = (TextView) findViewById(R.id.textView_output);
			textView.append(values + "\n");
		}
	}
}
