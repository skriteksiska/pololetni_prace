public class Spirala {
	private static double zmenaUhlu = 0.5;

	public static void main(String[] args) {
		
		double b = 5;	// rychlost otaceni
		double a = 0;	// pocatecni natoceni
		int maxR = 200;	// konec spiraly
		
		if (args.length > 0) {
			b = Double.parseDouble(args[0]);
			if (args.length > 1) {
				a = Double.parseDouble(args[1]);
				if (args.length > 2) {
					maxR = Integer.parseInt(args[2]);
				}
			}
		}
		
		System.out.printf("<?xml version=\"1.0\"?>\n<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" "
						 + "\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
						 + "<svg xmlns=\"http://www.w3.org/2000/svg\"\n     width=\"400\" height=\"400\">\n\n");
		
		double uhel = -a/b;
		double r;
		double x1=0, y1=0, x2=0, y2=0, x3=0, y3=0;
		int kolikrat = 0;
		
		while (true) {
			r = a + b*uhel;
			uhel += zmenaUhlu;
			kolikrat++;
			
			if (r > maxR) {
				break;
			}
			
			x1 = r * Math.sin(uhel) + 200;
			y1 = r * Math.cos(uhel) + 200;
			
			// vykresleni
			if ((kolikrat >= 3) && (kolikrat % 2 == 1)) {
				System.out.printf("<path d=\"M %d %d Q %d %d %d %d\" stroke=\"red\" stroke-width=\"2\" fill=\"none\" />", (int) x1, (int) y1,
																		  (int) (2*x2-(x1+x3)/2), (int) (2*y2-(y1+y3)/2), (int) x3, (int) y3);
			}
			
			x3 = x2;
			y3 = y2;
			
			x2 = x1;
			y2 = y1;
		}
		
		
		System.out.println("\n</svg>");
	}
}
