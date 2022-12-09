package edu.illinois.cs465.myquizappwithintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PeekActivity extends AppCompatActivity {
    public static String ACTIVITY_RETURN_MSG = "ACTIVITY_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peek);

        Intent intent = new Intent();
        intent.putExtra(ACTIVITY_RETURN_MSG, "Hey, you peeked!");
        setResult(RESULT_OK, intent);
    }
}
