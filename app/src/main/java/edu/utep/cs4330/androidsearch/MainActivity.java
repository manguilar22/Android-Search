package edu.utep.cs4330.androidsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.utep.cs4330.androidsearch.data.model.SearchCode;

public class MainActivity extends AppCompatActivity {
    private final static String SEARCH_TERM = "edu.utep.cs4330.androidsearch.SEARCH";
    private final static String SEARCH_TYPE_CODE = "edu.utep.cs4330.androidsearch.SEARCH_TYPE";

    private EditText textView;
    private Button imageButton;
    private Button videoButton;
    private Button newsButton;
    private Button bookButton;
    private Button allButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get views
        textView = findViewById(R.id.inputText);
        imageButton = findViewById(R.id.button1);
        videoButton = findViewById(R.id.button2);
        newsButton = findViewById(R.id.button3);
        bookButton = findViewById(R.id.button4);
        allButton = findViewById(R.id.button5);


        imageButton.setEnabled(true);
        videoButton.setEnabled(true);
        newsButton.setEnabled(true);
        bookButton.setEnabled(true);
        allButton.setEnabled(true);

        imageButton.setOnClickListener(this::onClickImageSearch);
        videoButton.setOnClickListener(this::onClickVideoSearch);
        newsButton.setOnClickListener(this::onClickNewsSearch);
        bookButton.setOnClickListener(this::onClickBooksSearch);
        allButton.setOnClickListener(this::onClickAllSearch);
    }



        protected void openSearchActivity() {
            Intent intent = new Intent(this,SearchActivity.class);


            String save = textView.getText().toString();

            intent.putExtra(SEARCH_TERM,save);
            startActivity(intent);
        }



    private void onClickAllSearch(View view) {

        Intent intent = new Intent(this,SearchActivity.class);

        String saveSearchTerm = textView.getText().toString();
        String savedSearchTermCode = SearchCode.ALL.tbm;

        intent.putExtra(SEARCH_TERM,saveSearchTerm);
        intent.putExtra(SEARCH_TYPE_CODE,savedSearchTermCode);

        startActivity(intent);
    }
    private void onClickNewsSearch(View view) {

        Intent intent = new Intent(this,SearchActivity.class);

        String savedSearchTerm = textView.getText().toString();
        String savedSearchTermCode = SearchCode.NEWS.tbm;

        intent.putExtra(SEARCH_TERM,savedSearchTerm);
        intent.putExtra(SEARCH_TYPE_CODE,savedSearchTermCode);

        startActivity(intent);

    }
    private void onClickBooksSearch(View view) {

        Intent intent = new Intent(this,SearchActivity.class);

        String savedSearchTerm = textView.getText().toString();
        String savedSearchTermCode = SearchCode.BOOKS.tbm;

        intent.putExtra(SEARCH_TERM,savedSearchTerm);
        intent.putExtra(SEARCH_TYPE_CODE,savedSearchTermCode);

        startActivity(intent);
    }

    private void onClickVideoSearch(View view) {

        Intent intent = new Intent(this,SearchActivity.class);

        String savedSearchTerm = textView.getText().toString();
        String savedSearchTermCode = SearchCode.VIDEO.tbm;

        intent.putExtra(SEARCH_TERM,savedSearchTerm);
        intent.putExtra(SEARCH_TYPE_CODE,savedSearchTermCode);

        startActivity(intent);
    }

    private void onClickImageSearch(View view) {
        String name = textView.getText().toString();
        debug(name);

        Intent intent = new Intent(this,SearchActivity.class);

        String save = textView.getText().toString();
        String savedType = SearchCode.IMAGE.tbm;
        intent.putExtra(MainActivity.SEARCH_TERM,save);
        intent.putExtra(MainActivity.SEARCH_TYPE_CODE,savedType);
        startActivity(intent);
    }

    private void debug(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}