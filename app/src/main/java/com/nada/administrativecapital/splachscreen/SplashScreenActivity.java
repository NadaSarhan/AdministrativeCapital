package com.nada.administrativecapital.splachscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nada.administrativecapital.MainActivity;
import com.nada.administrativecapital.R;

public class SplashScreenActivity extends AppCompatActivity {

    Context ctx;
    public Context getCtx() {
        return ctx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ctx = this;

        setContentView(R.layout.activity_splashscreen);

        /*
         * splash screen duration.
         * */
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };
        myThread.start();

    }

}