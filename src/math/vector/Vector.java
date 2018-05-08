package math.vector;

public class Vector {

	/**
	 * The X, Y, and Z coordinate of the point
	 */
	private double x, y, z;

	/**
	 * A pre-made vector representing the origin
	 */
	public static final Vector origin = new Vector(0.0, 0.0, 0.0);
	public static final Vector i = new Vector(1.0, 0.0, 0.0);
	public static final Vector j = new Vector(0.0, 1.0, 0.0);
	public static final Vector k = new Vector(0.0, 0.0, 1.0);

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @param z
	 *            the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}

	public double[] asArray() {
		return new double[] { x, y, z };
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Vector) {
			Vector v = (Vector) o;
			if ((v.x == x) && (v.y == y) && (v.z == z)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String componentForm() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	public String standardForm() {
		boolean flag = false;
		// True if value is non-zero
		boolean iexist = x != 0.0;
		boolean jexist = y != 0.0;
		boolean kexist = z != 0.0;
		if (!iexist && !jexist && !kexist) {
			return "0";
		}
		// True if sign is NEGATIVE
		boolean isign = x < 0;
		boolean jsign = y < 0;
		boolean ksign = z < 0;
		// Rounded display value
		double x = Math.abs(this.x);
		double y = Math.abs(this.y);
		double z = Math.abs(this.z);
		String ival = (long) x == x ? "" + (long) x : "" + x;
		String jval = (long) y == y ? "" + (long) y : "" + y;
		String kval = (long) z == z ? "" + (long) z : "" + z;
		if (x == 1.0) {
			ival = "";
		}
		if (y == 1.0) {
			jval = "";
		}
		if (z == 1.0) {
			kval = "";
		}

		StringBuilder sb = new StringBuilder();
		if (iexist) {
			if (isign) {
				sb.append("-");
			}
			sb.append(ival);
			sb.append("i");
			flag = true;
		}
		if (jexist) {
			if (jsign) {
				if (flag) {
					sb.append(" - ");
				} else {
					sb.append("-");
				}
			} else {
				if (flag) {
					sb.append(" + ");
				}
			}
			sb.append(jval);
			sb.append("j");
			flag = true;
		}
		if (kexist) {
			if (ksign) {
				if (flag) {
					sb.append(" - ");
				} else {
					sb.append("-");
				}
			} else {
				if (flag) {
					sb.append(" + ");
				}
			}
			sb.append(kval);
			sb.append("k");
			flag = true;
		}

		return sb.toString();
	}

	/**
	 * Vector addition
	 *
	 * @param v
	 *            The vector to add to this vector
	 */
	public Vector add(Vector v) {
		x += v.x;
		y += v.y;
		z += v.z;
		return this;
	}

	/**
	 * Vector addition (variable)
	 *
	 * @param vs
	 *            A variable number of vectors, generally more than two
	 * @return The resulting sum of all input vectors
	 */
	public static Vector add(Vector... vs) {
		Vector v = vs[0];
		for (int i = 1; i < vs.length; i++) {
			v.add(vs[i]);
		}
		return v;
	}

	/**
	 * Scalar multiplication
	 *
	 * @param a
	 *            The alpha value to multiple this vector by
	 */
	public Vector scale(double a) {
		x *= a;
		y *= a;
		z *= a;
		return this;
	}

	/**
	 * Scalar multiplication
	 *
	 * @param v
	 *            The vector to multiply
	 * @param a
	 *            The alpha value to multiply by
	 * @return The resulting vector of v * a
	 */
	public static Vector scale(Vector v, double a) {
		return new Vector(v.x * a, v.y * a, v.z * a);
	}

	/**
	 * Vector subtraction
	 *
	 * @param v
	 *            The vector to subtract from this one
	 */
	public Vector subtract(Vector v) {
		x -= v.x;
		y -= v.y;
		z -= v.z;
		return this;
	}

	/**
	 * Vector subtraction
	 *
	 * @param a
	 *            The vector A to subtract
	 * @param b
	 *            The vector B to subtract
	 * @return The resulting vector of A - B
	 */
	public static Vector subtract(Vector a, Vector b) {
		return new Vector(a.x - b.x, a.y - b.y, a.z - b.z);
	}

	/**
	 * The difference between two vectors as a vector
	 *
	 * @param s
	 *            The starting vector point
	 * @param e
	 *            The ending vector point
	 * @return A vector representing the difference between the points (end - start)
	 */
	public static Vector difference(Vector s, Vector e) {
		return subtract(e, s);
	}

	/**
	 * Returns the distance from the origin, also known as the magnitude or length.
	 *
	 * @return
	 */
	public double length() {
		return Math.sqrt((x * x) + (y * y) + (z * z));
	}

	/**
	 * Returns the distance between two points
	 *
	 * @param a
	 *            The vector A
	 * @param b
	 *            The vector B
	 * @return The distance between A and B
	 */
	public static double distance(Vector a, Vector b) {
		return Vector.subtract(b, a).length();
	}

	/**
	 * Turns this vector into a unit vector
	 */
	public void normalize() {
		x /= length();
		y /= length();
		z /= length();
	}

	/**
	 * The dot product or inner product of this vector and another vector
	 *
	 * @param v
	 *            The vector to multiply with this one
	 * @return The dot or inner product
	 */
	public double dotProduct(Vector v) {
		return (x * v.x) + (y * v.y) + (z * v.z);
	}

	/**
	 * The dot product or inner product of two vectors
	 *
	 * @param a
	 *            The vector A
	 * @param b
	 *            The vector B
	 * @return The dot product of A and B
	 */
	public static double dotProduct(Vector a, Vector b) {
		return (a.x * b.x) + (a.y * b.y) + (a.z * b.z);
	}

	/**
	 * The angle between two vectors
	 *
	 * @param a
	 *            The vector A
	 * @param b
	 *            The vector B
	 * @return The angle between A and B (in radians)
	 */
	public static double angle(Vector a, Vector b) {
		return Math.acos(Vector.dotProduct(a, b) / (a.length() * b.length()));
	}

	/**
	 * The cross product of two vectors
	 *
	 * @param a
	 *            The vector A
	 * @param b
	 *            The vector B
	 * @return The cross product or A X B
	 */
	public static Vector crossProduct(Vector a, Vector b) {
		return new Vector((a.y * b.z) - (a.z * b.y), -((a.x * b.z) - (a.z * b.x)), (a.x * b.y) - (a.y * b.x));
	}

	public static boolean perpendicular(Vector a, Vector b) {
		if (Vector.dotProduct(a, b) == 0.0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean parallel(Vector a, Vector b) {
		if (Vector.crossProduct(a, b).equals(Vector.origin)) {
			return true;
		} else {
			return false;
		}
	}

}
