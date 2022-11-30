package utilities;

import browsefactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


    public class UtilityTest extends BaseTest {
        public void clickOnElement(By by) {
            driver.findElement(by).click();
        }

        public String getTextOnElement(By by) {
            return driver.findElement(by).getText();
        }

        public void setTextOnElement(By by, String text) {
            driver.findElement(by).sendKeys(text);
        }


        public void switchToAlert() {
            //switch alert
            driver.switchTo().alert();
        }

        public void dismissAlert() {
            //switch alert
            driver.switchTo().alert().dismiss();
        }

        public void acceptAlert() {
            driver.switchTo().alert().accept();//Accept the alert
        }

        public void mouseHoverToElement(By by) {
            Actions a = new Actions(driver);
            WebElement e = driver.findElement(by);
            a.moveToElement(e).build().perform();
        }

        public void mouseHoverAndClick(By by) {

            Actions a = new Actions(driver);
            WebElement e = driver.findElement(by);
            a.moveToElement(e).click().build().perform();
        }

    }
