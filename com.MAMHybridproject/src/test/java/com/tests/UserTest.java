package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testBase.TestBase;

public class UserTest extends TestBase {

	@Test
	public void verifyTableRows() {		
		Assert.assertEquals(DashboardTest.up.verifyRows(), 5);
	}
}
