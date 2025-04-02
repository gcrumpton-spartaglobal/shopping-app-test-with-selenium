package com.sparta.gdc.testframework.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@Happy",
        plugin = {"pretty", "html:target/testreport.html", "json:target/jsonReport.json"},
        publish = true,
        glue = "com.sparta.gdc.testframework.stepdefs"
)
public class TestRunner {
}
