package FIStest.APItestRestAssured;

import static io.restassured.RestAssured.given;
import  io.restassured.response.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APItest {

	public static void main(String[] args) {
	RestAssured.baseURI = "http://api.coindesk.com/v1/bpi/currentprice.json";
	
	String rsp = given().when().get().then().log().all().extract().asString(); //only with extract method we get 'asString' option
	Response rsp1 = given().when().get().then().log().all().extract().response();	
	JsonPath js = new JsonPath(rsp);
	String s = js.getString("bpi.GBP.description");
	int size = js.getInt("bpi.size()");
	assert size == 3;
	assert s== "British Pound Sterling";
	
	}

}
