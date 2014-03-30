package es.ea.mde.ablamed.ccthelp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SondeoReal extends Activity {

	ViewGroup tableLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sound_data_table);
		tableLayout = (ViewGroup) findViewById(R.id.tablelayout);
		AddFirstRow();
	}

	private void AddFirstRow() {
		ViewGroup row = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.sound_data_row, tableLayout, false);
		EditText et = (EditText) row.findViewById(R.id.etazimut);
		et.setText("3600");
		tableLayout.addView(row);
	}

	public void AddRowClick(View view){
		ViewGroup row = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.sound_data_row, tableLayout, false);
		EditText et = (EditText) row.findViewById(R.id.etazimut);
		et.setText("3600");
		tableLayout.addView(row);
		
		view.setBackgroundResource(android.R.drawable.ic_notification_clear_all);
			
	}
	
	public void CalculaDatos(View view){
		
		int contador = 0;
		for (int i=0; i<tableLayout.getChildCount();i++){
			EditText et = (EditText)tableLayout.getChildAt(i).findViewById(R.id.etaltura);
			contador = contador + Integer.parseInt(et.getText().toString());
		}
		
		((Button)view).setText(String.valueOf(contador));
	}

}
