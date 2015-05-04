package com.example.rajyash.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityAdv extends ActionBarActivity {

    private Button cos, sin, tan, log, ln, pi, percent, raiseTo, squareRoot, delete;
    String advInput="";
    private EditText advDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_adv);

        advInput=getIntent().getStringExtra("simpleDisplay");
        advDisplay = (EditText)findViewById(R.id.advDisplay);
        advDisplay.setText(advInput);

        sin = (Button)findViewById(R.id.sin);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.sin(Math.toRadians(Double.parseDouble(advInput)));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        cos = (Button)findViewById(R.id.cos);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.cos(Math.toRadians(Double.parseDouble(advInput)));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        tan = (Button)findViewById(R.id.tan);
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.tan(Math.toRadians(Double.parseDouble(advInput)));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        ln = (Button)findViewById(R.id.ln);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.log(Double.parseDouble(advInput));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        log = (Button)findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.log10(Double.parseDouble(advInput));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        pi = (Button)findViewById(R.id.pi);
        pi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double num1=Double.parseDouble(advInput);
                double ans = Math.PI*num1;
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        squareRoot = (Button)findViewById(R.id.squareRoot);
        squareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = Math.sqrt(Double.parseDouble(advInput));
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        raiseTo = (Button)findViewById(R.id.raiseTo);
        raiseTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advInput = advInput+"^";
                if(advInput!=null) {
                    Intent intent = new Intent(MainActivityAdv.this, MainActivityCalc.class);
                    intent.putExtra("advInput",advInput);
                    startActivity(intent);
                }
            }
        });

        percent = (Button)findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ans = (Double.parseDouble(advInput)/100.00);
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(Double.toString(ans));
            }
        });

        delete = (Button)findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advInput="";
                advDisplay = (EditText)findViewById(R.id.advDisplay);
                advDisplay.setText(advInput);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_adv, menu);
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
