package com.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.UserPage;
import com.testBase.TestBase;

public class DashboardTest  extends TestBase {

	
	public static  UserPage up;
	@Test(priority=1)
	public void verifyCourses() {
		ArrayList<String> expCourses = new ArrayList<String>();
		expCourses.add("Selenium");
		expCourses.add("Java / J2EE");
		expCourses.add("Python");
		expCourses.add("Php");
		Assert.assertEquals(LoginTest.dp.verifycourse(), expCourses);;
		
	}
	@Test(priority=2)
	public void userClick() {
		up =LoginTest.dp.clickUsersLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		
	}
}
