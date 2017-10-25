package principal;

import java.io.Serializable;
 
public class Message implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -5488559777756043620L;
	String name;
    String text;
    
    public Message(){    	
    	
    }
 
    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }
 
    public String getName() {
        return name;
    }
 
    public String getText() {
        return text;
    }
 
    public String toString(){
    	return name+" "+text;
    }
}