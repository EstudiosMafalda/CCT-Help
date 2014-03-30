/* <summary>
   Clase diseñada para trabajar como un vector espacial, contando con una serie de funciones
   para realizar operaciones entre ellos.
   </summary> */

package es.estudiosmafalda.CCTUtils;

public class Vector {

	double x;					//Valor del vector en el eje X.
	double y;					//valor del vector en el eje Y.
	
	private static final double rad= Math.PI/180;	//Los radianes que corresponden a un grado.
	
	
	// <summary>
	// Constructor de la clase Vector que se define mediante un modulo y un ángulo.
	// </summary>
	// <param name="modulo">Valor del modulo del vector</param>
	// <param name="angulo">Valor del ángulo del vector en grados</param>
	
	public Vector(double modulo, int angulo)
	{
	    x = modulo * Math.sin(angulo * rad);
	    y = modulo * Math.cos(angulo * rad);
	    
	}
	
	
	// <summary>
	// Constructor de la clase Vector que se define mediante dos coordenadas.
	// </summary>
	// <param name="x">Valor de la coordenada x del vector</param>
	// <param name="y">Valor de la coordenada y del vector</param>
	
	public Vector (int x, int y)
	{
		this.x=x;
		this.y=y;		
	}

	
	/// <summary>
	/// Cálculo del modulo del vector resta de p1 y p2
	/// </summary>
	/// <param name="p1">Vector 1</param>
	/// <param name="p2">Vector 2</param>
	/// <returns>Módulo del vector resta P2-P1</returns>
	public static double ModuloResta(Vector p1, Vector p2)
	{
	    double x=p2.x-p1.x;
	    double y=p2.y-p1.y;
	    return (Math.sqrt((x*x)+(y*y)));
	}

	
	/// <summary>
	/// Calculo del ángulo del vector resta de p1 y p2
	/// </summary>
	/// <param name="p1">Vector 1</param>
	/// <param name="p2">Vector 2</param>
	/// <returns>Ángulo del vector resta P2-P1</returns>
	
	public static int AnguloResta(Vector p1, Vector p2)
	{

	    double res=0;

	    double x=p2.x-p1.x;
	    double y=p2.y-p1.y;

	    if (y<0)
	        res = 180 + Math.atan (x / y) / rad;

        else if ((y>0) && (x<0))
	        res=360 + Math.atan (x / y) / rad;

        else if ((y>0) && (x>0))
            res = Math.atan (x / y) / rad;

	    return (int) res;
	}

	
	/// <summary>
	/// Cálculo del modulo del vector suma de p1 y p2
	/// </summary>
	/// <param name="p1">Vector 1</param>
	/// <param name="p2">Vector 2</param>
	/// <returns></returns>
	
	public static double ModuloSuma(Vector p1, Vector p2)
	{

	    double x=p2.x+p1.x;
	    double y=p2.y+p1.y;
	    return (Math.sqrt((x*x)+(y*y)));
	}
	
	/// <summary>
	/// Calculo del ángulo del vector suma de p1 y p2
	/// </summary>
	/// <param name="p1">Vector 1</param>
	/// <param name="p2">Vector 2</param>
	/// <returns></returns>
	
	public static int AnguloSuma(Vector p1, Vector p2)
	{

	    double res=0;

	    double x=p2.x+p1.x;
	    double y=p2.y+p1.y;

	    if (y<0)
	        res = 180 + Math.atan (x / y) / rad;

        else if ((y>0) && (x<0))
	        res=360 + Math.atan (x / y) / rad;

        else if ((y>0) && (x>0))
            res = Math.atan (x / y) / rad;

	    return (int) res;
	}
}





