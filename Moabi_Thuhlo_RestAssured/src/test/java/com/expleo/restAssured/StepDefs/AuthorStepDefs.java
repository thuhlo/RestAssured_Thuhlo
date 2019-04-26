package com.expleo.restAssured.StepDefs;

import com.expleo.restAssured.Steps.AuthorSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AuthorStepDefs
{
    String authorName = "Danica";
    String authorID = "6";
    @Steps
    AuthorSteps authorSteps;

    /**
     * Created from Author.feature
     */
    @Given("^I have a valid author id$")
    public void iHaveAValidAuthorId()
    {

    }

    /**
     * Created from Author.feature
     * Method used to send the Search AuthorID and AuthorName to the AuthorSteps.java
     */
    @When("^I submit the correct id$")
    public void iSubmitTheCorrectId()
    {
       authorSteps.submitValidIDandName(authorID,authorName);
    }

    /**
     * Created from Author.feature
     * Method
     */
    @Then("^I should receive the correct author name$")
    public void iShouldReceiveTheCorrectAuthorName()
    {
        authorSteps.message(authorSteps.igetTheCorrectAuthorName(authorName,authorID));
    }
}
