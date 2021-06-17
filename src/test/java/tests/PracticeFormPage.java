package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    SelenideElement
            firstNameStudent = $("#firstName"),
            lastNameStudent = $("#lastName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            submitButton = $("#submit"),
            genderMale = $("[for='gender-radio-1']"),
            telNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSports = $("[for='hobbies-checkbox-1']"),
            hobbiesReading = $("[for='hobbies-checkbox-2']"),
            hobbiesMusic = $("[for='hobbies-checkbox-3']"),
            cityField = $("#city"),
            studentNameModal = $x("//*[@class='table-responsive']//*[text()='Student Name']/following::td"),
            genderModal = $x("//*[@class='table-responsive']//*[text()='Gender']/following::td"),
            phoneModal = $x("//*[@class='table-responsive']//*[text()='Mobile']/following::td"),
            dateOfBirdModal = $x("//*[@class='table-responsive']//*[text()='Date of Birth']/following::td"),
            subjectsModal = $x("//*[@class='table-responsive']//*[text()='Subjects']/following::td"),
            hobbiesModal = $x("//*[@class='table-responsive']//*[text()='Hobbies']/following::td"),
            addressModal = $x("//*[@class='table-responsive']//*[text()='Address']/following::td"),
            stateAndCityModal = $x("//*[@class='table-responsive']//*[text()='State and City']/following::td"),
            studentEmailModal = $x("//*[@class='table-responsive']//*[text()='Student Email']/following::td");

    @Step("открываем страницу с форомй для заполнения")
    public void openFormPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Step("Заплоняем имя студента даннымы {firstName} {lastName}")
    public void setNameStudent(String firstName, String lastName) {
        firstNameStudent.setValue(firstName);
        lastNameStudent.setValue(lastName);
    }

    @Step("Указываем адрес эдектронной почты: {userEmail}")
    public void setEmail(String userEmail) {
        email.setValue(userEmail);
    }

    @Step("Выбираем мужской пол")
    public void chooseGenderMale() {
        genderMale.scrollTo().click();

    }

    @Step("Вводим номер телефона: {number}")
    public void setMobileNumber(String number) {
        telNumberInput.setValue(number);
    }

    @Step("Выбираем предмет: {name}")
    public void chooseSubject(String name) {
        subjectsInput.setValue(name);
        $$(byText(name)).get(1).click();
    }

    @Step("Указываем все хобби")
    public void chooseHobbies() {
        hobbiesSports.click();
        hobbiesReading.click();
        hobbiesMusic.click();
    }

    @Step("Указываем текущий адресс: {address}")
    public void setCurrentAddress(String address) {
        currentAddress.setValue(address);
    }

    @Step("Выбираем штат {stateName} и город {cityName}")
    public void choseStateAndCity(String stateName, String cityName) {
        stateField.click();
        $(byText(stateName)).click();
        cityField.click();
        $(byText(cityName)).click();
    }

    @Step("Нажимаем отправить")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Проверяем что имя и фамилия равны: {firstName} {lastName}")
    public void assertStudentFullName(String firstName, String lastName) {
        studentNameModal.shouldHave(text(firstName + " " + lastName));
    }

    @Step("Проверяем что электронная почта равна {email}")
    public void assertStudentEmail(String email) {
        studentEmailModal.shouldHave(text(email));
    }

    @Step("Проверяем, что пол выбран {gender}")
    public void assertGender(String gender) {
        genderModal.shouldHave(text(gender));
    }

    @Step("Номер телефона в модалке равен {number}")
    public void assertMobNumber(String number) {
        phoneModal.shouldHave(text(number));
    }

    @Step("Предмет равен {subject}")
    public void assertSubject(String subject) {
        subjectsModal.shouldHave(text(subject));
    }

    @Step("Хобби указаны {hobbies}")
    public void assertHobbies(String ...hobbies) {
        for (String oneHobbies : hobbies) {
            hobbiesModal.shouldHave(text(oneHobbies));
        }
    }

    @Step("Текущий адрес указан {address}")
    public void assertCurrentAddress(String address) {
        addressModal.shouldHave(text(address));
    }

    @Step("Город и штат указаны {state} {city}")
    public void assertStateAndCity(String state, String city) {
        stateAndCityModal.shouldHave(text(state + " " + city));
    }

    public void assertStudentMail(String mail) {
        studentEmailModal.shouldHave(text(mail));
    }
}