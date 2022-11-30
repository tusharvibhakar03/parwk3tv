package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import utilities.UtilityTest;

public class RegisterTest extends UtilityTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    //1.verifyThatSigningUpPageDisplay
    public void verifyThatSigningUpPageDisplay()throws StaleElementReferenceException {
        //‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* Verify TEXT MESSASGE
        String vSignUp = "Signing up is easy!";
        Assert.assertEquals(vSignUp, getTextOnElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")));
    }

    //2.userSholdRegisterAccountSuccessfully
    @Test
    public void userShouldRegisterAccountSuccessfully()throws StaleElementReferenceException {
        //* ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //    First name
        setTextOnElement(By.xpath("//input[@id='customer.firstName']"), "Tushar");
        //*  Last name
        setTextOnElement(By.xpath("//input[@id='customer.lastName']"), "Vibhakar");
        //        Address
        setTextOnElement(By.xpath("//input[@id='customer.address.street']"), "44 Ceclil Road");
        //      City
        setTextOnElement(By.xpath("//input[@id='customer.address.city']"), "United Kingdom");
        //   *  State
        setTextOnElement(By.xpath("//input[@id='customer.address.state']"), "London");
        // *  Zip Code
        setTextOnElement(By.xpath("//input[@id='customer.address.zipCode']"), "HA3 5RA");
        //*  Phone
        setTextOnElement(By.xpath("//input[@id='customer.phoneNumber']"), "0208 427 1287");
        //*  SSN
        setTextOnElement(By.xpath("//input[@id='customer.ssn']"), "24689");
        //*  Username
        driver.findElement(By.xpath("//input[@id='customer.username']")).clear();
        setTextOnElement(By.xpath("//input[@id='customer.username']"), "TV8");
        //* PW
        setTextOnElement(By.xpath("//input[@id='customer.password']"), "Indra112");
        //* Confirm PW
        setTextOnElement(By.xpath("//input[@id='repeatedPassword']"), "Indra112");
        //* PRESS REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //* Verify TEXT MESSAGE
        String vYourLogin = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(vYourLogin, getTextOnElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
    }
    @After
    public void tearDown(){closeBrowser();}


}



