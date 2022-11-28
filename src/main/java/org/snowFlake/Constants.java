package org.snowFlake;

public class Constants {

    private Constants() {

    }

    protected static final long timeOuts = 30;

    public static final String url = "https://eq38788.ap-southeast-1.snowflakecomputing.com/console/login#/\n";

    public static final String getUserName = "SADIKJJ";

    public static final String getPassWord = "Test123@";

    protected static final String userName = "//input[@name='username']";

    protected static final String passWord = "//input[@name='password']";

    protected static final String signIn = "//div[@role='button'][contains(.,'Sign in')]";

    protected static final String workSheets = "//div//a[contains(@href,'worksheets')]";

    protected static final String dashBoards = "//div//a[contains(@href,'dashboard')]";

    protected static final String newWorkSheet = "//span[contains(.,'Worksheet')]//parent::div[@role='button'][@data-testid='new-button']";

    protected static final String newDashboard = "//div[@role='button'][text()='Dashboard']";

    protected static final String navRecent = "//main//div[text()='Recent']";

    protected static final String navSharedWithMe = "//main//div[text()='Shared with me']";

    protected static final String navMyWorkSheets = "//main//div[text()='My Worksheets']";

    protected static final String navFolders = "//main//div[text()='Folders']";
    protected static final String navMyDashboards = "//main//div[text()='My Dashboards']";

    protected static final String searchAllDocuments = "//div[@aria-label='Search all documents']";

    protected static final String enterValuesInSearchAllDocuments = "//input[@aria-label='Search all documents']";

    protected static final String optionsForWorksheets = "//div//following::*[@aria-label='Options for worksheets']";

    protected static final String optionsForDashboard = "//*[@aria-label='Options']//parent::div[@role='button']";

    protected static final String newFolder = "//div[@role='listbox']//div[text()='New Folder']";

    protected static final String manageFilters = "//div[@role='listbox']//div[text()='Manage Filters']";

    protected static final String createWorksheetFromSQLFile = "//div[@role='listbox']//div[text()='Create Worksheet from SQL File']";

    protected static final String rows = "//main//div[@role='rowgroup']//following::div[@role='row']";

    protected static final String goToHomePage = "//div/a[@data-testid='backToHomePageButton']";

    protected static final String worksheetName = "//div/a[@data-testid='backToHomePageButton']//following::span[contains(.,'-')]";

    protected static final String renameDashboardOrWorkSheet = "//div/input[contains(@aria-label,'Rename')]";

    protected static final String deleteWorkSheet = "//div[@role='menuitem'][contains(.,'Delete Worksheet')] | //div[@role='button'][contains(.,'Delete')]";

    protected static final String deleteDashboard = "//div[@role='menuitem'][contains(.,'Delete Dashboard')] | //div[@role='button'][contains(.,'Delete Dashboard')]";

    protected static final String duplicateDashboard = "//div[@role='menuitem'][contains(.,'Duplicate')]";

    protected static final String importSQL = "//div[@role='menuitem'][contains(.,'Import SQL from File')]";

    protected static final String duplicate = "//div[@role='menuitem'][contains(.,'Duplicate')]";

    protected static final String showShortcuts = "//div[@role='menuitem'][contains(.,'Show Shortcuts')]";

    protected static final String formatQuery = "//div[@role='menuitem'][contains(.,'Format Query')]";

    protected static final String moveTo = "//div[@role='menuitem'][contains(.,'Move to')]";

    protected static final String moveToNewFolder = "//div[@role='dialog']//following::div[@role='menuitem'][contains(.,'New Folder')]";

    protected static final String moveToNewDashboard = "//div[@role='dialog']//following::div[@role='menuitem'][contains(.,'New Dashboard')]";

    protected static final String databaseAndSchemaSelector = "//div[@data-testid='databaseAndSchemaSelector']";

    protected static final String searchDatabaseSelector = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Databases']";

    protected static final String searchSchemaSelector = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Schemas']";

    protected static final String searchWarehouses = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Warehouses']";

    protected static final String searchRoles = "//div[@data-testid='databaseAndSchemaSelector']//following::input[@placeholder='Roles']";

    protected static final String defaultDatabaseOption = "//div[@data-testid='databaseAndSchemaSelector']//following::div[@role='option'][@data-testid='default-option-component'][contains(.,'SNOWFLAKE')]";

    protected static final String sqlTextArea = "//div//textarea[@aria-label='SQL code block'][contains(@style,'outline')]";

    protected static final String shareWorkSheet = "//div[@role='button'][contains(.,'Share')]";

    protected static final String done = "//div[@role='button'][text()='Done']";

    protected static final String runQueryInWorkSheet = "//div[@role='button'][contains(@aria-label,'Run')]";

    protected static final String runQueryInDashboard = "//div[@role='dialog']//div[@role='button'][contains(@aria-label,'Run')]";

    protected static final String SearchAllDocumentsInDashBoard = "//input[@placeholder='Search all documents']";

    protected static final String getDatabaseAndSchemaOption(String value) {

        return "//div[@data-testid='databaseAndSchemaSelector']//following::div[@role='option'][@data-testid='default-option-component'][contains(.,'"+value+"')]";
    }
    protected static final String selectDocumentInSearch(String value) {

        return "//a[@role='option'][contains(.,'"+value+"')]";
    }
    protected static final String selectDefaultWorksheetOrDashboardName(String value) {

        return "//div[@role='button']/span[contains(.,'"+value+"')]";
    }

    protected static final String isDashboardPresent(String value) {

        return "//div[@role='row'][contains(.,'"+value+"')]";
    }



    protected static final String isWorkSheetPresent(String value) {

        return "//main//div[@role='rowgroup']//following::div[@role='row'][contains(.,'"+value+"')]";
    }
    protected static final String isDocumentsPresentInDashBoard(String value) {

        return "//input[@placeholder='Search all documents']//following::a/div[contains(.,'"+value+"')]";
    }

    protected static final String newDashboardPopUp = "//h2[@role='heading']//span[text()='New Dashboard']";

    protected static final String newDashboardName = "//input[@placeholder='Dashboard name']";

    protected static final String createDashboardButton = "//div[@role='button'][text()='Create Dashboard']";

    protected static final String cancelButton = "//div[@role='button'][text()='Cancel']";

    protected static final String newTile = "//div[@role='button'][text() ='New Tile']";

    protected static final String retrunTo = "//div[@role='button']//div[contains(text(),'Return to')]";

    protected static final String selectDashboardName(String value) {

        return "//div/a[@data-testid='backToHomePageButton']//following::div[@role='button']/span[contains(.,'"+value+"')]";
    }















}
