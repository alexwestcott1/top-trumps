/**
* Used to represent a player in the card game.
* Player class is used to be extended by other classes (such as HumanPlayer or SmartPlayer), therefore it is abstract.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

import java.util.ArrayList;

public abstract class Player{
	
	/**
	* The ID of this player.
	*/
	
	private int id;
	
	/**
	* The name of this player.
	*/
	
	protected String playerName;
	
	/**
	* ArrayList containing all of the cards the player has in their hand.
	*/
	
	ArrayList<Card> playerCards = new ArrayList<>();
	
	/**
	* This constructor is to set up the Player object.
	* @param id This player's ID.
	*/
	
	public Player(int id){
		this.id = id;
	}
	
	/**
	* This method adds the chosen card (the parameter) to this player's deck (the ArrayList playerCards).
	* @param card The card (object type Card) to be added to this player's deck.
	*/
	
	public void addCards(Card card){
		playerCards.add(card);
	}
	
	/**
	* This abstract method will be used to choose an attribute by the classes which extend the Player class.
	* @return The index of the attribute in ArrayList 'attributes' that has been chosen.
	*/
	
	public abstract int chooseAttribute();
	
	/**
	* This method removes the chosen item in the ArrayList playerCards.
	* @param cardNo the position in this player's deck of the card to be removed.
	*/
	
	public void removeCards(int cardNo){
		playerCards.remove(cardNo);
	}
	
	/**
	* This method loops through this player's deck, outputting the name of each of the cards.
	*/
	
	public void getCards(){
		for(int i=0;i<playerCards.size();i++){
			System.out.println(playerCards.get(i).retName());
		}
	}
	
	/**
	* This method is used to get the first card in this player's deck.
	* @return The Card which is positioned first in this player's deck.
	*/
	
	public Card returnNextCard(){
		return playerCards.get(0);
	}
	
	/**
	* This method is used to trim down the size of this player's deck of cards.
	*/
	
	public void condense(){
		playerCards.trimToSize();
	}
	
	/**
	* This method is used to return the number of cards this player has left.
	* @return The number of cards this player has left.
	*/
	
	public int retSize(){
		return playerCards.size();
	}
	
	/**
	* This abstract method will be used to return this player's name by the classes which extend the Player class.
	* @return This player's name.
	*/
	
	public abstract String retPlayerName();
	
	/**
	* This method checks to see if this player is a human player or not.
	* This method is a placeholder to be overridden by the HumanPlayer class (which will return true instead of false).
	* @return Whether or not this player is human or not (in this case, false).
	*/
	
	public boolean isHuman(){
		return false;
	}
}