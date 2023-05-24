import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class    PainterController {
    // enum representing pen sizes
    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private final int radius;
        // constructor
        PenSize(int radius){
            this.radius = radius;
        }
        public int getRadius(){
            return radius;
        }
    }; // end PenSize

    // instance variables for managing Painter state
    private PenSize radius = PenSize.MEDIUM; // radius of circle
    private Paint brushColor = Color.BLACK; // drawing color

    // instance variable that refer to GUI objects
    @FXML
    private RadioButton blackRadioButton;
    @FXML
    private RadioButton blueRadioButton;
    @FXML
    private RadioButton greenRadioButton;
    @FXML
    private RadioButton redRadioButtom;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Color)colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private Button clearButton;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        dreawingAreaPane.getChildren().clear();
    }

    @FXML
    private RadioButton largeRadioButton;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton smallRadioButton;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        // user data for each size radioButton is the corresponding PenSize
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private Button undoButton;
    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = dreawingAreaPane.getChildren().size();
        // if there are shapes remove the last one added
        if(count > 0){
            dreawingAreaPane.getChildren().remove(count-1);
        }
    }

    @FXML
    private Pane dreawingAreaPane;
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(),
                radius.getRadius(), brushColor);
        dreawingAreaPane.getChildren().add(newCircle);
    }

    // set user data for the RadioButtons
    public void initialize(){
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButtom.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }
}
