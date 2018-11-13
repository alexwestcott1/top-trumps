/**
* Contains most of the game logic, including setting up and subsequently playing the card game.
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

public class Game{
	
	/**
	* ArrayList containing all of the cards in the game, which will be distributed to the players.
	*/
	
	ArrayList<Card> deck = new ArrayList<>();

	/**
	* ArrayList containing all of the players in the game.
	*/	
	
	ArrayList<Player> players = new ArrayList<>();
	
	
	/**
	* Constructor for Game class, to be used by the main method to gain access to the methods in the Game class.
	*/
	
	public Game(){
	}
	
	/**
	* Method used to set up the card game, including assigning all of the cards to a deck and setting up all of the players in the game.
	*/
	
	public void setUpGame(){
		
		/**
		* Integer used to check the value of the user input.
		*/
		
		int playerInput = -1;
		
		/**
		* Setting up the Scanner package included in Java to take input from the user.
		*/
	
		Scanner sc = new Scanner(System.in);
		
		/**
		* Game prompts user to input numbers to either add players to game, start the game, or exit the application.
		*/
		
		System.out.println("\t\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
		System.out.println("\t\t*Welcome to Bristol City Top Trumps~");
		System.out.println("\t\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
		
		System.out.print("Enter number and press enter:\n0:\tStart game (minimum 2 players required)\n1:\tAdd human player");
		System.out.print("\n2:\tAdd 'Random' computer player (chooses attributes completely at random)");
		System.out.print("\n3:\tAdd 'Predictable' computer player (chooses the same attribute every time)");
		System.out.print("\n4:\tAdd 'Smart' computer player (always chooses the best attribute)");
		System.out.println("\n-1:\tExit application");
		
		int id = 0;
		boolean gameReady = false;
		
		/**
		* While loop which loops until either the user starts the game, or until the user adds 5 players to the game.
		* If the user enters a number between 1 and 4, a player will be added to the game.
		* The game sets up an object based on one of the classes that extends the Player class, depending on which player the user selected.
		* If the user tries to start the game with less than 2 players, the application prompts the user to try another option.
		* If the user enters 5 players, the game starts automatically.
		*/
		
		while(gameReady == false && players.size() < 5){
			playerInput = sc.nextInt();
			if(playerInput < 0){
				System.exit(0);
			} else if(playerInput == 1){
				players.add(new HumanPlayer(id));
				System.out.println("Player " + id + " added to game (human)");
				id++;
			} else if(playerInput == 2){
				players.add(new RandomPlayer(id));
				System.out.println("Player " + id + " added to game (random computer)");
				id++;
			} else if(playerInput == 3){
				players.add(new PredictablePlayer(id));
				System.out.println("Player " + id + " added to game (predictable computer)");
				id++;
			} else if(playerInput == 4){
				players.add(new SmartPlayer(id));
				System.out.println("Player " + id + " added to game (smart computer)");
				id++;
			} else if(playerInput == 0){
				if(players.size() > 1){
					gameReady = true;
				} else {
					System.out.println("Minimum 2 players required");
				}
			}
			System.out.println("Select another option");
		}
		
		/**
		* Adding Card objects to the deck HashSet, initialising the cards' names and attributes
		*/
		
		deck.add(new Card("Aden Flint", 4, 9, 9));
		deck.add(new Card("Famara Diedhiou", 9, 2, 9));
		deck.add(new Card("Eros Pisano", 4, 8, 8));
		deck.add(new Card("Jens Hegeler", 2, 9, 8));
		deck.add(new Card("Joe Bryan", 6, 7, 8));
		deck.add(new Card("Bailey Wright", 2, 7, 7));
		deck.add(new Card("Nathan Baker", 3, 9, 7));
		deck.add(new Card("Jamie Paterson", 7, 2, 7));
		deck.add(new Card("Marlon Pack", 6, 6, 7));
		deck.add(new Card("Korey Smith", 5, 7, 7));
		deck.add(new Card("Gary O'Neil", 5, 6, 6));
		deck.add(new Card("Matty Taylor", 7, 1, 6));
		deck.add(new Card("Niclas Eliasson", 6, 3, 6));
		deck.add(new Card("Hordur Magnusson", 3, 8, 5));
		deck.add(new Card("Milan Djuric", 7, 2, 5));
		deck.add(new Card("Josh Brownhill", 6, 5, 5));
		deck.add(new Card("Callum O'Dowda", 6, 4, 5));
		deck.add(new Card("Bobby Reid", 7, 4, 4));
		deck.add(new Card("Cauley Woodrow", 6, 2, 4));
		deck.add(new Card("Jonathan Leko", 7, 1, 4));
		deck.add(new Card("Zak Vyner", 1, 6, 3));
		deck.add(new Card("Paul Arnold Garita", 5, 2, 3));
		deck.add(new Card("Frank Fielding", 0, 9, 7));
		deck.add(new Card("Luke Steele", 0, 8, 6));
		deck.add(new Card("Max O'Leary", 0, 2, 1));
		
		/**
		* Constant integer, which is the number of cards each player in the game will have to start with.
		*/
		
		final int cardsPerPlayer = 5;
		
		/**
		* Distributing the cards to the players using a for loop nested in another for loop.
		* Using the Random package included in Java, the application assigns the cards to each player in the game.
		* The cards are checked to make sure they haven't already been assigned before being assigned to a player using the getAssigned() method in the Card class.
		* If a card has already been assigned, the for loop will try to find a card to assign to the player again.
		*/
		
		for(int i=0;i<cardsPerPlayer;i++){
			for(int j=0;j<players.size();j++){
				Random r = new Random();
				int rand = r.nextInt(deck.size());	
				if(deck.get(rand).getAssigned()){
					j--;
				} else {
					players.get(j).addCards(deck.get(rand));
					deck.get(rand).setAssigned();
				}
			}
		}
		
		System.out.println("\n");
		
	}
	
	/**
	* Method used to play the card game.
	* Contains all of the logic for choosing a winner for each round, eliminating players from the game, and establishing who the final winner of the game is.
	*/
	
	public void playGame(){
		
		/**
		* Integer to show the position of the previous winner in the 'players' ArrayList.
		* 0 to start with so that the first player has control of the game in the first round.
		*/
		
		int prevWinner = 0;
		
		/**
		* Setting up the Scanner package included in Java to take input from the user.
		*/
		
		Scanner sc = new Scanner(System.in);
		
		/**
		* While loop containing most of the game logic, which loops until there is only one player left in the game, at which point a winner can be decided.
		*/
		
		while(players.size() > 1){
			
			/**
			* For loop which loops through each player and checks if they are a human player.
			* For each human player found, print their next card and their attributes.
			* Deliberately not showing the computer players' cards as this would make game too easy for human player.
			*/
			
			for(int i=0;i<players.size();i++){
				if(players.get(i).isHuman()){
					System.out.println(players.get(i).retPlayerName() + "'s next card:");
					players.get(i).returnNextCard().printCard();
					System.out.println("");
				}
			}
			
			/**
			* Print message mentioning which player is to choose an attribute.
			*/
			
			System.out.println("\n" + players.get(prevWinner).retPlayerName() + " is to choose an attribute");
			
			/**
			* Using the chooseAttribute() method in the player classes (HumanPlayer, SmartPlayer, RandomPlayer, PredictablePlayer), choose an attribute.
			* This attribute will have the values on all of the players' cards compared to each other to determine a winner of that round.
			*/
			
			int chosenAttIndex = players.get(prevWinner).chooseAttribute();
			
			/**
			* Printing a message to let the user know which attribute has been chosen, and setting up an integer which will contain the value of the best card for this round.
			*/
			
			System.out.println("\n" + players.get(prevWinner).retPlayerName() + " chooses attribute " + players.get(prevWinner).returnNextCard().retChosen(chosenAttIndex).retName());
			int tempVal = players.get(prevWinner).returnNextCard().retChosen(chosenAttIndex).retVal();
			
			/**
			* For loop which compares the value of the previous best score (for the chosen attribute) with each player's card.
			* If a player's card is higher than the previous best score, they become the player with the best score.
			* Comparisons happen until each player has had their card compared to.
			* In the event of a tie, if one of the players in the tie is the person who chose the attribute, this is the player who wins the round.
			* If neither player involved in the tie chose the attribute, then the winner is determined by whichever player was added to the game first.
			* This gives a slight advantage to a) the player who is in control of the round, and b) to the players that are added to the game first.
			*/
			
			for(int i=0;i<players.size();i++){
				int compVal = players.get(i).returnNextCard().retChosen(chosenAttIndex).retVal();
				System.out.println("\n" + players.get(i).retPlayerName() + ": " + players.get(i).returnNextCard().retName() + " has a stat of " + compVal);
				if(compVal > tempVal){
					prevWinner = i;
					tempVal = players.get(i).returnNextCard().retChosen(chosenAttIndex).retVal();
				}
			}
			
			/**
			* Printing out who the winner of the round is.
			*/
			
			System.out.println("\nWinner of round: " + players.get(prevWinner).retPlayerName());
			
			/**
			* Adding the first cards of all of the players to the back of the winning player's deck.
			* Also removing the first card of each player's deck to avoid duplicates.
			* Trimming the player's decks to size to avoid any difficulty with potential 'null' values.
			*/
			
			for(int i=0;i<players.size();i++){
				players.get(prevWinner).addCards(players.get(i).returnNextCard());
				players.get(i).condense();
				players.get(i).removeCards(0);
				players.get(i).condense();
			}
			
			players.get(prevWinner).condense();
			
			/**
			* Loop which checks to see if a user has ran out of cards, and if they have, removing them from the 'players' ArrayList (in essence, removing them from the game).
			* Also makes sure that, if a player is removed, the value of the position of the winning player is not affected. If it is, adjust the position accordingly.
			*/
			
			for(int i=players.size()-1;i>=0;i--){
				if(players.size() > 1){
					if(players.get(i).retSize() < 1){
						System.out.println("\n" + players.get(i).retPlayerName() + " has been eliminated.");
						if(prevWinner > i){
							prevWinner--;
						}
						players.remove(i);
					}
				}
			}
			
			System.out.println("");
			
			/**
			* Print out the number of cards each player in the game has left in their deck.
			*/
			
			for(int i=0;i<players.size();i++){
				System.out.println(players.get(i).retPlayerName() + " has " + players.get(i).retSize() + " cards");
			}
			
			
			/**
			* Trim the 'players' ArrayList to size to avoid any potential issues with 'null' values.
			*/
			
			players.trimToSize();
			
			/**
			* Prompting the user to continue to the next round, and awaiting any user input to continue.
			*/
			
			System.out.print("\nPress enter to continue to next round");
			sc.nextLine();
			
		}
		
		/**
		* After the while loop ends, there will only be one player left, so print the name of this player and declare them the winner of the card game.
		*/
		
		System.out.println("Overall winner: " + players.get(0).retPlayerName());

	}
	
}