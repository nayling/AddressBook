import java.io.IOException;
import static spark.Spark.*;

import com.google.gson.Gson;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	ContactService cs = new ContactService();
    	
    	get("/contact?pageSize={}&page={}&query={}", (req, res) -> {
    		String pageSize = req.queryParams("pageSize");
    		String pageNum = req.queryParams("page");
    		String query = req.queryParams("query");
    		return cs.getAllContacts(pageSize, pageNum, query);
    	});
    	
    	get("/contact/:name", (req, res) -> {
    		String name = req.params("name");
    		return cs.getContact(name);
    	});
    	
    	post("/contact", (req, res) -> {
    	    res.type("application/json");
    	    Contact contact = new Gson().fromJson(req.body(), Contact.class);
    	    return cs.createContact(contact);
    	});
    	
    	put("/contact/:name", (req, res) -> {
    	    res.type("application/json");
    	    String name = req.params("name");
    	    Contact contact = new Gson().fromJson(req.body(), Contact.class);
    	    return cs.updateContact(contact);
    	});
    	
    	delete("/contact/:name", (req, res) -> {
    		String name = req.params("name");
    		return cs.deleteContact(name);
    	});

    }
}