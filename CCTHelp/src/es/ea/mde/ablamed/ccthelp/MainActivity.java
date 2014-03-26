package es.ea.mde.ablamed.ccthelp;

import es.ea.mde.ablamed.ccthelp.preferencias.PreferenceMain;
import es.ea.mde.ablamed.ccthelp.sondeo.manual.haho.CalculosManualHaho;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void onClick(View v) {
		
		Intent i;
		
		switch (v.getId()) {
		
		case R.id.btnmainmenu1:
			i= new Intent (this, SubmenuCalculosSondeo.class);
			startActivity(i);
			break;
			
		case R.id.btnmainmenu2:
			i= new Intent (this, CalculosManualHaho.class);
			startActivity(i);
			break;

		case R.id.btnmainmenu3:
			//i= new Intent (this, CalculosManualHaho.class);
			//startActivity(i);
			break;
			
		case R.id.btnmainmenu4:
			//i= new Intent (this, CalculosManualHaho.class);
			//startActivity(i);
			break;
			
		case R.id.btnmainmenu5:
			//i= new Intent (this, CalculosManualHaho.class);
			//startActivity(i);
			break;
			
		case R.id.btnmainmenu6:
			//i= new Intent (this, CalculosManualHaho.class);
			//startActivity(i);
			break;
		default:
			break;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent i = new Intent(this, PreferenceMain.class);
			startActivity(i);
			break;

		default:
			break;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}


}
