package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class QueList extends VBox {
    private int current =1 ;
    public  QueList(){
        super(10);
        for (int i = 15; i>0;i--){
            Text text = new Text("Question" + i);
            text.setFill(i == current ? Color.DARKBLUE : Color.RED);
            getChildren().add(text);
        }
    }
    public void selectNext(){
        if (current == 15){
            return;
        }
        Text text = (Text)getChildren().get(15 - current);
        text.setFill(Color.DARKVIOLET);
        current++;
        text = (Text)getChildren().get(15 - current);
        text.setFill(Color.DARKBLUE);
    }
}
