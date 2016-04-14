package uk.lonm.dp.hard.texscii;

import java.util.LinkedList;

public class Container extends Symbol {

	private Symbol top;
	private LinkedList<Symbol> bottom;
	
	/*
	 * roots , fractions & linear containers
	 */
	
	public Container (int type){
		super();
		if(type==0){
			String[] s = {"$","V"};
			String[] r = {"_","%"};
			super.setStartRepeat(s,r);
		} else if (type==1) {
			String[] s = {};
			String[] r = {"$","_","%"};
			super.setStartRepeat(s,r);
		} else if (type==2) {
			String[] s = {};
			String[] r = {"%"};
			super.setStartRepeat(s,r);
		}
	}
	
	public void addToBottom(Symbol s){
		this.bottom.offerLast(s);
	}
	public void setTop(Symbol s){
		this.top = s;
	}
	public Symbol getTop(){
		return this.top;
	}
	
}
