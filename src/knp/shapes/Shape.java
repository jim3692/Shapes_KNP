package knp.shapes;

import java.awt.image.BufferedImage;

import knp.shapes.exceptions.CoordinateOutOfRange;
import knp.shapes.exceptions.ShapeOversized;

public class Shape extends BufferedImage {
	
	public Shape(int width, int height) {
		super(width, height, TYPE_INT_ARGB);
	}

	public void makeRectangle(Point p, int width, int height, ColorScheme scheme, boolean ignoreOversized) throws Exception {
		if (!ignoreOversized) {
			if (p.X + width > this.getWidth()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Width);
			if (p.Y + height > this.getHeight()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Height);
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
		
		if (beginX < 0) throw new CoordinateOutOfRange(CoordinateOutOfRange.ErrorMessage.X_BelowZero);
		if (beginY < 0) throw new CoordinateOutOfRange(CoordinateOutOfRange.ErrorMessage.Y_BelowZero);
		
		if (!ignoreOversized) {
			if (endX + 1 > this.getWidth()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Width);
			if (endY + 1 > this.getHeight()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Height);
		}
		
		for (int x = beginX; x < endX; x++) {
			for (int y = beginY; y < endY; y++) {
				if (center.distanceTo(new Point(x, y)) + scheme.LineThickness < radius) this.setRGB(x, y, scheme.A.getRGB());
				else if (center.distanceTo(new Point(x, y)) < radius) this.setRGB(x, y, scheme.B.getRGB());
			}
		}
	}
	
	public void makeLine(Point p1, Point p2, ColorScheme scheme, boolean ignoreOversized) throws Exception {
		double width = Math.abs(p1.X - p2.X) + 1d;
		double height = Math.abs(p1.Y - p2.Y) + 1d;
		
		if (!ignoreOversized) {
			if (p1.X + 1 > this.getWidth()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Width);
			if (p2.X + 1 > this.getWidth()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Width);
			if (p1.Y + 1 > this.getHeight()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Height);
			if (p2.Y + 1 > this.getHeight()) throw new ShapeOversized(ShapeOversized.ErrorMessage.Height);
		}
		
		int sign_X = (p1.X < p2.X) ? 1 : -1;
		int sign_Y = (p1.Y < p2.Y) ? 1 : -1;
		double stepX = width / height;
		double stepY = height / width;
		
		if (stepX > stepY)
			for (double x = p1.X, y = p1.Y; x * sign_X < p2.X * sign_X; x += sign_X) {
				this.setRGB((int)x, (int)y, scheme.A.getRGB());
				y += stepY * sign_Y;
			}
		else
			for (double x = p1.X, y = p1.Y; y * sign_Y < p2.Y * sign_Y; y += sign_Y) {
				this.setRGB((int)x, (int)y, scheme.A.getRGB());
				x += stepX * sign_X;
			}
	}
	
	/* Upcoming
	public void makeTriangle(Point p1, Point p2, Point p3, ColorScheme scheme, boolean ignoreOversized) throws Exception {
		
	}
	*/
}
