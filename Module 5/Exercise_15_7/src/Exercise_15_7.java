import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_15_7 extends Application
{

    @Override
    public void start( Stage stage )
    {
        Pane pane = new Pane();

        Circle circle = new Circle( 250, 250, 50 );
        circle.setFill( Color.WHITE );

        pane.setOnMouseReleased( event -> circle.setFill( Color.WHITE ) );
        pane.setOnMousePressed( event -> circle.setFill( Color.BLACK ) );
        pane.getChildren().add( circle );

        Scene scene = new Scene( pane, 500, 500 );
        stage.setTitle( "Exercise 15.7" );
        stage.setScene( scene );
        stage.show();
    }

    public static void main( String[] args )
    {
        launch( args );
    }

}
