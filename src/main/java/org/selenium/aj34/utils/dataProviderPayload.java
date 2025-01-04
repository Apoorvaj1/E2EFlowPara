package org.selenium.aj34.utils;

import org.testng.annotations.DataProvider;

public class dataProviderPayload {


    @DataProvider(name = "demoData")
    public Object[][] getData(){
        return new Object[][]{
                {"Apoorv", "Jaswal"},
                {"Rahul","Jain"},
                {"Ravi","Singh"}
        };
    }
}
