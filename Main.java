/**
* Only contains the main method, and sets up a Game constructor to run the card game.
*
* Completed for an assignment at the University of Liverpool in 2017.
&
* @author	Alex Westcott
* @version	1.0
* @since	2017-10-25
*/

public class Main{
	
	/**
	* Main method for this application, used to set up the Game constructor and run the game.
	* @param args Expected arguments in the application.
	*/
	
	public static void main(String[] args){
		
		/**
		* Setting up the Game object.
		*/
		
		Game g = new Game();
		
		/**
		* Running the two methods from the Game class to run the card game in its entirety.
		*/
		
		g.setUpGame();
		g.playGame();
	
	}
}