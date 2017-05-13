package com.example.ex7;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity implements View.OnClickListener, TextWatcher, RadioGroup.OnCheckedChangeListener{
	private int edFNid =1;
	private int edLNid=2;
	private int rgGenderId=3;
	private int rbMaleId=4;
	private int rbFemaleId=5;
	static final int PICK_CONTACT_REQUEST = 1;  // The request code
	public static final String ACTION_REGISTER="com.action.register";
	private String fnString="";
	private String lnString="";
	private String strGender="";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
	      LinearLayout mainLayout = new LinearLayout(this);
	      mainLayout.setBackgroundColor(0xFFFFFFE0);
	      mainLayout.setOrientation(LinearLayout.VERTICAL);
	      mainLayout.setPadding(20, 50, 20, 100);
	      setContentView(mainLayout,new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT) );
	      
	      

	      
	      LinearLayout lnLayout1 = new LinearLayout(this);
	      LinearLayout.LayoutParams layoutP = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	      layoutP.setMargins(0, 0, 0, 100);
	      
	      mainLayout.addView(lnLayout1,layoutP);
	      
	      
	    //TextView label for first name
	      TextView tvFN = new TextView(this);
//	      lblFNid = View.generateViewId();
//	      tvFN.setId(lblFNid);  //automated generated id
	      tvFN.setText("First Name:");
	      tvFN.setTextSize(20);
	      lnLayout1.addView(tvFN, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
  
//EditView First Name
	      EditText edtxtFN = new EditText(this);
//	      edFNid = View.generateViewId();
	      edtxtFN.setId(edFNid);  //automated generated id	      
	      final float scale = this.getResources().getDisplayMetrics().density;
	      int pxWidth = (int) (200 * scale + 0.5f);
	      edtxtFN.setTextSize(20);
	      edtxtFN.setTextColor(0xFF000080);
//	      edtxtFN.addTextChangedListener(new EditWatcher(edtxtFN));	      
	      edtxtFN.addTextChangedListener(this);	      
	      lnLayout1.addView(edtxtFN, new LinearLayout.LayoutParams(pxWidth, LayoutParams.WRAP_CONTENT));
	      
	      LinearLayout lnLayout2 = new LinearLayout(this);
	      layoutP.setMargins(0, 0, 0, 100);
	      mainLayout.addView(lnLayout2,layoutP);

//TextView label for last name
	      TextView tvLN = new TextView(this);
//	      final int lblLNid = View.generateViewId();
//	      tvFN.setId(lblLNid);  //automated generated id
	      tvLN.setText("Last Name:");
	      tvLN.setTextSize(20);
	      lnLayout2.addView(tvLN, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	  
//EditView Last Name	     
	      EditText edtxtLN = new EditText(this);
//	      edLNid = View.generateViewId();
	      edtxtLN.setId(edLNid);  //automated generated id
	      edtxtLN.setTextSize(20);	      
	      edtxtLN.setTextColor(0xFF000080);
//	      edtxtLN.addTextChangedListener(new EditWatcher(edtxtLN));
	      edtxtLN.addTextChangedListener(this);
	      lnLayout2.addView(edtxtLN, new LinearLayout.LayoutParams(pxWidth, LayoutParams.WRAP_CONTENT));

	     
	      RadioGroup rg = new RadioGroup(this); //create the RadioGroup
	      rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
//	      rgGenderId = View.generateViewId();
	      rg.setId(rgGenderId);  //automated generated id
	      rg.setOnCheckedChangeListener(this);
		  mainLayout.addView(rg, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		  RadioButton rbMale = new RadioButton(this);
		  rbMale.setText("Male");
//	      rbMaleId = View.generateViewId();
	      rbMale.setId(rbMaleId);  //automated generated id
		  
		  rg.addView(rbMale,new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT));
		  RadioButton rbFemale = new RadioButton(this);
		  rbFemale.setText("Female");
//	      rbFemaleId = View.generateViewId();
	      rbFemale.setId(rbFemaleId);  //automated generated id
		  rg.addView(rbFemale,new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT));
		  
// Button
	      
	      Button myButton = new Button(this);
	      LinearLayout.LayoutParams btnLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	     
	      int orientation = this.getResources().getConfiguration().orientation;
	      if (orientation == Configuration.ORIENTATION_PORTRAIT)
	    	  btnLayoutParams.setMargins(350, 200, 0, 0);
	      else
	    	  btnLayoutParams.setMargins(700, 50, 0, 0);
	      
	      myButton.setGravity(Gravity.CENTER_HORIZONTAL);
	      myButton.setText("Send Back");
	      myButton.setBackgroundColor(Color.CYAN);

	 //   	myButton.setId(View.generateViewId());  //automated generated id
	      myButton.setId(R.id.codeButtonId);  //..or reserve an id in the resource xml file 
	      myButton.setOnClickListener(this);
	      myButton.setEnabled(false);

		  mainLayout.addView(myButton, btnLayoutParams);
		  
	      /* check if there is initialized data in the intent */
	      // Get the intent that started this activity
	      Intent intent = getIntent();
//	      Uri data = intent.getData();

	      // Figure out what to do based on the intent type (might be null!!!)
	      
	     	if (intent != null && intent.getAction()!=null && intent.getAction().equals(ACTION_REGISTER)) {
	     		Bundle bndl = intent.getExtras();
	     		if (bndl != null){
		     		fnString = bndl.getString("fname"); 
		     		lnString = bndl.getString("lname"); 
		     		strGender = bndl.getString("gender"); 
		     		if (fnString != null)
		     			((EditText) findViewById(edFNid)).setText(fnString);
		     		if (lnString != null)
		     			((EditText) findViewById(edLNid)).setText(lnString);
			        if ((strGender == null) || strGender.isEmpty());
			        else {		        	
			        	if (strGender.equals("Mr."))
			        		((RadioButton)findViewById(rbMaleId)).setChecked(true);
			        	else
			        		((RadioButton)findViewById(rbFemaleId)).setChecked(true);	
			        }
	     		}	     		
	      }
	     	else {
	     		Toast.makeText(getApplicationContext(), "Wrong activation of the 'Register' Activity", Toast.LENGTH_SHORT).show();
	     		finish();
	     	}
    }
	
	  public void onClick(View v) {
			Intent i = new Intent();			
			fnString = ((EditText)findViewById(edFNid)).getText().toString();
			i.putExtra("fname", fnString);
			lnString = ((EditText)findViewById(edLNid)).getText().toString();
			i.putExtra("lname", lnString);
			int rbID = ((RadioGroup)findViewById(rgGenderId)).getCheckedRadioButtonId();
			strGender = (rbID == rbMaleId)?"Mr. ":"Mrs. ";
			i.putExtra("gender", strGender);

			setResult(RESULT_OK, i);
			finish();
//			startActivityForResult(i, PICK_CONTACT_REQUEST);
		    }
