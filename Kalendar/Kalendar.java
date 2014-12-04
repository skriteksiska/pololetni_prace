public class Kalendar {
	public static void main(String[] args) {
		int mesic = Integer.parseInt(args[0]);
		int zacatek = Integer.parseInt(args[1]) - 1;
		int delka;
		
		if (mesic <= 6) {
			if ((mesic%2) == 0) {
				delka = 30;
			}
			else {
				delka = 31;
			}
		}
		else {
		    if ((mesic%2) == 0) {
				delka = 31;
			}
			else {
				delka = 30;
			}
		}
		
		if (mesic == 2) {
			delka = 28;
		}
		
		System.out.println("Po Ut St Ct Pa So Ne");
		
		for (int i=0; i <= (zacatek + delka); i++) {
			if ((i-zacatek) < 10) {
				System.out.printf(" ");
			}
			if ((i-zacatek) > 0) {
				System.out.printf("%d", i-zacatek);
			}
			else {
				System.out.printf(" ");
			}
			if ((i%7) == 0) {
				System.out.printf("\n");
			}
			else {
				System.out.printf(" ");
			}
		}
		
	}
}