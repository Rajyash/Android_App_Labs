package com.example.rajyash.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;


public class MainActivityCalc extends ActionBarActivity {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private GridLayout gMain;
    private Button multiply, addition,subtract, divide, delete, equal;
    private String input="";
    private EditText display;
    private int n1,n2;
    String firstValue="", secondValue="";
    private boolean raiseToPower=false, pendingOperations=false;
    double ansTmp=0.0, ans=0.0;
    String operator="";
    String tmpString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_calc);



        display = (EditText)findViewById(R.id.display);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            input = input + getIntent().getStringExtra("advInput");
            String advOperator="";
            advOperator = input.substring(input.length()-1, input.length());
            if(advOperator.equalsIgnoreCase("^")){
                operator="^";
            }
            display = (EditText)findViewById(R.id.display);
            display.setText(input);
        }
        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b1.getText();
                display.setText(input);
            }
        });

        b2 = (Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b2.getText();
                //prepare(firstValue, operator, secondValue);
                display.setText(input);
            }
        });

        b3 = (Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b3.getText();
                //prepare(firstValue, operator, secondValue);
                display.setText(input);
            }
        });

        b4 = (Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b4.getText();
                display.setText(input);
            }
        });

        b5 = (Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b5.getText();
                display.setText(input);
            }
        });

        b6 = (Button)findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b6.getText();
                display.setText(input);
            }
        });

        b7 = (Button)findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b7.getText();
                display.setText(input);
            }
        });

        b8 = (Button)findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b8.getText();
                display.setText(input);
            }
        });

        b9 = (Button)findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b9.getText();
                display.setText(input);
            }
        });

        b0 = (Button)findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input+b0.getText();
                display.setText(input);
            }
        });

        multiply = (Button)findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(pendingOperations){
                    prepare(firstValue,operator,secondValue);
                    pendingOperations=false;

                }*/
                operator = "*";
                input = input + operator;
                display = (EditText)findViewById(R.id.display);
                display.setText(input);

                /*if(!(input.isEmpty())||(input!=null)){
                    n2 = Integer.parseInt(input);
                    ans = n1 * n2;
                    System.out.println("ans"+ans);
                    input = Integer.toString(ans);
                    display = (TextView)findViewById(R.id.display);
                    display.setText(Integer.toString(ans));
                    //firstValue=Integer.toString(ans);
                    n1=ans;
                    input="";
                }
                else{
                    return;
                }*/
                //return;
            }
        });

        addition = (Button)findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /*if(firstValue.equals("")){
                    firstValue = input;
                    n1 = Integer.parseInt(firstValue);
                    //prepare(n1,);
                }*/
                operator = "+";
                input = input + operator;
                display = (EditText)findViewById(R.id.display);
                display.setText(input);

            }
        });

        subtract = (Button)findViewById(R.id.subtract);
        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /*if(firstValue.equals("")){
                    firstValue = input;
                    n1 = Integer.parseInt(firstValue);
                    //prepare(n1,);
                }*/
                operator = "-";
                input = input + operator;
                display = (EditText)findViewById(R.id.display);
                display.setText(input);

            }
        });

        divide = (Button)findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /*if(firstValue.equals("")){
                    firstValue = input;
                    n1 = Integer.parseInt(firstValue);
                    //prepare(n1,);
                }*/
                operator = "/";
                input = input + operator;
                display = (EditText)findViewById(R.id.display);
                display.setText(input);

            }
        });

        equal = (Button)findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*if(pendingOperations){
                    prepare(firstValue,operator,secondValue);
                    pendingOperations=false;

                }*/

                String arr[] = input.split("\\"+operator);

                double num1=Double.parseDouble(arr[0]);
                double num2=Double.parseDouble(arr[1]);
                double tmpAnswer=0.0;
                if(operator.equalsIgnoreCase("*")){
                    tmpAnswer=num1*num2;
                }
                if(operator.equalsIgnoreCase("+")){
                    tmpAnswer=num1+num2;
                }
                if(operator.equalsIgnoreCase("-")){
                    tmpAnswer=num1-num2;
                }
                if(operator.equalsIgnoreCase("/")){
                    tmpAnswer=num1/num2;
                }
                if(operator.equalsIgnoreCase("^")){
                    tmpAnswer=Math.pow(num1, num2);
                }
                input=Double.toString(tmpAnswer);
                display = (EditText)findViewById(R.id.display);
                display.setText(input);

            }
        });

        delete = (Button)findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                display = (EditText)findViewById(R.id.display);
                display.setText(input);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_calc, menu);
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
            if(input!=null) {
                Intent intent = new Intent(MainActivityCalc.this, MainActivityAdv.class);
                intent.putExtra("simpleDisplay",input);
                startActivity(intent);
                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }

   /* public void prepare(String fv1, String operator, String sv2){
        if(!(operator.isEmpty()) && operator!=null){
            if(!(fv1.isEmpty()) && (fv1!=null)){
                if(!(sv2.isEmpty()) && (sv2!=null)){
                    if(operator=="*"){
                        ans=n1*n2;
                        display = (TextView)findViewById(R.id.display);
                        display.setText(Integer.toString(ans));
                        n1=ans;
                    }
                    if(operator=="+"){
                        ans=n1+n2;
                        display = (TextView)findViewById(R.id.display);
                        display.setText(Integer.toString(ans));
                        n1=ans;
                    }
                }
                else{
                    pendingOperations = true;
                }
            }
        }
        else{
            return;
        }


    }
*/

}
