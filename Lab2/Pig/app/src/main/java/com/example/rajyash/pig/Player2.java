package com.example.rajyash.pig;

/**
 * Created by rajyash on 4/16/15.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.logging.Log;


public class Player2 extends ActionBarActivity {

    private FrameLayout die1, die2;
    private Button roll, hold;
    private int roundTotal, p2Total, p1Total;
    private TextView round, p2, p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);

        Bundle intent = getIntent().getExtras();
        p1Total = intent.getInt("p1");
        p2Total = intent.getInt("p2");
        p1 = (TextView)findViewById(R.id.p1);
        p1.setText("P1: "+Integer.toString(p1Total));
        p2 = (TextView)findViewById(R.id.p2);
        p2.setText("P2: "+Integer.toString(p2Total));



        roll = (Button)findViewById(R.id.button);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        hold = (Button)findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2 = (TextView) findViewById(R.id.p2);
                p2Total = p2Total + roundTotal;
                if(p2Total >= 100){
                    showDialog();
                }
                else{
                    //p2Total = p2Total + roundTotal;
                    p2 = (TextView) findViewById(R.id.p2);

                    p2.setText("P2: "+Integer.toString(p2Total));
                    passIntent();

                }
            }
        });

        die1 = (FrameLayout)findViewById(R.id.die1);
        die2 = (FrameLayout)findViewById(R.id.die2);

    }

    public void rollDice(){
        if(p2Total < 100) {
            round = (TextView) findViewById(R.id.round);
            int val1 = 1 + (int) (6 * Math.random());
            int val2 = 1 + (int) (6 * Math.random());
            int sum;
            setDie(val1, die1);
            setDie(val2, die2);
            if (val1 == 1 || val2 == 1) {
                roundTotal = 0;
                //p2Total = p2Total + roundTotal;
                passIntent();
            }
            else {
                sum = val1 + val2;
                roundTotal = roundTotal + sum;
                //p2Total = p2Total + roundTotal;
            }
            //p2Total = p2Total + roundTotal;
            round.setText("Round: " + Integer.toString(roundTotal));

        }
        else{
            showDialog();
        }
    }

    public void setDie(int num,FrameLayout layout){
        Drawable pic;
        switch (num){
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                layout.setBackground(pic);
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                layout.setBackground(pic);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                layout.setBackground(pic);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                layout.setBackground(pic);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                layout.setBackground(pic);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                layout.setBackground(pic);
                break;
            default:
                //Log.i("my code", "Something went wrong");

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_pig, menu);
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

    public void passIntent(){
        Intent intent = new Intent(Player2.this,MainActivityPig.class);
        intent.putExtra("p1", p1Total);
        intent.putExtra("p2", p2Total);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
    public void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(Player2.this).create();
        alertDialog.setTitle("You Won!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
