import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest  extends TestBase {

    @Test
    void successRegistrationTest (){
        //заполняем форму
        new RegistrationPage().openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("email@email.ru")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setBirthDay("17", "September", "1984")
                .setSubjects("sc", "Computer Science")
                .setSubjects("y", "Biology")
                .setHobby("Reading")
                .setHobby("Music")
                .uploadPicture("src/test/data/sample.jpg")
                .setCurrentAddress("My current Address")
                .setStateCity("Haryana", "Panipat")
                .submit();

        //Блок проверок
        new RegistrationPage().verifyResultModal("Student Name", "Ivan Ivanov")
                .verifyResultModal("Student Email", "email@email.ru")
                .verifyResultModal("Gender", "Male")
                .verifyResultModal("Mobile", "1234567890")
                .verifyResultModal("Date of Birth", "17 September,1984")
                .verifyResultModal("Subjects", "Computer Science, Biology")
                .verifyResultModal("Hobbies", "Reading, Music")
                .verifyResultModal("Picture", "sample.jpg")
                .verifyResultModal("Address", "My current Address")
                .verifyResultModal("State and City", "Haryana Panipat");

    }

}

