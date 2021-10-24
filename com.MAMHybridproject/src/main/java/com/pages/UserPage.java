package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	@FindBy(xpath="//tr")
	List<WebElement> tableRows;
	
	
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void usertable() {
		for(WebElement row : tableRows) {
			System.out.println(row.getText());
		}
	}
	public int verifyRows() {
		
		return tableRows.size();
	}
	
}