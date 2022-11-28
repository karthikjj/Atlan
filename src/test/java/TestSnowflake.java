import org.snowFlake.BaseClass;
import org.snowFlake.Constants;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSnowflake extends BaseClass {

    String workSheetName;
    String dashboardName;


    @Test(priority = 0)
    public void login(){
        driver.get(Constants.url);
        enterUserName(Constants.getUserName);
        enterPassword(Constants.getPassWord);
        clickSignIn();
        waitTillVisible();
    }


    @Test(priority = 1)
    public void TestCreateNewWorkSheet(){
        clickWorkSheets();
        String defaultWorkSheetName = clickNewWorksheet();
        workSheetName = getWorkSheetName();
        renameAndVerifyWorkSheetOrDashboard(workSheetName,defaultWorkSheetName);
        selectDatabase("");
        selectSchema("CORE");
        clickWorksheetOrDashboardName(workSheetName);
        clickWorksheetOrDashboardName(workSheetName);
        enterQuery("Select * From ");
        clickRunInWorkSheet();

        clickHomePage();
        verifyWorkSheetIsCreated(workSheetName);

        clickWorkSheets();
        selectWorkSheet(workSheetName);
        deleteWorksheet(workSheetName);
    }

    @Test(priority = 2)
    public void TestCreateNewDashboard(){
        clickHomePage();
        clickDashboards();
        dashboardName = createNewDashboard();
        clickAddToTile();
        String workSheetName_1 = getWorkSheetName();
        renameAndVerifyWorkSheetOrDashboard(workSheetName_1,dateAndTime);
        selectDatabase("");
        selectSchema("CORE");

        clickWorksheetOrDashboardName(workSheetName_1);
        clickWorksheetOrDashboardName(workSheetName_1);
        enterQuery("Select * From ");
        clickRunInDashboard();

        clickReturnTo();
        clickHomePage();
        verifyDashBoardIsCreated(dashboardName);

        clickDashboards();
        selectDashboard(dashboardName);
        deleteDashboard(dashboardName);

    }






}
