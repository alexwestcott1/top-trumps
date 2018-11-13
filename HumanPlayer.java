/**
* Used to represent a human-controlled player in the card game.
* Can be multiple instances of the HumanPlayer class in the game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

import java.util.Scanner;

public class HumanPlayer extends Player{
	
	/**
	* The name of this player.
	*/
	
	private String playerName;

	/**
	* This constructor is to set up the HumanPlayer object.
	* It is also used to get the human player's name by using input from Scanner.
	* @param id This player's ID.
	*/
	
	public HumanPlayer(int id){
		super(id);
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a name for this player: ");
		playerName = sc.nextLine();
	}

	/**
	* This method is used to choose an attribute when this player is in charge of the game.
	* Prompts the user to use input (by typing an umber) to decide on an attribute to play.
	* @return The index of the attribute in ArrayList 'attributes' that the user has chosen.
	*/
	
	public int chooseAttribute(){
		int attIndex = -1;
		System.out.println("Choose an attribute: ");
		returnNextCard().getAttributes();
		Scanner sc = new Scanner(System.in);
		while(attIndex > returnNextCard().getAttributeNo() || attIndex < 0){
			attIndex = sc.nextInt();
		}
		
		return attIndex;
	}
	
	/**
	* This method is used to return this players's name.
	* @return This player's name.
	*/
	
	public String retPlayerName(){
		return playerName;
	}
	
	/**
	* This method checks to see if this player is a human player or not.
	* @return Whether or not this player is human or not (in this case, true).
	*/
	
	public boolean isHuman(){
		return true;
	}

}