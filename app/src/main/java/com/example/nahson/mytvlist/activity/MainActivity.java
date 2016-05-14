package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.TV.TV;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText searchBarText;
    private Button searchButton;
    private Button tvListButton;
    private Intent intent;
    private Intent tvIntent;

    public static ArrayList<TV> tvShowList;

    public static final String TV_LIST_TAB = "TV List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvShowList = new ArrayList<>();

        intent = new Intent(MainActivity.this, Result.class);
        searchBarText = (EditText) findViewById(R.id.search_bar);
        searchBarText.setText("");
        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchBarText.getText() != null) {
                    String input = searchBarText.getText().toString();
                    intent.putExtra("Input", input);
                }
                startActivity(intent);
            }
        });

        tvListButton = (Button) findViewById(R.id.tv_list_button);
        tvListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvIntent = new Intent(MainActivity.this, TVShowList.class);
                tvIntent.putParcelableArrayListExtra(TVShowList.TAG, tvShowList);
                startActivity(tvIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
