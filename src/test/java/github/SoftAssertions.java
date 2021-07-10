package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSoftAssertions() {
        open("https://github.com/selenide/selenide");
        $("[data-content=Wiki]").click();
        $("#wiki-pages-filter").setValue("Soft");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
