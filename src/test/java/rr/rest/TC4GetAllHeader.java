package rr.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC4GetAllHeader {	
	@Test
	void getCity()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httpReq=RestAssured.given().log().all();
		Response response=httpReq.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String resBody=response.getBody().asString();
		
		System.out.println(resBody);
		
		
		//Validate Status Code 
		int ActualStatusCode=response.getStatusCode();
		Assert.assertEquals(ActualStatusCode, 200);
		
		
		//Capture All Header 
		Headers allheader=response.headers();
		for(Header h:allheader) 
		{
			System.out.println(h.getName()+"\t"+h.getValue());
		}
		
		
		
	}	
}
