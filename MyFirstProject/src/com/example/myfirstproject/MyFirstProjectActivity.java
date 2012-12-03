package com.example.myfirstproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyFirstProjectActivity extends Activity {

	public TextView mTextView;
	public Button mButton;
	public EditText mEditText,mPass;
	private Activity act;
	
	Thread checking=new Thread(){
		
		Boolean edit=false,passw=false;
		
		@Override
		public void run()
		{
			while(true){
				if(mEditText.getText().toString().equals("")&&edit==false)
				{
					//mEditText.setError("You should fill username");
					edit=true;
				}
				else
				{
					edit=false;
				}
				
				if(mPass.getText().toString().equals("")&&passw==false)
				{
					//mPass.setError("You should fill password");
					passw=true;
				}
				else
				{
					passw=false;
				}
			}
		}
	};		
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_first_project);
		mTextView=(TextView)findViewById(R.id.txt);
		mButton=(Button)findViewById(R.id.button);
		mEditText=(EditText)findViewById(R.id.editText1);
		mPass=(EditText)findViewById(R.id.pass);
		act=this;
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(!mEditText.getText().toString().equals("")&&
						!mPass.getText().toString().equals(""))
				{
				mTextView.setText("Username : "+mEditText.getText().toString()+
						"\nPassword : "+mPass.getText().toString());
				startActivity(new Intent().setClassName("com.example.myfirstproject", "com.example.myfirstproject.TestImageListActivity"));
				act.finish();				
				}
				else if(mEditText.getText().toString().equals(""))
				{
					mEditText.setError("You should fill username");					
				}
				else if(mPass.getText().toString().equals(""))
				{
					mPass.setError("You should fill password");
				}
			}
		});
		
		//checking.start();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_my_first_project, menu);
		return true;
	}

}
