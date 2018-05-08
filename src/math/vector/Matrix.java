package math.vector;

import java.util.Random;

public class Matrix {

	// Two-dimensional double array representing matrix values
	private double matrix[][];
	// Integer representing row and column count
	private int rows, columns;

	/**
	 * Create a new matrix with the given size
	 *
	 * @param rows
	 *            Number of rows
	 * @param columns
	 *            Number of columns
	 */
	public Matrix(int rows, int columns) {
		if ((rows > 0) && (columns > 0)) {
			matrix = new double[rows][columns];
			this.rows = rows;
			this.columns = columns;
		}
	}

	/**
	 * Print the matrix
	 */
	public void print() {
		System.out.println(String.format("Matrix size %dx%d", rows, columns));
		for (int i = 0; i < rows; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < columns; j++) {
				sb.append("--------");
			}
			System.out.println(sb.toString());
			sb = new StringBuilder();
			for (int j = 0; j < columns; j++) {
				sb.append("| ");
				sb.append(String.format("% 3.2f ", matrix[i][j]));
			}
			System.out.println(sb.toString());
		}
	}

	/**
	 * Determines if the given row and column exists in this matrix. Row must be in
	 * range 1...rows and column must be in range 1...columns
	 *
	 * @param row
	 *            The row number to check
	 * @param column
	 *            The column number to check
	 * @return True if the row AND column exists, otherwise false
	 */
	public boolean valid(int row, int column) {
		boolean value = ((row >= 1) && (row <= rows) && (column >= 1) && (column <= columns));
		return value;
	}

	/**
	 * Determines if the given two-dimensional array will fit this matrix. Checks
	 * both dimension size
	 *
	 * @param m
	 *            The two-dimensional array
	 * @return True if the array is the same size as the existing array, false if
	 *         not
	 */
	public boolean valid(double m[][]) {
		boolean valid = true;
		if (m.length != rows) {
			valid = false;
		}
		for (double[] element : m) {
			if (element.length != columns) {
				valid = false;
			}
		}
		return valid;
	}

	/**
	 * @return The number of rows in the matrix
	 */
	public int rows() {
		return rows;
	}

	/**
	 * @return The number of columns in the matrix
	 */
	public int columns() {
		return columns;
	}

	/**
	 * Set new values for the matrix
	 *
	 * @param m
	 *            The array to replace the existing one with
	 * @return Reference to this for method chaining
	 */
	public Matrix populate(double m[][]) {
		if (valid(m)) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					matrix[i][j] = m[i][j];
				}
			}
		}
		return this;
	}

	/**
	 * Returns the value at the specified row and column. Row must be in range
	 * 1...rows and column must be in range 1...column
	 *
	 * @param row
	 *            The row number
	 * @param column
	 *            The column number
	 * @return The value at the position row,column
	 */
	public double get(int row, int column) {
		if (valid(row, column)) {
			return matrix[row - 1][column - 1];
		} else {
			return 0.0;
		}
	}

	/**
	 * Returns a specific row in the matrix as a one-dimensional array. Row must be
	 * in range 1...rows
	 *
	 * @param row
	 *            The row number
	 * @return The row as a one-dimensional array
	 */
	public double[] getRow(int row) {
		if (valid(row, 1)) {
			return matrix[row - 1].clone();
		} else {
			return null;
		}
	}

	/**
	 * Returns a specific column in the matrix as a one-dimensional array. Column
	 * must be in range 1...columns
	 *
	 * @param column
	 *            The column number
	 * @return The column as a one-dimensional array
	 */
	public double[] getColumn(int column) {
		if (valid(1, column)) {
			double[] c = new double[rows];
			for (int i = 0; i < rows; i++) {
				c[i] = matrix[i][column - 1];
			}
			return c;
		} else {
			return null;
		}
	}

	/**
	 * Sets a particular position in the matrix to a new value
	 *
	 * @param row
	 *            The row number
	 * @param column
	 *            The column number
	 * @param value
	 *            The new value
	 * @return Reference to this for method chaining
	 */
	public Matrix set(int row, int column, double value) {
		if (valid(row, column)) {
			matrix[row - 1][column - 1] = value;
		}
		return this;
	}

	/**
	 * Sets an entire row in the matrix to new values
	 *
	 * @param row
	 *            The row number
	 * @param r
	 *            The one-dimensional row array
	 */
	public void setRow(int row, double r[]) {
		if (valid(row, 1) && (r.length == columns)) {
			for (int i = 0; i < columns; i++) {
				matrix[row - 1][i] = r[i];
			}
		}
	}

	/**
	 * Sets an entire column in the matrix to new values
	 *
	 * @param column
	 *            The column number
	 * @param c
	 *            The one-dimensional column array
	 */
	public void setColumn(int column, double c[]) {
		if (valid(1, column) && (c.length == rows)) {
			for (int i = 0; i < rows; i++) {
				matrix[i][column - 1] = c[i];
			}
		}
	}

	/**
	 * Calculates the determinant of the matrix
	 *
	 * @return The determinant
	 */
	public double determinant() {
		// Matrix must be square
		if (rows == columns) {

			// Simply variable name
			int size = rows;

			// If the matrix is 1x1
			if (size == 1) {
				// Return the value - end recursion
				return matrix[0][0];
			} else if (size > 1) {
				// Get the top row
				double row[] = getRow(1);
				// Create the sum
				double sum = 0.0;
				// Loop through each value in the row
				for (int i = 0; i < columns; i++) {
					// Multiply the row value times the determinant of the matrix of minors
					// We also multiply in -1^i to account for plus/minus of these values
					sum += Math.pow(-1.0, i) * row[i] * matrixOfMinors(1, i + 1).determinant();
				}
				return sum;
			} else {
				System.out.println("Matrix size invalid");
				return 0.0;
			}
		} else {
			System.out.println("Matrix must be square");
			return 0.0;
		}
	}

	/**
	 * Deletes the row and column from the input matrix and returns the new "Matrix
	 * of minors"
	 *
	 * @param m
	 * @param row
	 * @param column
	 * @return
	 */
	protected Matrix matrixOfMinors(int row, int column) {
		// We can only operate on at least 3x3 matrices
		if ((rows < 2) || (columns < 2)) {
			return null;
		}
		// Create a temp matrix
		Matrix t = new Matrix(rows - 1, columns);
		// Copy over all rows except the deleted one
		for (int i = 0, j = 0; i < rows; i++) {
			if ((i + 1) == row) {
				// Don't copy
			} else {
				// Copy
				t.setRow(j + 1, getRow(i + 1));
				j++;
			}
		}
		// Create the final matrix
		Matrix n = new Matrix(t.rows, t.columns - 1);
		// Copy over all columns except the deleted ones
		for (int i = 0, j = 0; i < t.columns; i++) {
			if ((i + 1) == column) {
				// Don't copy
			} else {
				// Copy
				n.setColumn(j + 1, t.getColumn(i + 1));
				j++;
			}
		}
		// We're done
		return n;
	}

	/**
	 * Adds the given matrix to this one
	 *
	 * @param m
	 *            The matrix to add
	 * @return Reference to this for method chaining
	 */
	public Matrix add(Matrix m) {
		if ((rows == m.rows) && (columns == m.columns)) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					matrix[i][j] += m.matrix[i][j];
				}
			}
			return this;
		} else {
			return null;
		}
	}

	/**
	 * Adds two matrixes together
	 *
	 * @param a
	 *            Matrix A
	 * @param b
	 *            Matrix B
	 * @return The matrix A + B
	 */
	public static Matrix add(Matrix a, Matrix b) {
		if ((a.rows == b.rows) && (a.columns == b.columns)) {
			Matrix m = new Matrix(a.rows, a.columns);
			for (int i = 0; i < a.rows; i++) {
				for (int j = 0; j < a.columns; j++) {
					m.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
				}
			}
			return m;
		} else {
			return null;
		}
	}

	/**
	 * Multiplies this matrix by the scalar
	 *
	 * @param s
	 *            The scalar value
	 * @return Reference to this for method chaining
	 */
	public Matrix scalarMultiply(double s) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] *= s;
			}
		}
		return this;
	}

	/**
	 * Multiplies two one-dimensional arrays (vectors) together
	 *
	 * @param a
	 *            The vector/array A
	 * @param b
	 *            The vector/array B
	 * @return The dot product of A and B
	 */
	private static double dotProduct(double a[], double b[]) {
		if (a.length == b.length) {
			double sum = 0.0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i] * b[i];
			}
			return sum;
		} else {
			return 0.0;
		}
	}

	/**
	 * Multiplies two matrixes together
	 *
	 * @param a
	 *            Matrix A
	 * @param b
	 *            Matrix B
	 * @return The Matrix A x B
	 */
	public static Matrix matrixMultiply(Matrix a, Matrix b) {
		if (a.columns == b.rows) {
			Matrix m = new Matrix(a.rows, b.columns);
			for (int i = 0; i < a.rows; i++) {
				for (int j = 0; j < b.columns; j++) {
					// Calculate C[i][j]
					m.matrix[i][j] = Matrix.dotProduct(a.getRow(i + 1), b.getColumn(j + 1));
				}
			}
			return m;
		} else {
			return null;
		}
	}

	/**
	 * Generates random matrix values in a given range. Replaces all existing values
	 * with new random ones.
	 *
	 * @param min
	 *            The minimum value (inclusive)
	 * @param max
	 *            The maximum value (inclusive)
	 * @return Reference to this for method chaining
	 */
	public Matrix generate(int min, int max) {
		Random random = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = random.nextInt((max - min) + 1) + min;
			}
		}
		return this;
	}
}
