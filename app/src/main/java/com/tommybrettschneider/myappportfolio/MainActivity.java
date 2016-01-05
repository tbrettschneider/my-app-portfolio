/**
 * Copyright (C) 2016 Tommy Brettschneider
 */
package com.tommybrettschneider.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * This app's main activity.
 */
public class MainActivity extends AppCompatActivity {

    private static final Map<Integer, Integer> MAP_VIEW_ID_TOAST_STRING = new HashMap<Integer, Integer>() {
        {
            put(R.id.button1, R.string.btn_toast_app1);
            put(R.id.button2, R.string.btn_toast_app2);
            put(R.id.button3, R.string.btn_toast_app3);
            put(R.id.button4, R.string.btn_toast_app4);
            put(R.id.button5, R.string.btn_toast_app5);
            put(R.id.button6, R.string.btn_toast_app6);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addCustomButtons();
    }

    /**
     * Adds custom buttons that will display a toast on click.
     */
    private void addCustomButtons() {

        for (final Integer viewId : MAP_VIEW_ID_TOAST_STRING.keySet()) {
            Button button = (Button)findViewById(viewId);
            final Integer toastString = MAP_VIEW_ID_TOAST_STRING.get(viewId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), toastString, Toast.LENGTH_SHORT).show();
                }
            });
        }
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
