import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 100000;
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void successRegistrationTest(){

        //Переменые регистрируемого студента
        //идеи доработки: вынести все в одтельную переменную, может список, + добавить все переменные студента
        //идеи доработок 2: когда вынесу переменные в объкт, вынести его в отдельный файл
        //идея 3: возможность создавать и проверять одним кейсом 2 объекта или вооьще любое количество
        //совершенный вариант: создавать массив тестовых данных и выбирать рандомно из ниъ
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "email@email.ru";
        String gender = "Male";
        String userNumber = "1234567890";
        String subjectsContainer_1 = "sc";
        String subjectsContainer_2 = "y";
        String hobby_1 = "Reading";
        String hobby_2 = "Music";
        String currentAddress = "My current Address";

        //заполняем форму

        new RegistrationPage().openPage();

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--017").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subjectsContainer_1);
        $(byText("Computer Science")).click();
        $("#subjectsInput").setValue(subjectsContainer_2);
        $(byText("Biology")).click();
        $(byText(hobby_1)).click();
        $(byText(hobby_2)).click();
        $("#uploadPicture").uploadFile(new File("src/test/data/sample.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        //Блок проверок
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $$("td").shouldHave(itemWithText(firstName + " " + lastName));
        $$("td").shouldHave(itemWithText(userEmail));
        $$("td").shouldHave(itemWithText(gender));
        $$("td").shouldHave(itemWithText(userNumber));
        $$("td").shouldHave(itemWithText("17 September,1984"));
        $$("td").shouldHave(itemWithText("Computer Science, Biology"));
        $$("td").shouldHave(itemWithText(hobby_1 + ", " + hobby_2));
        $$("td").shouldHave(itemWithText("sample.jpg"));
        $$("td").shouldHave(itemWithText(currentAddress));
        $$("td").shouldHave(itemWithText("Haryana Panipat"));

    }

}

