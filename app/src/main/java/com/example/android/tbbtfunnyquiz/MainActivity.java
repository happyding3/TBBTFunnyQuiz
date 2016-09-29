package com.example.android.tbbtfunnyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.tbbtfunnyquiz.R.id.question1;

public class MainActivity extends AppCompatActivity {
    RadioButton answer1;
    CheckBox Zack;
    CheckBox Kurt;
    CheckBox Doug;
    CheckBox Eric;
    CheckBox Justin;
    CheckBox David;
    EditText answer3;
    RadioButton answer4;
    int score = 0;
    RadioGroup question1AWS;
    RadioGroup question4AWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1 = (RadioButton) findViewById(R.id.correct_answer1);
        Zack = (CheckBox) findViewById(R.id.zack_answer2);
        Kurt = (CheckBox) findViewById(R.id.kurt_answer2);
        Doug = (CheckBox) findViewById(R.id.doug_answer2);
        Eric = (CheckBox) findViewById(R.id.eric_answer2);
        Justin = (CheckBox) findViewById(R.id.justin_answer2);
        David = (CheckBox) findViewById(R.id.david_answer2);
        answer3= (EditText) findViewById(R.id.answer3);
        answer4 = (RadioButton) findViewById(R.id.correct_answer4);
        question1AWS= (RadioGroup) findViewById(R.id.question1_Asw);
        question4AWS= (RadioGroup) findViewById(R.id.question4_Asw);
    }

    public void submit(View view) {
        String reward="It's no wonder you are a TEAL fan of TBBT!!!";
        String answer=q1()+q2()+q3()+q4();
        String toast;
        if(score==4){
            toast=answer+reward;
        }else {
            toast=answer;
        }
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    public String q1() {
        String question1Answer;
        if (answer1.isChecked()) {
            question1Answer = "1, correct"+"\n";
            score = score + 1;
        } else {
            question1Answer = "1, wrong, the right answer is " + answer1.getText()+"\n";
        }
        return question1Answer;
    }

    public String q2() {
        String question2Answer;
        if (Zack.isChecked() && Kurt.isChecked() && Doug.isChecked() && Eric.isChecked() && Justin.isChecked() && David.isChecked()) {
            question2Answer = "2, correct, it's amazing you remember all of them!!!"+"\n";
            score = score + 1;
        } else {
            question2Answer = "2, wrong, think it over!"+"\n";
        }
        return question2Answer;
    }

    public String q3() {
        String question3Answer;
        String answer3_1="Amy";
        String answer3_2="Amy Farrah Fowler";
        String answer3_3="Dr.Amy Farrah Fowler";
        String question3_input= String.valueOf(answer3.getText());
        if (question3_input.equalsIgnoreCase(answer3_1)|question3_input.equalsIgnoreCase(answer3_2)|question3_input.equalsIgnoreCase(answer3_3)) {
            question3Answer = "3, correct"+"\n";
            score = score + 1;
        } else {
            question3Answer = "3, wrong, it is Amy!"+"\n";
        }
        return question3Answer;
    }
    public String q4() {
        String question4Answer;
        if (answer4.isChecked()) {
            question4Answer = "4, correct"+"\n";
            score = score + 1;
        } else {
            question4Answer = "4, wrong, the right answer is yes and this question should be mastered by physics Master!" +"\n";
        }
        return question4Answer;
    }
    public void retry(View view){
        question1AWS.clearCheck();
        Zack.setChecked(false);
        Kurt.setChecked(false);
        Doug.setChecked(false);
        Eric.setChecked(false);
        Justin.setChecked(false);
        David.setChecked(false);
        answer3.getText().clear();
        question4AWS.clearCheck();
        score=0;
    }


}
