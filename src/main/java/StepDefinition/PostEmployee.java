package StepDefinition;

import org.testng.Assert;

import Reusable_Requests.PostRequest;
import Utility.JSONReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostEmployee {
	
	 String response;
	 JSONReader _JsonRead;
	 PostRequest _postReq;
	 String Req_URL;
	
	@When("^I post the data from request$")
	public void i_post_the_data_from_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		_JsonRead = new JSONReader();
		_postReq = new PostRequest();
		
	    String Req_URL = _JsonRead.ReadJSONFile("Request_Post", ".\\Data\\wsData.json");
	    String first_name = _JsonRead.ReadJSONFile("first_name", ".\\Data\\wsData.json");
	    String last_name = _JsonRead.ReadJSONFile("last_name", ".\\Data\\wsData.json");
	    String email = _JsonRead.ReadJSONFile("email", ".\\Data\\wsData.json");
	    System.out.println(Req_URL);
	    response = _postReq.postRequest(Req_URL, "{\"first_name\":"+first_name+",\"email\":"+email+",\"last_name\":"+last_name+"}");
	    //response = _postReq.postRequest(Req_URL, "{\"email\":\"+email+\",\"password\":\"+password+\"}");
	    System.out.println(response);
	 // Assert.assertEquals(response.contains("201") , true , "Request is successful");

		
	    
	}

	@Then("^It should insert the details of the employee$")
	public void it_should_insert_the_details_of_the_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
			//Assert.assertEquals(response.contains("201") , true , "Request is successful");

	    
	}


}
