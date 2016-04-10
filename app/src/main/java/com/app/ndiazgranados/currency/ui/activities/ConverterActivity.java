package com.app.ndiazgranados.currency.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.app.ndiazgranados.currency.R;
import com.app.ndiazgranados.currency.network.WifiReceiver;
import com.squareup.otto.Subscribe;

public class ConverterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Subscribe
    public void updateConnectionStatus(WifiReceiver.NetworkConnectionChange networkConnectionChange ) {
        updateActiveConnectionIcon(networkConnectionChange.isOnline());
    }
}
