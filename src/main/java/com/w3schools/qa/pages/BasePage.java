package com.w3schools.qa.pages;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public static void openPage(String url) {
        open(url);
    }

}