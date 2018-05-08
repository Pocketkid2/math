package math.vector;

public class TwoDimensionCoordinates {

	private static TwoDimensionCoordinates instance = new TwoDimensionCoordinates();

	public class CartesianCoordinate {
		private double x, y;

		/**
		 * @param x
		 * @param y
		 */
		public CartesianCoordinate(double x, double y) {
			this.x = x;
			this.y = y;
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
	}

	public class PolarCoordinate {

		private double r, t;

		/**
		 * @param r
		 * @param t
		 */
		public PolarCoordinate(double r, double t) {
			this.r = r;
			this.t = t;
		}

		/**
		 * @return the r
		 */
		public double getR() {
			return r;
		}

		/**
		 * @param r
		 *            the r to set
		 */
		public void setR(double r) {
			this.r = r;
		}

		/**
		 * @return the t
		 */
		public double getT() {
			return t;
		}

		/**
		 * @param t
		 *            the t to set
		 */
		public void setT(double t) {
			this.t = t;
		}
	}

	public static PolarCoordinate convert(CartesianCoordinate c) {
		double a = Math.atan2(c.y, c.x);
		if (a < 0.0) {
			a += Math.PI * 2.0;
		}
		return instance.new PolarCoordinate(Math.sqrt((c.x * c.x) + (c.y * c.y)), a);
	}

	public static CartesianCoordinate convert(PolarCoordinate c) {
		return instance.new CartesianCoordinate(c.r * Math.cos(c.t), c.r * Math.sin(c.t));
	}

}
