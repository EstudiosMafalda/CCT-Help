package es.ea.mde.ablamed.ccthelp;

import es.ea.mde.ablamed.ccthelp.sondeo.automatico.CalculosAutomatico;
import es.ea.mde.ablamed.ccthelp.sondeo.manual.haho.CalculosManualHaho;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SubmenuCalculosSondeo extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.submenu_calculos_sondeo);
	}

	public void onClick(View v) {

		Intent i;
		
		switch (v.getId()) {
		
		case R.id.btnsbmsondeo1:
			i = new Intent (this, CalculosAutomatico.class);
			startActivity(i);
			break;
			
		case R.id.btnsbmsondeo2:
			i = new Intent (this, CalculosManualHaho.class);
			startActivity(i);
			break;
			
		case R.id.btnsbmsondeo3:
			break;
			
		default:
			break;
		}
		
	}

}
