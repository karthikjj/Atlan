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

    public static final String newWorkSheet = "//div[@data-testid='new-button']/span['Woksheet']";

    public static final String navRecent = "//main//div[text()='Recent']";

    public static final String navSharedWithMe = "//main//div[text()='Shared with me']";

    public static final String navMyWorkSheets = "//main//div[text()='My Worksheets']";

    public static final String navFolders = "//main//div[text()='Folders']";

    public static final String rows = "//main//div[@role='rowgroup']//following::div[@role='row']";




}
