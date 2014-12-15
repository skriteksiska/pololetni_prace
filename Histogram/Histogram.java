public class Histogram {
 	private static final int MAXIMUM_RADEK = 20;

	private static void vypis(int[] vyskySloupcu, int rozsahSloupce) {
		/*for (int i=0; i < vyskySloupcu.length; i++) {
			System.out.printf("%d ", vyskySloupcu[i]);
		}
		System.out.printf(":D%d ", rozsahSloupce);*/
		int radku = 0;
		for (int i=0; i < vyskySloupcu.length; i++) {
			if (vyskySloupcu[i] > radku) {
				radku = vyskySloupcu[i];
			}	
		}
		
		// aby vysoke cetnosti nerozhodily formatovani
		int maxDelka = (new Integer(radku)).toString().length();
		  
		while (radku > 0) {
			System.out.printf("%"+maxDelka+"dx |", radku);
			for (int i=0; i < vyskySloupcu.length; i++) {
				if (vyskySloupcu[i] >= radku) {
					System.out.printf(" XX");
				}
				else {
					System.out.printf("   ");
				}
			}
			radku--;
			System.out.println();
		}
		
		//System.out.printf()
		
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
		
		
		/* urci, kolik jaky rozsah bude mit kazdy sloupec (1, 10, 100, ...)
		   aby se to pohodlne veslo na radek */
		int rozsahSloupce = 1;
		while (max-min > MAXIMUM_RADEK * rozsahSloupce) {
			rozsahSloupce *= 10;		
		}
		
		int pocetSloupcu = (int) Math.ceil((1+max-min) / (double) rozsahSloupce);
		int[] vyskySloupcu = new int[pocetSloupcu];
		
		// pro kazdy sloupec histogramu
		for (int i=0; i < pocetSloupcu; i++) {
			vyskySloupcu[i] = 0;
			for (int j=0; j < seznam.length; j++) {
				// kazde cislo v tomto sloupci
				if ((seznam[j] >= min+i*rozsahSloupce) && (seznam[j] < min + (i+1)*rozsahSloupce )) {
					vyskySloupcu[i] += cetnosti.getCetnost(j);
				}
			}
		}
		
		
		vypis(vyskySloupcu, rozsahSloupce);
	}
	
}