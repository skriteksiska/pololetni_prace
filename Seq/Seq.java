public class Seq {
	public static void main(String[] args) {
		int min = 1, max, krok = 1;
		String oddelovac = " ";
		int posunS = 0;
		
		if (args.length >= 3) {
			if (args[0].equals("-s")) {
				oddelovac = args[1];
				posunS = 2;
			}
		}
		
		switch (args.length - posunS) {
			case 0:
				return;
			case 1:
				max = Integer.parseInt(args[posunS]);
				break;
			case 2:
				min = Integer.parseInt(args[posunS]);
				max = Integer.parseInt(args[posunS+1]);
				break;
			case 3:
			default:
				min = Integer.parseInt(args[posunS]);
				krok = Integer.parseInt(args[posunS+1]);
				max = Integer.parseInt(args[posunS+2]);
		}
		
		if (krok > 0) {
			for (int i=min; i <= max; i += krok) {
				System.out.printf("%d", i);
				if (i+krok <= max) {
					 System.out.printf("%s", oddelovac);
				}
			}
		}
		if (krok < 0) {
			for (int i=min; i >= max; i += krok) {
			    System.out.printf("%d", i);
				if (i+krok >= max) {
					 System.out.printf("%s", oddelovac);
				}
			}
		}
		
	}
}