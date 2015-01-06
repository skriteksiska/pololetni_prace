public class Elipsa {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		for (int y = b; y >= -b; y--)  {
		    for (int x = -a; x <= a; x++) {
				if ( ((double) x / a)*((double) x / a) + ((double) y / b)*((double) y / b) <= 1) {
					System.out.printf("X");
				}
				else {
					System.out.printf(" ");
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}
}