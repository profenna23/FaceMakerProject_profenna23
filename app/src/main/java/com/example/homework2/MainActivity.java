package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // new view
        Face theView = (Face)findViewById(R.id.surfaceView);

        // random face button
        Button Random = (Button)findViewById(R.id.randomFaceButton);
        Random.setOnClickListener(theView);

        // radio group
        RadioGroup radioGroup = findViewById(R.id.radioButtonHES);
        radioGroup.setOnCheckedChangeListener(theView);

        // color seekBars
        SeekBar redSB = (SeekBar)findViewById(R.id.redSeekBar);
        redSB.setOnSeekBarChangeListener(theView);
        SeekBar greenSB = (SeekBar)findViewById(R.id.greenSeekBar);
        greenSB.setOnSeekBarChangeListener(theView);
        SeekBar blueSB = (SeekBar)findViewById(R.id.blueSeekBar);
        blueSB.setOnSeekBarChangeListener(theView);

        // spinner
        Spinner spinner = findViewById(R.id.hairSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.hairStyles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

}