package math.vector;

public class Plane {

	private Vector normal;
	private double a, b, c, d;

	public Plane(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		normal = new Vector(a, b, c);
	}

	public Plane(Vector p, Vector q, Vector r) {
		normal = Vector.crossProduct(Vector.difference(p, q), Vector.difference(p, r));
		// create A, B, C, and D with the normal and the points
		d = 0 - (normal.getX() * p.getX()) - (normal.getY() * p.getY()) - (normal.getZ() * p.getZ());
		a = normal.getX();
		b = normal.getY();
		c = normal.getZ();
	}

	/**
	 * @return the normal
	 */
	public Vector getNormal() {
		return normal;
	}

	/**
	 * @param normal
	 *            the normal to set
	 */
	public void setNormal(Vector normal) {
		this.normal = normal;
	}

	/**
	 * Returns true if the planes are parallel to each other
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean parallel(Plane a, Plane b) {
		return Vector.parallel(a.normal, b.normal);
	}

	/**
	 * Calculates the distance from a point to a plane
	 *
	 * @param v
	 *            The point vector
	 * @param p
	 *            The plane
	 * @return The distance from point to plane
	 */
	public static double pointToPlane(Vector v, Plane p) {
		return Math.abs((p.a * v.getX()) + (p.b * v.getY()) + (p.c * v.getZ()) + p.d) / Math.sqrt((p.a * p.a) + (p.b * p.b) + (p.c * p.c));
	}
}
