package com.egecius.demo_google_analytics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.analytics.GoogleAnalytics;

import butterknife.OnClick;
import shared.Analytics;
import shared.Screen;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		trackScreen();
	}

	private void trackScreen() {
		new Analytics(getApplicationContext()).trackScreen(Screen.MAIN);
	}

	@OnClick (R.id.detail)
	void goToDetailActivity() {
		startActivity(new Intent(this, DetailActivity.class));
	}

	@OnClick (R.id.settings)
	void goToSettingsActivity() {
		startActivity(new Intent(this, SettingsActivity.class));
	}
}
