package com.martynaskairys.udacitytga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThingsToDoActivity extends AppCompatActivity {

    public static final String THINGSTODO = "thingsworthdoing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        setExplanationText();
    }

    private void setExplanationText() {
        TextView textExplainingFolderChoice = (TextView) findViewById(R.id.text_explaining_things_to_do);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            String j = (String) b.get(THINGSTODO);
            textExplainingFolderChoice.setText(j);
        }
    }
}
