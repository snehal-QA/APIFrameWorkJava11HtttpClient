package tests;


import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.annotations.Test;

import utilities.GitHubRepoExceptions;
import utilities.HttpManager;

public class GitHubAPITest {
	
	@Test
	public void restapi() throws IOException, InterruptedException, GitHubRepoExceptions {
		
		HttpManager httpManager = HttpManager.getInstance();
		
		String query = System.getProperty("query");
		String sort  = System.getProperty("sort");
		String order = System.getProperty("order");
     //	String default_val = System.getProperty("default_val","N");
//					
//		if(default_val.toUpperCase() == "Y") {
//			if(query == null) query="HotelBookingapi_apifram";
//			if(sort == null) sort="desc";
//			if(order == null) order="stars";		
//		}
			
		System.out.println("Query +++++++++++++++++++++++++  : " + query);
		if(query == null) {
			throw new GitHubRepoExceptions("Query is Empty");
		}
		//HttpRequest request = httpManager.setRequest("q=HotelBookingapi_apifram&sort=stars&order=desc");
		//HttpRequest request = httpManager.setRequest("q=HotelBookingapi&order=desc");
		HttpRequest request = httpManager.setRequest("q=" + query + "&sort=" + sort + "&order=" + order);
		
		HttpResponse<String> response = httpManager.getHttpclient().send(request, HttpResponse.BodyHandlers.ofString());
	    // print status code
        System.out.println(response.statusCode());
        System.out.println("Response: " + response.body());

        // print response body
      //  Log.info(response.body());
        
//        CompletableFuture<HttpResponse<String>> response =
//        httpManager.getHttpclient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
//        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
//        System.out.println(result);
        
        
	}
	
	

}
