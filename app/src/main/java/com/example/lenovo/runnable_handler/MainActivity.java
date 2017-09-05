package com.example.lenovo.runnable_handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button start,stop,reset;
    Handler handler;
    Runnable run;
    int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.txt_time);
        start = (Button) findViewById(R.id.btn_start);
        stop = (Button) findViewById(R.id.btn_stop);
        reset = (Button) findViewById(R.id.btn_reset);
        time=0;
    }
    public void start(View view)
    {
        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                tv.setText("Time: "+time);
                time++;
                tv.setText("Time: "+time);
                handler.postDelayed(this,1000);
            }

        };
        handler.post(run);
    }
    public void stop(View view)
    {
        handler.removeCallbacks(run);
    }
    public void reset(View view)
    {
        handler.removeCallbacks(run);
        time = 0;
        tv.setText("Time: "+time);
    }
}
