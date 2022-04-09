package api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

public class Reqresin {
    private static final String url = "https://reqres.in";

    //Scenario GET Single user
    public void GetSingleUser() {
        SerenityRest.get(url + "/api/users/2");
    }

    public void UserNotFound() {
        SerenityRest.get(url + "/api/users/23");
    }
    public void PostLogin () {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("email", "eve.holt@reqres.in");
        bodyJson.put("password", "cityslicka");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .post(url + "/api/login");
    }
    public void PostRegister () {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put ("email", "eve.holt@reqres.in");
        bodyJson.put ("password", "pistol");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .post(url + "/api/register");
    }
    public void PostCreate () {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put ("name", "morpheus");
        bodyJson.put ("job", "leader");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .post(url + "/api/users");
    }
    public void PutUpdate() {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put ("name", "morpheus");
        bodyJson.put ("job", "zion resident");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJson.toString())
                .put(url + "/api/users/2");
    }
    public void DeleteData (){
        Response response = SerenityRest.delete(url + "/api/users/2");
        Assert.assertEquals(response.statusCode(), 204);
    }
}
