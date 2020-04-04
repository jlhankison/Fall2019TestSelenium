package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage eventsPage = new CalendarEventsPage();


    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/
    @Test
    public void defaultOptionsTest(){
        loginPage.login();
        eventsPage.navigateTo("Activities", "Calendar Events");
        eventsPage.clickToCreateCalendarEvent();
        String currentUser = eventsPage.getCurrentUserName();
        String owner = eventsPage.getOwnerName();
        Assert.assertEquals(currentUser, owner);

        String actualStartDate = eventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getTodaysDate("MMM dd, yyyy");
        Assert.assertEquals(expectedStartDate, actualStartDate);
    }

    /**
     * 15 minutes until 3:45
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/
    @Test
    public void defaultTimeDifference(){
        loginPage.login();
        eventsPage.navigateTo("Activities", "Calendar Events");
        eventsPage.clickToCreateCalendarEvent();

        String startTime = eventsPage.getStartTime();
        String endTime = eventsPage.getEndTime();
        String format = "h:mm a"; // format example:  5:15 AM

        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);

        long timeDifference = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

        System.out.println("timeDifference = " + timeDifference);
        Assert.assertEquals(timeDifference, 1);
    }

    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     **/
    @Test
    public void verifyCalendarTable (){
        loginPage.login();
        eventsPage.navigateTo("Activities", "Calendar Events");
        List<String> expectedColumnHeader = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        List<String> actualColumnHeaders = eventsPage.getColumnNames();

        Assert.assertEquals(actualColumnHeaders, expectedColumnHeader);
    }
    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventsTest(String title, String description){
        test = report.createTest("Create calendar event");
        loginPage.login();
        eventsPage.navigateTo("Activities", "Calendar Events");
        eventsPage.clickToCreateCalendarEvent();
        eventsPage.enterCalendarEventTitle(title);
        eventsPage.enterCalendarEventDescription(description);
        eventsPage.clickOnSaveAndClose();
    }

    @DataProvider
    public Object[][] calendarEvents (){
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"}
        };
    }
}
