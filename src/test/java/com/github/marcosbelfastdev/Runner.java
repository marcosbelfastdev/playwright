package com.github.marcosbelfastdev;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.github.marcosbelfastdev")
public class Runner {
    // Leave this class empty; it's just a placeholder for the test runner
}
