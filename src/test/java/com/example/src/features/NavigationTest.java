package com.example.src.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NavigationTest {

    @Test
    public void shouldAllowNavigation() throws Exception {
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:4200");

        $(".drawer__button--open").click();
        $(".drawer").should(appear);

        $(".drawer__button--users").click();

        $("app-user").should(appear);

        $(".drawer__button--open").click();
        $(".drawer").should(appear);

        $(".drawer__button--create-user").click();
        $(".create__user__page").should(appear);

        $(".drawer__button--open").click();
        $(".drawer").should(appear);

        $(".drawer__button--jobs").click();
        $("app-job").should(appear);
    }
}
