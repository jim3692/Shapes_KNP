package knp.shapes.exceptions;

public class CoordinateOutOfRange extends Exception {
	private static final long serialVersionUID = 1L;

	public CoordinateOutOfRange(String string) {
		super(string);
	}
	
	public CoordinateOutOfRange(ErrorMessage msg) {
		super(msg.Text());
	}
	
	private static final String[] ErrorMessages = { 
		"X Coordinate is below 0.",
		"Y Coordinate is below 0.",
		"X Coordinate is out of allowed range.",
		"Y Coordinate is out of allowed range."
	};
	
	public static enum ErrorMessage {
		X_BelowZero, Y_BelowZero, X, Y;

		public String Text() {
			ErrorMessage[] messages = ErrorMessage.values();
			
			for (int i = 0; i < messages.length; i++)
				if (this == messages[i]) return ErrorMessages[i];
			
			return "";
		}
	}
}
