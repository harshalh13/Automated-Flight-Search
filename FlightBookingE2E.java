import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBookingE2E {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//loading URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");//URL
		driver.manage().window().maximize();
		
		
		//selecting India region
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a[class='ui-corner-all']"));
		for(WebElement option: options)
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		
		//selecting FROM
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//  //a[@value='BLR']
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		
		//Selecting TO
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//   (//a[@value='MAA'])[2]
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		// #ctl00_mainContent_ddl_destinationStation1_CTNR-------parent div
		
		
		//selecting date in calender
		//driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		//.ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();// -----NOT WORKING
		
		
		//verification for round trip date option
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
		
		//selecting family and friends checkbox
		Assert.assertFalse((driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected()));//will pass if confition is false
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());//will pass if confition is true
		
		
		//selecting 3 number of passengers
		int passengers = 4;
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i =1; i<passengers; i++) 
		{
			driver.findElement(By.id("hrefIncAdt")).click();	
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		//Selecting Currency
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		String country = "INR";
		dropdown.selectByValue(country);
		System.out.println(country);
		
		//Search Flight
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		

	}

}
