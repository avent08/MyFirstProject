package com.example.myfirstproject.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class MyfirstProjectTestsRobotium extends ActivityInstrumentationTestCase2{

	private Solo solo;
	
	public MyfirstProjectTestsRobotium() throws ClassNotFoundException {
		super("com.example.myfirstproject", Class.forName("com.example.myfirstproject.MyFirstProjectActivity"));
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(),getActivity());
	}

	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void testWhenUnameAndPassFilled() {
		solo.typeText(0, "andhika.ventausa@gdpventure.com");
		solo.sleep(2000);
		solo.typeText(1,"password");
		solo.clickOnButton("login");		
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollDown();
		solo.sleep(2000);
		solo.clickInList(5);
	}
	
	public void testWhenUnameAndPassFilledLandscapeHome() {
		solo.setActivityOrientation(Solo.LANDSCAPE);
		solo.typeText(0, "andhika.ventausa@gdpventure.com");
		solo.sleep(2000);
		solo.typeText(1,"password");
		solo.clickOnButton("login");		
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollDown();
		solo.sleep(2000);
		solo.clickInList(5);
	}
	
	public void testWhenUnameAndPassFilledLandscapeInside() {
		solo.typeText(0, "andhika.ventausa@gdpventure.com");
		solo.sleep(2000);
		solo.typeText(1,"password");
		solo.clickOnButton("login");
		solo.setActivityOrientation(Solo.LANDSCAPE);
		solo.scrollDown();
		solo.sleep(2000);
		solo.scrollDown();
		solo.sleep(2000);
		solo.clickInList(5);
	}
	
	public void testWhenUnameFilled() {
		//solo.enterText(0, "Andhika_Ventausa");
		solo.typeText(0, "user name id input only test");
		solo.clickOnButton("login");		
		
	}
	
	public void testWhenPassFilled() {
		solo.typeText(1, "password input only test");		
		solo.clickOnButton("login");
		solo.sleep(2000);
		
	}

	
}
