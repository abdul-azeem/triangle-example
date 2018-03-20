package com.triangle.example;

import static com.triangle.example.TriangleType.EQUILATERAL;
import static com.triangle.example.TriangleType.INVALID;
import static com.triangle.example.TriangleType.ISOSCELES;
import static com.triangle.example.TriangleType.SCALENE;

/**
 * Simple example to classification of different types of triangle.
 * @author Abdul Azeem
 *
 */
public class Triangle {

	public TriangleType doClassify(final int line1, final int line2, final int line3) {
		// is valid triangle
		if (isInvalidTraingle(line1, line2, line3)) {
			return INVALID;
		}
		int equiLinesCount = doEquiLinesCount(line1, line2, line3);

		// check 3 lines are identical
		if (equiLinesCount > 3) {
			return EQUILATERAL;
		}
		// check any two lines are identical
		if ((equiLinesCount == 1) && ((line1 + line2) > line3)) {
			return ISOSCELES;
		} else if ((equiLinesCount == 2) && ((line1 + line3) > line2)) {
			return ISOSCELES;
		} else if ((equiLinesCount == 3) && ((line2 + line3) > line1)) {
			return ISOSCELES;
		}
		// no identical lines
		if (equiLinesCount == 0) {
			return SCALENE;
		}

		return INVALID;
	}

	private int doEquiLinesCount(int line1, int line2, int line3) {
		int count = 0;
		if (line1 == line2) {
			count = count + 1;
		}
		if (line1 == line3) {
			count = count + 2;
		}
		if (line2 == line3) {
			count = count + 3;
		}
		return count;
	}

	private boolean isInvalidTraingle(int line1, int line2, int line3) {
		boolean linesExists = (line1 <= 0) || (line2 <= 0) || (line3 <= 0);
		boolean validLines = ((line1 + line2) < line3) || ((line1 + line3) < line2) || ((line2 + line3) < line1);
		return linesExists || validLines;
	}

}
