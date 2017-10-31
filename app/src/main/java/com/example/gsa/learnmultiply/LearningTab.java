package com.example.gsa.learnmultiply;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class LearningTab extends AppCompatActivity {
    int a = 0;
    int b = 0;
    public static int multiplayer = 10;
    public static Drawable background = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_tab);
        newExpression();

        // result field
        final EditText result = (EditText) findViewById(R.id.result);
        // validate field
        final TextView validate = (TextView) findViewById(R.id.validateField);

        // check button
        Button checkButton = (Button) findViewById(R.id.check);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!result.getText().toString().equals("")){
                    int tempResult = a * b;
                    int userResult = Integer.parseInt(result.getText().toString());
                    if(tempResult == userResult){
                        validate.setText("Success!\n" + a + " x " + b + " = " + userResult);
                        newExpression();
                    } else {
                        validate.setText("Failure!\n" + a + " x " + b + " != " + userResult + "    Correct: " + tempResult);
                        newExpression();
                    }
                } else {
                    validate.setText("Empty string!");
                }
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onResume(){
        super.onResume();
        findViewById(R.id.content_layout).setBackground(background);
    }

    public void newExpression(){
        Random generator = new Random();
        // result field
        final EditText result = (EditText) findViewById(R.id.result);
        // validate field
        final TextView validate = (TextView) findViewById(R.id.validateField);

        result.setText("");

        // Landing
        a = generator.nextInt(multiplayer+1);
        b = generator.nextInt(multiplayer+1);
        TextView landing = (TextView) findViewById(R.id.landing);
        landing.setText(a + " x " + b + " = ");
    }


    public void buttonClicked(View view){
        EditText result = (EditText) findViewById(R.id.result);
        String tempResult = result.getText().toString();
        Button tempB = (Button) view;
        result.setText(tempResult + tempB.getText().toString());
    }

    public void optionTab( View view ) {
        Intent myIntent = new Intent(view.getContext(), OptionsTab.class);
        startActivityForResult(myIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learning_tab, menu);
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
