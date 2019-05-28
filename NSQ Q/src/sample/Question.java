package sample;

import java.util.Arrays;
import java.util.List;

public class Question{
    private String name;
    private List<String> answers;

    public Question (String name, String... answers){
        this.name = name;
        this.answers = Arrays.asList(answers);
    }

    public String getName() {
        return name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer(){
        return answers.get(0);
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
