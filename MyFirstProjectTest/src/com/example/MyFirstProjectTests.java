package com.example;

import com.example.myfirstproject.MyFirstProjectActivity;
import com.example.myfirstproject.R;
import com.example.myfirstproject.TestImageListActivity;

import org.junit.Test;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyFirstProjectTests extends ActivityInstrumentationTestCase2<MyFirstProjectActivity> {

	TextView mTextView;
	Button mButton;
	MyFirstProjectActivity mActivity;
	Activity test;
	EditText mEditText,mPass;
	Instrumentation mInstrumentation;
	
	public MyFirstProjectTests(){
		this("Test JUnit Android");
	}
	
	public MyFirstProjectTests(String name) {
		super(MyFirstProjectActivity.class);
		setName(name);		
	}

	//initialize all of component in mainProject
	protected void setUp() throws Exception {
		super.setUp();		
		mActivity = getActivity();
		mTextView = (TextView)mActivity.findViewById(R.id.txt);
		mButton = (Button)mActivity.findViewById(R.id.button);
		mEditText =(EditText)mActivity.findViewById(R.id.editText1);
		mPass = (EditText)mActivity.findViewById(R.id.pass);
		mInstrumentation = getInstrumentation();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAvailabilityComponent()
	{
		assertNotNull(mButton);
		assertNotNull(mTextView);
		assertNotNull(mActivity);
		assertNotNull(mEditText);
		assertNotNull(mInstrumentation);
	}
	
	private void requestUnameFocus() {
		try {
			runTestOnUiThread(new Runnable() {
				
				public void run() {
					mEditText.requestFocus();
				}
			});
		} catch (Throwable e) {
			fail("Couldn't set focus");
		}
		
		//mInstrumentation.waitForIdleSync();
	}
	
	private void requestPassFocus() {
		try {
			runTestOnUiThread(new Runnable() {
				
				public void run() {
					mPass.requestFocus();
				}
			});
		} catch (Throwable e) {
			fail("Couldn't set focus");
		}
		
		//mInstrumentation.waitForIdleSync();
	}
	
	
	public void testInputIntTextConfirmButton()
	{
		requestUnameFocus();
		sendKeys(KeyEvent.KEYCODE_H,
				KeyEvent.KEYCODE_E,
				KeyEvent.KEYCODE_E,
				KeyEvent.KEYCODE_E,
				KeyEvent.KEYCODE_Y								
				);		
		TouchUtils.clickView(this, mButton);
		assertEquals("Username and Password", mTextView.getText().toString());
	}
				
	public void testInputStringTextConfirmButton()
	{
		requestUnameFocus();
		sendKeys("H E E E Y");		
		TouchUtils.clickView(this, mButton);
		System.out.print(mTextView.getText());
		assertEquals("Username and Password", mTextView.getText().toString());
	}
	
	
	public void testInputRepeatTextConfirmButton()
	{
		requestUnameFocus();
		sendRepeatedKeys(1,KeyEvent.KEYCODE_H,
				3,KeyEvent.KEYCODE_E,				
				1,KeyEvent.KEYCODE_Y								
				);
		TouchUtils.clickView(this, mButton);		
		System.out.print(mTextView.getText());
		assertEquals("Username and Password", mTextView.getText().toString());
	}
	
	@UiThreadTest
	public void testWhenEditableEmpty()
	{
		mButton.performClick();
		assertEquals("Username and Password", mTextView.getText().toString());		
	}
	
	@UiThreadTest
	public void testWhenEditableTextNotEmpty()
	{
		mEditText.setText("hallo");		
		mButton.performClick();	
		assertEquals("Username : hallo Password : hallo", mTextView.getText().toString());
			
		//test.finish();
		
	}

}
