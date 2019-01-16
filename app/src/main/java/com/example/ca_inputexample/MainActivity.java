package com.example.ca_inputexample;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initOnClickListeners();
    }

    void initOnClickListeners() {
        final Button buttonPrint = findViewById(R.id.buttonPrint);
        buttonPrint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText input = findViewById(R.id.editViewInput);
                TextView output = findViewById(R.id.textViewOutput);

                String result = input.getText().toString();
                output.setText(result);
            }
        });

        final Button buttonPrintHello = findViewById(R.id.buttonPrintHello);
        buttonPrintHello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create TextView object programmatically
                ConstraintLayout layout = findViewById(R.id.ConstraintLayout);

                TextView outputHello = new TextView(getApplicationContext());
                outputHello.setId(R.id.textViewOutputHello);
                outputHello.setText("Hello!");
                outputHello.setTextSize(24);

                ConstraintLayout.LayoutParams clpOutput = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                outputHello.setLayoutParams(clpOutput);

                layout.addView(outputHello);

                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(layout);
                constraintSet.connect(outputHello.getId(), ConstraintSet.TOP, R.id.buttonPrintHello, ConstraintSet.TOP, 250);
                constraintSet.connect(outputHello.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT, 0);
                constraintSet.connect(outputHello.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT, 0);
                constraintSet.applyTo(layout);
            }
        });
    }

}
