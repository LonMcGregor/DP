package uk.lonm.dp.hard.texscii;

public class Symbol {
 //a symbol has a width, min width, height, min height, data top height-width, data bottom height-width, start exprssion, continue expression

	private int width, minWidth;
	private int height, minHeight;
	private int dataTopWidth, dataTopHeight;
	private int dataBottomWidth, dataBottomHeight;
	private String [] startPattern;
	private String [] repeatPattern;
	private String [] verticalRepeatPattern;
	
	private static final String [] ROOT_START = {"$","V"};            //arrays form rows. these are all single-column rows
	private static final String [] ROOT_CONT = {"_","%"};
	private static final String [] FRAC_CONT = {"$","-","%"};
	
	
	private Object internal; //either a container, styler or expression
	//0=root, 1=sqrt, 2=fraction
	public Symbol(){
		
	}
	
	protected void setStartRepeat(String[] start, String[] repeater){
		startPattern = start;
		repeatPattern = repeater;
	}
	/*
	public void setRepeat(String[] repeater){
		
	}*/
	
	
//example:
//root
	/*
	 2___
	 V4+5
	  
	  width:5
	  min width: 2
	  data top-width: 1
	  data bottom-width: 3
	  height: 2 
	  min height: 2
	  data top-height: 1
	  data bottom-height: 1
	  start expression:
	  	$
	  	V 
	  continue expression:
	  	_
	  	%
	  */
	//public void newRoot(Symbol )
	
	  
	  /*
//fraction
 
 	  57
 	  --
  	  6
  	  -
 	  3
 	  
 	  width: 2
 	  min: 1
 	  height:5
 	  min:3
 	  data-top-h:1
 	  data-bottom-h:3
 	  data-top-w:2
 	  data-bottom-w:1
 	  start expression:
 	  
 	  continue expression:
 	  $
 	  -
 	  %
 	  
 	  
//number
 	  
	  %
	  
	  
	  
	  
	  
	  
	 */
	
}
