package es.ea.mde.ablamed.ccthelp.sondeo.automatico;

import es.estudiosmafalda.CCTUtils.Sondeo;
import es.ea.mde.ablamed.ccthelp.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculosAutomatico extends Activity {

	private Sondeo sondeo;
	private int distancia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.copy_calculos_automatico);
		
		Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
		btnCalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				EditText etAltura = (EditText)findViewById(R.id.etaltura);
				EditText etElevacion = (EditText)findViewById(R.id.etelevacion);
				
				sondeo = new Sondeo();
				
				distancia = sondeo.SondeoAutomatico(Integer.valueOf(etAltura.getText().toString()),
						Integer.valueOf(etElevacion.getText().toString()), 30.0);
				
				LinearLayout lt = (LinearLayout)findViewById(R.id.linear2);
				TextView dist = (TextView)findViewById(R.id.tvDistancia);
				TextView rumbo = (TextView)findViewById(R.id.tvRumbo);
				EditText etAzimut = (EditText)findViewById(R.id.etazimut);
				
				dist.setText(Double.toString(distancia) + " metros");
				rumbo.setText(etAzimut.getText().toString() + "º");
				
				lt.setVisibility(View.VISIBLE);
				
			}
		});
		
		Spinner spDZ = (Spinner)findViewById(R.id.spzonalanzamiento);
		spDZ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (arg2>0) findViewById(R.id.griddz).setVisibility(View.VISIBLE);
				else findViewById(R.id.griddz).setVisibility(View.GONE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}

}
