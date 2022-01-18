package com.indra.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://10.69.60.57:8180/tigo-pos-web/wap/windex.wml")
public class PruebaPages extends PageObject {
    public PruebaPages(WebDriver driver) {
        super(driver);
    }
}
