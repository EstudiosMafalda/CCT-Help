package es.ea.mde.ablamed.ccthelp.sondeo.manual.haho;

import es.estudiosmafalda.CCTUtils.ConstantesParacaidas;
import es.estudiosmafalda.CCTUtils.ConstantesParacaidas.Paracaidas;
import es.estudiosmafalda.CCTUtils.Sondeo;
import es.ea.mde.ablamed.ccthelp.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculosManualHaho extends Activity{
	
	private Sondeo sondeo;
	private double distancia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.copy_calculos_manual_haho);
		
		Spinner spParacaidas = (Spinner)findViewById(R.id.spparacaidas);
		spParacaidas.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				/*LinearLayout lyCK = (LinearLayout)findViewById(R.id.ConstantesCyK);
				if (arg2==4) lyCK.setVisibility(View.VISIBLE);
				else if (arg2!=4) lyCK.setVisibility(View.INVISIBLE);*/
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Spinner spConsideraciones = (Spinner)findViewById(R.id.spconsideraciones);
		spConsideraciones.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				LinearLayout lyEjeDet = (LinearLayout)findViewById(R.id.layoutEjeDeterminado);
				RelativeLayout lyRuta = (RelativeLayout)findViewById(R.id.layoutRuta);
				
				switch (arg2) {
				case 0:
					lyEjeDet.setVisibility(View.GONE);
					lyRuta.setVisibility(View.GONE);
					break;
					
				case 1:
					lyEjeDet.setVisibility(View.VISIBLE);
					lyRuta.setVisibility(View.GONE);
					break;
					
				case 2:
					lyEjeDet.setVisibility(View.GONE);
					lyRuta.setVisibility(View.VISIBLE);
					break;

				default:
					break;
				}				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
		btnCalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				
					
				EditText etAltura = (EditText)findViewById(R.id.etaltura);
				EditText etElevacion = (EditText)findViewById(R.id.etelevacion);
				Spinner spParacaidas = (Spinner)findViewById(R.id.spparacaidas);
				
				EditText etC = (EditText)findViewById(R.id.etC);
				EditText etK = (EditText)findViewById(R.id.etK);
				
				
				sondeo = new Sondeo();
				
				int paraca = (int)spParacaidas.getSelectedItemPosition();
				int altura = Integer.parseInt(etAltura.getText().toString());
				double C = 0.0;
				double K = 0.0;
				
				switch (paraca){
				case Paracaidas.MT1X:
				case Paracaidas.TPMPLUS:
				case Paracaidas.JANUS:
				case Paracaidas.G9:
					C = ConstantesParacaidas.C(paraca, altura);
					K = ConstantesParacaidas.K(paraca, altura);
					break;
				case Paracaidas.NONE:
					//System.out.println("Hemos llegado al punto de NONE");
					C = Double.parseDouble(etC.getText().toString());
					K = Double.parseDouble(etK.getText().toString());
				}
				
				distancia = sondeo.SondeoManual(Integer.valueOf(etAltura.getText().toString()),
						Integer.valueOf(etElevacion.getText().toString()), C, K);
				
				LinearLayout lt = (LinearLayout)findViewById(R.id.linear2);
				TextView dist = (TextView)findViewById(R.id.tvDistancia);
				TextView rumbo = (TextView)findViewById(R.id.tvRumbo);
				EditText etAzimut = (EditText)findViewById(R.id.etazimut);
				
				String d = String.format(Double.toString(distancia), "%d.dd");
					System.out.println ("distancia: " + d);
					
				dist.setText(d + " NM");
				rumbo.setText(etAzimut.getText().toString() + "º");
				
				lt.setVisibility(View.VISIBLE);
			}
		});
	}
}
