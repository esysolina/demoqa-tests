package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("My name");
        $("#userEmail").setValue("test@test.ru");
        $("#currentAddress").setValue("Address1 address");
        $("#permanentAddress").setValue("Address2");
        $("#submit").click();

        $("#output").shouldHave(text("My name"), text("test@test.ru"),
                text("Address1"), text("Address2"));
    }
}
