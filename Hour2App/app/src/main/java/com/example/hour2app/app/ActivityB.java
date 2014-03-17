package com.example.hour2app.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityB extends ActionBarActivity {

    public static final String GREETING = "greeting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
//
//        Intent intent = getIntent();
//        Bundle bundle = intent.getBundleExtra("greetingBundle");
//        String greeting = bundle.getString(GREETING);
//        String message = intent.getStringExtra("message");
//        Boolean showAll = intent.getBooleanExtra("showAll", false);
//        int numItems = intent.getIntExtra("numItems", 0);

        TextView t = (TextView) findViewById(R.id.textView);
       // t.setText("This is Activity B: " + greeting + " " + message + " " + showAll + " " + numItems);

        Intent intent = getIntent();
        if (intent!=null){
            String action = intent.getAction();
            String type = intent.getType();
            if(intent.ACTION_SEND.equals(action)&& "text/plain".equals(type)) {
                t.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
            else{
                //handle dat form A.
            }
        }

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityA.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);


                startActivity(intent);
            }
        });
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
