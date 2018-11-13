/**
* Used to represent an attribute for a card in the card game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

public class Attribute{

	/**
	* The name of this attribute.
	*/
	
	private String name;
	
	/**
	* The value of this attribute.
	*/
	
	private int val;
	
	/**
	* This constructor is to set up the Attribute object.
	* This constructor also sets up the name and value of the attribute.
	* @param name The name of this attribute.
	* @param val The value of this attribute.
	*/

	public Attribute(String name, int val){
		this.name = name;
		this.val = val;
	}
	
	/**
	* This method prints the name and value of this attribute.
	*/
	
	public void printAtt(){
		System.out.println(name + " " + val);
	}
	
	/**
	* This method returns the value of this attribute.
	* @return The value of this attribute.
	*/
	
	public int retVal(){
		return val;
	}
	
	/**
	* This method returns the name of this attribute.
	* @return The name of this attribute.
	*/
	
	public String retName(){
		return name;
	}
}