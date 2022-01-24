package com.indra.actions;

import com.indra.pages.MerchandiseEntryPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchandiseEntryAction extends MerchandiseEntryPage {
    public MerchandiseEntryAction(WebDriver driver) {
        super(driver);
    }


    public void loadMerchandise(){
        getInventory().click();
        getMerchandiseEntry().click();
        getMassMerchandiseEntry().click();
    }

    public void merchandiseEntry(){
        getChannel().click();
        getStoreChannel().click();
        getReason().click();
        getReasonMerchandiseEntry().click();
        getPointSale().click();
        getPointSaleStore().click();
        //compare();
        getSelectReason().click();
        getBulkUploadItems().click();
        getWindow().waitUntilClickable();
        FileUpload();
        getUploadFile2().click();
        //compareM();
        getUpload().click();
    }

    public void compare(){
        MatcherAssert.assertThat("El usuario esta en entrada de mercancia masiva",
                getPointSale().getText().equals(getStoreIndra().getText()));
    }

    public void compareM(){
        MatcherAssert.assertThat("El usuario esta en entrada de mercancia masiva",
                getCompare().equals("Erroneos: 0"));
    }

    public void compareUpload(){
        MatcherAssert.assertThat("El usuario termina entrada de mercancia masiva",
                getCompare2().equals("Carga Masiva Efectuada Exitosamente"));
    }

    public void FileUpload(){
        getUpload().waitUntilClickable().sendKeys("C:\\Users\\nriosa\\Desktop\\Mercanncia.csv");
    }

}
