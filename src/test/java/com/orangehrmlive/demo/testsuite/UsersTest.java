package com.orangehrmlive.demo.testsuite;
/**
 * adminShouldAddUserSuccessFully().
 *     Login to Application
 * 	click On "Admin" Tab
 * 	Verify "System Users" Text
 * 	click On "Add" button
 * 	Verify "Add User" Text
 * 	Select User Role "Admin"
 * 	enter Employee Name "Ananya Dash"
 * 	enter Username
 * 	Select status "Disable"
 * 	enter psaaword
 * 	enter Confirm Password
 * 	click On "Save" Button
 * 	verify message "Successfully Saved"
 *
 * 2. searchTheUserCreatedAndVerifyIt().
 * 	Login to Application
 * 	click On "Admin" Tab
 * 	Verify "System Users" Text
 * 	Enter Username
 * 	Select User Role
 * 	Select Satatus
 * 	Click on "Search" Button
 * 	Verify the User should be in Result list.
 *
 * 3. verifyThatAdminShouldDeleteTheUserSuccessFully.
 * 	Login to Application
 * 	click On "Admin" Tab
 * 	Verify "System Users" Text
 * 	Enter Username
 * 	Select User Role
 * 	Select Satatus
 * 	Click on "Search" Button
 * 	Verify the User should be in Result list.
 * 	Click on Check box
 * 	Click on Delete Button
 * 	Popup will display
 * 	Click on Ok Button on Popup
 * 	verify message "Successfully Deleted"
 *
 * 4. searchTheDeletedUserAndVerifyTheMessageNoRecordFound.
 * 	Login to Application
 * 	click On "Admin" Tab
 * 	Verify "System Users" Text
 * 	Enter Username
 * 	Select User Role
 * 	Select Satatus
 * 	Click on "Search" Button
 * 	verify message "No Records Found"
 */

import com.orangehrmlive.demo.page.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {


    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage = new HomePage();
    ViewSystemUsersPage systemUsersPage = new ViewSystemUsersPage();
    AddUserPage addUserPage = new AddUserPage();


    @Test
    public void adminShouldAddUserSuccessFully()
    {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdmin();
        Assert.assertEquals(systemUsersPage.getSystemUserText(),"System Users");
        systemUsersPage.clickOnAddButton();
        Assert.assertEquals(systemUsersPage.getAddUserText(),"Add User");
        addUserPage.selectUserRoleDropDownAddUserLocator("Admin");
        addUserPage.enterEmployeeNameAddUserLocator("Ananya Dash");
        addUserPage.enterUserNameAddUserLocator("ananya");
        addUserPage.selectStatusDropDownAddUserLocator("Disabled");
        addUserPage.enterPasswordAddUser("Admin@123");
        addUserPage.enterConfirmPasswordAddUser("Admin@123");
        addUserPage.clickOnSaveAddUser();
        Assert.assertEquals(addUserPage.getTextFromSuccessfullyAdded(),"Successfully Saved");




    }

    @Test
    public void searchTheUserCreatedAndVerifyIt()
    {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdmin();
        Assert.assertEquals(systemUsersPage.getSystemUserText(),"System Users");
        // systemUsersPage.clickOnSystemUserButton();
        systemUsersPage.enterUsernameField("John.Smith");
        systemUsersPage.selectUserRollDropdown("Admin");
        systemUsersPage.selectStatusDropdown("Enabled");
        systemUsersPage.clickOnSearchButton();
        Assert.assertEquals(systemUsersPage.getTextSearchUserResultText(),"John Smith");

    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException
    {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdmin();
        Assert.assertEquals(systemUsersPage.getSystemUserText(),"System Users");
        // systemUsersPage.clickOnSystemUserButton();
        systemUsersPage.enterUsernameField("Admin");
        Thread.sleep(2000);
        systemUsersPage.selectUserRollDropdown("Admin");
        systemUsersPage.selectStatusDropdown("Enabled");
        systemUsersPage.clickOnSearchButton();
        Assert.assertEquals(systemUsersPage.getTextSearchUserResultText(),"Carolinecarl CollingsMagare");
        systemUsersPage.clickOnCheckBox();
        systemUsersPage.clickOnDeleteButton();
        systemUsersPage.clickOnOkInDeleteUserPopUp();
        Assert.assertEquals(systemUsersPage.getDeleteUserSuccessfullyMessageText(),"Successfully Deleted");


    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException
    {
        Thread.sleep(1000);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLogin();
        homePage.clickOnAdmin();
        Assert.assertEquals(systemUsersPage.getSystemUserText(),"System Users");
        // systemUsersPage.clickOnSystemUserButton();
        systemUsersPage.enterUsernameField("Admin");
        //Thread.sleep(2000);
        systemUsersPage.selectUserRollDropdown("Admin");
        systemUsersPage.selectStatusDropdown("Enabled");
        systemUsersPage.clickOnSearchButton();

    }

}