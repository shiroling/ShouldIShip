package com.example.shouldship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EstimationActivity extends AppCompatActivity {
    private TextView destinationTextView;
    private TextView weightTextView;
    private TextView shippingDateTextView;
    private TextView estimatedDateTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimation);

        destinationTextView = findViewById(R.id.destinationTextView);
        weightTextView = findViewById(R.id.weightTextView);
        shippingDateTextView = findViewById(R.id.shippingDateTextView);
        estimatedDateTextView = findViewById(R.id.estimatedDateTextView);
        priceTextView = findViewById(R.id.priceTextView);

        Intent intent = getIntent();
        long estimationId = intent.getLongExtra("estimationId", -1);
        if (estimationId == -1) {
            Toast.makeText(this, "Error: estimation id not found", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            EstimationDetails estimation = getEstimationById(estimationId);
            if (estimation == null) {
                Toast.makeText(this, "Error: estimation not found", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                destinationTextView.setText(estimation.getDestination());
                weightTextView.setText(String.format(Locale.getDefault(), "%.2f kg", estimation.getWeight()));
                shippingDateTextView.setText(estimation.getShippingDate().toString());
                estimatedDateTextView.setText(estimation.getEstimationDate().toString());
                priceTextView.setText(String.format(Locale.getDefault(), "%.2f €", estimation.getPrice()));
            }
        }
    }

    private EstimationDetails getEstimationById(long estimationId) {
        // TODO: implémenter la méthode pour récupérer l'estimation correspondant à l'id donné
    }
}
