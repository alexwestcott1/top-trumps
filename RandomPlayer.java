/**
* Used to represent a computer player in the card game.
* RandomPlayer, when in control of the game, chooses a random attribute every time.
* Can be multiple instances of the RandomPlayer class in the game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

import java.util.Random;

public class RandomPlayer extends Player{
	
	/**
	* This constructor is to set up the RandomPlayer object.
	* @param id This player's ID.
	*/
	
	public RandomPlayer(int id){
		super(id);
		playerName = "Player " + Integer.toString(id);
	}
	
	/**
	* This method is used to choose an attribute when this player is in charge of the game.
	* @return The index of the attribute in ArrayList 'attributes' that has been randomly generated.
	*/
	
	public int chooseAttribute(){
		int attIndex = -1;
		
		/**
		* Generates a random number between 0 and the total number of attributes on the card in play.
		*/
		
		Random r = new Random();
		attIndex = r.nextInt(returnNextCard().getAttributeNo());
		return attIndex;
	}
	
	/**
	* This method is used to return this players's name.
	* @return This player's name.
	*/
	
	public String retPlayerName(){
		return playerName;
	}
}