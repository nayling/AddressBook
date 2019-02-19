
public class Contact {
	
	private String name;
	private String address;
	private String phone;
	private String email;
	
	protected void setName(String n) {
		n = n.trim();
		if (n != null && n.length() >= 2 && n.length() <= 75)
			this.name = n;
		else
			throw new Error("Error: invalid name");
	}
	
	protected void setAddress(String a) {
		a = a.trim();
		if (a != null && a.length() >= 5 && a.length() <= 150) {
			String expression = "[\\w',-\\/.\\s]";
		    if (a.matches(expression)) {
		    	this.address = a;
		    	return;
		    }	    
		}
		throw new Error("Error: invalid address");
	}
	
	protected void setPhone(String p) {
		p = p.trim();
		if (p != null) {
			String expression = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		    if (p.matches(expression)) {
		    	this.phone = p;
		    	return;
		    }	    
		}
		throw new Error("Error: invalid phone number");
	}
	
	protected void setEmail(String e) {
		e = e.trim();
		if (e != null && e.length() >= 7 && e.length() <= 50) {
			String expression = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		    if (e.matches(expression)) {
		    	this.email = e;
		    	return;
		    }	    
		}
		throw new Error("Error: invalid email address");
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}

}
