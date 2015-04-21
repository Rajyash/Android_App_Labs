package com.example.rajyash.pig;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivityPig extends ActionBarActivity {
    private FrameLayout die1, die2;
    private Button roll, hold;
    private TextView round, p1, p2;
    private int roundTotal, p1Total, p2Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_pig);

        p2 = (TextView) findViewById(R.id.p2);
        p1 = (TextView) findViewById(R.id.p1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            roundTotal = 0 ;
            p2Total = extras.getInt("p2");
            p2.setText("P2: " + Integer.toString(p2Total));
            p1Total = extras.getInt("p1");
            p1.setText("P1: " + Integer.toString(p1Total));
        }


        roll = (Button) findViewById(R.id.button);
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
                p1 = (TextView) findViewById(R.id.p1);
                p1Total = p1Total + roundTotal;
                if(p1Total >= 100){
                    showDialog();
                }
                else{

                    //p1Total = p1Total + roundTotal;
                    p1 = (TextView) findViewById(R.id.p1);

                    p1.setText("P1: "+Integer.toString(p1Total));
                    passIntent();
                }
            }
        });


        die1 = (FrameLayout) findViewById(R.id.die1);
        die2 = (FrameLayout) findViewById(R.id.die2);

    }

    //get two random ints between 1 and 6 inclusive
    public void rollDice() {
        if(p1Total < 100) {
            round = (TextView) findViewById(R.id.round);
            int val1 = 1 + (int) (6 * Math.random());
            int val2 = 1 + (int) (6 * Math.random());
            int sum;
            setDie(val1, die1);
            setDie(val2, die2);
            if (val1 == 1 || val2 == 1) {
                roundTotal = 0;
                //p1Total = p1Total + roundTotal;
                passIntent();
            } else {
                sum = val1 + val2;
                roundTotal = roundTotal + sum;
                //p1Total = p1Total + roundTotal;
            }
            round.setText("Round: " + Integer.toString(roundTotal));

        }
        else{
            showDialog();
        }

    }

    //set the appropriate picture for each die per int
    public void setDie(int value, FrameLayout layout) {
        Drawable pic = null;

        switch (value) {
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                break;
        }
        layout.setBackground(pic);
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
        Intent intent = new Intent(MainActivityPig.this, Player2.class);
        intent.putExtra("p1", p1Total);
        intent.putExtra("p2", p2Total);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivityPig.this).create();
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
