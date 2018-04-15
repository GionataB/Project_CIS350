package prototype;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

	/** A list of players **/
	private ArrayList<Player> players;
	
	/** Indicates whether the game is running or not **/
	private boolean gameRunning = false;
	
	/** The current player's color **/
	private ColorStatus currentPlayer; 

	/***************************************************************
	 * Constructor for a Game object.
	 * The Game object contains the game's actors,
	 * namely the two players, and has a field variable indicating
	 * whether the game is running or not.
	 ***************************************************************/
	public Game() {
		players = new ArrayList<Player>();
		this.gameRunning = true;
		players.add(new Player("White", ColorStatus.WHITE));
		players.add(new Player("Black", ColorStatus.BLACK));
		this.currentPlayer = ColorStatus.WHITE;
	}

	/***************************************************************
	 * Overloaded constructor that let the player decide
	 * its color when playing against the computer.
	 * @param playerColor the user's choice of color.
	 ***************************************************************/
	public Game(ColorStatus playerColor) {
		this.players.clear(); // Make sure the array is empty.
		this.gameRunning = true;
		players.add(new Player("Player", playerColor));
		this.currentPlayer = ColorStatus.WHITE;
	}

	

	/***************************************************************
	 * Get method for the list of players.
	 * @return The list of players.
	 ***************************************************************/
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/***************************************************************
	 * Get method for the gameRunning field. The value indicates
	 * whether the game is currently running or not.
	 * Note that the game is limited to the board, not the GUI,
	 * it is possible to modify the GUI elements when the game
	 * is not running, but not the board.
	 * @return true if the game is running, false otherwise
	 ***************************************************************/
	public boolean isGameRunning() {
		return gameRunning;
	}

	
	/***************************************************************
	 * The method is called when starting a new game.
	 * It will create a new Game object, new Players
	 * and set the names for the Players.
	 * Note that the previous game does not need to end, or to be
	 * stopped, in order to start a new game.
	 * @param name1 Player 1's name
	 * @param name2 Player 2's name
	 ***************************************************************/
	public void startGame(String name1, String name2) {
		this.gameRunning = true;
		new Game();
		this.players.get(0).setName(name1);
		this.players.get(1).setName(name2);
	}
	
	/***************************************************************
	 * Stop the current game.
	 ***************************************************************/
	public void stopGame() {
		this.gameRunning = false;
	}

	/***************************************************************
	 * Go through the list of players and return the player whose
	 * color matches the currentPlayer's color.
	 * Note, it could return null in the case the list is empty, 
	 * or none of the players in the list have a color 
	 * matching currentPlayer.
	 * The null value is used for testing purposes, since it is
	 * assumed that during a game the list can't be empty,
	 * and that there is one white and one black player.
	 * @return 	the current Player object, or null if there is no player 
	 * 			matching currentPlayer.
	 ****************************************************************/
	public Player getCurrentPlayer() {
		for(Player p: players)
			if(p.playerColor() == currentPlayer)
				return p;
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		stopGame();
	}
	
	

}
