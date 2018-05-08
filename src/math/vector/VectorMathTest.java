package math.vector;

import org.junit.jupiter.api.Test;

class VectorMathTest {

	@Test
	final void test() {
		Vector a = new Vector(0, 0, 0);
		Vector b = new Vector(1, 1, 1);
		Vector c = new Vector(0, -2, 3);
		System.out.println(VectorMath.triangleArea(a, b, c));

	}

}
