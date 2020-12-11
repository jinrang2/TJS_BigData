package polymorphism.shape;

public class ShapeTest {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] s = new Shape[20];
		for (int i = 0; i < s.length; i++)
			s[i] = gen.next();
		
		
		
		for (Shape shp : s)
			shp.draw();
	}
}
