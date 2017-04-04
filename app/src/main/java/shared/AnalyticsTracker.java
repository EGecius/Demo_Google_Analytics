package shared;

import android.content.Context;
import android.util.Log;

import com.egecius.demo_google_analytics.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AnalyticsTracker {

	private final Tracker tracker;
	private static AnalyticsTracker analyticsTracker;

	 public static synchronized AnalyticsTracker getInstance(final Context context) {
		if (analyticsTracker == null) {
			analyticsTracker = new AnalyticsTracker(context);
		}
		return analyticsTracker;
	}

	private AnalyticsTracker(Context context) {
		tracker = GoogleAnalytics.getInstance(context).newTracker(R.xml.ga_tacker);
	}

	public void trackScreen(Screen screen) {
		Log.i("Eg:AnalyticsTracker:27", "trackScreen screen " + screen);
		tracker.setScreenName(screen.name());
		tracker.send(new HitBuilders.ScreenViewBuilder().build());
	}

	public void trackEvent(AnalyticsEvent event) {
		Log.d("Eg:AnalyticsTracker:34", "trackEvent event " + event);
		tracker.send(new HitBuilders.EventBuilder()
				.setCategory("Action")
				.setAction(event.name())
				.build());
	}

}
