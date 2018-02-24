package knp.shapes.exceptions;

public class ExceptionTemplate extends Exception {
	private static final long serialVersionUID = 1L;

	private static String[] ErrorMessages;

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
