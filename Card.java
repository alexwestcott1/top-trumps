/**
* Used to represent a card in the card game.
* Each card object contains attributes, which all have values.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Card{
	
	/**
	* The name of this card.
	*/
	
	private String cardName;

	/**
	* Boolean to check whether this card hsa been assigned to a player or not.
	*/
	
	private boolean assigned = false;
	
	/**
	* ArrayList containing all of the attributes for this card.
	*/
	
	ArrayList<Attribute> attributes = new ArrayList<>();
	
	/**
	* This constructor is to set up the Card object.
	* @param cardName The name of this card.
	* @param at1 The value of the first attribute.
	* @param at2 The value of the second attribute.
	* @param at3 The value of the third attribute.
	*/
	
	public Card(String cardName, int at1, int at2, int at3){
		this.cardName = cardName;
		
		/**
		* Adding the names and values of the attributes to this card.
		*/
		
		attributes.add(new Attribute("Attack", at1));
		attributes.add(new Attribute("Defence", at2));
		attributes.add(new Attribute("Overall", at3));
		assigned = false;
	}
	
	/**
	* This method prints the name and attributes (including their respective values) of this card.
	*/
	
	public void printCard(){
		System.out.println(cardName);
		
		/**
		* Makes use of the printAtt() method from the Attribute class.
		*/
		
		attributes.get(0).printAtt();
		attributes.get(1).printAtt();
		attributes.get(2).printAtt();
	}
	
	/**
	* This method is used to return this card's name.
	* @return The name of this card.
	*/
	
	public String retName(){
		return cardName;
	}
	
	/**
	* This method is used to check if a card has already been assigned to a player or not.
	* @return Whether this card has been assigned to a player or not.
	*/
	
	public boolean getAssigned(){
		return assigned;
	}
	
	/**
	* This method loops through this card's attributes, outputting the name and value of each of the attributes.
	*/
	
	public void getAttributes(){
		for(int i=0;i<attributes.size();i++){
			System.out.println(i + ": " + attributes.get(i).retName());
		}
	}
	
	/**
	* This method is used to return the number of attributes this card has.
	* @return The number of attributes this card has.
	*/
	
	public int getAttributeNo(){
		return attributes.size();
	}
	
	/**
	* This method is used to set the value of 'assigned' to true after this card has been assigned to a player.
	*/
	
	public void setAssigned(){
		assigned = true;
	}
	
	/**
	* This method returns an attribute which is decided by the parameter.
	* @param index The position of the attribute in the ArrayList attributes to be returned.
	* @return The chosen attribute.
	*/
	
	public Attribute retChosen(int index){
		return attributes.get(index);
	}
	
}