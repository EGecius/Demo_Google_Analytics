package shared;

import android.content.Context;
import android.util.Log;

import com.egecius.demo_google_analytics.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class Analytics {

	private final Tracker tracker;
	private static Analytics analytics;

	 public static synchronized Analytics getInstance(final Context context) {
		if (analytics == null) {
			analytics = new Analytics(context);
		}
		return analytics;
	}

	private Analytics(Context context) {
		tracker = GoogleAnalytics.getInstance(context).newTracker(R.xml.ga_tacker);
	}

	public void trackScreen(Screen screen) {
		Log.i("Eg:Analytics:27", "trackScreen screen " + screen);
		tracker.setScreenName(screen.name());
		tracker.send(new HitBuilders.ScreenViewBuilder().build());
	}

	public void trackEvent(AnalyticsEvent event) {
		Log.d("Eg:Analytics:34", "trackEvent event " + event);
		tracker.send(new HitBuilders.EventBuilder()
				.setCategory("Action")
				.setAction(event.name())
				.build());
	}

}
