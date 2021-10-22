package rr.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC8BasicAuthentication {	
	@Test
	void getCity()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpReq=RestAssured.given().log().all();
		
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("use");
		auth.setPassword("pwd");
		RestAssured.authentication=auth;
		
		
		
		Response response=httpReq.request(Method.GET,"/2");
		
		String resBody=response.getBody().asString();
		
		System.out.println(resBody);
		
		
		//Validate Status Code 
		int ActualStatusCode=response.getStatusCode();
		Assert.assertEquals(ActualStatusCode, 200);
		
		
		//validate Header 
		String ExpectedContentType=response.getHeader("Content-Type");
		//Assert.assertEquals(ExpectedContentType, 200);
		
		
		//Extract value for a key in a JSON Response
		JsonPath js=response.jsonPath();	
		System.out.println(js.getString("email"));
				
	}	
}
