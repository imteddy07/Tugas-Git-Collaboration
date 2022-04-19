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


}
