package com.lonm.dp.dpandroid;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;
import android.net.Uri;
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
	
	public void onExecuteLong(View view){
		clearOut();
		EditText editText = (EditText) findViewById(R.id.editText_inputField);
		int power = Integer.parseInt(editText.getText().toString());
		long max = generateLongTenToPower(power);
		
		long startTime = System.currentTimeMillis();
		ArrayList<Long> nums = generateArrayOfDivisibles(max, 7, 7);
		long total = totalArrayListNumeric(nums);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		
		out("Total: "+total);
		out("Time taken: "+totalTime+"ms");
		for (int i = 0; i < 5; i++){
			out(nums.get(i));
		}
		out("Omitting "+(nums.size()-10)+" entries...");
		for (int i = nums.size()-5; i < nums.size(); i++){
			out(nums.get(i));
		}
	}
	
	public void onExecuteShort(View view){
		clearOut();
		out("Not Implemented Yet");
	}
	
	private void out(String s) {
		TextView textView = (TextView) findViewById(R.id.textView_output);
		textView.append(s + "\n");
	}
	
	private void out(long l){
		out(""+l);
	}

	
	private void clearOut(){
		TextView textView = (TextView) findViewById(R.id.textView_output);
		textView.setText("");
	}
	
	private long generateLongTenToPower(int power){
		long maximum = 1;
		for(int i = 0; i<power; i++){
			maximum = maximum * 10;
		}
		return maximum;
	}

	private ArrayList<Long> generateArrayOfDivisibles(long maximum, int minimum, int divisor){
		ArrayList<Long> values = new ArrayList<Long>();
		for(long i = minimum; i < maximum;){
			if(!values.contains(i) && isValidMirrorDivisible(i, divisor)){
				values.add(i);
				if(!isPalindrome(i)){
					values.add(mirrorLong(i));
				}
			}
			i += 7;
		}
		return values;
	}
	
	private boolean isValidMirrorDivisible(long test, int divisor){
		return (test%divisor==0) && (mirrorLong(test)%divisor==0);
	}
	
	private boolean isPalindrome(long test){
		String in = "" + test;
		String mirror = "" + mirrorLong(test);
		String flippedMirror = "";
		while(mirror.length()<in.length()){
			mirror = "0"+mirror;
		}
		for(int i = mirror.length()-1; i >= 0; i--){
			flippedMirror += mirror.charAt(i);
		}
		return in.equals(flippedMirror);
	}
	
	private long mirrorLong(long in){
		String input = ""+in;
		String output = "";
		for(int i = input.length()-1; i >= 0; i--){
			output += input.charAt(i);
		}
		return Long.parseLong(output);
	}
	
	private Long totalArrayListNumeric(ArrayList<Long> array){
		long total = 0;
		for (Long long1 : array) {
			total += long1;
		}
		return total;
	}
}
