package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {

    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){openBrowser();}
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()throws StaleElementReferenceException {
        //*  username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Tushar");
        //* password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Indra112");
        //* ‘Login
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* Verify message
        String vAccountOver = "Accounts Overview";
        Assert.assertEquals(vAccountOver, getTextOnElement(By.xpath("//h1[@class='title']")));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
    }

    //2.verifyTheErrorMessage
    @Test
    public void verifyTheErrorMessage() {
        //*  invalid username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "TV");
        //*  invalid password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "INDRA");
        //* press Login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* Verify the error message
        String vErrorMsg = "An internal error has occurred and has been logged.";
        Assert.assertEquals(vErrorMsg, getTextOnElement(By.xpath("//p[@class='error']")));
    }
    @Test
    //3.userShouldLogOutSuccessfully
    public void userShouldLogOutSuccessfully(){

        //* valid username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Tushar");
        //* valid password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "INDRA112");
        //* PRESS ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //* Verify MESSAGE ‘Customer Login’
        String vAccountOver = "Customer Login";
        Assert.assertEquals(vAccountOver, getTextOnElement(By.xpath("//h2[contains(text(),'Customer Login')]")));

    }
    @After
    public void tearDown(){closeBrowser();}
}





