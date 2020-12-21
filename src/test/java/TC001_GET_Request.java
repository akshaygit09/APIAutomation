import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {


    @Test
    void getUserDetails(){
        //Specify Base URI
        RestAssured.baseURI="https://reqres.in/";
        //Request Object
        RequestSpecification httpRequest = RestAssured.given();
        //Response Object
        Response response = httpRequest.request(Method.GET,"api/users/2");
        //print response in console window
        String ResponseBody = response.getBody().asString();
        System.out.println("Response is :" + ResponseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :" + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String StatusLine = response.getStatusLine();
        System.out.println("Status Line is : " + StatusLine);
        Assert.assertEquals(StatusLine,"HTTP/1.1 200 OK");


    }


}
