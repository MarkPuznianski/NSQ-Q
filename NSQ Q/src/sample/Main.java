package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {

    private static QuestionD q = new QuestionD();
    private static QueList ql = new QueList();
    private static File file = new File("questions.txt");

    private Parent createContent() throws IOException {
        HBox root = new HBox(40);
        root.setPadding(new Insets(40,40,40,40));
        root.setBackground(new Background(new BackgroundFill(Color.MEDIUMAQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

        BufferedReader b = new BufferedReader(new FileReader(file));
        String s = b.readLine();
        String[] s1 = s.split("_");
        q.setQuestion(new Question(s1[0], s1[1], s1[2], s1[3], s1[4]));
        root.getChildren().addAll( q, ql);

        return root;
    }

    public static String str(int n, int i) throws IOException {
        List <String> lines = Files.readAllLines(Paths.get("questions.txt"), StandardCharsets.UTF_8);
        String s [] = lines.get(n).split("_");
        return s[i];
    }

    public static void nextQuestion(int j) throws IOException {
        switch (j) {
            case 1:
                q.setQuestion(new Question(str(1,0), str(1,1), str(1,2), str(1,3), str(1,4)));
            ql.selectNext();
            break;
            case 2:
                q.setQuestion(new Question(str(2,0), str(2,1), str(2,2), str(2,3), str(2,4)));
                ql.selectNext();
                break;
            case 3:
                q.setQuestion(new Question(str(3,0), str(3,1), str(3,2), str(3,3), str(3,4)));
                ql.selectNext();
                break;
            case 4:
                q.setQuestion(new Question(str(4,0), str(4,1), str(4,2), str(4,3), str(4,4)));
                ql.selectNext();;
                break;
            case 5:
                q.setQuestion(new Question(str(5,0), str(5,1), str(5,2), str(5,3), str(5,4)));
                ql.selectNext();
                break;
            case 6:
                q.setQuestion(new Question(str(6,0), str(6,1), str(6,2), str(6,3), str(6,4)));
                ql.selectNext();
                break;
            case 7:
                q.setQuestion(new Question(str(7,0), str(7,1), str(7,2), str(7,3), str(7,4)));
                ql.selectNext();
                break;
            case 8:
                q.setQuestion(new Question(str(8,0), str(8,1), str(8,2), str(8,3), str(8,4)));
                ql.selectNext();
                break;
            case 9:
                q.setQuestion(new Question(str(9,0), str(9,1), str(9,2), str(9,3), str(9,4)));
                ql.selectNext();
                break;
            case 10:
                q.setQuestion(new Question(str(10,0), str(10,1), str(10,2), str(10,3), str(10,4)));
                ql.selectNext();
                break;
            case 11:
                q.setQuestion(new Question(str(11,0), str(11,1), str(11,2), str(11,3), str(11,4)));
                ql.selectNext();
                break;
            case 12:
                q.setQuestion(new Question(str(12,0), str(12,1), str(12,2), str(12,3), str(12,4)));
                ql.selectNext();
                break;
            case 13:
                q.setQuestion(new Question(str(13,0), str(13,1), str(13,2), str(13,3), str(13,4)));
                ql.selectNext();
                break;
            case 14:
                q.setQuestion(new Question(str(14,0), str(14,1), str(14,2), str(14,3), str(14,4)));
                ql.selectNext();
                break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
