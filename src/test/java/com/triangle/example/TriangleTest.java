package com.triangle.example;

import static com.triangle.example.TriangleType.EQUILATERAL;
import static com.triangle.example.TriangleType.INVALID;
import static com.triangle.example.TriangleType.ISOSCELES;
import static com.triangle.example.TriangleType.SCALENE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.triangle.example.Triangle;
import com.triangle.example.TriangleType;

public class TriangleTest {

	private Triangle traingle = new Triangle();

	@Test
	public void testScalene() {
		final TriangleType type = traingle.doClassify(1, 2, 3);
		assertEquals("SCALENE triangle", SCALENE, type);
	}

	@Test
	public void testInvalidLinesOne() {
		final TriangleType type = traingle.doClassify(1, 2, 4);
		assertEquals("Invalid lines - scenario one.", INVALID, type);
	}

	@Test
	public void testInvalidLinesTwo() {
		final TriangleType type = traingle.doClassify(1, 4, 2);
		assertEquals("Invalid lines - scenario two.", INVALID, type);
	}

	@Test
	public void testInvalidLines() {
		final TriangleType type = traingle.doClassify(4, 1, 2);
		assertEquals("Invalid lines - scenario three.", INVALID, type);

	}

	@Test
	public void testNegativeLines() {
		final TriangleType type = traingle.doClassify(-1, 1, 1);
		assertEquals("Negative input - First Line.", INVALID, type);
	}

	@Test
	public void testNegativeLinesTwo() {
		final TriangleType type = traingle.doClassify(1, -1, 1);
		assertEquals("Negative input - Second Line.", INVALID, type);
	}

	@Test
	public void testNegativeLinesThree() {
		final TriangleType type = traingle.doClassify(1, 1, -1);
		assertEquals("Negative input - Three Line.", INVALID, type);
	}

	@Test
	public void testEquilateral() {
		final TriangleType type = traingle.doClassify(1, 1, 1);
		assertEquals("Equilateral triangle.", EQUILATERAL, type);
	}

	@Test
	public void testIsocelesFirst() {
		final TriangleType type = traingle.doClassify(2, 2, 3);
		assertEquals("Isosceles triangle - First two lines.", ISOSCELES, type);
	}

	@Test
	public void testIsocelesSecond() {
		final TriangleType type = traingle.doClassify(2, 3, 2);
		assertEquals("Isosceles triangle - First and Last lines.", ISOSCELES, type);
	}

	@Test
	public void testIsoceles3() {
		final TriangleType type = traingle.doClassify(3, 2, 2);
		assertEquals("Isosceles triangle - Last two lines.", ISOSCELES, type);
	}

	@Test
	public void testInvalidLinesThree() {
		final TriangleType type = traingle.doClassify(3, 1, 1);
		assertEquals("Invalid Triangle two sides are less than thrid one.", INVALID, type);
	}
}
