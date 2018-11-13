/**
* Used to represent a computer player in the card game.
* PredictablePlayer, when in control of the game, chooses the same attribute every time.
* Can be multiple instances of the PredictablePlayer class in the game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

import java.util.Random;

public class PredictablePlayer extends Player{
	
	/**
	* The index of the attribute in ArrayList 'attributes' that this player will always choose when in control of the game.
	*/
	
	private int prefAtt;
	
	/**
	* This constructor is to set up the PredictablePlayer object.
	* It is also used to select a preferred attribute for this player, using Random.
	* @param id This player's ID.
	*/
	
	public PredictablePlayer(int id){
		super(id);
		playerName = "Player " + Integer.toString(id);
		
		/**
		* Using the Random package included in Java, generate a number between 0 and 2, which will dictate this player's preferred attribute.
		*/
		
		Random r = new Random();
		prefAtt = r.nextInt(2);
	}
	
	/**
	* This method is used to return the preferred attribute of this PredictablePlayer when they are in control of the game.
	* @return The index of the attribute in ArrayList 'attributes' that has been predetermined by the constructor.
	*/	
	
	public int chooseAttribute(){
		return prefAtt;
	}

	/**
	* This method is used to return this players's name.
	* @return This player's name.
	*/
	
	public String retPlayerName(){
		return playerName;
	}
}