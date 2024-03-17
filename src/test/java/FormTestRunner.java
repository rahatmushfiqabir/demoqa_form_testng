import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTestRunner extends Setup {

    PracticeForm practiceForm;

    @Test(description = "Submitted form with valid data")
    public void doSubmit() throws InterruptedException {
        practiceForm = new PracticeForm(driver);
        practiceForm.submitForm();


        String actual = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Thread.sleep(1500);
        System.out.println(actual);
        String excepted = "Thanks for submitting the form";
        Assert.assertEquals(actual,excepted);
        Thread.sleep(1500);
        driver.findElement(By.id("closeLargeModal")).click();
    }
}
