package org.selenium.aj34.utils;

import net.datafaker.Faker;
import org.testng.annotations.DataProvider;

public class dataProviderPayload {

    Faker faker = new Faker();


    @DataProvider(name = "demoData")
    public Object[][] getData(){
        return new Object[][]{
                {"Apoorv", "Jaswal",123},
                {"Rahul","Jain",456},
                {"Ravi","Singh",789}
        };
    }

    @DataProvider(name = "demoData1")
    public Object[][] getData1(){
        return new Object[][]{
                {faker.name().firstName(), faker.name().lastName(),faker.number().numberBetween(1,1000),faker.bool().bool()},
                {faker.name().firstName(), faker.name().lastName(),faker.number().numberBetween(1,1000),faker.bool().bool()},
                {faker.name().firstName(), faker.name().lastName(),faker.number().numberBetween(1,1000),faker.bool().bool()}
        };
    }
}
