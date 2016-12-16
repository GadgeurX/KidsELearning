package com.rcorp.kidselearning;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.rcorp.kidselearning.com.rcorp.kidselearning.managers.ExercicesManager;

public class ExerciceActivity extends Activity {

    TextView Question;
    EditText Response;
    ExercicesManager m_ExerciceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        Question = (TextView) findViewById(R.id.QuestionTextView);
        Response = (EditText) findViewById(R.id.ResponsesEdit);
        m_ExerciceManager = new ExercicesManager(ExercicesManager.ExerciceType.valueOf(getIntent().getStringExtra("ExerciceType")));
        Question.setText(m_ExerciceManager.GetNextQuestion());
    }
}
