package es.estudiosmafalda.CCTUtils;

public class TiemposAscenso {
	
//	private final int VEL_ASC_GLOBO_200 = 200;
//	private final int VEL_ASC_GLOBO_100 = 100;
//	private final double PIES_TO_METERS = 1 / 3.28;
	
	private final static double SECONDS_PER_1000FT_BELOW_4500 = (93.3 / 1000.0);
	private final static double SECONDS_PER_1000FT_ABOVE_4500 = (90.0/ 1000.0);

	public TiemposAscenso(){
		
	}
	
	public static double Segundos (int altura){
		System.out.println ("Altura: " + altura);
		if (altura < 4500) return altura * SECONDS_PER_1000FT_BELOW_4500;
		else {
		int diferencia = altura - 4500;
		System.out.println ("Tiempo: " + (420 + (diferencia*90/1000))+ " segundos.");
		return 420 + (diferencia * SECONDS_PER_1000FT_ABOVE_4500);
		}
	}
	
}
