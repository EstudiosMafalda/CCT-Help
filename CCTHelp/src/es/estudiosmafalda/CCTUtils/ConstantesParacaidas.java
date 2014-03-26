package es.estudiosmafalda.CCTUtils;

public class ConstantesParacaidas {
	
	public interface Paracaidas {
		int MT1X=0, TPMPLUS=1, JANUS=2, G9=3, NONE=4;
		};

	public static final double [][] MT1X = {{59.9,18.6},{62.3,19.3},{64.8,20.1},{67.6,20.9},{70.6,21.9}};
	public static final double [][] TPMPLUS = {{59.9,18.6},{62.3,19.3},{64.8,20.1},{67.6,20.9},{70.6,21.9}};
	public static final double [][] G9 = {{30.0,23.3},{31.2,24.2},{32.4,25.2},{33.8,26.2},{35.3,27.4}};

	public static double C (int paracaidas, int altura){
		int alt = 0;
		if (0 < altura && altura < 5000) alt = 0;
		else if (5000 < altura && altura < 10000) alt = 1;
		else if (10000 < altura && altura < 15000) alt = 2;
		else if ( 15000 < altura && altura < 20000) alt = 3;
		else if (20000 < altura && altura < 25000) alt = 4;
				
		switch (paracaidas){
		case Paracaidas.MT1X:
			return MT1X[alt][1];
			
		case Paracaidas.TPMPLUS:
			return TPMPLUS[alt][1];
			
		case Paracaidas.G9:
			return G9[alt][1];
			
		default:
			return -1;
		}
		
	}
	
	public static double K (int paracaidas, int altura){
		int alt = 0;
		if (0 < altura && altura < 5000) alt = 0;
		else if (5000 < altura && altura < 10000) alt = 1;
		else if (10000 < altura && altura < 15000) alt = 2;
		else if ( 15000 < altura && altura < 20000) alt = 3;
		else if (20000 < altura && altura < 25000) alt = 4;
				
		switch (paracaidas){
		case Paracaidas.MT1X:
			return MT1X[alt][0];
			
		case Paracaidas.TPMPLUS:
			return TPMPLUS[alt][0];
			
		case Paracaidas.G9:
			return G9[alt][0];
			
		default:
			return -1;
		}
	}
}
