package es.ea.mde.ablamed.ccthelp.preferencias;

import es.ea.mde.ablamed.ccthelp.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenceMain extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.preferencelayout);
	}

	

}
