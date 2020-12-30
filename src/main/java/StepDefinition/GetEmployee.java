package StepDefinition;

import org.testng.Assert;

import Reusable_Requests.GetRequest;
import Utility.JSONReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetEmployee {
	
	 String response;
	 JSONReader _JsonRead;
	 GetRequest _GetReq;
	 String Req_URL;
	
	@Given("^I have a Web Service$")
	public void i_have_a_Web_Service() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		_JsonRead = new JSONReader();
		_GetReq = new GetRequest();
	    
	}

	@When("^I send the get request$")
	public void i_send_the_get_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Req_URL = _JsonRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json");
		response = _GetReq.getRequest(Req_URL);
	 
	}

	@Then("^It should return the details of the employee$")
	public void it_should_return_the_details_of_the_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Assert.assertEquals(response.toLowerCase().contains("sebastian") , true , "Response body contains Sebastian");
		  System.out.println(response);
	   
	}
	
}
