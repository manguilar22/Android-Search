package edu.utep.cs4330.androidsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String SEARCH = "edu.utep.cs4330.androidsearch.SEARCH";

    private EditText textView;
    private Button button1;
    private Button button2;
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get views
        textView = findViewById(R.id.inputText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button1.setEnabled(true);
        button2.setEnabled(false);
        button3.setEnabled(false);

        button1.setOnClickListener(this::onClick);
    }

        protected void openSearchActivity() {
            Intent intent = new Intent(this,SearchActivity.class);

            String save = textView.getText().toString();
            intent.putExtra(MainActivity.SEARCH,save);
            startActivity(intent);
        }




    private void onClick(View view) {
        String name = textView.getText().toString();
        debug(name);

        openSearchActivity();
    }

    private void debug(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}