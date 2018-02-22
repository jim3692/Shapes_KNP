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
			switch (this) {
			case Width:
				return ErrorMessages[0];
			case Height:
				return ErrorMessages[1];
			default:
				return "";
			}
		}
	}
}
