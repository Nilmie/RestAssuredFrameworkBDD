package Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable_Requests.*;
import Utility.JSONReader;
import io.restassured.response.Response;

public class GetEmployees {
	
	 @Test
	    public void GetEmployee() throws FileNotFoundException, IOException, ParseException {
		 
		 String response;
		 JSONReader _JsonRead = new JSONReader();
		 GetRequest _GetReq = new GetRequest();
		 String Req_URL = _JsonRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json");
		 response = _GetReq.getRequest(Req_URL);

		  Assert.assertEquals(response.toLowerCase().contains("sebastian") , true , "Response body contains Sebastian");
		  System.out.println(response);
	 
	 }
	 
	 @Test
	    public void GetEmployee2() throws FileNotFoundException, IOException, ParseException {
		 
		 String response;
		 JSONReader _JsonRead = new JSONReader();
		 GetRequest _GetReq = new GetRequest();
		 String Req_URL = _JsonRead.ReadJSONFile("Request_Get2", ".\\Data\\wsData.json");
		 response = _GetReq.getRequest(Req_URL);

		  Assert.assertEquals(response.toLowerCase().contains("steve") , true , "Response body contains steve");
		  System.out.println(response);
	 }

	 @Test
	    public void GetEmployee3() throws FileNotFoundException, IOException, ParseException {
		 
		 String response;
		 JSONReader _JsonRead = new JSONReader();
		 GetRequest _GetReq = new GetRequest();
		 String Req_URL = _JsonRead.ReadJSONFile("Request_Get3", ".\\Data\\wsData.json");
		 response = _GetReq.getRequest(Req_URL);

		  Assert.assertEquals(response.toLowerCase().contains("ann") , true , "Response body contains ann");
		  System.out.println(response);
	 }
	 
	 @Test
		public void PostEmployee() throws FileNotFoundException, IOException, ParseException
		{
			
			String response;
			JSONReader _JSONRead = new JSONReader();
			PostRequest _postReq = new PostRequest();
		    String Req_URL = _JSONRead.ReadJSONFile("Request_Post", ".\\Data\\wsData.json");
		    String first_name = _JSONRead.ReadJSONFile("first_name", ".\\Data\\wsData.json");
		    String last_name = _JSONRead.ReadJSONFile("last_name", ".\\Data\\wsData.json");
		    String email = _JSONRead.ReadJSONFile("email", ".\\Data\\wsData.json");
		   System.out.println(Req_URL);
		    response = _postReq.postRequest(Req_URL, "{\"first_name\":"+first_name+",\"email\":"+email+",\"last_name\":"+last_name+"}");
		    //response = _postReq.postRequest(Req_URL, "{\"email\":\"+email+\",\"password\":\"+password+\"}");
		    System.out.println(response);
		 // Assert.assertEquals(response.contains("201") , true , "Request is successful");
		}

	 @Test
		public void PutEmployee() throws FileNotFoundException, IOException, ParseException
		{
			
			String response;
			JSONReader _JSONRead = new JSONReader();
			PutRequest _putReq = new PutRequest();
		    String Req_URL = _JSONRead.ReadJSONFile("Request_Put", ".\\Data\\wsData.json");
		    String first_name = _JSONRead.ReadJSONFile("first_name", ".\\Data\\wsData.json");
		    String last_name = _JSONRead.ReadJSONFile("last_name", ".\\Data\\wsData.json");
		    String email = _JSONRead.ReadJSONFile("email", ".\\Data\\wsData.json");
		   
		   System.out.println(Req_URL);
		    response = _putReq.putRequest(Req_URL, "{\"first_name\":"+first_name+",\"email\":"+email+",\"last_name\":"+last_name+"}");
		
		    System.out.println(response);
		 // Assert.assertEquals(response.contains("201") , true , "Request is successful");
		}
	 
	 @Test
		public void DeleteEmployee() throws FileNotFoundException, IOException, ParseException
		{
			
			String response;
			JSONReader _JSONRead = new JSONReader();
			DeleteRequest _DeleteReq = new DeleteRequest();
		    String Req_URL = _JSONRead.ReadJSONFile("Request_Delete", ".\\Data\\wsData.json");
		   
		    System.out.println(Req_URL);
		    response = _DeleteReq.deleteRequest(Req_URL);
		    System.out.println(response);
		 // Assert.assertEquals(response.contains("201") , true , "Request is successful");
		}
	 
	 
}
