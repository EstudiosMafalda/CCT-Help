package es.ea.mde.ablamed.ccthelp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;


public class SplashScreen extends Activity {

	public static int SPLASH_TIME_OUT = 3000;
	public static String SPLASH_TIME_PREFERENCE = "splash_time_preference";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_screen);
		
		PreferenceManager.setDefaultValues(this, R.xml.preferencelayout, false);
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		//SharedPreferences sp = getSharedPreferences("GeneralPreferences", MODE_PRIVATE);
		
		//if (!sp.getBoolean("are_preferences_created", false)) initPreferences();
		
		/*if (!sp.getBoolean("splash_activation", true)){
			mainActivityRun();
			finish();
		}*/
		
		
		if (sp.getBoolean("splash_activation", false)){
		
		
		SPLASH_TIME_OUT = getSplashTimeOut();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Log.v("SPLASHSCREEN", "Pasando por run");
				mainActivityRun();				
				finish();
			}
		}, SPLASH_TIME_OUT);
		}
		
		else if (!sp.getBoolean("splash_activation", false)){
		mainActivityRun();
		}
	}

	private int getSplashTimeOut() {
		SharedPreferences sp = getSharedPreferences("GeneralPreferences", MODE_PRIVATE);
		return sp.getInt(SPLASH_TIME_PREFERENCE, 3000);
	}
	
	private void mainActivityRun(){
		Intent i = new Intent (SplashScreen.this, MainActivity.class);
		startActivity(i);
	}
	
	private void initPreferences() {
		SharedPreferences sp = getSharedPreferences("GeneralPreferences", MODE_PRIVATE);
		SharedPreferences.Editor sp_editor = sp.edit();
		sp_editor.putBoolean("are_preferences_created", true);
		sp_editor.putInt(SPLASH_TIME_PREFERENCE, 3000);
		sp_editor.putBoolean("splash_activation", true);
		sp_editor.putInt("default_free_fall_canopy", 2);
		sp_editor.putInt("default_static_line_canopy", 1);
		sp_editor.commit();
		
	}

}
