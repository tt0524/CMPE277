package com.example.mycalculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
//    private Button digit;
    private Button equal;
    private Button add;
    private Button sub;
    private Button multi;
    private Button divide;
    private Button delete;
    private Button sign;
    private Button clear;
    private TextView formula;
    private TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        /**
         * Click Listen Event
         */
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "9");
            }
        });

//        digit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                formula.setText(formula.getText().toString() + ".");
//            }
//        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNumeric(formula.getText().toString())){
                    formula.setText( '-' + formula.getText().toString());
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "-");
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(formula.getText().toString() + "/");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formula.setText(null);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formula.getText().length() > 0) {
                    CharSequence name = formula.getText().toString();
                    formula.setText(name.subSequence(0, name.length() - 1));
                } else {
                    formula.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(calculate(formula.getText().toString())));
            }
        });



    }


    /**
     * Set up UI Views associated with class
     */
    private void setupUIViews(){

        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
//        digit = (Button)findViewById(R.id.btnDigit);
        equal = (Button)findViewById(R.id.btnEqual);
        add = (Button)findViewById(R.id.btnAdd);
        sub = (Button)findViewById(R.id.btnSub);
        multi = (Button)findViewById(R.id.btnMlt);
        divide = (Button)findViewById(R.id.btnDivide);
        delete = (Button)findViewById(R.id.btnDel);
        sign = (Button)findViewById(R.id.btnSign);
        clear = (Button)findViewById(R.id.btnClear);
        formula = (TextView)findViewById(R.id.tvFormula);
        result = (TextView)findViewById(R.id.tvResult);

    }

    /**
     * Given a string formula, calculate the value of the formula
     * @param s: formula, for example: "6+9"
     * @return double value result
     */
    private double calculate(String s){
        int md=-1; // 0 is multiple, 1 is divide
        int sign=1; // 1 is add, -1 is substract
        int prev=0;
        int result=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                while(++i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10+s.charAt(i)-'0';
                }
                i--; // back to last digit of number

                if(md==0){
                    prev = prev * num;
                    md=-1;
                }else if(md==1){
                    prev = prev / num;
                    md=-1;
                }else{
                    prev = num;
                }
            }else if(c=='/'){
                md=1;
            }else if(c=='*'){
                md=0;
            }else if(c=='+'){
                result = result + sign*prev;
                sign=1;
            }else if(c=='-'){
                result = result + sign*prev;
                sign=-1;
            }
        }

        result = result + sign*prev;
        return result;
    }

    /**
     * Given a string, return whether it is a number or not
     * @param strNum: string number, for example "0.9"
     * @return boolean: true/false
     */
    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
