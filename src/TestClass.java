import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class TestClass {
    WebDriver driver = new ChromeDriver();
	String MyWebsite = "https://automationteststore.com/";
	String [] FirstNames = {"Baraa " , "Rahaf" , "Hadeel" , "Hamzeh" , "Abdullla" , "Ghadeer" , "Nasr" , "Intesar" , "Ahmad" };
	String [] LastNames = {"Hussam" , "Mohammad" , "Ammar" , "Dyaa" , "Omar" , "Ali" ,"Ammar" , "Yaser" , "Mahmood" , "Naser"};
	Random Rand = new Random();
	String GlobalUserName = "";
	String GlobalUserInput = "";
	String PasswordInput = "Baraa1234@";
	
	
	
	@BeforeTest 
	public void MyTest() {
		driver.get(MyWebsite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
	
	
	
	
	
	
	@Test (priority=1,enabled=false)
	public void SignUp() throws InterruptedException {
		int RandomIndexForFirstNames = Rand.nextInt (FirstNames.length);
		
		int RandomIndexForLastNames = Rand.nextInt(LastNames.length);
		
		
		String UserFirstName = FirstNames[RandomIndexForFirstNames];
		
		String UserLastName = LastNames [RandomIndexForLastNames];
		
		
		
		
		
		int RandomNumberForTheEmail = Rand.nextInt(489893);
		
		String DomainName = "@gmail.coom";
		
		
		driver.findElement(By.partialLinkText("Login")).click();
		
		
		// tagname [ @attributename='value' ]  >> xpath
		// button  [ @title = 'Continue' ] 
		WebElement SignInButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		SignInButton.click();
		
		
		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
		FirstName.sendKeys(UserFirstName);
		GlobalUserName = UserFirstName;
		
		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
		LastName.sendKeys(UserLastName);
		
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		Email.sendKeys(UserFirstName+UserLastName+RandomNumberForTheEmail+DomainName);
		
		WebElement Adress = driver.findElement(By.id("AccountFrm_address_1"));
		Adress.sendKeys("Amman city - tlaa al ali ");
		
		WebElement City = driver.findElement(By.id("AccountFrm_city"));
		City.sendKeys("Capital City");
		
		
		WebElement Country = driver.findElement(By.id("AccountFrm_country_id"));
		Select selector2 = new Select(Country);
		
		int RandomCountry = Rand.nextInt(1, 240);
		selector2.selectByIndex(RandomCountry);
		Thread.sleep(2000);
		
		WebElement Region = driver.findElement(By.id("AccountFrm_zone_id"));
		Select selector = new Select(Region);
		int RandomRegion = Rand.nextInt(1, 6);
		selector.selectByIndex(RandomRegion);
		
		WebElement ZipCode = driver.findElement(By.id("AccountFrm_postcode"));
		ZipCode.sendKeys("13310");
		
		
		
		
		
		
		
		String LocalUserInput = UserFirstName+UserLastName+RandomNumberForTheEmail ;
		
		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
		LoginName.sendKeys(LocalUserInput);
		GlobalUserInput = LocalUserInput ;
		WebElement Password = driver.findElement(By.id("AccountFrm_password"));
		Password.sendKeys(PasswordInput);
		WebElement ConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));
		ConfirmPassword.sendKeys(PasswordInput);
		
		WebElement CheckAgree = driver.findElement(By.id("AccountFrm_agree"));
		CheckAgree.click();
		
		WebElement ContinueButton = driver.findElement(By.xpath("//button [@title='Continue']"));
		ContinueButton.click();
	}
	
	
	
	
	
	@Test (priority=2,enabled=false)
	public void LogOut () throws InterruptedException {
		Thread.sleep(2000);
		WebElement UserNav = driver.findElement(By.id("customernav")); 
		
		Actions action = new Actions(driver);
		
		action.moveToElement(UserNav).perform();
		WebElement logoff = driver.findElement(By.linkText("Not "+GlobalUserName+"? Logoff"  ));
		logoff.click();
		Thread.sleep(2000);
	}
	
	
	@Test (priority=3,enabled=false)
	public void LogIn () {
		
		WebElement LogInButton=  driver.findElement(By.linkText("Login or register"));
		LogInButton.click();
		
		WebElement LoginName = driver.findElement(By.id("loginFrm_loginname"));
		LoginName.sendKeys(GlobalUserInput);
		
		WebElement Password = driver.findElement(By.id("loginFrm_password"));
		Password.sendKeys(PasswordInput);
		
		WebElement LoginButton = driver.findElement(By.xpath("//button [@title='Login']"));
		LoginButton.click();
	}
	
	@Test (priority=4) 
	public void AddToCart () throws InterruptedException {
	String [] WebSitesForTheItems = {"https://automationteststore.com/index.php?rt=product/category&path=68" , 
			"https://automationteststore.com/index.php?rt=product/category&path=36" , 
			"https://automationteststore.com/index.php?rt=product/category&path=43"  , 
			"https://automationteststore.com/index.php?rt=product/category&path=49"  , 
			"https://automationteststore.com/index.php?rt=product/category&path=58" , 
			"https://automationteststore.com/index.php?rt=product/category&path=52" , 
			"https://automationteststore.com/index.php?rt=product/category&path=65" } ; 
	int randomIndex = Rand.nextInt(WebSitesForTheItems.length);
	driver.get(WebSitesForTheItems[randomIndex]);
	
	//define for web element which is ul tag 
	WebElement ListOfItem = driver.findElement(By.cssSelector(".thumbnails.row"));
	int TotalNumbersOfItems = ListOfItem.findElements(By.tagName("li")).size();
	int RandomIndexForItem = Rand.nextInt(TotalNumbersOfItems);
	Thread.sleep(3000);
	ListOfItem.findElements(By.tagName("li")).get(RandomIndexForItem).click();;
	
	WebElement Container = driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
	int NumberOfProducts= Container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).size();
	
	int RandomIndexForProducts = Rand.nextInt(NumberOfProducts);
	
	Container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).get(RandomIndexForProducts).click();
	
	WebElement UlList = driver.findElement(By.className("productpagecart"));
	int LiItem = UlList.findElements(By.tagName("li")).get(0).findElements(By.tagName("a")).size();
	if (LiItem > 0) {
		driver.get(MyWebsite);

		System.out.println("sorry the item out of the stock ");
		String ExpectedResult = "https://automationteststore.com/";
		String ActualResult = driver.getCurrentUrl();
		Assert.assertEquals(ActualResult, ExpectedResult, "sosso");

	} else {

		driver.findElement(By.className("cart")).click();
		;
		Thread.sleep(2000);
		String ActualResult = driver.findElement(By.className("heading1")).getText();
		String ExpectedResult = "Shopping Cart";

		Assert.assertEquals(ActualResult, ExpectedResult.toUpperCase());

		boolean ExpectedValueForCheck = true;
		boolean ActualValueForCheck = driver.findElement(By.id("cart_checkout1")).isDisplayed();
		Assert.assertEquals(ActualValueForCheck, ExpectedValueForCheck);
		
		
		
	}
	
	
	
	
	
	
	
	//System.out.println(NumberOfItems);
	/*if (driver.findElement(By.className("nostock")).isDisplayed()) {
		driver.get(MyWebsite);
		System.out.println("item is out of the stock");
	}
	else { 
	driver.findElement(By.className("cart")).click();;*/
	
	}
	}
		
		
		
		
		
		
		
		
		
		
		
		/* driver.get("https://automationteststore.com/");
		WebElement ListOfItems = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul"));
		//ListOfItems.findElements(By.tagName("li")).size();
		//System.out.println(ListOfItems.findElements(By.className("subcategories")).size());;
		List<WebElement> myList= ListOfItems.findElements(By.tagName("li"));
		for (int i = 0 ; i < myList.size(); i ++) {
			if(myList.get(i).getText().contains("care")) {
				myList.get(i).click();
			}
		} */
		
		//driver.navigate().refresh();
		//	Thread.sleep(3000);
	
		//	ListOfItems.findElements(By.className("subcategories"));
		//	System.out.println(ListOfItems.findElements(By.className("subcategories")).size());
		//	Thread.sleep(3000);
		//	List <WebElement> TheItemsInsideListSubCategories = ListOfItems.findElements(By.tagName("li"));
		//TheItemsInsideListSubCategories.findElements(By.className("subcategories"));
		//TheItemsInsideListSubCategories.get(2).click();
		
	
	
	

