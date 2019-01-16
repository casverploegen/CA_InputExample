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

        // Invoke the method that initializes all onclick listeners
        initOnClickListeners();
    }

    void initOnClickListeners() {
        // Initialize print-button onclick listener
        final Button buttonPrint = findViewById(R.id.buttonPrint);
        buttonPrint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Get the input (EditView) and output (TextView) elements
                EditText input = findViewById(R.id.editViewInput);
                TextView output = findViewById(R.id.textViewOutput);

                // Get text from input, paste text into output
                String result = input.getText().toString();
                output.setText(result);
            }
        });

        // Initialize print Hello-button onclick listener
        final Button buttonPrintHello = findViewById(R.id.buttonPrintHello);
        buttonPrintHello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create TextView output object programmatically
                // Find main layout object, to add the new TextView to
                ConstraintLayout layout = findViewById(R.id.ConstraintLayout);

                // Create the new TextView and set its properties
                TextView outputHello = new TextView(getApplicationContext());
                outputHello.setId(R.id.textViewOutputHello);
                outputHello.setText("Hello!");
                outputHello.setTextSize(24);

                // Set the layout parameters of the TextView to wrap the content
                ConstraintLayout.LayoutParams clpOutput = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                outputHello.setLayoutParams(clpOutput);

                // Add the newly created TextView to the main layout
                layout.addView(outputHello);

                // Position the TextView in the main layout with help of a ConstraintSet. (N.B. this
                // must be done after the TextView is added to the main layout)
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(layout);
                // Position vertically relative to the print Hello-button
                constraintSet.connect(outputHello.getId(), ConstraintSet.TOP, R.id.buttonPrintHello, ConstraintSet.TOP, 250);
                // Center the element horizontally
                constraintSet.connect(outputHello.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT, 0);
                constraintSet.connect(outputHello.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT, 0);
                // Apply the new constraints to the layout
                constraintSet.applyTo(layout);
            }
        });
    }

}
