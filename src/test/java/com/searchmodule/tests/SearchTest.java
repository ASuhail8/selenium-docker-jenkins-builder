package com.searchmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;

import test.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int result =  searchPage.getResult();
        Assert.assertTrue(result>0);
    }
    
    @Test
    public void justGoToTheSite() {
    	 SearchPage searchPage = new SearchPage(driver);
         searchPage.goTo();	
    }



}
