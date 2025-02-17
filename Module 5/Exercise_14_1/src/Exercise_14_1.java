import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_14_1 extends Application
{

    @Override
    public void start( Stage stage )
    {
        GridPane grid = new GridPane();

        grid.setVgap( 10 );
        grid.setHgap( 10 );

        String[] images = { "flag1.gif", "flag2.gif", "flag6.gif", "flag7.gif" };

        int row = 0;
        int col = 0;
        for (String imageString : images)
        {
            Image image = new Image( "images/" + imageString );

            ImageView imageView = new ImageView(image);
            imageView.setFitHeight( 250 );
            imageView.setFitWidth( 250 );

            grid.add( imageView, row, col );

            col++;

            if (col == 2)
            {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 500, 500);
        stage.setTitle( "Exercise 14.1" );
        stage.setScene( scene );

        stage.show();
    }

    public static void main( String[] args )
    {
        launch( args );
    }

}
