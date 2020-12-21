import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

    @Test
    void customerRegistration() {
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

        //status Code validation
        int StatusCode = response.getStatusCode();
        System.out.println("Status Code is :" + StatusCode);
        Assert.assertEquals(StatusCode,201);

        //Job validation
        String JobID = response.jsonPath().get("job");
        System.out.println("Job is :" + JobID);
        Assert.assertEquals(JobID,"QA");

        //Content type validation
        String contentType = response.header("Content-type");
        System.out.println("Content Type is :" + contentType);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");

        //date validation
        String date = response.header("date");
        System.out.println("Date is :" + date);






    }



}