/* This is another option for defining the TextWatcher listener
	  private class EditWatcher implements TextWatcher{

		    private View view;

		    private EditWatcher(View view) {
		        this.view = view;
		    }

		    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
		    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

		    public void afterTextChanged(Editable editable) {
		        Button btn = (Button)findViewById(R.id.codeButtonId);
		        btn.setEnabled((((EditText) findViewById(edFNid)).getText().length() >0) &&
		        		(((EditText) findViewById(edLNid)).getText().length() >0));
		        
		    }
		}
*/

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
        Button btn = (Button)findViewById(R.id.codeButtonId);
        btn.setEnabled((((EditText) findViewById(edFNid)).getText().length() >0) &&
        		(((EditText) findViewById(edLNid)).getText().length() >0) &&
        		((RadioGroup)findViewById(rgGenderId)).getCheckedRadioButtonId() != -1);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
        Button btn = (Button)findViewById(R.id.codeButtonId);
        btn.setEnabled((((EditText) findViewById(edFNid)).getText().length() >0) &&
        		(((EditText) findViewById(edLNid)).getText().length() >0) &&
        		(checkedId != -1));
		
	}	
	
	@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
//        Toast.makeText(this, "Saving state:" + mSwitchBack, Toast.LENGTH_LONG).show();

        // Save the user's current  state
	       savedInstanceState.putString("firstName", ((EditText) findViewById(edFNid)).getText().toString());
	       savedInstanceState.putString("lastName", ((EditText) findViewById(edLNid)).getText().toString());
	       int x= ((RadioGroup)findViewById(rgGenderId)).getCheckedRadioButtonId();
	       savedInstanceState.putInt("gender", ((RadioGroup)findViewById(rgGenderId)).getCheckedRadioButtonId());
	       
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

	   @Override
	    public void onRestoreInstanceState(Bundle savedInstanceState) {
	        // Always call the superclass so it can restore the view hierarchy
	        super.onRestoreInstanceState(savedInstanceState);

	        ((EditText) findViewById(edFNid)).setText(savedInstanceState.getString("firstName"));
	        ((EditText) findViewById(edLNid)).setText(savedInstanceState.getString("lastName"));
	        int checkedId = savedInstanceState.getInt("gender");
	        if (checkedId != -1) {
		        RadioButton rb = (RadioButton)findViewById(checkedId);
		        rb.setChecked(true);	        	
	        }
	        // Restore state members from saved instance
	    }
}
