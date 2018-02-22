package knp.shapes;

import java.awt.image.BufferedImage;

import knp.shapes.exceptions.ShapeOversized;
import knp.shapes.exceptions.ShapeOversized.ErrorMessage;

public class Shape extends BufferedImage {
	
	public Shape(int width, int height) {
		super(width, height, TYPE_INT_ARGB);
	}

	public void makeRectangle(Point p, int width, int height, ColorScheme scheme, boolean ignoreOversized) throws Exception {
		if (!ignoreOversized) {
			if (p.X + width > this.getWidth()) throw new ShapeOversized(ErrorMessage.Width);
			if (p.Y + height > this.getHeight()) throw new ShapeOversized(ErrorMessage.Height);
		}
		
		for (int x = (int) p.X; x < width + p.X; x++) {
			for (int y = (int) p.Y; y < height + p.Y; y++) {
				if ((p.X + scheme.LineThickness > x || x >= width + p.X - scheme.LineThickness) ||
					(p.Y + scheme.LineThickness > y || y >= height + p.Y - scheme.LineThickness)) this.setRGB(x, y, scheme.B.getRGB());
				else this.setRGB(x, y, scheme.A.getRGB());
			}
		}
	}
	
	public void makeCircle(Point center, int radius, ColorScheme scheme, boolean ignoreOversized) throws Exception {
		int beginX = ((int)center.X) - radius;
		int beginY = ((int)center.Y) - radius;
		
		int endX = ((int)center.X) + radius;
		int endY = ((int)center.Y) + radius;
		
		for (int x = beginX; x < endX; x++) {
			for (int y = beginY; y < endY; y++) {
				if (center.distanceTo(new Point(x, y)) + scheme.LineThickness < radius) this.setRGB(x, y, scheme.A.getRGB());
				else if (center.distanceTo(new Point(x, y)) < radius) this.setRGB(x, y, scheme.B.getRGB());
			}
		}
	}
}
