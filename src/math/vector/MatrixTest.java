package math.vector;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	final void test() {
		Matrix m = new Matrix(4, 4).populate(new double[][] { { 5, -7, 2, 2 }, { 0, 3, 0, -4 }, { -5, -8, 0, 3 }, { 0, 5, 0, -6 } });
		m.print();
		System.out.println(m.determinant());
		Matrix c = new Matrix(3, 3).populate(new double[][] { { 6, 1, 1 }, { 4, -2, 5 }, { 2, 8, 7 } });
		c.print();
		System.out.println(c.determinant());
	}

}
