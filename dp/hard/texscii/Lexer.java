package uk.lonm.dp.hard.texscii;

public class Lexer {
	
	private String expressionIn;
	private Equation expression;
	private static final String REGEX_VALID_CHARS = "a-zA-Z0-9-+*&"; //not sure this is enough //actually can probably ignore this. anything not a \ is valid
	
	/*
	 * @param String: LaTeX expression
	 * @return boolean: Is it a valid expression
	 * Checks if an expression is valid and adds it to the Lexer object if it is
	 */
	public boolean newExp(String expression){
		return false;
	}

	/*
	 * @return boolean: Is the expression well-formed
	 * Processes the current LaTeX expression, and checks if it is well formed.
	 * Then sets the object equation to this.
	 */
	private boolean processString(){
		try{
			//take in a string
			
			//go through symbol by symbol
				//if '\'
					//check text between '\' and next opening brace
					//access symbol library and ensure is a valid command
						//if so, add open brace
						//else quit with error
				//if '{'
					//provided this is directly preceded by a command
					//do nothing, these are already added
					//else quit with error
				//if '}'
					//if there is an available open brace [count them?]
						//add a closing brace
					//else quit with error
				//if matches regex'a-zA-Z0-9\*\-\+'
					//add the item
				//else quit with error
			return true;
		} catch (Exception e){ //specify for texscii errors later
			return false;
		}
	}
	
	private boolean processChar(int position){
		//if '\' or '}' or regex
		return true;
		//else
		//return false;
	}
	
	/*
	 * @param int: Position in the expression to start at
	 * @return String: The command found
	 * Finds a command from a specified start position
	 */
	private String findCommand(int position) throws TexsciiInvalidExpressionException{
		//find the next
		return "";
	}
	
	
}
