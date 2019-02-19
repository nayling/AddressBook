import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import com.google.gson.Gson;

public class ContactService {
	
	RestClient restClient = RestClient.builder(
		    new HttpHost("localhost", 9200, "http"),
		    new HttpHost("localhost", 9201, "http")).build();

	// returns a list of all contacts
	public String getAllContacts(String pageSize, String pageNum, String query) throws IOException {
		Request request = new Request("GET", "/addressbook/contact/_search");
		request.setJsonEntity("{ \"size\" : \"" + pageSize + "\", \"from\" : \"" + pageNum + 
				"\", \"query\" : " + query + "}");
		Response response = restClient.performRequest(request);
		String responseBody = EntityUtils.toString(response.getEntity()); 
		restClient.close();
		return(responseBody);
	}
	// returns a single contact by id
	public String getContact(String name) throws IOException {
		Response response = restClient.performRequest(new Request("GET", "/addressbook/contact/" + name));
		String responseBody = EntityUtils.toString(response.getEntity()); 
		restClient.close();
		return(responseBody);
	}
	// creates a new contact
	public String createContact(Contact contact) throws IOException {
		Request request = new Request("POST", "/addressbook/contact/" + contact.getName());
		Gson gson = new Gson();
		request.setJsonEntity(gson.toJson(contact));
		Response response = restClient.performRequest(request); 
		String responseBody = EntityUtils.toString(response.getEntity());
		restClient.close();
		return(responseBody);
	}
	// updates an existing contact
	public String updateContact(Contact contact) throws IOException {
		Request request = new Request("PUT", "/addressbook/contact/" + contact.getName());
		Gson gson = new Gson();
		request.setJsonEntity(gson.toJson(contact));
		Response response = restClient.performRequest(request); 
		String responseBody = EntityUtils.toString(response.getEntity()); 
		restClient.close();
		return(responseBody);
	}
	// updates an existing contact
	public String deleteContact(String name) throws IOException {
		Response response = restClient.performRequest(new Request("DELETE", "/addressbook/contact/" + name));
		String responseBody = EntityUtils.toString(response.getEntity()); 
		restClient.close();
		return(responseBody);
	}
	
}
