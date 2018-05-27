package com.edge.fragmentactivitycallback;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Callback callback;
    Button button;
    String data ="Hello World\n";
    CallbackFramgent callbackFramgent = new CallbackFramgent();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTransaction.replace(R.id.container,callbackFramgent);
        fragmentTransaction.commit();
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                data +=data;
                callback.dataCallback(data);
                break;
        }
    }
}
