package com.expleo.restAssured.Steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AuthorSteps
{

    private static RequestSpecification reqSpec = null;
    private static ResponseSpecification respSpec = null;


    /**
     * Method submitValidIDandName gets the expected AuthorName
     * @param authorName the name we are looking for
     * @param authorID used for Serenity Reporting purposes
     */
    @Step("Author ID : {0}\n ")
    public void submitValidIDandName(String authorID,String authorName) {
        setReqSpec();
        setRespSpec(authorName);
    }


    /**
     * Method setReqSpec creates a new instance of RequestSpecBuilder with variables BaseURI and
     * Port Number and Base Path
     */
    @Step()
    private void setReqSpec() {

        try {
            reqSpec = new RequestSpecBuilder()
                    .setBaseUri("http://10.9.10.139")
                    .setPort(3000)
                    .setBasePath("/posts")
                    //.addPathParam("id",id)//...Not needed for this Web Service
                    .build();
        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }


    /**
     * Method setRespSpec asserts what we are expecting and what is returned
     * @param authorName the name of the Author we are expecting to find
     * @return Returns a message of the result of the methods operation
     */
    @Step()
    private String setRespSpec(String authorName)
    {
        String message;
        try {
            respSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectBody("author", equalTo(authorName))
                    .build();
            message = "Correct Match Found";
        }
        catch (AssertionError e)
        {
            message = "Invalid Author Name, Expected " + authorName;
        }
        return message;
    }


    /**
     * Method igetTheCorrectAuthorName gets the details of the expected authorID
     * @param expeceted the expected Author Name
     * @param auhtorID the AuthorID used to search for an author
     * @return Returns a message about the author search
     */

    public String igetTheCorrectAuthorName(String expeceted,String auhtorID) {
        String message;
        Response response = given(reqSpec, respSpec)
                .get(auhtorID);
        response.then().log().all();
        //please ignore next line, for debugging purposes
        //System.out.println("Response :: " + response.prettyPrint());
        return message = "Expected : "+ expeceted + "\n ID  : " +  auhtorID;
    }

    @Step("{0}")
    public void message(String message){}
}

