package com.w3schools.qa.ui;

import com.w3schools.qa.pages.TrySQLPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TrySQL {
    @Test
    @Description("Run and Validate SQL Query")
    public void runSqlQuery() {
        TrySQLPage trySQLPage = TrySQLPage.open();
        trySQLPage.setSQLQuery("Insert into Customers (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country) values ('99', 'Test Name', 'Contact Test Name', 'Test Adr', 'TestCity', 'Wa 1', 'RU');");
        trySQLPage.clickRunSQL();
        trySQLPage.setSQLQuery("Select * from Customers where CustomerID='99';");
        trySQLPage.clickRunSQL();
        trySQLPage.checkRowValue("99", "Test Name");
    }

    @Test
    @Description("Restore Data Base")
    public void restoreDB() {
        TrySQLPage trySQLPage = TrySQLPage.open();
        trySQLPage.setSQLQuery("Insert into Customers (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country) values ('99', 'Test Name', 'Contact Test Name', 'Test Adr', 'TestCity', 'Wa 1', 'RU');");
        trySQLPage.clickRunSQL();
        trySQLPage.setSQLQuery("Select * from Customers where CustomerID='99';");
        trySQLPage.clickRunSQL();
        trySQLPage.checkRowValue("99", "Test Name");
        trySQLPage.clickResetDBButton();
        trySQLPage.validateDBRestoredLabel();
        trySQLPage.setSQLQuery("Select * from Customers where CustomerID='99';");
        trySQLPage.clickRunSQL();
        trySQLPage.validateNoResult();
    }
}
