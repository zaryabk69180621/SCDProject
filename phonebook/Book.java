package phonebook;
import java.util.ArrayList;
import java.io.*;
import java.io.*;

public class Book{

	public ArrayList<Contact> list= new ArrayList<Contact>();
	
	public Book(){
	}
	
	public void addContact(Contact p) {
		
		list.add(p);
		
		
	}
	
	public Contact findcontact(String name) {
		for (Contact i:list) {
			
			
			if(i.name.equals(name)) {
				
				return i;
				
			}
			
		}
		return new Contact(null,null,null);
	}
	public boolean rmContact(String name) {
		
		Contact res=this.findcontact(name);
		if(res.name==null) {

			
		return false;
		
		
	
		}
		list.remove(list.indexOf(res));
		return true;
	
	}
	public void dispall() {
		
		list.forEach(c->c.disp());
		
		
	}
	
	/*public void makechanges(int number,String Newname,String... Newemail) {
		int flag=1;
		
		for (Contact i:list) {
			
			if(i.number.equals(number)){
			
				flag=0;
				if(Newemail!=null)
				i.setemail(Newemail[0]);
				i.setname(Newname);
				System.out.print("contact modified");
			}
		}
		
		if(flag==1) {
			
			System.out.print("couldnt upload the file");
			
			
		}else {
			
			System.out.print("Insertion Successful");
		}
		
	}*/
	public ArrayList<String> getallstr() {
		ArrayList <String> arr=new ArrayList<>();
		if(list.size()<1) {
			arr.add("no contact to show");
		}
		for(Contact i:list) {
			
			arr.add("name:"+i.name+"\n email:"+i.email+"\n number:"+i.number);
		}
		return arr;
		
	}
	
	
	public void save() {
		
		try {
			BufferedWriter b1= new BufferedWriter(new FileWriter("./phonebook.txt"));
			b1.write("");
			for (Contact i: list) {
				
				String str= i.name+","+i.number+","+i.email+"\n";
				b1.append(str);
				
				
			}
			b1.close();
			
		}catch(Exception ex) {
			
			
		System.err.print(ex.getMessage())	;
		}
	}
	
}
