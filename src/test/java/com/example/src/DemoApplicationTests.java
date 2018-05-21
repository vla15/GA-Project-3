package com.example.src;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoApplicationTests {

	@Test
	public void demoTest() {
		System.setProperty("selenide.browser", "Chrome");

		open("http://www.google.com");

		WebElement queryBox = $(By.name("q"));
		queryBox.sendKeys("Kent Beck");
		queryBox.submit();

		$("body").shouldHave(text("extreme programming"));
	}

}
