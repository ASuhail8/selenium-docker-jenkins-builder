package com.searchmodule.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "q")
	private WebElement searchTxt;

	@FindBy(id = "search_button_homepage")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[text()='Videos']")
	private WebElement videosLink;

	@FindBy(xpath = "//div[contains(@class,'tile--vid')]")
	private List<WebElement> allVideos;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://duckduckgo.com/");
	}

	public void doSearch(String keyword) {
		wait.until(ExpectedConditions.visibilityOf(searchTxt));
		searchTxt.sendKeys(keyword);
		searchBtn.click();
	}

	public void goToVideos() {
		wait.until(ExpectedConditions.visibilityOf(videosLink));
		videosLink.click();
	}

	public int getResult() {
		By by = By.className("tile--vid");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println(allVideos.size());
		return allVideos.size();
	}

}
