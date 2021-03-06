package com.reeuse.component.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.reeuse.component.R;
import com.reeuse.component.activity.fragment.ContactUsFragment;
import com.reeuse.component.activity.fragment.HomeFragment;
import com.reeuse.component.activity.fragment.OnFragmentInteractionListener;


public class FragmentDemoActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private static final int HOME_FRAGMENT = 0;
    private static final int CONTACT_US_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("Activity:: onCreate()");
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("Activity:: onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("Activity:: onStart()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        showToast("Activity:: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("Activity:: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("Activity:: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("Activity:: onRestart()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        showToast("Activity:: onCreateOptionsMenu(Menu menu)");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        showToast("Activity:: onOptionsItemSelected(MenuItem item)");
        if (id == R.id.action_home) {
            displayView(HOME_FRAGMENT);
            return true;
        } else if (id == R.id.action_contact_us) {
            displayView(CONTACT_US_FRAGMENT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String fragmentName) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(fragmentName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    /**
     * Displaying fragment view for selected navigation drawer list item
     */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        String fragmentName = null;
        switch (position) {
            case HOME_FRAGMENT:
                fragment = new HomeFragment();
                fragmentName = HomeFragment.class.getSimpleName();
                break;
            case CONTACT_US_FRAGMENT:
                fragment = new ContactUsFragment();
                break;
            default:
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.addToBackStack(fragmentName);
            fragmentTransaction.commit();
        }
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
        showToast("Activity:: onBackPressed()");
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}
