package org.snowFlake;

public class Constants {

    private Constants() {

    }

    public static final long timeOuts = 120;

    public static final String url = "https://eq38788.ap-southeast-1.snowflakecomputing.com/console/login#/\n";

    public static final String getUserName = "SADIKJJ";

    public static final String getPassWord = "Test123@";

    public static final String userName = "//input[@name='username']";

    public static final String passWord = "//input[@name='password']";

    public static final String signIn = "//div[@role='button'][contains(.,'Sign in')]";

    public static final String workSheets = "//div//a[contains(.,'Worksheets')]";

    public static final String dashBoards = "//div//a[contains(.,'Dashboards')]";

    public static final String newWorkSheet = "//span[contains(.,'Worksheet')]//parent::div[@role='button'][@data-testid='new-button']";

    public static final String newDashboard = "//div[@role='button'][text()='Dashboard']";

    public static final String navRecent = "//main//div[text()='Recent']";

    public static final String navSharedWithMe = "//main//div[text()='Shared with me']";

    public static final String navMyWorkSheets = "//main//div[text()='My Worksheets']";

    public static final String navFolders = "//main//div[text()='Folders']";

    public static final String searchAllDocuments = "//div[@aria-label='Search all documents']";

    public static final String optionsForWorksheets = "//div//following::*[@aria-label='Options for worksheets']";

    public static final String optionsForDashboard = "//*[@aria-label='Options']//parent::div[@role='button']";

    public static final String newFolder = "//div[@role='listbox']//div[text()='New Folder']";

    public static final String manageFilters = "//div[@role='listbox']//div[text()='Manage Filters']";

    public static final String createWorksheetFromSQLFile = "//div[@role='listbox']//div[text()='Create Worksheet from SQL File']";

    public static final String rows = "//main//div[@role='rowgroup']//following::div[@role='row']";

    public static final String goToHomePage = "//div/a[@data-testid='backToHomePageButton']";

    public static final String worksheetName = "//div/a[@data-testid='backToHomePageButton']//following::span[contains(.,'-')]";

    public static final String renameWorksheet = "//div/input[contains(@aria-label,'Rename')]";

    public static final String deleteWorkSheet = "//div[@role='menuitem'][contains(.,'Delete Worksheet')]";

    public static final String importSQL = "//div[@role='menuitem'][contains(.,'Import SQL from File')]";

    public static final String duplicate = "//div[@role='menuitem'][contains(.,'Duplicate')]";

    public static final String showShortcuts = "//div[@role='menuitem'][contains(.,'Show Shortcuts')]";

    public static final String formatQuery = "//div[@role='menuitem'][contains(.,'Format Query')]";

    public static final String moveTo = "//div[@role='menuitem'][contains(.,'Move to')]";

    public static final String moveToNewFolder = "//div[@role='dialog']//following::div[@role='menuitem'][contains(.,'New Folder')]";

    public static final String moveToNewDashboard = "//div[@role='dialog']//following::div[@role='menuitem'][contains(.,'New Dashboard')]";

    public static final String databaseAndSchemaSelector = "//div[@data-testid='databaseAndSchemaSelector']";

    public static final String searchDatabaseSelector = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Databases']";

    public static final String searchSchemaSelector = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Schemas']";

    public static final String searchWarehouses = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Warehouses']";

    public static final String searchRoles = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Roles']";

    public static final String defaultDatabaseOption = "//div[@data-testid='databaseAndSchemaSelector']//following::div[@role='option'][@data-testid='default-option-component'][contains(.,'SNOWFLAKE')]";

    public static final String sqlTextArea = "//div//textarea[@aria-label='SQL code block'][contains(@style,'outline')]";

    public static final String shareWorkSheet = "//div[@role='button'][contains(.,'Share')]";

    public static final String runQueryInWorkSheet = "//div[@role='button'][contains(@aria-label,'Run')]";

    public static final String SearchAllDocumentsInDashBoard = "//input[@placeholder='Search all documents']";

    public static final String getDatabaseAndSchemaOption(String value) {

        return "//div[@data-testid='databaseAndSchemaSelector']//following::div[@role='option'][@data-testid='default-option-component'][contains(.,'"+value+"')]";
    }

    public static final String isWorkSheetPresent(String value) {

        return "//main//div[@role='rowgroup']//following::div[@role='row'][contains(.,'"+value+"')]";
    }
    public static final String isDocumentsPresentInDashBoard (String value) {

        return "//input[@placeholder='Search all documents']//following::a/div[contains(.,'"+value+"')]";
    }











}
