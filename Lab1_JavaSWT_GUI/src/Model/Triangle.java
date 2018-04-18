package Model;

/**
 * <h1>Operations on triangles</h1>
 * 
 * @author Valery Chadovich
 *
 */
public class Triangle {
	/**
	 * <h1>Area of triangle with all known sides</h1>
	 * 
	 * @param a
	 * 			Side 1
	 * @param b
	 * 			Side 2
	 * @param c
	 * 			Side 3
	 * @return
	 * 			Area of a triangle
	 * @throws Exception
	 * 			Negative side or unreal sides of triangle
	 */
	public static double getArea(double a, double b, double c) throws Exception {
		if (a <= 0 || b <= 0 || c <= 0) 
			throw new Exception("All parameters must be positive!");
		if ((a + b < c) || (a + c < b) || (b + c < a))
			throw new Exception("Unreal sides of triangle");
		
		double p = Triangle.getPerimeter(a, b, c);
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
	
	/**
	 * 
	 * <h1>Area of triangle with all known sides</h1>
	 * 
	 * @param a
	 * 			Side 1
	 * @param b
	 * 			Side 2
	 * @param c
	 * 			Side 3
	 * @return
	 * 			Area of a triangle
	 * @throws Exception
	 * 			Negative side or unreal sides of triangle
	 */
	public static double getPerimeter(double a, double b, double c) throws Exception {
		if (a <= 0 || b <= 0 || c <= 0) 
			throw new Exception("All parameters must be positive!");
		if ((a + b < c) || (a + c < b) || (b + c < a))
			throw new Exception("Unreal sides of triangle");
		
		return a + b + c;
	}
}
