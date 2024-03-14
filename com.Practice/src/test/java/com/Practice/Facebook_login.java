package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_login {

	public static void main(String[] args) {
     WebDriver driver;
     Properties prop = new Properties();
	   FileInputStream fis = null;
	   try {
		fis = new FileInputStream(Facebook_login.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"locators.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   prop.setProperty("browser", "chrome");
	   FileOutputStream fos = null;
	   try {
		fos = new FileOutputStream("C:\\Users\\ADMIN\\eclipse-workspace\\com.OHRM\\src\\test\\resources\\locators.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		prop.store(fos, null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver = WebDriverManager.chromedriver().create(); 
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
		//driver.get("https://www.facebook.com/signup");
		//login
		/*driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.name("login")).submit();*/
		
		//Signup
	driver.findElement(By.name(prop.getProperty("fname"))).sendKeys(prop.getProperty("fname_value"));
	driver.findElement(By.name(prop.getProperty("lname"))).sendKeys(prop.getProperty("lname_value"));	
	driver.findElement(By.name(prop.getProperty("regmail"))).sendKeys(prop.getProperty("regmail_value"));	
	driver.findElement(By.name(prop.getProperty("regpass"))).sendKeys(prop.getProperty("regpass_value"));
	
		//birthday selection
		WebElement drpbday= driver.findElement(By.name("birthday_day"));
		Select drpbirthday = new Select(drpbday);
		drpbirthday.selectByVisibleText("7");


		WebElement drpmonth = driver.findElement(By.name("birthday_month"));
		Select drpdmonth = new Select(drpmonth);
		drpdmonth.selectByValue("5");

		WebElement drpyear = driver.findElement(By.name("birthday_year"));
		Select drpdyear = new Select(drpyear);
		drpdyear.selectByValue("1997");
		
		//gender selection
		driver.findElement( By.xpath("//label[normalize-space()='Female']")).click();
		driver.findElement(By.name("websubmit")).click();

}

	private static Object Select(WebElement findElement) {
		// TODO Auto-generated method stub
		return null;
	}

}
