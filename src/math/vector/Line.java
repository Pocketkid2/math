package math.vector;

public class Line {

	private Vector tip;
	private Vector dir;

	/**
	 * @param tip
	 *            The vector pointing to a point on the line which can be considered
	 *            the "start" or "tip"
	 * @param dir
	 *            The vector pointing in the same direction as the vector i.e.
	 *            parallel to the line
	 */
	public Line(Vector tip, Vector dir) {
		this.tip = tip;
		this.dir = dir;
	}

	/**
	 * @return the tip
	 */
	public Vector getTip() {
		return tip;
	}

	/**
	 * @param tip
	 *            the tip to set
	 */
	public void setTip(Vector tip) {
		this.tip = tip;
	}

	/**
	 * @return the dir
	 */
	public Vector getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set
	 */
	public void setDir(Vector dir) {
		this.dir = dir;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((dir == null) ? 0 : dir.hashCode());
		result = (prime * result) + ((tip == null) ? 0 : tip.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Line)) {
			return false;
		}
		Line other = (Line) obj;
		if (dir == null) {
			if (other.dir != null) {
				return false;
			}
		} else if (!dir.equals(other.dir)) {
			return false;
		}
		if (tip == null) {
			if (other.tip != null) {
				return false;
			}
		} else if (!tip.equals(other.tip)) {
			return false;
		}
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Line [tip=" + tip.standardForm() + ", dir=" + dir.standardForm() + "]";
	}

	/**
	 * Generate a vector line from two points. Line starts at p1 and moves towards
	 * p2.
	 *
	 * @param p1
	 *            Point 1
	 * @param p2
	 *            Point 2
	 * @return A Line between both points
	 */
	public static Line fromPoints(Vector p1, Vector p2) {
		return new Line(p1, Vector.difference(p1, p2));
	}
}
