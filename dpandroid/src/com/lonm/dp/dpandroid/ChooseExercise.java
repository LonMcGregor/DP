package com.lonm.dp.dpandroid;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ChooseExercise extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exercise);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.choose_exercise, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_visitdp) {
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dailyprogrammer.reddit.com/"));
			startActivity(browserIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onExerciseH229Click(View view){
		startActivity(new Intent(this, ExerciseH229.class));
		overridePendingTransition(R.anim.exercise_slide_out, R.anim.exercise_slide_in);
	}
	
	
}
