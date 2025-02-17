import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise_16_17 extends Application
{

    @Override
    public void start( Stage stage )
    {
        Label text = new Label( "Some Text!" );
        text.setTextFill( Color.rgb( 255, 0, 0 ) );
        text.setFont( new Font("Arial", 70) );

        ScrollBar redScrollBar = new ScrollBar(), greenScrollBar = new ScrollBar(), blueScrollBar = new ScrollBar();

        redScrollBar.setMax( 0 );
        redScrollBar.setMax( 255 );
        redScrollBar.setValue( 0 );
        redScrollBar.setBlockIncrement( 1 );

        redScrollBar.valueProperty().addListener( ( obs, oldValue, newValue ) ->
        {
            text.setTextFill( Color.rgb( newValue.intValue(), (int) greenScrollBar.getValue(), (int) blueScrollBar.getValue() ) );
        } );

        greenScrollBar.setMax( 0 );
        greenScrollBar.setMax( 255 );
        greenScrollBar.setValue( 0 );
        greenScrollBar.setBlockIncrement( 1 );

        greenScrollBar.valueProperty().addListener( ( obs, oldValue, newValue ) ->
        {
            text.setTextFill( Color.rgb( (int) redScrollBar.getValue(), newValue.intValue(), (int) blueScrollBar.getValue() ) );
        } );

        blueScrollBar.setMax( 0 );
        blueScrollBar.setMax( 255 );
        blueScrollBar.setValue( 0 );
        blueScrollBar.setBlockIncrement( 1 );

        blueScrollBar.valueProperty().addListener( ( obs, oldValue, newValue ) ->
        {
            text.setTextFill( Color.rgb( (int) redScrollBar.getValue(), (int) greenScrollBar.getValue(), newValue.intValue() ) );
        } );

        ScrollBar opactiyScrollBar = new ScrollBar();
        opactiyScrollBar.setMin( 0 );
        opactiyScrollBar.setMax( 100 );
        opactiyScrollBar.setValue( 100 );
        opactiyScrollBar.setBlockIncrement( 1 );

        opactiyScrollBar.valueProperty().addListener( ( obs, oldValue, newValue ) ->
        {
            text.setOpacity( newValue.intValue() / 100.0 );
        } );

        VBox layout = new VBox( 10 );
        layout.setAlignment( Pos.CENTER );
        layout.getChildren().addAll( text, redScrollBar, greenScrollBar, blueScrollBar, opactiyScrollBar );

        Scene scene = new Scene( layout, 500, 500 );
        stage.setTitle( "Exercise 16.17" );
        stage.setScene( scene );
        stage.show();
    }

    public static void main( String[] args )
    {
        launch( args );
    }
}
