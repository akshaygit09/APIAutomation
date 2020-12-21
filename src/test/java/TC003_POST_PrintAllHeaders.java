import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_POST_PrintAllHeaders {


    @Test
    void customerRegistrationValidation() {
        //Specify Base URI
        RestAssured.baseURI = "https://reqres.in/";
        //Request Object
        RequestSpecification httpRequest = RestAssured.given();
        //Request Payload sending along with Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Akshay");
        requestParams.put("job", "QA");

        httpRequest.header("Content-type","application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST,"api/users");

        String ResponseBody = response.getBody().asString();
        System.out.println("Response Body is : " + ResponseBody);

        //getAllHeaders
        Headers allheaders =  response.headers();
        for(Header header:allheaders){
            System.out.println(header.getName() + "    " + header.getValue());
        }







    }

}
