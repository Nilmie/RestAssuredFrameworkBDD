package StepDefinition;

import Reusable_Requests.DeleteRequest;
import Utility.JSONReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

public class DeleteEmployee {

	String response;
	
	@When("^I send the delete request$")
	public void i_send_the_delete_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		JSONReader _JSONRead = new JSONReader();
		DeleteRequest _DeleteReq = new DeleteRequest();
	    String Req_URL = _JSONRead.ReadJSONFile("Request_Delete", ".\\Data\\wsData.json");
	   
	    System.out.println(Req_URL);
	    response = _DeleteReq.deleteRequest(Req_URL);
	    System.out.println(response);
	    
		
	
	}

	@Then("^It should delete  the employee$")
	public void it_should_delete_the_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.contains("200") , true , "Request is successful");
	    
	}
	
}
