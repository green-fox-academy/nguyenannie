import java.awt.Color;

public class PostIt {
    Color backgroundColor ;
    String text;
    Color textColor;

    public void setBackgroundColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }
    public Color getBackgroundColor(Color backgroundColor){
        return this.backgroundColor;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText(String text) {
        return this.text;
    }

    public void setTextColor(Color textColor){
        this.textColor = textColor;
    }
    public Color getTextColor(Color textColor){
        return this.textColor;
    }
}
