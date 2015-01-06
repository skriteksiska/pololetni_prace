public class Histogram {
 	private static final int MAXIMUM_RADEK = 14;

	private static void vypis(int[] poleSloupcu, int rozsahSloupce, int min) {
		/* Pro ladeni:
		for (int i=0; i < poleSloupcu.length; i++) {
			System.out.printf("%d ", poleSloupcu[i]);
		}
		System.out.printf(":D%d ", rozsahSloupce); */
		
		int radku = 0;
		for (int i=0; i < poleSloupcu.length; i++) {
			if (poleSloupcu[i] > radku) {
				radku = poleSloupcu[i];
			}	
		}
		
		// aby vysoke cetnosti nerozhodily formatovani
		int maxDelka = (new Integer(radku)).toString().length();
		  
		while (radku > 0) {
			System.out.printf("%"+maxDelka+"dx |", radku);
			for (int i=0; i < poleSloupcu.length; i++) {
				if (poleSloupcu[i] >= radku) {
					System.out.printf("  XXX");
				}
				else {
					System.out.printf("     ");
				}
			}
			radku--;
			System.out.println();
		}
		
		// vypsani spodni linky
		for (int i=0; i <= maxDelka; i++) {
			System.out.printf(" ");
		}
		System.out.printf(" +-");
		for (int i=0; i < poleSloupcu.length; i++) {
			System.out.printf("-----");
		}
		System.out.println();
		
		// popis spodni osy
		for (int i=-2; i <= maxDelka; i++) {
			System.out.printf(" ");
		}
		for (int i=0; i < poleSloupcu.length; i++) {
			System.out.printf("%4d", (i + min/rozsahSloupce) * rozsahSloupce);
			if (rozsahSloupce == 1) {
				System.out.printf(" ");
			}
			else {
			    System.out.printf("+");
			}
		}
		
	}

	public static void main(String[] args) {
		// nacteni vstupu
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int vstup;
		
		// vyskyt jednotlivych cisel spocita trida Cetnosti
		Cetnosti cetnosti = new Cetnosti();
		
		while (sc.hasNextInt()) {
			vstup = sc.nextInt();
			cetnosti.zapocitej(vstup);
			if (vstup < min) {
			    min = vstup;
			}
			if (vstup > max) {
			    max = vstup;
			}	
		}
		int[] seznam = cetnosti.seznamCisel();
		
		
		/* urci, kolik cisel bude v jednom sloupci (1, 5, 10, 50, 100, ...),
		   aby se to pohodlne veslo na radek */
		int rozsahSloupce = 1;
		boolean tedPetku = true;
		while (max-min > MAXIMUM_RADEK * rozsahSloupce) {
			if (tedPetku) {
				rozsahSloupce *= 5;
				tedPetku = false;
			}
			else {			
				rozsahSloupce *= 2;
				tedPetku = true;
			}		
		}
		
		int pocetSloupcu = (int) Math.ceil((1+max-min) / (double) rozsahSloupce);
		// v promenne seznam nemame hodnoty serazene
		int[] poleSloupcu = new int[pocetSloupcu];
		
		// pro kazdy sloupec histogramu
		for (int i=0; i < pocetSloupcu; i++) {
			poleSloupcu[i] = 0;
			for (int j=0; j < seznam.length; j++) {
				// jestli patri do tohoto sloupce
				if ((seznam[j] >= min+i*rozsahSloupce) && (seznam[j] < min + (i+1)*rozsahSloupce )) {
					poleSloupcu[i] += cetnosti.getCetnost(j);
				}
			}
		}
		
		
		vypis(poleSloupcu, rozsahSloupce, min);
	}
	
}