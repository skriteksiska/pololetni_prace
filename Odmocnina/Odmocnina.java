public class Odmocnina {
	private static final double maxOdchylka = 0.001;

	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double mezivysledek = 1;
		double odchylka = 1000;
		
		while ((odchylka > maxOdchylka) || (-odchylka > maxOdchylka)) {
			mezivysledek = (a/(mezivysledek*mezivysledek) + 2*mezivysledek) / 3;
			odchylka = a - mezivysledek*mezivysledek*mezivysledek;
		}
		
		System.out.printf("%.2f", mezivysledek);
	}
}