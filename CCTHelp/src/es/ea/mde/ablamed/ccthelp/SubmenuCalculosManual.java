package es.ea.mde.ablamed.ccthelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SubmenuCalculosManual extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.submenu_calculos_manual);
		
	}

	public void onClick(View v) {

		Intent i;
		
		switch (v.getId()) {
		
		case R.id.btnsbmcalcman1:
			//i = new Intent (this, CalculosAutomatico.class);
			//startActivity(i);
			break;
			
		case R.id.btnsbmcalcman2:
			break;
			
		case R.id.btnsbmcalcman3:
			break;
			
		default:
			break;
		}
	}

}
