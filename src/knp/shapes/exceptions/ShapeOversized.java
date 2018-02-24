package knp.shapes.exceptions;

public class ShapeOversized extends Exception {
	private static final long serialVersionUID = 1L;

	public ShapeOversized(String string) {
		super(string);
	}
	
	public ShapeOversized(ErrorMessage msg) {
		super(msg.Text());
	}

	private static final String[] ErrorMessages = { 
		"Width is too big.",
		"Height is too big." 
	};

	public static enum ErrorMessage {
		Width, Height;

		public String Text() {
			ErrorMessage[] messages = ErrorMessage.values();
			
			for (int i = 0; i < messages.length; i++)
				if (this == messages[i]) return ErrorMessages[i];
			
			return "";
		}
	}
}
