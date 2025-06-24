package phonebook;
import java.util.regex.*;
public class Contact {

	public String name;
	public String number;
	public String email;
	
	public Contact(String name, String phone, String email) {
		this.name=name;
		this.email=email;
		this.number=phone;
		
	}
	
	public void disp() {
		
		
			
		
	System.out.print("name:"+this.name+"\n email:"+this.email+"\n number:"+this.number);
	
		
		
		
		
		
		
	}

	public String getnumber() {
		
		return this.number;
		
	}
	public void setname(String name) {
		
		this.name=name;
	}
	
	public void setemail(String email) {
		this.email=email;
		
	}
	
	
}