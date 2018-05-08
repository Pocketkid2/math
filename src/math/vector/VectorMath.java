package math.vector;

public class VectorMath {

	/**
	 * Calculates the area of the triangle with the three points given
	 *
	 * @param a
	 *            Point A as a vector
	 * @param b
	 *            Point B as a vector
	 * @param c
	 *            Point C as a vector
	 * @return The area of the triangle
	 */
	public static double triangleArea(Vector a, Vector b, Vector c) {
		double al = a.length();
		double bl = b.length();
		double cl = c.length();
		if ((al <= bl) && (al <= cl)) {
			// A is smallest
			return VectorMath.parallelogramArea(b.subtract(a), c.subtract(a)) / 2.0;
		} else if ((bl <= al) && (bl <= cl)) {
			// B is smallest
			return VectorMath.parallelogramArea(a.subtract(b), c.subtract(b)) / 2.0;
		} else if ((cl <= al) && (cl <= bl)) {
			// C is smallest
			return VectorMath.parallelogramArea(a.subtract(c), b.subtract(c)) / 2.0;
		}
		return 0.0;
	}

	/**
	 * Calculates the area of the parallelogram defined by the origin and the two
	 * vectors given (2D)
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static double parallelogramArea(Vector a, Vector b) {
		return Vector.crossProduct(a, b).length();
	}

	/**
	 * Calculates the volume of the parallelepiped defined by the origin and the
	 * three vectors given (3D)
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double parallelepipedArea(Vector a, Vector b, Vector c) {
		Matrix m = new Matrix(3, 3);
		m.setRow(1, a.asArray());
		m.setRow(2, b.asArray());
		m.setRow(3, c.asArray());
		return Math.abs(m.determinant());
	}
}
