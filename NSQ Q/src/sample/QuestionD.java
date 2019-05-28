package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sample.Main.nextQuestion;

public class QuestionD extends VBox {
    private Text text = new Text();
    private Text textResult = new Text();
    private Text textHead = new Text();
    private Text score = new Text();
    private List<Button> buttons = new ArrayList<>();
    private Button exitB = new Button();
    private Question current;
    private int j;

    public QuestionD(){
        super(50);
        HBox hbo = new HBox();
        text.setFont(Font.font("Verdana",18));
        textResult.setFont(Font.font("Lucida Console",17));
        score.setFont(Font.font("Century Gothic", 16));
        score.setFill(Color.INDIGO);
        j=0;
        for (int i = 0; i<4;i++)
        {
            Button b = new Button();
            b.setPrefWidth(120);
            b.setFont(Font.font(18));
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (b.getText().equals(current.getCorrectAnswer())) {
                        j++;
                        try {
                            nextQuestion(j);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        textResult.setText("Correct!");
                        textResult.setFill(Color.DARKGREEN);
                        score.setText("Score: " + j);
                        if (j==15) {
                            textResult.setFill(Color.FIREBRICK);
                            textResult.setText("Congratulations! You have completed the quiz!");
                            exitB.setText("EXIT");
                            getChildren().addAll(exitB);
                        }

                    } else {
                        textResult.setText("Inorrect");
                        textResult.setFill(Color.RED);
                    }
                }
            });
            buttons.add(b);
            hbo.getChildren().add(b);
        }
        exitB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
        });
        textHead.setFont(Font.font("Bookman",24));
        textHead.setText("SPACE QUIZ");
        setAlignment(Pos.CENTER);
        getChildren().addAll(textHead, text, hbo, textResult, score);
    }

    public void setQuestion(Question que){
        current = que;
    text.setText(que.getName());
    Collections.shuffle(buttons);
    for (int i = 0; i < 4; i++){
        buttons.get(i).setText(que.getAnswers().get(i));
        }
    }
}
