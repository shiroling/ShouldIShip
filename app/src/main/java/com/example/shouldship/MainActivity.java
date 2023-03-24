package com.example.shouldship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonEstimation = findViewById(R.id.BtnNouvelleEstimation);
        boutonEstimation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToEstimation();
            }
        });

        Button boutonComparer = findViewById(R.id.BtnComparer);
        boutonComparer.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        goToComparer();
                    }
                }
        );
        Button boutonHistorique = findViewById(R.id.BtnHistorique);
        boutonHistorique.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        goToHistorique();
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()) {
            case R.id.menu_quitter:
                System.exit(0);
                break;
            case R.id.menu_estimation:
                goToEstimation();
                break;
            case R.id.menu_comparer:
                goToComparer();
                break;
            case R.id.menu_historique:
                goToHistorique();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToEstimation(){
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
    }

    public void goToComparer(){ 
        Intent intent = new Intent(MainActivity.this, CompareActivity.class);
        startActivity(intent);
    }

    public void goToHistorique(){
        Intent intent = new Intent(MainActivity.this, HistoricActivity.class);
        startActivity(intent);
    }

}