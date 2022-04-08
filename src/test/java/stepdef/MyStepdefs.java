package stepdef;

import api.Reqresin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class MyStepdefs {
    Reqresin reqresin = new Reqresin();

    @When("User send GET HTTP request to reqresin")
    public void userSendGETHTTPRequestToReqresin() {
        reqresin.GetSingleUser();
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe (int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
    @And("response status should match with schema \"([^\"]*)\"$")
    public void responseStatusShouldMatchWithSchema(String schema) {
            String path = String.format("schema/%s", schema);
            System.out.println(path);
            restAssuredThat(response -> response.assertThat().body(matchesJsonSchemaInClasspath(path)));
    }

    @When("User send other GET HTTP requset to reqresin")
    public void userSendOtherGETHTTPRequsetToReqresin() {
        reqresin.UserNotFound();
    }

    @When("User send POST register HTTP request to reqresin")
    public void userSendPOSTRegisterHTTPRequestToReqresin() {
        reqresin.PostRegister();
    }

    @When("User send POST create HTTP request to reqresin")
    public void userSendPOSTCreateHTTPRequestToReqresin() {
        reqresin.PostCreate();
    }

    @When("User send PUT update HTTP request to reqresin")
    public void userSendPUTUpdateHTTPRequestToReqresin() {
        reqresin.PutUpdate();
    }

    @When("User send Delete data HTTP request to reqresin")
    public void userSendDeleteDataHTTPRequestToReqresin() {
        reqresin.DeleteData();
    }

    @When("User send POST login HTTP request to reqresin")
    public void userSendPOSTLoginHTTPRequestToReqresin() {
        reqresin.PostLogin();
    }


}
