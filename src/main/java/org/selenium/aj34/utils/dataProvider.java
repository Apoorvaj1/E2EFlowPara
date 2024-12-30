package org.selenium.aj34.utils;

import org.testng.annotations.DataProvider;

public class dataProvider {

//    @DataProvider(name = "demoData")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Iphone"},
//                {"Powerbank"},
//                {"AC"}
//        };
//    }

    @DataProvider(name = "demoData")
    public Object[][] getData(){
        Object[][] object = new Object[2][1];
        object[0][0] = "Taj Mahal";
        object[1][0] = "Amul";
        return object;
    }
}
