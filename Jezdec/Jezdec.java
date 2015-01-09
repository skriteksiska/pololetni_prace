public class Jezdec {
	
	private static int[][] sachovnice;
	private static int n;
	
	public static void skok(int x, int y, int kolikSem) {
		// zkontroluje, ze nejsme mimo sachovnici
		if ((x<0) || (y<0) || (x>=n) || (y>=n)) {
			return;
		}
		
		int staraHodnota = sachovnice[x][y];
		
		// nenavstivene policko
		if (staraHodnota == 0) {
			sachovnice[x][y] = kolikSem;
		}
		// navstivene policko
		else {
			if (kolikSem < staraHodnota) {
				sachovnice[x][y] = kolikSem;
			}
			// tento pripad je zbytecne pocitat
			else {
				return;
			}
		}
		
		// skoky z tohoto policka
		skok(x+1, y+2, kolikSem+1);
		skok(x+2, y+1, kolikSem+1);
		skok(x+2, y-1, kolikSem+1);
		skok(x+1, y-2, kolikSem+1);
		skok(x-1, y-2, kolikSem+1);
		skok(x-2, y-1, kolikSem+1);
		skok(x-2, y+1, kolikSem+1);
		skok(x-1, y+2, kolikSem+1);		
	}
	
	public static void vypis() {
	    System.out.println("<!DOCTYPE html>");
		System.out.println("<html>\n<head>\n  <title>Jezdec</title>\n</head>\n<body>\n");
		System.out.println("<table style=\"font-size: 3em;\" cellspacing=\"0\">");
		
		int pom;
		
		// pro nastaveni barvy
		int nejvetsi = 1;
		for (int y=0; y < n; y++) {
			for (int x=0; x < n; x++) {
				if (sachovnice[x][y]-1 > nejvetsi) {
					nejvetsi = sachovnice[x][y]-1;
				}
			}
		}
		
		for (int y=0; y <= n; y++) {
			System.out.println("  <tr>");
			
			for (int x=0; x <= n; x++) {
				if ((x == 0) && (y == 0)) {
					System.out.printf("    <td></td>\n");
				}
				else if (y == 0) {
					System.out.printf("    <td><b>&nbsp;%d&nbsp;</b></td>\n", x);
				}
				else if (x == 0) {
					System.out.printf("    <td><b>&nbsp;%d&nbsp;</b></td>\n", y);
				}
				else {
					pom = sachovnice[x-1][y-1] - 1;	
					
					System.out.printf("    <td style=\"background-color: #FF%02x%02x\">&nbsp;%d&nbsp;</td>\n",
									 (int) (255 * Math.sin((nejvetsi-pom) / (double) nejvetsi)),
									 (int) (255 * Math.sin((nejvetsi-pom) / (double) nejvetsi)), pom);
				}
			}
			
			System.out.println("  </tr>");
		}
		
		System.out.println("</table>\n\n</body>\n</html>");
	}
	
	public static void main(String[] args) {
		if (args.length < 3) { return; }
		
		n = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
				
		sachovnice = new int[n][n];
		
		/* hodnoty zvetsene o 1, aby 0 vyzdy oznacovala nenavstivene policko */
		skok(x-1, y-1, 1);
					
		// vypsani
		vypis();
	}
}