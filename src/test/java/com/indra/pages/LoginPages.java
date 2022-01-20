package com.indra.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://10.69.60.57:8180/tigo-pos-web/wap/windex.wml")
public class LoginPages extends PageObject {
    public LoginPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "filtro1")
    WebElementFacade user;
    @FindBy(id = "filtro2")
    WebElementFacade password;
    @FindBy(className = "boton1")
    WebElementFacade btnLogin;

    public WebElementFacade getUser() {
        return user;
    }

    public WebElementFacade getPassword() {
        return password;
    }

    public WebElementFacade getBtnLogin() {
        return btnLogin;
    }
}
