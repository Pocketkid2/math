package math.vector;

import org.junit.jupiter.api.Test;

class PlaneTest {

	@Test
	final void test() {
		Plane p = new Plane(1, -2, 2, 5);
		Vector point = new Vector(2, 1, -1);
		System.out.println(Plane.pointToPlane(point, p));
	}

}
