package com.example.spenner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author        benjamin rogachevsky
 * @version       1.0
 * @since         2/5/26
 * This activity displays the credits for the application.
 */
public class MyActivityName extends AppCompatActivity {

    /**
     * Called when the activity is first created. This is where you should do all of your normal static set up.
     * <p>
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_name);


    }


    /**
     * Initialize the contents of the Activity's standard options menu.
     * <p>
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.name_menu, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * <p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("back")) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
