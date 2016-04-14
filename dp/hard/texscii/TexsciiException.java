package uk.lonm.dp.hard.texscii;

public class TexsciiException extends Exception {

	/**
	 * An exception for Texscii problems
	 */
	private static final long serialVersionUID = -3629131275969757240L;
	public TexsciiException(String error){
		super("Generic Texscii Error: " + error);
	}
	public TexsciiException(String errType, String error){
		super(errType + ": " + error);
	}
}

class TexsciiInvalidExpressionException extends TexsciiException {

	/**
	 * An exception for Texscii problems, specific to issues in the expression
	 */
	private static final long serialVersionUID = 9143157362429039728L;

	public TexsciiInvalidExpressionException(String error) {
		super("Expression Problem", error);
	}
	
}
