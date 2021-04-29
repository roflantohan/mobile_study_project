package com.example.labmob1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView;
import android.graphics.Color;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.EditText
import android.widget.Button;



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var okButton = findViewById<Button>(R.id.ok);
        var cancelButton = findViewById<Button>(R.id.cancel);

        okButton.setOnClickListener{
            checkInput();
        }

        cancelButton.setOnClickListener{
            clearAll();
        }

    }

    fun clearAll(){
        var editText = findViewById<EditText>(R.id.input);
        var textView = findViewById<TextView>(R.id.result_text);
        var radioGroup = findViewById<RadioGroup>(R.id.radios);

        editText.setText("");
        textView.setText("");
        radioGroup.clearCheck();
    }

    fun setResultColor(str: String): String{
        var color: String = "#000000"; //black by default
        when (str) {
            "Blue" -> color = "#0000FF"
            "Green" -> color = "#008000"
            "Red" -> color = "#FF0000"
            "Black" -> color = "#000000"
        }
        return color;
    }

    fun checkInput(){
        var flag = true;
        var resText = findViewById<TextView>(R.id.result_text);
        var str = findViewById<EditText>(R.id.input).text;
        var radioGroup = findViewById<RadioGroup>(R.id.radios);
        var checkedColorId = radioGroup.checkedRadioButtonId;

        resText.setTextColor(Color.parseColor("#000000"))// black color by default
        
        if(str.isEmpty()) {
            flag = false;
            resText.setText("Please, enter the text");
        }

        if(checkedColorId == -1) {
            flag = false;
            resText.setText("Please, choose the color");
        }

        if(flag){
            var colorStr = findViewById<RadioButton>(checkedColorId).text;
            var color = setResultColor(colorStr.toString());
            resText.setTextColor(Color.parseColor(color));
            resText.setText(str)
        }
    }



}