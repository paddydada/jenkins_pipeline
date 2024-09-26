package org.example.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Features/LoginPage.feature" }, glue = "org.example.cucumber.stepdefinitions")
  
public class CucumberRunnerTest {

}
