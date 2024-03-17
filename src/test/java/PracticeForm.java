import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeForm {

    @FindBy(id = "firstName")
    WebElement txtFirstName;

    @FindBy(id = "lastName")
    WebElement txtLastName;

    @FindBy(id="userEmail")
    WebElement txtUserEmail;

    @FindBy(className = "custom-radio")
    List<WebElement> btnGenders;

    @FindBy(id = "userNumber")
    WebElement txtMobile;

    @FindBy(id = "dateOfBirthInput")
    WebElement txtDOB;

    @FindBy(id = "subjectsContainer")
    WebElement subjects;

    @FindBy(className = "custom-checkbox")
    List<WebElement> hobbies;

    @FindBy(id = "uploadPicture")
    WebElement uploadPic;

    @FindBy(id = "currentAddress")
    WebElement txtCurrentAddress;

    @FindBy(xpath = "//div[@id='state']")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "submit")
    WebElement btnSubmit;

    WebDriver driver;

    public PracticeForm(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void submitForm(){
        txtFirstName.sendKeys("Test");                      //firstName
        txtLastName.sendKeys("User73");                     //lastName
        txtUserEmail.sendKeys("testuser73@gmail.com");      //userEmail
        btnGenders.get(0).click();                                      //gender
        txtMobile.sendKeys("1234567890");                   //mobile

        txtDOB.click();                                                 //dateOfBirth
        txtDOB.sendKeys(Keys.CONTROL+"a");
        txtDOB.sendKeys("25 Sep 1996");
        txtDOB.sendKeys(Keys.ENTER);

        Actions action = new Actions(driver);                           //subjects
        action.click(subjects);
        action.sendKeys("hindi").perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();

        Utils.scroll(driver,0,400);                             //scroll

        hobbies.get(1).click();                                      //hobbies

        uploadPic.sendKeys(System.getProperty("user.dir")+"/src/test/resources/1.jpeg"); //pictures

        txtCurrentAddress.sendKeys("Dhaka");            //currentAddress


        action.click(state);                                        //state
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();

        action.click(city);                                         //city
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();

        btnSubmit.click();                                          //submit
    }

}
