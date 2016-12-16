package com.rcorp.kidselearning;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rcorp.kidselearning.com.rcorp.kidselearning.managers.com.rcorp.kidselearning.managers.ExercicesManager;

public class ExerciceActivity extends Activity {

    TextView Question;
    EditText Response;
    Button Submit;
    ProgressBar m_Bar;
    ExercicesManager m_ExerciceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        Question = (TextView) findViewById(R.id.QuestionTextView);
        Response = (EditText) findViewById(R.id.ResponsesEdit);
        Submit = (Button) findViewById(R.id.SubmitBtn);
        m_Bar = (ProgressBar) findViewById(R.id.progressBar);
        m_ExerciceManager = new ExercicesManager(ExercicesManager.ExerciceType.valueOf(getIntent().getStringExtra("ExerciceType")), getResources());
        Question.setText(m_ExerciceManager.GetNextQuestion());
        m_Bar.setMax(11);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question.setText(m_ExerciceManager.GetNextQuestion());
                Response.setText("");
                m_Bar.setProgress(m_ExerciceManager.getQuestionState());
            }
        });
    }


}
