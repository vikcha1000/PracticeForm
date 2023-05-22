package pages;

import pages.components.CalenderComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Practice Form";

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName (String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName (String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail (String userEmail){
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender (String userGender) {
        $(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setUserNumber (String userNumber){
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDay (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        CalenderComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects (String subInput, String subjectsContainer) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subInput);
        $(byText(subjectsContainer)).click();
        return  this;
    }

    public RegistrationPage setHobby (String hobby){
        $(byText(hobby)).click();
        return  this;

    }

    public RegistrationPage uploadPicture (String url) {
        $("#uploadPicture").uploadFile(new File(url));
        return  this;
    }
    public RegistrationPage setCurrentAddress (String currentAddress){
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationPage setStateCity (String state, String city){
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public void submit()  {
        $("#submit").click();
    }

    public RegistrationPage verifyResultModal (String key, String value) {
        RegistrationResultsModal.verifyModalAppears();
        RegistrationResultsModal.verifyResult(key, value);
        return this;
    }

}