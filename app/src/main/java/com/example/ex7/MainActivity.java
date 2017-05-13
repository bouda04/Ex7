package com.example.ex7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final String SWITCH_BACK = "SwitchBack";
	static final String FIRST_NAME = "FirstName";
	static final String LAST_NAME = "LastName";
	static final String GENDER = "Gender";

	boolean mSwitchBack = false;
	String fnString = "";
	String lnString = "";
	String strGender="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}
	
	static final int INTERNAL_CONTACT_REQUEST = 1;  // The request code

    public void onRegisterClick(View v){
  
    	Intent nextIntent = new Intent(this, RegisterActivity.class); //explicit intent
    	nextIntent.setAction(RegisterActivity.ACTION_REGISTER);
//    	nextIntent.setType("text/plain");
    	nextIntent.putExtra("fName", fnString);
		nextIntent.putExtra("lName", lnString);
		nextIntent.putExtra("gender", strGender);

    	startActivityForResult(nextIntent,INTERNAL_CONTACT_REQUEST);
    	/*
    	 * This code demonstrates the use of implicit intent
    	 * 
    	Intent callIntent = new Intent(Intent.ACTION_DIAL);
    	callIntent.setData(Uri.parse("tel:049974479"));
    	// Create intent to show chooser
    	Intent chooser = Intent.createChooser(callIntent, "Choose your Phone dialer");

    	// Verify the intent will resolve to at least one activity
    	if (callIntent.resolveActivity(getPackageManager()) != null) 
    	    startActivity(chooser);
*/

    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == INTERNAL_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
            	mSwitchBack = true;
    			
        		fnString = data.getExtras().getString("fname");
           		lnString = data.getExtras().getString("lname");
           		strGender = data.getExtras().getString("gender");
        		SetBackScreen();        		
           }
        }
    }
    
    private void SetBackScreen() {
    	
        ((TextView)findViewById(R.id.textView1)).setVisibility(View.INVISIBLE);
        
        ((Button)findViewById(R.id.button1)).setText("again...");
  	
		TextView textView1 = (TextView) findViewById(R.id.WelcomeBack);
					
		textView1.setText("Welcome back " + strGender + fnString + ", " + lnString);	
		textView1.setGravity(Gravity.CENTER);
		textView1.setTextSize(20);
		textView1.setVisibility(View.VISIBLE);

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
//        Toast.makeText(this, "Saving state:" + mSwitchBack, Toast.LENGTH_LONG).show();

        // Save the user's current  state
        savedInstanceState.putBoolean(SWITCH_BACK, mSwitchBack);
        if (mSwitchBack) {
            savedInstanceState.putString(FIRST_NAME, fnString);
            savedInstanceState.putString(LAST_NAME, lnString);        	
            savedInstanceState.putString(GENDER, strGender);        	
        }
        
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
 
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
       
        // Restore state members from saved instance
        mSwitchBack = savedInstanceState.getBoolean(SWITCH_BACK);
        if (mSwitchBack) {
            fnString = savedInstanceState.getString(FIRST_NAME);
            lnString = savedInstanceState.getString(LAST_NAME);   
            strGender = savedInstanceState.getString(GENDER);   
    		SetBackScreen();
        }
    }
}
