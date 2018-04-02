package tw.edlo.apps.englishlearning.model;

import java.io.Serializable;

/**
 * Created by EdLo on 2018/4/1.
 */

public class MyDataModel implements Serializable{
    private String chinese;
    private String english;

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
