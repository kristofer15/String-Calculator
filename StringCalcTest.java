package stringCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalcTest {
	
	StringCalc c = new StringCalc();
	@Test
	public void testBothSeperators() {
		assertEquals(6, c.add("1\n2,3"));
	}
	
	@Test
	public void testEmptyInput() {
		assertEquals(0, c.add(""));
	}
	
	@Test
	public void testOver2Numbers() {
		assertEquals(4, c.add("1,1,1,1"));
		assertEquals(4, c.add("1\n1\n1\n1"));
	}
	
	@Test
	public void testAdd2numbers() {
		assertEquals(3, c.add("1,2"));
		assertEquals(6, c.add("3,3"));
		assertEquals(2, c.add("1,1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeNumbers() {
		c.add("2,-4,3,-5");

	}
	
	@Test
	public void testNumbersOver1000() {
		assertEquals(1000, c.add("1000,1001"));
	}
	
	@Test
	public void testDelimiterChange() {
		assertEquals(20, c.add("//;\n5;5;5;5"));
		assertEquals(20, c.add("//z\n5z5z5z5"));
		
	}
}
