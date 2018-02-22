package knp.shapes;

public class Point {
	public double X;
	public double Y;
	
	public Point(double x, double y) {
		X = x;
		Y = y;
	}
	
	public double distanceTo(Point p) {
		double XSquared = Math.pow(p.X - this.X, 2);
		double YSquared = Math.pow(p.Y - this.Y, 2);
		return Math.sqrt(XSquared + YSquared);
	}
}
