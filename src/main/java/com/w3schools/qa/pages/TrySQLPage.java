package com.w3schools.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.w3schools.qa.pages.BasePage.openPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TrySQLPage {
    SelenideElement buttonRunSQL = $x("//button[contains(text(),'Run SQL')]");
    SelenideElement buttonResetDB = $x("//button[@id=\"restoreDBBtn\"]");
    SelenideElement resultLabel = $x("//*[@id='divResultSQL']/div");

    @Step("Open Main Page")
    public static TrySQLPage open() {
        openPage("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all");
        return page(TrySQLPage.class);
    }

    @Step("Click on Run SQL Button")
    public void clickRunSQL() {
        buttonRunSQL.shouldHave(exist, visible).click();
    }

    @Step("Click on Reset DB Button")
    public void clickResetDBButton() {
        buttonResetDB.shouldHave(exist, visible).click();
        Selenide.confirm();
    }

    @Step("Check row value")
    public void checkRowValue(String value1, String value2) {
        SelenideElement row = $x("//tr[td='" + value1 + "'][td='" + value2 + "']");
        row.shouldHave(exist, visible);
    }

    @Step("Validate no result text")
    public void validateNoResult() {
        assertThat("Validate no result text", resultLabel.getText(), equalTo("No result."));
    }

    @Step("Validate text after RestoreDB")
    public void validateDBRestoredLabel() {
        assertThat("Validate text after RestoreDB", resultLabel.getText(), equalTo("The database is fully restored."));
    }

    @Step("Set SQL Query")
    public void setSQLQuery(String query) {
        Selenide.executeJavaScript("window.editor.getDoc().setValue(\"" + query + "\")", "");
        Selenide.sleep(300);
    }


}
