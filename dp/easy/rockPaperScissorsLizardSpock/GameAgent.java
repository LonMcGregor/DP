package uk.lonm.dp.easy.rockPaperScissorsLizardSpock;

import java.util.Random;

/* r/DailyProgrammer 04/23/2014
 * Rock Paper Scissors Lizard Spock - INT
 * http://www.reddit.com/r/dailyprogrammer/comments/23qy19/4232014_challenge_159_intermediate_rock_paper/
 * u/LonMcGregor
 */

public class GameAgent {
	private int [] myCards;
	private int [] opCards;
	
	public GameAgent(){
		myCards = new int[5];
		opCards = new int[5];		
		for(int i = 0; i < 5; i++){
			myCards[i]=0;
			opCards[i]=0;
		}
	}
	
	public void incCard(boolean player, int card){
		//player T=me    F=opponent
		//card 0-4
		if(player){
			myCards[card]++;
		} else {			
			opCards[card]++;
		}
	}
	
	public Card chooseCard(){
		int x = mostChosen();
		System.out.println("Card to beat: " + Card.toString(x));
		if (x==0){
			return makeChoice(1,4);
		} else if (x==1) {
			return makeChoice(2,3);
		} else if (x==2) {
			return makeChoice(0,4);
		} else if (x==3) {
			return makeChoice(0,2);
		} else if (x==4) {
			return makeChoice(1,3);
		} else {
			throw new Error("error in GameAgent.chooseCard");
		}
	}
	
	private Card makeChoice(int op1, int op2){
		boolean b = new Random().nextBoolean();
		System.out.println("Beaten by: " + Card.toString(op1) + " or " + Card.toString(op2));
		if (b) {
			System.out.println("CPU Chose: " + Card.toString(op1));
			return Card.toCard(op1);
		}else{
			System.out.println("CPU Chose: " + Card.toString(op2));
			return Card.toCard(op2);
		}
	}
	
	private int mostChosen(){
		int chosen = 0;
		System.out.println("Checking for most chosen:");
		for (int i = 0; i < 5; i++){
			System.out.println("Current most chosen: " + Card.toString(chosen)+ ", chosen " + opCards[chosen] + " times.");
			System.out.println(Card.toString(i)+" was chosen " + opCards[i] + " times.");
			if (chosen < opCards[i]){
				chosen = i;
				System.out.println("New most chosen: " + Card.toString(i));
			}
		}
		System.out.println("/-----------/");
		return chosen;
	}	
}