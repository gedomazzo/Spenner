package com.example.spenner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author        benjamin rogachevsky
 * @version       1.0
 * @since         1/7/26
 * This activity displays a numerical progression and calculates the sum of its terms.
 */
public class progression extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Double[] list = new Double[20];
    Spinner prog;

    TextView an;
    TextView nan;
    TextView sum;

    double a1;
    double q;
    boolean type;

    /**
     * Called when the activity is first created. Initializes the UI, retrieves progression data from the Intent, and populates the spinner.
     * <p>
     *
     * @param savedInstanceState If the activity is being re-initialized, this Bundle contains the most recent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progression);

        an = findViewById(R.id.an);
        nan = findViewById(R.id.nan);
        sum = findViewById(R.id.sum);

        prog = findViewById(R.id.prog);
        prog.setOnItemSelectedListener(this);

        ArrayAdapter<Double> adp = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);

        prog.setAdapter(adp);

        Intent intent = getIntent();
        a1 = intent.getDoubleExtra("a1", 1);
        q = intent.getDoubleExtra("q", 2);
        type = intent.getBooleanExtra("type", true);

        // Populate the list based on the progression type
        if (type) { // Geometric
            for (int n = 0; n < 20; n++) {
                list[n] = a1 * Math.pow(q, n);
            }
        } else { // Arithmetic
            for (int n = 0; n < 20; n++) {
                list[n] = a1 + n * q;
            }
        }
        adp.notifyDataSetChanged();
    }

    /**
     * Callback method to be invoked when an item in this view has been selected.
     * It calculates and displays the selected term, its position, and the sum of the series up to that term.
     * <p>
     *
     * @param parent The AdapterView where the selection happened.
     * @param view The view within the AdapterView that was clicked.
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that is selected.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        an.setText(String.valueOf(position + 1));
        nan.setText(String.valueOf(list[position]));
        double x;
        int n = position + 1;
        if (type) { // Geometric series
            if (q == 1) {
                x = n * a1;
            } else {
                x = a1 * (1 - Math.pow(q, n)) / (1 - q);
            }
        } else { // Arithmetic series
            x = (n / 2.0) * (2 * a1 + (n - 1) * q);
        }
        sum.setText(String.valueOf(x));
    }

    /**
     * Callback method to be invoked when the selection disappears from this view.
     * It resets the text views to "0".
     * <p>
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        sum.setText("0");
        an.setText("0");
        nan.setText("0");
    }
}
