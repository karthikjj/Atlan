package org.snowFlake;


import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseClass {

    public WebDriver driver = null;
    public WebElement webElement = null;
    public WebDriverWait wait = null;
    public Actions actions = null;
    Faker faker = new Faker();

    protected String dateAndTime = "";


    public BaseClass(){

    }

    @BeforeSuite
    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.timeOuts));
        System.out.println("Before CLass Ran");
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
        if(dashboards.isDisplayed()){
            actionClick(dashboards);
        }
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

    public String getWorkSheetName(){
        return faker.name().firstName() +"-ws";
    }

    public String getDashboardName(){
        return faker.name().lastName() +"-db";
    }

    public String phone(){
        return faker.phoneNumber().cellPhone();
    }

    public void waitTillVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(180))
                .until(driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public void clickNewDashboards(){
        WebElement dashboards = findElement(Constants.newWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(dashboards);
        dashboards.click();
        waitTillVisible();
    }

    public String clickNewWorksheet(){
        WebElement workSheet = findElement(Constants.newWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(workSheet);
        workSheet.click();
        waitTillVisible();
        dateAndTime = getCurrentDateAndTime();
        return dateAndTime;
    }

    public String createNewDashboard(){
        WebElement dashboard = findElement(Constants.newDashboard,Locators.Xpath.getValue());
        moveToTheElement(dashboard);
        dashboard.click();
        waitTillVisible();
        dashboard = findElement(Constants.newDashboardName,Locators.Xpath.getValue());
        moveToTheElement(dashboard);
        dashboard.click();
        String dashboardName = getDashboardName();
        dashboard.sendKeys(dashboardName);
        dashboard = findElement(Constants.createDashboardButton,Locators.Xpath.getValue());
        moveToTheElement(dashboard);
        dashboard.click();
        waitTillVisible();
        dateAndTime = getCurrentDateAndTime();
        return dashboardName;
    }

    public boolean renameAndVerifyWorkSheetOrDashboard(String renameValue, String input){
        if(input.isBlank() || input.isEmpty() || input != null || input.equals("")){
            input = dateAndTime;
        }
        boolean flag = false;
        WebElement element = findElement(Constants.selectDefaultWorksheetOrDashboardName(input),Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        element = findElement(Constants.renameDashboardOrWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        element.clear();
        element.sendKeys(renameValue);
        element.sendKeys(Keys.TAB);
        element = findElement(Constants.selectDefaultWorksheetOrDashboardName(renameValue),Locators.Xpath.getValue());
        if(element.isDisplayed()){
            flag = true;
        }
        return flag;
    }

    public boolean deleteDashboard(String input){
        boolean flag = false;
        WebElement element = findElement(Constants.selectDefaultWorksheetOrDashboardName(input),Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        element = findElement(Constants.deleteDashboard,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        element = findElement(Constants.deleteDashboard,Locators.Xpath.getValue());
        if(element.isDisplayed()){
            moveToTheElement(element);
            element.click();
            flag = true;
        }
        return flag;
    }


    public boolean deleteWorksheet(String input) {
        boolean flag = false;
        WebElement element = findElement(Constants.selectDefaultWorksheetOrDashboardName(input),Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        element = findElement(Constants.deleteWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        element = findElement(Constants.deleteWorkSheet,Locators.Xpath.getValue());
        if(element.isDisplayed()){
            moveToTheElement(element);
            element.click();
            flag = true;
        }
        return flag;
    }


    public void searchAndSelectWorkSheetInDocumentsModal(String input){
        WebElement element = findElement(Constants.enterValuesInSearchAllDocuments,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        element.sendKeys(input);
        element = findElement(Constants.selectDocumentInSearch(input),Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        waitTillVisible();
    }

    public String getCurrentDateAndTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h");
        LocalDateTime now = LocalDateTime.now();
        String value = dateTimeFormatter.format(now).toLowerCase();
        return value;
    }

    public void selectDatabase(String input){
        WebElement element = findElement(Constants.databaseAndSchemaSelector,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();

        if(!input.isEmpty() || !input.isBlank()){
            element = findElement(Constants.searchDatabaseSelector,Locators.Xpath.getValue());
            moveToTheElement(element);
            element.click();
            element.sendKeys(input);
        }
        else {
            element = findElement(Constants.defaultDatabaseOption,Locators.Xpath.getValue());
            moveToTheElement(element);
            element.click();
        }
    }

    public boolean verifyDashBoardIsCreated(String input) {
        WebElement element = findElement(Constants.isDashboardPresent(input), Locators.Xpath.getValue());
        moveToTheElement(element);
        boolean result =  element.isDisplayed();
        Assert.assertTrue(result,"Dashboard -"+input+ " is created");
        return result;
    }

    public boolean verifyWorkSheetIsCreated(String input) {
        WebElement element = findElement(Constants.isWorkSheetPresent(input), Locators.Xpath.getValue());
        moveToTheElement(element);
        boolean result =  element.isDisplayed();
        Assert.assertTrue(result,"Worksheet -"+input+ " is created");
        return result;
    }
    public void selectWorkSheet(String input) {
        WebElement element = findElement(Constants.isWorkSheetPresent(input), Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        waitTillVisible();
    }

    public void selectDashboard(String input) {
        WebElement element = findElement(Constants.isDashboardPresent(input), Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        waitTillVisible();
    }

    public void selectSchema(String input) {
        WebElement element = findElement(Constants.searchSchemaSelector, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        if(!input.isEmpty() || !input.isBlank()){
            element = findElement(Constants.searchSchemaSelector,Locators.Xpath.getValue());
            moveToTheElement(element);
            element.click();
            element.sendKeys(input);
        }
        element = findElement(Constants.getDatabaseAndSchemaOption(input.toUpperCase()),Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void clickWorksheetOrDashboardName(String input){
        WebElement element = findElement(Constants.selectDefaultWorksheetOrDashboardName(input),Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void enterQuery(String input){
        WebElement element = findElement(Constants.sqlTextArea,Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        element.sendKeys(input);
        waitTillVisible();
    }

    public void clickRunInWorkSheet( ){
        WebElement element = findElement(Constants.runQueryInWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        waitTillVisible();
    }

    public void clickRunInDashboard( ){
        WebElement element = findElement(Constants.runQueryInDashboard,Locators.Xpath.getValue());
        moveToTheElement(element);
        actionClick(element);
        waitTillVisible();
    }

    public void selectShareandDone( ){
        WebElement element = findElement(Constants.shareWorkSheet,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
        element = findElement(Constants.done,Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void goToRecent() {
        WebElement element = findElement(Constants.navRecent, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void goToSharedWithMe() {
        WebElement element = findElement(Constants.navSharedWithMe, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void goToMyWorkSheets() {
        WebElement element = findElement(Constants.navMyWorkSheets, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void goToFolders() {
        WebElement element = findElement(Constants.navFolders, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void goToMyDashboard() {
        WebElement element = findElement(Constants.navMyDashboards, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void clickAddToTile() {
        WebElement element = findElement(Constants.newTile, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void clickReturnTo() {
        WebElement element = findElement(Constants.retrunTo, Locators.Xpath.getValue());
        moveToTheElement(element);
        element.click();
        waitTillVisible();
    }

    public void clickHomePage() {
        WebElement element = findElement(Constants.goToHomePage, Locators.Xpath.getValue());
        if(element.isDisplayed()){
            moveToTheElement(element);
            element.click();
        }
        waitTillVisible();
    }




}






