package math.vector;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class VectorTest {

	@Test
	final void test() {

		// TEST COMPONENT PARALLELIZATION
		if (!Vector.parallel(Vector.i, Vector.i)) {
			fail("i and i must be parrallel");
		}
		if (!Vector.parallel(Vector.j, Vector.j)) {
			fail("j and j must be parrallel");
		}
		if (!Vector.parallel(Vector.k, Vector.k)) {
			fail("k and k must be parrallel");
		}

		// TEST COMPONENT PERPENDICULARIZATION
		if (!Vector.perpendicular(Vector.i, Vector.j)) {
			fail("i and j must be perpendicular");
		}
		if (!Vector.perpendicular(Vector.j, Vector.k)) {
			fail("j and k must be perpendicular");
		}
		if (!Vector.perpendicular(Vector.k, Vector.i)) {
			fail("k and i must be perpendicular");
		}

		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(-3, -2, -1);
		Vector v3 = new Vector(3, 0, 4);
		Vector v4 = new Vector(0, 4, 5);
		Vector v5 = new Vector(7, 2, 0);
		Vector v6 = new Vector(-0.5, 1.5, 1.0);
		Vector v7 = new Vector(0, 0, 5);
		Vector v8 = new Vector(0, 23.54, -100);
		Vector v9 = new Vector(0, -0.0, 0.0);

		System.out.println("Component form: " + v1.componentForm());
		System.out.println("Standard form: " + v1.standardForm());

		System.out.println("Component form: " + v2.componentForm());
		System.out.println("Standard form: " + v2.standardForm());

		System.out.println("Component form: " + v3.componentForm());
		System.out.println("Standard form: " + v3.standardForm());

		System.out.println("Component form: " + v4.componentForm());
		System.out.println("Standard form: " + v4.standardForm());

		System.out.println("Component form: " + v5.componentForm());
		System.out.println("Standard form: " + v5.standardForm());

		System.out.println("Component form: " + v6.componentForm());
		System.out.println("Standard form: " + v6.standardForm());

		System.out.println("Component form: " + v7.componentForm());
		System.out.println("Standard form: " + v7.standardForm());

		System.out.println("Component form: " + v8.componentForm());
		System.out.println("Standard form: " + v8.standardForm());

		System.out.println("Component form: " + v9.componentForm());
		System.out.println("Standard form: " + v9.standardForm());

		if (!v9.equals(Vector.origin)) {
			fail("Should be the same as origin");
		}

		System.out.println(Vector.crossProduct(new Vector(2, -4, -2), new Vector(1, 3, -2)).standardForm());
	}

}
