package com.egecius.demo_google_analytics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shared.Analytics;
import shared.Screen;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setListeners();
		trackScreen();
	}

	private void setListeners() {
		findViewById(R.id.detail_btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				startActivity(DetailActivity.class);
			}
		});
		findViewById(R.id.settings_btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				startActivity(SettingsActivity.class);
			}
		});
	}

	private <T> void startActivity(final Class<T> aClass) {
		startActivity(new Intent(this, aClass));
	}

	private void trackScreen() {
		Analytics.getInstance(getApplicationContext()).trackScreen(Screen.MAIN);
	}

}
