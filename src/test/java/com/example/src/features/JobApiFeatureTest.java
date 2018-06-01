package com.example.src.features;

import com.codeborne.selenide.CollectionCondition;
import com.example.src.models.Job;
import com.example.src.repositories.JobRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JobApiFeatureTest {
    @Autowired
    JobRepository jobRepository;

    @Before
    public void setUp() {
        jobRepository.deleteAll();
    }

    @After
    public void tearDown() {
        jobRepository.deleteAll();
    }

    @Test
    public void shouldAllowFullCrudFunctionality() throws Exception {

        Job firstJob = new Job(5, 200);
        Job secondJob = new Job(5, 500);

        Stream.of(firstJob, secondJob)
                .forEach(job -> {
                    jobRepository.save(job);
                });

        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:4200/jobs");
        $("[data-job-list-display").should(appear);
        $$("[data-job-list-display]").shouldHave(CollectionCondition.size(10));


        $(".button--apply").click();
        $(".apply__form").should(appear);
        $("#job-apply-full-name").sendKeys("John");
        $("#job-apply-email").sendKeys("Wayne");
        $("#job-apply-phone").sendKeys("2311123");
        $("#job-apply-cover-letter").sendKeys("Welcome to the world");

        $(".button--apply").shouldHave(text("Submit"));
        $(".button--apply").click();

        $("[data-job-list-display").should(appear);
        $(".view").should(appear);

        $(".view").click();
        $(".apply__form").should(appear);
        $(".header--applied").should(appear);
        $("#job-apply-full-name").shouldBe(disabled);
        $("#job-apply-email").shouldBe(disabled);
        $("#job-apply-phone").shouldBe(disabled);
        $("#job-apply-cover-letter").shouldBe(disabled);
        $(".button--apply").shouldBe(disabled);

    }

    @Test
    public void shouldHaveASearchBar() throws Exception {
        System.setProperty("selenide.browser", "Chrome");
        System.setProperty("selenide.headless", "true");

        open("http://localhost:4200/jobs");

        $(".searchbar--active").should(appear);
        $(".searchbar--active").click();
        $(".searchform").should(appear);
    }
}
