package tw.edlo.apps.englishlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tw.edlo.apps.englishlearning.model.MyDataModel;

public class TestActivity extends AppCompatActivity {
    private TextView chinese_TV, score_TV;
    private EditText english_ET;
    private List<MyDataModel> words;
    private int word_count, score;
    private String answer, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
    }

    private void init(){
        word_count = score = 0;
        words = (ArrayList)getIntent().getSerializableExtra("words");
        title = "Your Score : ";
        // 將單字順序洗牌
        Collections.shuffle(words);

        chinese_TV = findViewById(R.id.chinese_TV);
        score_TV = findViewById(R.id.test_score);
        english_ET = findViewById(R.id.english_TV);
        test();
    }

    private void test(){
        final int total_test_word = 10;
        if(word_count < total_test_word){
            score_TV.setText(title + score);
            chinese_TV.setText(words.get(word_count).getChinese());
            english_ET.setText("");
            answer = words.get(word_count).getEnglish();
        }
    }

    public void submit(View view){
        String input = english_ET.getText().toString();
        if(input.length() > 0){
            if (answer.equals(input)){
                score += 10;
            }else {

            }
        }
        word_count++;
        test();
    }
}
