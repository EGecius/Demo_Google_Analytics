package com.egecius.demo_google_analytics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shared.AnalyticsTracker;
import shared.Screen;

import static shared.AnalyticsEvent.SUBMIT_BUTTON_CLICK;

public class DetailActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		trackScreen();
		setListeners();
	}

	private void setListeners() {
		findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				AnalyticsTracker.getInstance(getApplicationContext()).trackEvent(SUBMIT_BUTTON_CLICK);
			}
		});
	}

	private void trackScreen() {
		AnalyticsTracker.getInstance(getApplicationContext()).trackScreen(Screen.DETAIL);
	}

}
