import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_GET_ValidatingJSONResponse {

    @Test
    void getUserDetails(){
        //Specify Base URI
        RestAssured.baseURI="https://reqres.in/";
/*
        //For authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("Username");
        authScheme.setPassword("Password");

        RestAssured.authentication= authScheme;
*/





        //Request Object
        RequestSpecification httpRequest = RestAssured.given();
        //Response Object
        Response response = httpRequest.request(Method.GET,"api/users/2");
        //print response in console window
        String ResponseBody = response.getBody().asString();
       // System.out.println("Response is :" + ResponseBody);

        Assert.assertEquals(ResponseBody.contains("Janet"),true);

        JsonPath jsonpath = response.jsonPath();
        System.out.println(jsonpath.get("data"));
        System.out.println(jsonpath.get("email"));
        System.out.println(jsonpath.get("first_name"));
        System.out.println(jsonpath.get("last_name"));










    }

}
