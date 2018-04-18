package Tests;

import Model.*;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.equalTo;

public class TriangleTests {
	
	@Test
	public void can_compute_perimeter() throws Exception{
		// Arrange
		
		// pass
		
		// Action
		
		String result2 = "";
		
		try {
			Triangle.getPerimeter(-1, 2, 3);
		}
		catch(Exception e) {
			result2 = e.getMessage();
		}
		
		double result1 = Triangle.getPerimeter(3, 4, 5);
		
		// Assert
		assertEquals(12.0, result1, 0.0);
		assertEquals("All parameters must be positive!", result2);
	}
	
	@Test
	public void can_compute_area() throws Exception{
		// Arrange
		
		// pass
				
		// Action
		String result2 = "";
		
		try {
			Triangle.getArea(-1, 2, 3);
		}
		catch(Exception e) {
			result2 = e.getMessage();
		}
		
		double result1 = Triangle.getArea(3, 4, 5);
		
		// Assert
		assertEquals(77.76, result1, 0.1);
		assertEquals("All parameters must be positive!", result2);

	}
	
}