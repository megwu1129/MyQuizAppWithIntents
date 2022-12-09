package edu.illinois.cs465.myquizappwithintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PEEK_ACTIVITY_REQUEST = 1;

    private Button trueButton;
    private Button falseButton;
    private Button peekButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        peekButton = (Button) findViewById(R.id.peek_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        peekButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.true_button) {
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.false_button) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.peek_button) {
             /* This segment of code starts Peek Activity using an explicit intent. To run this
             code, uncomment these two lines and comment out all the code below.
             */

            /*
                Intent intent = new Intent(this, PeekActivity.class);
                startActivity(intent);
             */

             /* This segment of code starts Peek Activity using an explicit intent. When it ends,
              the onActivityResult method is called below. To run this code, uncomment
              these two lines and comment out all the code below and the segment of code above.
              */
/*
                Intent intent = new Intent(this, PeekActivity.class);
                startActivityForResult(intent, PEEK_ACTIVITY_REQUEST);
*/
            /* the code below creates an implicit intent and requests that Android launch an
             activity that can handle the request described in the Intent.
            */

//            Uri webpage = Uri.parse("https://en.wikipedia.org/wiki/Springfield,_Illinois");
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.setData(webpage);
//            Intent chooser = Intent.createChooser(intent, "OPEN WITH");
//            startActivity(chooser);

            // show Springfield, IL on a map
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 39.799999, -89.650002);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            Intent chooser = Intent.createChooser(intent, "OPEN WITH");
            startActivity(chooser);

        }
    }

    public void onActivityResult(int activityCode, int resultCode, Intent intent) {
        super.onActivityResult(activityCode, resultCode, intent);

        if (activityCode == PEEK_ACTIVITY_REQUEST) {
            if (resultCode == RESULT_OK) {
                String s = intent.getStringExtra(PeekActivity.ACTIVITY_RETURN_MSG);
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }
    }

}