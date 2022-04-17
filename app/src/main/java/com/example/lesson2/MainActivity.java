package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button7, button8,button9, button6, button5, button4, button3, button2, button1, button0, buttonTen;
    Button  buttonDelete, buttonPlusMinus;
    Button buttonPlus, buttonMinus,  buttonX, buttonDiv,buttonDot ;
    TextView tv_num, tv_zapis;
    String firstNum,secondNum, znak, zapisTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.less4);

        numMethods();
        delMethods();
        funcMethods();
        initViews();

    }
    public void initViews(){
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button0 = findViewById(R.id.btn0);


        tv_num = findViewById(R.id.tv_num);
        tv_zapis = findViewById(R.id.tv_zapis);


        buttonDelete = findViewById(R.id.btnC);
        buttonPlusMinus = findViewById(R.id.btnPlusMin);


        buttonPlus = findViewById(R.id.btnPlus);
        buttonMinus = findViewById(R.id.btnMinus);


        buttonX = findViewById(R.id.btnX);
        buttonDiv = findViewById(R.id.btnDiv);
        buttonDot = findViewById(R.id.btnDot);

        buttonTen = findViewById(R.id.btnTen);
    }
    public void numMethods(){
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aldingiSan = tv_num.getText().toString();
                String basilganNum = "";
                String songyResult = "";

                switch (view.getId()){
                    case R.id.btn0:

                        basilganNum = "0";
                        break;
                    case R.id.btn1:

                        basilganNum = "1";
                        break;
                    case R.id.btn2:

                        basilganNum = "2";
                        break;
                    case R.id.btn3:

                        basilganNum = "3";
                        break;
                    case R.id.btn4:

                        basilganNum = "4";
                        break;
                    case R.id.btn5:

                        basilganNum = "5";
                        break;
                    case R.id.btn6:

                        basilganNum = "6";
                        break;
                    case R.id.btn7:

                        basilganNum = "7";
                        break;

                    case R.id.btn8:

                        basilganNum = "8";
                        break;
                    case R.id.btn9:

                        basilganNum = "9";
                    case R.id.btnDot:
                        if (aldingiSan.contains(("."))){
                            basilganNum = "";
                        }else {
                            basilganNum = ".";
                        }
                        break;
                    case R.id.btnC:
                        if (tv_num.length()>0){
                            String tv_del = aldingiSan.substring(0, aldingiSan.length()-1);
                            aldingiSan = tv_del;
                            basilganNum = "";
                        }
                        break;



                }
                if (!aldingiSan.equals("0")) songyResult = aldingiSan +basilganNum;
                else songyResult = basilganNum;
                tv_num.setText(songyResult);

            }
        };


        button1.setOnClickListener(buttonSandar);
        button0.setOnClickListener(buttonSandar);
        button2.setOnClickListener(buttonSandar);
        button3.setOnClickListener(buttonSandar);
        button4.setOnClickListener(buttonSandar);
        button5.setOnClickListener(buttonSandar);
        button6.setOnClickListener(buttonSandar);
        button7.setOnClickListener(buttonSandar);
        button8.setOnClickListener(buttonSandar);
        button9.setOnClickListener(buttonSandar);
        buttonDot.setOnClickListener(buttonSandar);
    }
    public void delMethods(){
        View.OnClickListener buttonOshiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case  R.id.btnC:
                        tv_num.setText("0");
                        tv_zapis.setText("");
                        break;
                    case  R.id.btnPlusMin:

                        String  santext = tv_num.getText().toString();
                        int san = Integer.parseInt(santext);
                        if (san>0) tv_num.setText("-"+santext);

                        else {
                            san = san*(-1);
                            tv_num.setText(" "+san);
                        }
                        break;
                }
            }
        };
        buttonDelete.setOnClickListener(buttonOshiruPlusMinus);
        buttonPlusMinus.setOnClickListener(buttonOshiruPlusMinus);
    }
    public void funcMethods(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = tv_num.getText().toString();
                switch (view.getId()) {
                    case R.id.btnPlus:
                        znak = "+";
                        break;

                    case R.id.btnMinus:
                        znak = "-";
                        break;
                    case R.id.btnX:
                        znak = "*";
                        break;
                    case R.id.btnDiv:
                        znak = "/";
                        break;
                    case R.id.btnPerc:
                        znak = "%";
                        break;

                }
                zapisTxt = firstNum + znak;
                tv_zapis.setText(zapisTxt);
                tv_num.setText("0");

            };
        };

        buttonPlus.setOnClickListener(btnFunctions);
        buttonMinus.setOnClickListener(btnFunctions);
        buttonX.setOnClickListener(btnFunctions);
        buttonDiv.setOnClickListener(btnFunctions);

        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                secondNum = tv_num.getText().toString();
                double res = 0;
            if (tv_num.getText().toString().contains(".")) {
                    double san1 = Double.parseDouble(firstNum);
                    double san2 = Double.parseDouble(secondNum);

                    if (znak.equals("+")) {
                    res = san1 + san2;
                } else if (znak.equals("-")) {
                    res = san1 - san2;
                } else if (znak.equals("*")) {
                    res = san1 * san2;
                } else if (znak.equals("/")) {
                    res = san1 / san2;
                } else if (znak.equals("%")) {
                    res = san1 % san2;
                }
            }else {
                secondNum = tv_num.getText().toString();
                int san1 = Integer.parseInt(firstNum);
                int san2 = Integer.parseInt(secondNum);
                if (znak.equals("+")) {
                    res = san1 + san2;
                } else if (znak.equals("-")) {
                    res = san1 - san2;
                } else if (znak.equals("*")) {
                    res = san1 * san2;
                } else if (znak.equals("/")) {
                    res = san1 / san2;
                } else if (znak.equals("%")) {
                    res = san1 % san2;
                }
            }

                zapisTxt = firstNum + znak + secondNum + "=" + res;
                tv_zapis.setText(zapisTxt);
                tv_num.setText(""+res);
            }
        });
    }
}