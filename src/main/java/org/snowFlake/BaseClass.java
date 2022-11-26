package org.snowFlake;


import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class BaseClass {

    public WebDriver driver = null;
    public WebElement webElement = null;
    public WebDriverWait wait = null;
    public Actions actions = null;
    Faker faker = new Faker();


    public BaseClass(){

    }

    @BeforeClass
    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.timeOuts));
        System.out.println("Before CLass Ran");
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
        System.out.println("After CLass Ran");

    }

    @AfterSuite
    public void quitDriver(){
        driver.quit();
        System.out.println("After Suite Ran");

    }


    public void enterUserName(String username){
        WebElement user = findElement(Constants.userName,Locators.Xpath.getValue());
        user.click();
        user.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement pswd = findElement(Constants.passWord,Locators.Xpath.getValue());
        pswd.click();
        pswd.sendKeys(password);
    }

    public void clickSignIn(){
        WebElement signIn = findElement(Constants.signIn,Locators.Xpath.getValue());
        signIn.click();
        waitTillVisible();
    }

    public void clickWorkSheets(){
        WebElement workSheets = findElement(Constants.workSheets,Locators.Xpath.getValue());
        moveToTheElement(workSheets);
        workSheets.click();
        waitTillVisible();
    }

    public void createNewWorkSheet(){
        WebElement newWorkSheet = findElement(Constants.newWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(newWorkSheet);
        newWorkSheet.click();
        waitTillVisible();
    }

    public void clickDashboards(){
        WebElement dashboards = findElement(Constants.dashBoards,Locators.Xpath.getValue());
        moveToTheElement(dashboards);
        dashboards.click();
        waitTillVisible();
    }

    public int getRandomNumber(int num){
        Random random = new Random();
        return random.nextInt(num);
    }

    public boolean waitTillVisible(WebElement webElement){

        return new WebDriverWait(driver, Duration.ofSeconds(Constants.timeOuts))
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    public WebElement findElement(String locator , String locatorType){
        locatorType = locatorType.toLowerCase();
        if(locatorType.contains("xpath")){
            webElement = driver.findElement(By.xpath(locator));
        }
        else  if(locatorType.contains("classname")){
            webElement = driver.findElement(By.className(locator));
        }
        else  if(locatorType.contains("id")){
            webElement = driver.findElement(By.id(locator));
        }
        else  if(locatorType.contains("tagname")){
            webElement = driver.findElement(By.tagName(locator));
        }
        else  if(locatorType.contains("css")){
            webElement = driver.findElement(By.cssSelector(locator));
        }
        else  if(locatorType.equals("linktext")){
            webElement = driver.findElement(By.linkText(locator));
        }
        else  if(locatorType.contains("partiallinktext")){
            webElement = driver.findElement(By.partialLinkText(locator));
        }
        return webElement;

    }

    public List<WebElement> findElements(String locator , String locatorType){
        List<WebElement> webElementList = new ArrayList<>();
        locatorType = locatorType.toLowerCase();
        if(locatorType.contains("xpath")){
            webElementList = driver.findElements(By.xpath(locator));
        }
        else  if(locatorType.contains("classname")){
            webElementList = driver.findElements(By.className(locator));
        }
        else  if(locatorType.contains("id")){
            webElementList = driver.findElements(By.id(locator));
        }
        else  if(locatorType.contains("tagname")){
            webElementList = driver.findElements(By.tagName(locator));
        }
        else  if(locatorType.contains("css")){
            webElementList = driver.findElements(By.cssSelector(locator));
        }
        else  if(locatorType.equals("linktext")){
            webElementList = driver.findElements(By.linkText(locator));
        }
        else  if(locatorType.contains("partiallinktext")){
            webElementList = driver.findElements(By.partialLinkText(locator));
        }
        return webElementList;

    }

    public WebElement scrollToTheElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitTillVisible(element);
        return element;
    }

    public WebElement moveToTheElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return element;
    }

    public WebElement actionClick(WebElement element){
        actions = new Actions(driver);
        actions.click(element);
        actions.perform();
        return element;
    }

    public String randomEmail() {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int stringLength = 5;
        for(int i = 0; i < stringLength; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.append("@gmail.com").toString();
        System.out.println("Random Name is: " + randomString);
        return randomString;
    }

    public String firstName(){
        return faker.name().firstName();
    }

    public String lastName(){
        return faker.name().lastName();
    }

    public String phone(){
        return faker.phoneNumber().cellPhone();
    }

    public void waitTillVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(180))
                .until(driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }




}

