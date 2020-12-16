package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.tsr.tsrproblemreport_tossticket_checker.R;

import java.util.ArrayList;

public class DemoActivity extends AppCompatActivity {


	private AHBottomNavigationAdapter navigationAdapter;
	private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
	private boolean useMenuResource = true;
	private int[] tabColors;
	private Handler handler = new Handler();

	// UI
	private AHBottomNavigationViewPager viewPager;
	private AHBottomNavigation bottomNavigation;
	private FloatingActionButton floatingActionButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		boolean enabledTranslucentNavigation = getSharedPreferences("shared", Context.MODE_PRIVATE)
				.getBoolean("translucentNavigation", false);
		setTheme(enabledTranslucentNavigation ? R.style.AppTheme_TranslucentNavigation : R.style.AppTheme);
		setContentView(R.layout.check_customer_new2);
		initUI();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);
	}
	
	/**
	 * Init UI
	 */
	private void initUI() {
		
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
		}
		
		bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
		//viewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);
	//	floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);

		if (useMenuResource) {
			tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
			navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
			navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
		} else {




		}


		bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);
		bottomNavigation.setTranslucentNavigationEnabled(true);

		bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
			@Override
			public boolean onTabSelected(int position, boolean wasSelected) {



				if (position == 0) {
					Log.e("1111","1111");


				}
				else if (position == 1) {
					Log.e("2222", "2222");
				}

				else {

					Log.e("3333","3333");






				}

				return true;
			}
		});
		


		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				// Setting custom colors for notification
				AHNotification notification = new AHNotification.Builder()
						.setText("100")
						.setBackgroundColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_back))
						.setTextColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_text))
						.build();
				bottomNavigation.setNotification(notification, 1);
				//Snackbar.make(bottomNavigation, "Snackbar with bottom navigation",
					//	Snackbar.LENGTH_SHORT).show();

			}
		}, 3000);
		
		//bottomNavigation.setDefaultBackgroundResource(R.drawable.bottom_navigation_background);
	}

}
