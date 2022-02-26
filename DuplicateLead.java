package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {

		//initiate browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Open Testleaf URL
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Login credentials
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();

		//click CRMSFA
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		//Create Leads
		WebElement clickLeads = driver.findElement(By.linkText("Leads"));
		clickLeads.click();
		WebElement clickCreatLeads = driver.findElement(By.linkText("Create Lead"));
		clickCreatLeads.click();
		WebElement enterCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		enterCompanyName.sendKeys("Invent");
		WebElement enterFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		enterFirstName.sendKeys("Rajasekar");
		WebElement enterLastName = driver.findElement(By.id("createLeadForm_lastName"));
		enterLastName.sendKeys("M");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Raja");
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("QA - Department");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mrajasekar@outlook.com");

		// Select value of state/region using visible text
		Select d = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		d.selectByVisibleText("New York");
		// Click submit
		driver.findElement(By.className("smallSubmit")).click();

		//Click on Duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// Clear Company
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Invent Softlabs");

		// Clear FirstName
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Raja Sekar");



		driver.findElement(By.className("smallSubmit")).click();

		System.out.println("Resulting Page Title -> "+driver.getTitle());
	}

}