package knp.shapes;

import knp.shapes.exceptions.CoordinateOutOfRange;
import knp.shapes.exceptions.CoordinateOutOfRange.ErrorMessage;

public class Point {
	public double X;
	public double Y;
	
	public Point(double x, double y) throws CoordinateOutOfRange{
		if (x < 0) throw new CoordinateOutOfRange(ErrorMessage.X_BelowZero);
		if (y < 0) throw new CoordinateOutOfRange(ErrorMessage.Y_BelowZero);
		
		X = x;
		Y = y;
	}
	
	public double distanceTo(Point p) {
		double XSquared = Math.pow(p.X - this.X, 2);
		double YSquared = Math.pow(p.Y - this.Y, 2);
		return Math.sqrt(XSquared + YSquared);
	}
	
	@Override
	public String toString() {
		return String.format("({0},{1})", (int)X, (int)Y);
	}
}
