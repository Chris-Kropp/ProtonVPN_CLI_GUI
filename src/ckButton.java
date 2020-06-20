import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ckButton extends Node {
    private int height;
    private int width;
    private String text;
    private Color mainColor;
    private Color borderColor;
    private int borderWidth;

    public ckButton(int width, int height, String text, Color mainColor, Color borderColor, int borderWidth){
        this.height = height;
        this.width = width;
        this.text = text;
        this.mainColor = mainColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
    }

    public StackPane buildButton(){
        StackPane sp = new StackPane();
        Rectangle borderBox = new Rectangle(width, height, borderColor);
        borderBox.setArcHeight(width);
        borderBox.setArcHeight(width);
        Rectangle mainBox = new Rectangle(width-borderWidth, height-borderWidth, mainColor);
        borderBox.setArcHeight(width-borderWidth);
        borderBox.setArcHeight(width-borderWidth);
        Text text = new Text(this.text);
        sp.getChildren().addAll(borderBox, mainBox, text);
        return sp;
    }
}
