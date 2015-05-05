package dp.easy.rockPaperScissorsLizardSpock;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/* r/DailyProgrammer 04/21/2014
 * Rock Paper Scissors Lizard Spock - EASY
 * http://www.reddit.com/r/dailyprogrammer/comments/23lfrf/4212014_challenge_159_easy_rock_paper_scissors/
 * u/LonMcGregor
 */

public class GameUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static GameLogic game;
	//Game UI Fields
	private JPanel user, top, computer, stats, bottom;
	private JLabel cpuIndicate, cpuChoice, statsTitle, userChoice, gameOutcome;
	private JTextArea statsText;
	private JButton [] choices;
	private JButton newGame, clearStats;
	private static final String [] choiceStrings= {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
	
	//Game init
	public GameUI(){
		makeLogic();
		
		setLayout(new GridLayout(3,1));

		top = new JPanel(new GridLayout(1, 2));
		makeComputer();
		top.add(computer);
		makeStats();
		top.add(stats);
		add(top);
		
		user = new JPanel(new GridLayout(1, 5));
		makeChoices();
		add(user);
		
		bottom = new JPanel(new GridLayout(1, 5));
		makeBottom();
		add(bottom);
	}
	private void makeComputer() {
		computer = new JPanel(new GridLayout(3,1));
		cpuIndicate = new JLabel("Computer Choice:");
		cpuChoice = new JLabel("RPSLS");
		newGame = new JButton("New Game");
		newGame.addActionListener(this);
		computer.add(cpuIndicate);
		computer.add(cpuChoice);
		computer.add(newGame);
	}
	private void makeStats() {
		stats = new JPanel(new GridLayout(3,1));
		statsTitle = new JLabel("Statistics:");
		statsText = new JTextArea("No Stored Data");
		statsText.setEditable(false);
		clearStats = new JButton("Quit Game");
		clearStats.setEnabled(false);
		clearStats.addActionListener(this);
		stats.add(statsTitle);
		stats.add(statsText);
		stats.add(clearStats);
	}
	private void makeChoices(){
		choices = new JButton [choiceStrings.length];
		for (int i = 0; i < choiceStrings.length; i++){
			JButton x = new JButton(choiceStrings[i]);
			choices[i] = x;
			x.addActionListener(this);
			user.add(x);
		}
		SwitchUserChoice(false);
	}
	private void makeBottom(){
		userChoice = new JLabel("Press New Turn to begin...");
		gameOutcome = new JLabel("");
		bottom.add(userChoice);
		bottom.add(gameOutcome);
	}
	private void makeLogic(){
		game = new GameLogic();
		game.init();
	}

	//respond to buttons
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src==newGame){
			doTurn();
		}
		if (src==clearStats){
			game.clearStats();
		}
		if (src==choices[0]||src==choices[1]||src==choices[2]||src==choices[3]||src==choices[4]){
			chooseCard(src);
		}
	}
	
	private void chooseCard(Object src) {
		SwitchUserChoice(false);
		if (src == choices[0]){
			game.setPlayerCard(0);
		}if (src == choices[1]){
			game.setPlayerCard(1);
		}if (src == choices[2]){
			game.setPlayerCard(2);
		}if (src == choices[3]){
			game.setPlayerCard(3);
		}if (src == choices[4]){
			game.setPlayerCard(4);
		}
		finishTurn();
	}

	//Do Turn
	public void doTurn(){
		game.newComputerCard();
		cpuIndicate.setText("Computer is waiting...");
		userChoice.setText("Make your choice...");
		newGame.setText("Next Turn");
		newGame.setEnabled(false);
		SwitchUserChoice(true);
		clearStats.setEnabled(true);
	}
	public void finishTurn(){
		cpuIndicate.setText("Computer Chose: ");
		cpuChoice.setText(game.getCardString(true));
		userChoice.setText("You Chose: " + game.getCardString(false));
		int win = game.checkWin();
		if (win==0){
			gameOutcome.setText("You Lose!");
		} else if (win==1){
			gameOutcome.setText("You Win!");
		} else {
			gameOutcome.setText("It's a Tie!");
		}
		updateStats();
		newGame.setEnabled(true);
	}
	
	private void updateStats(){
		statsText.setText(game.statString());
	}
	
	//enable - disable user choices
	private void SwitchUserChoice(boolean state){
		for (JButton x : choices){
			x.setEnabled(state);
		}
	}
	
}

class RunGameUI {
	public static void main(String[] args) {
		JFrame e = new GameUI();
		e.setSize(500,300);
		e.setTitle("RPSLS Game");
		e.setVisible(true);
		e.addWindowListener(
			new WindowAdapter(){ 
				public void windowClosing(WindowEvent e){
					System.exit(0); 
				}
			}
		);
	}
}
