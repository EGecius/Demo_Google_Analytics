package com.egecius.demo_google_analytics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import shared.Analytics;
import shared.Screen;

public class SettingsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_activity);
		trackScreen();
	}

	private void trackScreen() {
		Analytics.getInstance(getApplicationContext()).trackScreen(Screen.SETTINGS);
	}

}
