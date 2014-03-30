/********************************************************************************
 * 
 * Clase para el cálculo del viento medio para globo de 30 gramos, en lanzamientos
 * de apertura automatica, con rangos de altura entre 500 y 4500 pies, y rangos
 * de elevación del globo entre 13 y 80 grados.
 * 
 ********************************************************************************/

package es.estudiosmafalda.CCTUtils;

public class VientoMedio{

	public int [][] VientoMedio;
	private int [] AngulosElevacion;
	private int [] AlturasMuestreo;
	
	public static final int VEL_ASC_GLOBO_200 = 200;
	public static final int VEL_ASC_GLOBO_100 = 100;
	private final double MTS_TO_KTS = 1.94384449;
	
	public VientoMedio(){
		VientoMedio = new int [22][];
		VientoMedio[0] = new int [] {31,30,30,30,30,29,29,29,28,28,28,27};
		VientoMedio[1] = new int [] {29,29,28,27,27,27,27,27,26,26,26,26};
		VientoMedio[2] = new int [] {27,27,26,26,25,25,25,25,24,24,24,24};
		VientoMedio[3] = new int [] {25,25,24,24,24,24,23,23,23,23,22,22};
		VientoMedio[4] = new int [] {23,23,23,22,22,22,22,22,21,21,21,21};
		VientoMedio[5] = new int [] {22,22,21,21,21,21,20,20,20,20,20,20};
		VientoMedio[6] = new int [] {21,20,20,20,20,20,19,19,19,19,19,18};
		VientoMedio[7] = new int [] {20,20,19,19,19,18,18,18,18,18,18,18};
		VientoMedio[8] = new int [] {19,19,18,18,18,17,17,17,17,17,17,17};
		VientoMedio[9] = new int [] {18,18,17,17,17,17,17,16,16,16,16,16};
		VientoMedio[10] = new int [] {17,17,16,16,16,15,15,15,15,15,15,15};
		VientoMedio[11] = new int [] {16,16,15,15,15,15,15,15,15,15,15,15};
		VientoMedio[12] = new int [] {15,15,15,15,15,15,14,14,14,14,14,14};
		VientoMedio[13] = new int [] {12,12,12,12,12,12,12,12,11,11,11,11};
		VientoMedio[14] = new int [] {10,10,10,10,10,10,9,9,9,9,9,9};
		VientoMedio[15] = new int [] {9,8,8,8,8,8,8,8,8,8,8,8};
		VientoMedio[16] = new int [] {7,7,7,7,7,7,7,7,7,6,6,6};
		VientoMedio[17] = new int [] {6,6,6,6,6,6,6,6,5,5,5,5};
		VientoMedio[18] = new int [] {5,5,5,5,5,5,5,5,5,5,4,4};
		VientoMedio[19] = new int [] {4,4,4,4,4,4,4,4,4,4,4,4};
		VientoMedio[20] = new int [] {3,3,3,2,2,2,2,2,2,2,2,2};
		VientoMedio[21] = new int [] {1,1,1,1,1,1,1,1,1,1,1,1};
		
		AngulosElevacion = new int [] {13,14,15,16,17,18,19,20,21,22,23,24,25,30,35,40,45,50,55,60,70,80};
		
		AlturasMuestreo = new int [] {500,750,1000,1250,1500,1750,2000,2500,3000,3500,4000,4500};
	}
	
	public int Automatico (int altura, int elevacion){
		// TODO: Implementar control de errores en caso de altura > 4500 ft y angulo >80.
		
		if (500 > altura || altura > 4500) return -1;
		if (13 > elevacion || elevacion > 80) return -2;
		
		int alt = 0;
		int elv = 0;
		
		for (int i = 0; i < AngulosElevacion.length; i++){
			if (AngulosElevacion[i] >= elevacion){
				double dif = AngulosElevacion[i] - elevacion;
				double diff = (i>0) ? AngulosElevacion[i] - AngulosElevacion[i-1]: 1;
				//System.out.println ("valor de dif= " + dif + " Valor de diff= " + diff);
				if (dif == 1) elv = i-1;
				else if ((diff / 2) > dif) elv = i;
				else elv = i-1;
				//System.out.println ("valor de i= " + i + " Valor de elv= " + elv);
				break;
			}
		}
		
		for (int j = 0; j < AlturasMuestreo.length; j++){
			if (AlturasMuestreo[j] >= altura){
				double dif = AlturasMuestreo[j] - altura;
				double diff = (j>0) ? (AlturasMuestreo[j] - AlturasMuestreo[j-1]) : 250;
				//System.out.println ("valor de dif= " + dif + " Valor de diff= " + diff);
				if (dif == 250) alt = j-1;
				else if ((diff / 2) > dif) alt = j;
				else alt = j-1;
				//System.out.println ("valor de i= " + j + " Valor de alt= " + alt);
				break;
			}
		}
		System.out.println("Viento medio: " + VientoMedio[elv][alt]);
		return VientoMedio[elv][alt];
	}
	
	public double Manual (int elevacion, int vel_asc){
		double v = ((vel_asc)==VEL_ASC_GLOBO_200?VEL_ASC_GLOBO_200:VEL_ASC_GLOBO_100) / Math.tan(Math.toRadians(elevacion));
		return  v * MTS_TO_KTS / 60;
	}
}
