import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void  beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Ivan Petrov");
        $("#userEmail").setValue("IvanPetrov@12mail.ru");
        $("#currentAddress").setValue("RU, MSK");
        $("#permanentAddress").setValue("RU, some adress");
        $("#submit").click();

        $("#output").shouldHave(text("Ivan Petrov"), text("IvanPetrov@12mail.ru"),
                text("RU, MSK"), text("RU, some adress"));


    }
}
