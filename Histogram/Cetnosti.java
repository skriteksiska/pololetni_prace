public class Cetnosti {
	private Cislo[] cisla;
	private int delka;
	
	public Cetnosti() {
		delka = 0;
	}

	public void zapocitej(int a) {
		for (int i=0; i < delka; i++) {
			if (a == cisla[i].getVelikost()) {
				cisla[i].zvysCetnost();
				return;
			}
		}

		delka++;
		Cislo[] pom = new Cislo[delka];
		for (int i=0; i < delka-1; i++) {
			pom[i] = new Cislo(this.cisla[i].getVelikost());
			pom[i].setCetnost(this.cisla[i].getCetnost());
		}
		pom[delka-1] = new Cislo(a);
		this.cisla = pom;
	}

	public int[] seznamCisel() {
		int[] pom = new int[delka];
		for (int i=0; i < delka; i++) {
			pom[i] = this.cisla[i].getVelikost();
		}
		return pom;
	}

	public int getCetnost(int a) {
		return this.cisla[a].getCetnost();
	}
}