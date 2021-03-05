package com.example.homework2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class Face extends SurfaceView implements SeekBar.OnSeekBarChangeListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{

    // properties of the face

    // skin
    int skinColor;
    int skinColorRed;
    int skinColorGreen;
    int skinColorBlue;
    // eyes
    int eyeColor;
    int eyeColorRed;
    int eyeColorGreen;
    int eyeColorBlue;
    // hair
    int hairColor;
    int hairColorRed;
    int hairColorGreen;
    int hairColorBlue;
    int hairStyle;

    int wasPressed;

    private Context myContext;

    // constructor
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        myContext = context;
        randomize();
        //setWillNotDraw(false);
    }

    // initializes all the variables to randomly selected valid values
    public void randomize(){
        Random rand = new Random();
        // skin
        skinColorRed = rand.nextInt(256);
        skinColorGreen = rand.nextInt(256);
        skinColorBlue = rand.nextInt(256);
        // eyes
        eyeColorRed = rand.nextInt(256);
        eyeColorGreen = rand.nextInt(256);
        eyeColorBlue = rand.nextInt(256);
        // hair
        hairColorRed = rand.nextInt(256);
        hairColorGreen = rand.nextInt(256);
        hairColorBlue = rand.nextInt(256);
        hairStyle = rand.nextInt(3);
    }

    // draws this Face object upon a given Canvas
    public void onDraw(Canvas canvas){

        // draw base head shape
        Paint color = new Paint();
        skinColor = Color.rgb(skinColorRed, skinColorGreen, skinColorBlue);
        color.setColor(skinColor);
        canvas.drawCircle(1250,750,500, color);

        // draw eyes
        eyeColor = Color.rgb(eyeColorRed, eyeColorGreen, eyeColorBlue);
        color.setColor(eyeColor);
        canvas.drawCircle(1050, 700, 100, color);
        canvas.drawCircle(1450, 700, 100, color);

        // draw mouth
        int mouthColor = Color.rgb(0, 0, 0);
        color.setColor(mouthColor);
        canvas.drawLine(1050, 900, 1450, 900, color);
        canvas.drawRect(1050, 900, 1450, 920, color);

        // draw hairstyle
        hairColor = Color.rgb(hairColorRed, hairColorGreen, hairColorBlue);
        color.setColor(hairColor);

        // draws each hairstyle
        if (hairStyle == 0){
            // draw hairstyle 1: long
            canvas.drawRect(700, 200, 1800, 550, color);
            canvas.drawRect(600, 200, 900, 1300, color);
            canvas.drawRect(1600, 200, 1900, 1300, color);
        } else if (hairStyle == 1){
            // draw hairstyle 2: short
            canvas.drawRect(700, 200, 1800, 550, color);
            canvas.drawRect(600, 200, 900, 1000, color);
            canvas.drawRect(1600, 200, 1900, 1000, color);
        } else {
            // draw hairstyle 3: shorter
            canvas.drawRect(700, 200, 1800, 550, color);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // for color SeekBars
        // makes the seekBar change the colors

        if (wasPressed == R.id.hairButton){
            // hair button pressed
            if (seekBar.getId() == R.id.redSeekBar){
                hairColorRed = progress;
            } else if (seekBar.getId() == R.id.greenSeekBar){
                hairColorGreen = progress;
            } else {
                hairColorBlue = progress;
            }
        } else if (wasPressed == R.id.eyesButton){
            // eyes button pressed
            if (seekBar.getId() == R.id.redSeekBar){
                eyeColorRed = progress;
            } else if (seekBar.getId() == R.id.greenSeekBar){
                eyeColorGreen = progress;
            } else {
                eyeColorBlue = progress;
            }
        } else {
            // skin button pressed
            if (seekBar.getId() == R.id.redSeekBar){
                skinColorRed = progress;
            } else if (seekBar.getId() == R.id.greenSeekBar){
                skinColorGreen = progress;
            } else {
                skinColorBlue = progress;
            }
        }

        invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // for color SeekBars
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // for color SeekBars
    }

    @Override
    public void onClick(View v) {
        // for randomFace button:
        // creates a new face when clicked
        randomize();
        invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // for spinner

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(myContext, text, Toast.LENGTH_SHORT).show();

        // change hair styles
        if (position == 0){
            // long
            hairStyle = 0;
            invalidate();
        } else if (position == 1){
            // short
            hairStyle = 1;
            invalidate();
        } else {
            // shorter
            hairStyle = 2;
            invalidate();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // for spinner

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // for radio group

        wasPressed = checkedId;

        // CRASHES THE CODE: COMMENTED OUT

        // creates seekbar objects
        /*SeekBar redSB = (SeekBar)findViewById(R.id.redSeekBar);
        SeekBar greenSB = (SeekBar)findViewById(R.id.greenSeekBar);
        SeekBar blueSB = (SeekBar)findViewById(R.id.blueSeekBar);

        // updates the seekbars
        if (wasPressed == R.id.hairButton){
            redSB.setProgress(hairColorRed);
            greenSB.setProgress(hairColorGreen);
            blueSB.setProgress(hairColorBlue);
        } else if (wasPressed == R.id.eyesButton){
            redSB.setProgress(eyeColorRed);
            greenSB.setProgress(eyeColorGreen);
            blueSB.setProgress(eyeColorBlue);
        } else if (wasPressed == R.id.skinButton){
            redSB.setProgress(skinColorRed);
            greenSB.setProgress(skinColorGreen);
            blueSB.setProgress(skinColorBlue);
        }*/

    }
}
