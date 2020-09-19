package edu.utep.cs4330.androidsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    private final static String SEARCH = "edu.utep.cs4330.androidsearch.SEARCH";
    private final static String SEARCH_TYPE_CODE = "edu.utep.cs4330.androidsearch.SEARCH_TYPE";


    private TextView htmlBanner;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Get Data from Main Activity (Declared 1)
        Intent intent = getIntent();
        String savedText = intent.getStringExtra(SEARCH);
        String savedCodeText = intent.getStringExtra(SEARCH_TYPE_CODE);

        // Get Views by id
        htmlBanner = findViewById(R.id.htmlBanner);
        proceedButton = findViewById(R.id.proceed);


        htmlBanner.setText(Html.fromHtml(String.format(
                "<h1> Search Server </h1><br/><p>Search Term: %s</p><br/><p>Type: %s</p>",
                savedText,
                savedCodeText)));

        proceedButton.setOnClickListener(this::onClickSearchServer);


    }


    private void onClickSearchServer(View view) {
        // (Declared 2)
        Intent intent = getIntent();
        String text = intent.getStringExtra(SEARCH);
        proceed(text);
    }

    private void proceed(String text) {

        Intent intentRetrieval = getIntent();
        String tbm = intentRetrieval.getStringExtra(SEARCH_TYPE_CODE);
        String searchTerm = text.replace("\n","").trim();
        String url = String.format("https://www.google.com/search?tbm=%s&q=%s",tbm,searchTerm);

        // Create a search intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(intent);
    }






}