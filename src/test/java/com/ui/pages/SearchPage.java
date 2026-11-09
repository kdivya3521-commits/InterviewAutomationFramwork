package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class SearchPage extends BrowserUtility {

	private static final By SEARCHHEADERLOCATOR = By.xpath("//h1[@class=\"page-heading  product-listing\"]");
	private static final By SEARCHRESULTSLOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchHeaderText() {
		return getVisableText(SEARCHHEADERLOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywordsList = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNames = getVisableTextofAllElements(SEARCHRESULTSLOCATOR);

		boolean result = productNames.stream()
				.anyMatch(name -> (keywordsList.stream().anyMatch(name.toLowerCase()::contains)));

		return result;
	}

	// Clicking on the product based on the index form list of searched products
	public ProductDetailedPage clickOnTheProductAt(int index) {
		clickOn(getAllElements(SEARCHRESULTSLOCATOR).get(index));
		ProductDetailedPage productdetailPage = new ProductDetailedPage(getDriver());
		return productdetailPage;
	}

}
