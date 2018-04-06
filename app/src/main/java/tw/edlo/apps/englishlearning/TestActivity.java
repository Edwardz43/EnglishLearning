package tw.edlo.apps.englishlearning;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tw.edlo.apps.englishlearning.model.MyDataModel;

public class TestActivity extends AppCompatActivity {
    private TextView chinese_TV, score_TV;
    private EditText english_ET;
    private List<MyDataModel> words;
    private int word_count, score;
    private String answer, title, input;
    private boolean isGameOver;
    private FloatingActionButton retry_btn;
    private SimpleAdapter adapter;
    private List<HashMap<String, String>> hist;
    private ListView listView;
    private String[] from = {"index", "chinese", "english", "input", "result"};
    private int[] to = {R.id.index_word, R.id.chinese_word, R.id.english_word, R.id.input, R.id.result};

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
        isGameOver = false;
        hist = new ArrayList<>();
        listView = findViewById(R.id.hist);
        adapter = new SimpleAdapter(this, hist, R.layout.layout_hist_row, from, to);
        listView.setAdapter(adapter);

        // 將單字順序洗牌
        Collections.shuffle(words);

        chinese_TV = findViewById(R.id.chinese_TV);
        score_TV = findViewById(R.id.test_score);
        english_ET = findViewById(R.id.english_TV);
        retry_btn = findViewById(R.id.retry_btn);

        english_ET.setVisibility(View.VISIBLE);
        chinese_TV.setVisibility(View.VISIBLE);
        retry_btn.setVisibility(View.GONE);
        test();
    }

    private void test(){
        final int total_test_word = 10;
        if(word_count < total_test_word){
            score_TV.setText(title + score);
            chinese_TV.setText(words.get(word_count).getChinese());
            english_ET.setText("");
            answer = words.get(word_count).getEnglish();
        }else {
            isGameOver = true;
            retry_btn.setVisibility(View.VISIBLE);
            english_ET.setVisibility(View.GONE);
            chinese_TV.setVisibility(View.GONE);

            show_hist();
        }
    }

    private void show_hist() {
        adapter.notifyDataSetChanged();
    }

    public void submit(View view){
        if(!isGameOver){
            input = english_ET.getText().toString();

            HashMap<String, String> hist_map = new HashMap<>();
            hist_map.put(from[3], input);
            hist_map.put(from[0], "" + (word_count + 1));
            hist_map.put(from[1], chinese_TV.getText().toString());
            hist_map.put(from[2], answer);
            if(input.length() > 0){
                if (answer.equals(input)){
                    score += 10;
                    hist_map.put(from[4], "O");
                }else {
                    hist_map.put(from[4], "X");
                }
            }else{
                hist_map.put(from[4], "X");
            }
            hist.add(hist_map);
            adapter.notifyDataSetChanged();
            word_count++;
            test();
        }
    }

    public void retry(View view){
        init();
    }
}
