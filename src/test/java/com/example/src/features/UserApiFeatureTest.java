package com.example.src.features;

import com.codeborne.selenide.CollectionCondition;
import com.example.src.models.User;
import com.example.src.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserApiFeatureTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldAllowFullCrudFunctionalityForAUser() throws Exception {
        User firstUser = new User(
                "someone",
                "Ima",
                12,
                "captian",
                "oh",
                "my",
                "player"
        );

        User secondUser = new User(
                "Inker",
                "Dosa",
                44,
                "create",
                "hello",
                "world",
                "the end"
        );

        Stream.of(firstUser, secondUser)
                .forEach(user -> {
                    userRepository.save(user);
                });


        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:4200");

        $$("[data-user-list-display]").shouldHave(CollectionCondition.size(2));


        long firstUserId = firstUser.getId();
        $(".user-" + firstUserId + "-name").shouldHave(text("someone"));
        $(".user-" + firstUserId + "-name").shouldHave(text("Ima"));

        long secondUserId = secondUser.getId();
        $(".user-" + secondUserId + "-name").shouldHave(text("Inker"));
        $(".user-" + secondUserId + "-name").shouldHave(text("Dosa"));

        $(".create-user-btn").click();

        $(".create-user-form").should(appear);

        $("#create-user-first-name").sendKeys("johnny");
        $("#create-user-last-name").sendKeys("walker");
        $("#create-user-age").sendKeys("30");
        $("#create-user-occupation").sendKeys("warrior");
        $("#create-user-ethnicity").sendKeys("monkey");
        $("#create-user-interests").sendKeys("champion");

        $(".submit-create-user-button").click();

        $("[data-user-list-display").should(appears);
        $$("[data-user-list-display]").shouldHave(CollectionCondition.size(3));
    }

}
