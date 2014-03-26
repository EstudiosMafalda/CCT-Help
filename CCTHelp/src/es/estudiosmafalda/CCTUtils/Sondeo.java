package es.estudiosmafalda.CCTUtils;

public class Sondeo {

	private VientoMedio viento;
	
	public Sondeo (){
		viento = new VientoMedio();
	}

	public int SondeoAutomatico (int altura, int elevacion, double k){
		return (int) (((float)altura / 1000) * k * viento.Automatico(altura, elevacion));
	}
	
	public double SondeoManual (int altura, int elevacion, double c, double k){
		System.out.println ("Viento medio APM: " + viento.Manual(elevacion, VientoMedio.VEL_ASC_GLOBO_200));
		return (((float)altura/1000) * (viento.Manual(elevacion, VientoMedio.VEL_ASC_GLOBO_200) + c)) / k;
	}
	
}
