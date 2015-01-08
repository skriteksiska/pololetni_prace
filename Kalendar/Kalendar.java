import java.util.Calendar;

public class Kalendar {
	public static int dnuMesice(Calendar cal) {
	     return cal.getActualMaximum(Calendar.DATE);
	}
	
	public static int prvniDenMesice(Calendar cal) {
		int denVTydnu =  cal.get(Calendar.DAY_OF_WEEK) - 1;
		// osetreni nedele
		if (denVTydnu == 0) {
			denVTydnu = 7;
		}
		return denVTydnu;
	}
	
	public static String nazevMesice(Calendar cal) {
		switch (cal.get(Calendar.MONTH)) {
			case 0: 
				return "        leden         ";
			case 1: 
				return "         unor         ";
			case 2: 
				return "       brezen         ";
			case 3: 
				return "        duben         ";
			case 4: 
				return "        kveten        ";
			case 5: 
				return "       cerven         ";
			case 6: 
				return "       cervenec       ";
			case 7: 
				return "        srpen         ";
			case 8: 
				return "         zari         ";
			case 9: 
				return "        rijen         ";
			case 10: 
				return "       listopad       ";
		}
		//	case 11: 
				return "       prosinec       ";
	}

	public static void main(String[] args) {
		// 1 - predchazejici, 2 - soucasny, 3 - nasledujici mesic
		Calendar mesic1 = Calendar.getInstance(),
				 mesic2 = Calendar.getInstance(),
				 mesic3 = Calendar.getInstance();
				 
		int mesic = mesic2.get(Calendar.MONTH);
		int rok = mesic2.get(Calendar.YEAR);
		
		if (args.length >= 1) {
			mesic = Integer.parseInt(args[0]) - 1;
		}
		if (args.length >= 2) {
			rok = Integer.parseInt(args[1]);
		}
		
		// osetreni prechodu roku
		if (mesic-1 >= 0) {
			mesic1.set(rok, mesic-1, 1);
		}
		else {
			mesic1.set(rok-1, 11, 1);
		}
		
		mesic2.set(rok, mesic, 1);
		
		// osetreni prechodu roku
		if (mesic+1 < 12) {
			mesic3.set(rok, mesic+1, 1);
		}
		else {
			mesic3.set(rok+1, 0, 1);
		}
		
		int zacatek1 = prvniDenMesice(mesic1),
			zacatek2 = prvniDenMesice(mesic2),
			zacatek3 = prvniDenMesice(mesic3);
		int delka1 = dnuMesice(mesic1),
			delka2 = dnuMesice(mesic2),
			delka3 = dnuMesice(mesic3);
		
		/* System.out.printf("%d %d %d %d %d %d %d %d %d %d %d %d %d %d %d\n", mesic1.get(Calendar.DATE), mesic1.get(Calendar.MONTH), mesic1.get(Calendar.YEAR),
														mesic2.get(Calendar.DATE), mesic2.get(Calendar.MONTH), mesic2.get(Calendar.YEAR),
														mesic3.get(Calendar.DATE), mesic3.get(Calendar.MONTH), mesic3.get(Calendar.YEAR),
														zacatek1, zacatek2, zacatek3, delka1, delka2, delka3); */
														
		// vypsani
		System.out.println("\n .----------------------.  .----------------------.  .----------------------.");
		System.out.printf(" |%s|  |%s|  |%s|\n", nazevMesice(mesic1), nazevMesice(mesic2), nazevMesice(mesic3));
		System.out.println(" |----------------------|  |----------------------|  |----------------------|");
		System.out.println(" | Po Ut St Ct Pa So Ne |  | Po Ut St Ct Pa So Ne |  | Po Ut St Ct Pa So Ne |");
		System.out.println(" |                      |  |                      |  |                      |");
		
		for (int radek=0; radek < 6; radek++) {
			System.out.printf(" |");
			// predchozi mesic
			for (int i=0; i<7; i++) {
				if ((radek*7 + i - zacatek1 > -2) && (radek*7 + i - zacatek1 + 1 < delka1)) {
					System.out.printf(" %2d", radek*7 + i - zacatek1 + 2);
				}
				else {
					System.out.printf("   ");	
				}
			}
			System.out.printf(" |  |");
			
			// tento mesic
			for (int i=0; i<7; i++) {
				if ((radek*7 + i - zacatek2 > -2) && (radek*7 + i - zacatek2 + 1 < delka2)) {
					System.out.printf(" %2d", radek*7 + i - zacatek2 + 2);
				}
				else {
					System.out.printf("   ");	
				}
			}
			System.out.printf( " |  |");
			
			// nasledujici mesic
			for (int i=0; i<7; i++) {
				if ((radek*7 + i - zacatek3 > -2) && (radek*7 + i - zacatek3 + 1 < delka3)) {
					System.out.printf(" %2d", radek*7 + i - zacatek3 + 2);
				}
				else {
					System.out.printf("   ");	
				}
			}
			System.out.printf(" | \n"); 
		}
		
		System.out.println(" `----------------------'  `----------------------'  `----------------------' ");
			
	}
}