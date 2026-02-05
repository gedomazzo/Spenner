package com.example.spenner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class progression extends AppCompatActivity {

    Integer[] list = new Integer[20];
    Spinner prog;

    TextView an;
    TextView nan;
    TextView sum;


    int a1;
    int q;
    boolean type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progression);

        an = findViewById(R.id.an);
        nan = findViewById(R.id.nan);
        sum = findViewById(R.id.sum);

        prog = findViewById(R.id.prog);



        Intent intent = getIntent();
        a1 = intent.getIntExtra("a1", 1);
        q = intent.getIntExtra("q", 2);
        type = intent.getBooleanExtra("type", true);

        // Populate the list based on the progression type
        if (type) { // Geometric
            for (int n = 0; n < 20; n++) {
                list[n] = (int) (a1 * Math.pow(q, n));
            }
        } else { // Arithmetic
            for (int n = 0; n < 20; n++) {
                list[n] = a1 + n * q;
            }
        }


    }
}