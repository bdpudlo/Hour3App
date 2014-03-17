package com.example.hour2app.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityA extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText("This is activity A");
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                Bundle b = new Bundle();
                b.putString("greeting", "Hello");
                intent.putExtra("greetingBundle", b);
                intent.putExtra("message", "World!");
                intent.putExtra("showAll", true);
                intent.putExtra("numItems", 5);
                startActivity(intent);
            }
        });

        Button getDataB = (Button) findViewById(R.id.getDataButton);
        getDataB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityC.class);
                startActivityForResult(intent, 0);
            }



        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView t = (TextView) findViewById(R.id.textView);

        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String enteredData = data.getStringExtra("Data");
            t.setText(enteredData);
        }
        else{
            t.setText("Canceled button pushed");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu., menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

}
