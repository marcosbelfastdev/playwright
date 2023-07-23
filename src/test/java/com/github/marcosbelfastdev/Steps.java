package com.github.marcosbelfastdev;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

/**
 * Created by upgundecha on 14/10/16.
 */
public class Steps {


    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^I start a new emulator session$")
    public void i_start_a_new_emulator_session() throws Throwable {

        System.out.println("Teste");
        //session = new Session("test");
        //session.open();

    }
}

