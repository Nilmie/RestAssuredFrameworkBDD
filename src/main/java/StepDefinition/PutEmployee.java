package StepDefinition;

import Reusable_Requests.GetRequest;
import Reusable_Requests.PutRequest;
import Utility.JSONReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

public class PutEmployee {
	
	 String response;
	 JSONReader _JsonRead;
	 PutRequest _putReq;
	 String Req_URL;

	@When("^I send the put request$")
	public void i_send_the_put_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		_JsonRead = new JSONReader();
		_putReq = new PutRequest();
		
	    String Req_URL = _JsonRead.ReadJSONFile("Request_Put", ".\\Data\\wsData.json");
	    String first_name = _JsonRead.ReadJSONFile("first_name", ".\\Data\\wsData.json");
	    String last_name = _JsonRead.ReadJSONFile("last_name", ".\\Data\\wsData.json");
	    String email = _JsonRead.ReadJSONFile("email", ".\\Data\\wsData.json");
	   
	    System.out.println(Req_URL);
	    response = _putReq.putRequest(Req_URL, "{\"first_name\":"+first_name+",\"email\":"+email+",\"last_name\":"+last_name+"}");
	
	    System.out.println(response);
	 // Assert.assertEquals(response.contains("201") , true , "Request is successful");
		
	  
	}

	@Then("^It should update the details of the employee$")
	public void it_should_update_the_details_of_the_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.contains("200") , true , "Request is successful");
	}
	
}
