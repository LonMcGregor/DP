package uk.lonm.dp.easy.rockPaperScissorsLizardSpock;

public class GameStats {
	private int totalGames;
	private int [] wins; //0=cpu //1=1up
	private int ties;
	
	public GameStats(){
		reset();
	}
	
	public void reset(){
		totalGames = 0;
		wins = new int [2];
		wins[0]=0;
		wins[1]=1;
		ties=0;
	}
	
	public int getTotalGames() {
		return totalGames;
	}
	public void incTotalGames() {
		this.totalGames++;
	}
	public int [] getWins() {
		return wins;
	}
	public void incWins(int player) {
		this.wins[player]++;
	}
	public int getTies() {
		return ties;
	}
	public void incTies() {
		this.ties++;
	}
	
}
