package com.ca.steps;

import com.ca.runner.RunTest;
import com.ca.steps.support.TextBlobGenerator;
import cucumber.api.java.en.Given;
import java.util.List;


public class TestSteps extends RunTest {

    TextBlobGenerator generator = new TextBlobGenerator();

    @Given("^I can Generate a Blob of Text$")
    public void i_can_Generate_a_Blob_of_Text(List<String> table) throws Throwable {
//        System.out.println(table.size());

        for (int i = 0; i < table.size(); i++){
            System.out.println(table.get(i));
            System.out.println(generator.main(table.get(i)));
        }
    }


}
