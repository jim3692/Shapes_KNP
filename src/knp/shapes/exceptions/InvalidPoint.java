package knp.shapes.exceptions;

import knp.shapes.Point;

public class InvalidPoint extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPoint(Point p, ErrorMessage msg) {
		super(String.format(msg.Text(), p.toString()));
	}
	
	private static String[] ErrorMessages = {
		"Point {0} is outside the working image."
	};

	public static enum ErrorMessage {
		Default;
		
		public String Text() {
			ErrorMessage[] messages = ErrorMessage.values();
			
			for (int i = 0; i < messages.length; i++)
				if (this == messages[i]) return ErrorMessages[i];
			
			return "";
		}
	}
}
