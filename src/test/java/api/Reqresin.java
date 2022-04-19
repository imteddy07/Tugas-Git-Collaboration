package api;

import net.serenitybdd.rest.SerenityRest;


public class Reqresin {
    private static final String url = "https://reqres.in";

    //Scenario GET Single user
    public void GetSingleUser() {
        SerenityRest.get(url + "/api/users/2");
    }
}
