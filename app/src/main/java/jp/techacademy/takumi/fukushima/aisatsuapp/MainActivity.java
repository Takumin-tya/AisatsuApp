package jp.techacademy.takumi.fukushima.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textTime;
    TextView aisatu;
    int startHour = 0;
    int stratMinute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timeSetButton = (Button) findViewById(R.id.timeSetButton);
        timeSetButton.setOnClickListener(this);

        textTime = (TextView) findViewById(R.id.textTime);
        aisatu = (TextView) findViewById(R.id.aisatu);

        textTime.setText(String.valueOf(startHour) + ":" + String.valueOf(stratMinute));

    }

    @Override
    public void onClick(View v){

        showTimePickerDialog();

    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        textTime.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (2 <= hourOfDay && hourOfDay < 10){
                            aisatu.setText("おはよう");
                        }else if (10 <= hourOfDay && hourOfDay < 18){
                            aisatu.setText("こんにちは");
                        }else {
                            aisatu.setText("こんばんは");
                        }
                        startHour = hourOfDay;
                        stratMinute = minute;
                    }
                },
                startHour,
                stratMinute,
                true);

        timePickerDialog.show();
    }
}