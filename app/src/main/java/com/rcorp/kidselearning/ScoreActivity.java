package com.rcorp.kidselearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreActivity extends Activity {

    TextView scoreText;
    RelativeLayout TouchArea;
    ScoreActivity m_Instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_Instance = this;
        setContentView(R.layout.activity_score);
        scoreText = (TextView) findViewById(R.id.ScoreText);
        TouchArea = (RelativeLayout) findViewById(R.id.activity_score);
        scoreText.setText("Well done, your score is " + getIntent().getStringExtra("SCORE") + "/10");
        TouchArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(m_Instance, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
