package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void  beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successfulRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixeban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("IvanPetrov@12mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("6598955622");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/Cat.jpeg");
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan"), text("Petrov"), text("IvanPetrov@12mail.ru"), text("6598955622"));


    }
}



