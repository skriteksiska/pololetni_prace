public class DenTyden {
	public static void main(String[] args) {
		int rok = Integer.parseInt(args[0]);
		int mesic = Integer.parseInt(args[1]);
		int denVMesici = Integer.parseInt(args[2]);
		
		double denVTydnu = (denVMesici + Math.round((2.6*((mesic-2)%12)) - 0.2) + 5*((rok-1)%4) + 4*((rok-1)%100) + 6*((rok-1)%400)) % 7;
		
		String odpoved;
		
		switch ((int) denVTydnu) {
			case 0:
				odpoved = "nedele";
				break;
			case 1:
				odpoved = "pondeli";
				break;
			case 2:
				odpoved = "utery";
				break;
			case 3:
				odpoved = "streda";
				break;
			case 4:
				odpoved = "ctvrtek";
				break;
			case 5:
				odpoved = "patek";
				break;
			case 6:
				odpoved = "sobota";
				break;
			default:
				odpoved = "error";
				break;
		}
		
		System.out.println(odpoved);
	}
}