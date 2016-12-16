package com.rcorp.kidselearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rcorp.kidselearning.com.rcorp.kidselearning.managers.ExercicesManager;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends Activity {

    ImageButton AddBtn;
    ImageButton MultiBtn;
    ImageButton DivBtn;
    ImageButton SubBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddBtn = (ImageButton) findViewById(R.id.AddBtn);
        MultiBtn = (ImageButton) findViewById(R.id.MultiBtn);
        DivBtn = (ImageButton) findViewById(R.id.DivBtn);
        SubBtn = (ImageButton) findViewById(R.id.SubBtn);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartExercice(ExercicesManager.ExerciceType.ADD);
            }
        });

        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartExercice(ExercicesManager.ExerciceType.SUB);
            }
        });

        MultiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartExercice(ExercicesManager.ExerciceType.MUL);
            }
        });

        DivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartExercice(ExercicesManager.ExerciceType.DIV);
            }
        });
    }

    public void StartExercice(ExercicesManager.ExerciceType p_Type)
    {
        Intent intent = new Intent(this, ExerciceActivity.class);
        intent.putExtra("ExerciceType", p_Type.toString());
        startActivity(intent);
    }
}
