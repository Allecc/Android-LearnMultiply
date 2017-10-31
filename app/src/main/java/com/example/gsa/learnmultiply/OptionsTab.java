package com.example.gsa.learnmultiply;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class OptionsTab extends AppCompatActivity {

    @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_tab);
        findViewById(R.id.options).setBackground(LearningTab.background);

        switch(LearningTab.multiplayer){
            case 10: {
                RadioButton radio = (RadioButton) findViewById(R.id.radio10);
                radio.setChecked(true);
                break;
            }
            case 20: {
                RadioButton radio = (RadioButton) findViewById(R.id.radio20);
                radio.setChecked(true);
                break;
            }
            case 30: {
                RadioButton radio = (RadioButton) findViewById(R.id.radio30);
                radio.setChecked(true);
                break;
            }
        }
    }

    public void onImageClick(View view){
        switch(view.getId()){
            case R.id.imageButton:{
                findViewById(R.id.options).setBackground(getResources().getDrawable(R.drawable.back1));
                LearningTab.background = getResources().getDrawable(R.drawable.back1);
                break;
            }
            case R.id.imageButton2:{
                findViewById(R.id.options).setBackground(getResources().getDrawable(R.drawable.back2));
                LearningTab.background = getResources().getDrawable(R.drawable.back2);
                break;
            }
            case R.id.imageButton3:{
                findViewById(R.id.options).setBackground(getResources().getDrawable(R.drawable.back3));
                LearningTab.background = getResources().getDrawable(R.drawable.back3);
                break;
            }
            case R.id.imageButton4:{
                findViewById(R.id.options).setBackground(getResources().getDrawable(R.drawable.back4));
                LearningTab.background = getResources().getDrawable(R.drawable.back4);
                break;
            }
        }
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio10:
                if (checked)
                   LearningTab.multiplayer = 10;
                break;
            case R.id.radio20:
                if (checked)
                    LearningTab.multiplayer = 20;
                break;
            case R.id.radio30:
                if (checked)
                    LearningTab.multiplayer = 30;
                break;
        }
    }
}

