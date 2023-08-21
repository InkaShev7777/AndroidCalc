package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    boolean isAction = false;
    String ActionNow = "";
    Float firstNumber = (float) 0;
    Float secondNumber = (float) 0;
    List<Button>NumberButtons;
    private TextView textView;

    // Button Actions
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnMultiplication;
    private Button btnDevision;
    private Button btnComma;
    private Button btnRes;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calk);
        this.textView = (TextView) findViewById(R.id.textView3);
        AddActionButton();
        GetAllNumbersButton();

    }
    private void GetAllNumbersButton(){
        NumberButtons = new ArrayList<Button>();
        for(Integer i = 0; i < 9;i++){
            int id = getResources().getIdentifier("button"+i, "id", getPackageName());
            Button btn = (Button) findViewById(id);
            btn.setOnClickListener(v -> {
                String view = (String) this.textView.getText();
                Integer num = Integer.parseInt((String) btn.getText());
                if(view.equals(("0"))){
                    this.textView.setText(btn.getText());
                }
                else {
                    if(this.isAction == true){
                        this.textView.setText(btn.getText());
                    }
                    else {
                        this.textView.setText(((String)this.textView.getText() + btn.getText()));
                    }
                }
            });
            this.NumberButtons.add(btn);
        }
    }
    private void AddActionButton(){
        //
        //      AC
        //
        this.buttonClear = (Button)findViewById(R.id.buttonClear);
        this.buttonClear.setOnClickListener(v -> {
            this.textView.setText("0");
            this.isAction = false;
            this.firstNumber = (float) 0;
            this.secondNumber = (float) 0;
        });
        //
        //      +
        //
        this.btnAddition = (Button)findViewById(R.id.button21);
        this.btnAddition.setOnClickListener(v -> {
            this.isAction = true;
            this.ActionNow = "+";
            if(isAction == true){
                this.firstNumber += Float.parseFloat((String) this.textView.getText());
                this.textView.setText(this.firstNumber.toString());
            }
        });
        //
        //      =
        //
        this.btnRes = (Button) findViewById(R.id.buttonRes);
        this.btnRes.setOnClickListener(v -> {
            this.secondNumber = Float.parseFloat((String) this.textView.getText());
            Float res = (float)0;
            boolean isError = false;
            if(this.ActionNow == "+"){
                res = this.firstNumber + this.secondNumber;
            } else if (this.ActionNow == "-") {
                res = this.firstNumber - this.secondNumber;
            }
            else if (this.ActionNow == "*"){
                res = this.firstNumber * this.secondNumber;
            }
            else if (this.ActionNow == "/"){
                if(this.secondNumber == 0){
                   isError = true;
                }
                else {
                    res = this.firstNumber / this.secondNumber;
                }
            }
            if(isError == false){
                this.textView.setText(res.toString());
                this.secondNumber = (float) 0;
                this.firstNumber = (float) 0;
                this.isAction = false;
                this.ActionNow = "";
            }
            else {
                this.secondNumber = (float) 0;
                this.firstNumber = (float) 0;
                this.isAction = false;
                this.ActionNow = "";
                this.textView.setText("Ошибка");
            }
        });
        //
        //      -
        //
        this.btnSubtraction = (Button) findViewById(R.id.button17);
        this.btnSubtraction.setOnClickListener(v -> {
            this.isAction = true;
            this.firstNumber = Float.parseFloat((String) this.textView.getText());
            this.ActionNow="-";
        });
        //
        //  *
        //
        this.btnMultiplication = (Button) findViewById(R.id.button13);
        this.btnMultiplication.setOnClickListener(v -> {
            this.isAction = true;
            this.firstNumber = Float.parseFloat((String) this.textView.getText());
            this.ActionNow = "*";
        });
        //
        //  /
        //
        this.btnDevision = (Button) findViewById(R.id.button_d);
        this.btnDevision.setOnClickListener(v -> {
            this.isAction = true;
            this.firstNumber = Float.parseFloat((String) this.textView.getText());
            this.ActionNow = "/";
        });
    }
}