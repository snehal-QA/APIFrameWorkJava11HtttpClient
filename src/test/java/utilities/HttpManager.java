package utilities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public class HttpManager {
	
    private static HttpManager httpManager = null;
    
       // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private HttpManager(){}
 
    // Static method
    // Static method to create instance of Singleton class
    public static HttpManager getInstance()
    {
        if (httpManager == null)
        	httpManager = new HttpManager();
        return httpManager;
    }
	
	private final static HttpClient httpClient = HttpClient.newBuilder()
	            .version(HttpClient.Version.HTTP_2)
	            .connectTimeout(Duration.ofSeconds(10))
	            .build();
	 
	public static HttpClient getHttpclient() {
				return httpClient;		
	}

	public static HttpRequest setRequest(String queryParam) {
		return HttpRequest.newBuilder()
             	.GET()
             	.uri(URI.create("https://api.github.com/search/repositories?" + queryParam))
             	.setHeader("accept", "application/vnd.github.v3+json")
             	.build();
	} 
	
}
