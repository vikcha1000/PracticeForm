package  pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String titleText = "Practice Form";

    public void openPage() {

        open("/automation-practice-form");
        $(".main-header").shouldHave(text(titleText));
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName

}