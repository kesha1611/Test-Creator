package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Reference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        setupHyperlink();
    }

    private void setupHyperlink() {
        TextView linkTextView7 = findViewById(R.id.textView7);
        linkTextView7.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkTextView8 = findViewById(R.id.textView8);
        linkTextView8.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkTextView9 = findViewById(R.id.textView9);
        linkTextView9.setMovementMethod(LinkMovementMethod.getInstance());
        TextView linkTextView10 = findViewById(R.id.textView10);
        linkTextView10.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
