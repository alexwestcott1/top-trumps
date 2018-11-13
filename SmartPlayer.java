/**
* Used to represent a computer player in the card game.
* SmartPlayer, when in control of the game, chooses the highest-scoring attribute on their card.
* Can be multiple instances of the SmartPlayer class in the game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

public class SmartPlayer extends Player{
	
	/**
	* This constructor is to set up the SmartPlayer object.
	* @param id This player's ID.
	*/
	
	public SmartPlayer(int id){
		super(id);
		playerName = "Player " + Integer.toString(id);
	}
	
	/**
	* This method is used to choose an attribute when this player is in charge of the game.
	* @return The index of the attribute in ArrayList 'attributes' that has been selected.
	*/
	
	public int chooseAttribute(){
		int highest = 0;
		
		/**
		* The method compares the values of each of the attributes on their cards (using a for loop), before choosing the attribute with the highest value.
		*/
		
		for(int i=1;i<returnNextCard().getAttributeNo();i++){
			
			if(returnNextCard().retChosen(i).retVal() >= returnNextCard().retChosen(highest).retVal()){
				
				highest = i;
			}
			
		}
		
		return highest;
		
	}
	
	/**
	* This method is used to return this players's name.
	* @return This player's name.
	*/
	
	public String retPlayerName(){
		return playerName;
	}
}