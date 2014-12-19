package com.deep.arun.numbertowordapp;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class NumbersToWords extends ActionBarActivity {

    private static final String TAG = "NumbersToWords";
    private boolean backPressedToExitOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_to_words);

        final EditText text = (EditText)findViewById(R.id.editTextNumber);
        final TextView setText = (TextView)findViewById(R.id.textViewWord);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View v) {
                if(text.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Text Field is empty",Toast.LENGTH_LONG).show();
                    Log.d(TAG,"text field empty");
                }
                else{
                    String num = text.getText().toString();
                    String str = NumberToWord.convert(num);
                    setText.setText(str.trim());
                    Log.d(TAG,"text field non empty");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

        Log.i(TAG, "onBackPressed");
        if (backPressedToExitOnce) {
            super.onBackPressed();
            return;
        }
        this.backPressedToExitOnce = true;
        Toast.makeText(this, "Press again to quit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressedToExitOnce = false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers_to_words, menu);
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
