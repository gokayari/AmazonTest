package com.clipboardHealth.step_definitions;

// in this class we define pre and post conditions to each scenario and each step.

import com.clipboardHealth.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    //runs before every scenario
    //@Before   // import from io.cucumber.java not junit
    public void setupScenario(){

        System.out.println("====setting up browser using cucumber @Before");

    }


    //runs after every scenario
    @After   // import from io.cucumber.java not junit
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){

            byte screenshot[]= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        //this will automatically close the driver after every scenario
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
    }

    // @BeforeStep
    public void setupStep(){
        System.out.println("-------->applying setup using @BeforeStep");

    }

    //@AfterStep
    public void afterStep(){
        System.out.println("-------->applying tearDown using @AfterStep");

    }
}
