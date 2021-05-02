package textstatistics;
 
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javax.swing.event.ChangeListener;
import javafx.scene.control.TextArea;
import javax.swing.event.ChangeEvent;
 
public class TextStatisticsApplication extends Application {
 
    @Override
    public void start(Stage piso){
        
        HBox fila = new HBox();
        
        
        BorderPane confi = new BorderPane();
        
        
        
        TextArea espacioBlanco = new TextArea();
        
        Label text1 = new Label("Letters: 0");
        Label text2 = new Label("Words: 0");
        Label text3 = new Label("The longest word is: ");
        
         //texto gigante
        
        fila.getChildren().addAll(text1,text2,text3); // creo hbox 
        fila.setSpacing(20);
        
        confi.setCenter(espacioBlanco);
        confi.setBottom(fila); //unbico la fila abajo
         //creo espacio blanco y lo pongo en el medio
        //creo listener en espacio blanco
        espacioBlanco.textProperty().addListener( (cambio, vantiguo, vnuevo) -> {
            //cantidad de letras
            int cletras = vnuevo.length(); // c letras
            String[] vvPalabras = vnuevo.split(" ");// c palabras
            int cpalabras = vvPalabras.length;
            
            //palabra mas larga, creo stream
            String maxPal = Arrays.stream(vvPalabras)
                    .sorted( (p1, p2) -> p2.length() - p1.length())
                    .findFirst() // agarra el elemento que quedo tope en el Array
                    .get();
            
        
            //
            text1.setText("Letters: " + cletras);
            text2.setText("Words: " + cpalabras);
            text3.setText("The longest word is: " + maxPal);
            });
            //creo scene
            
        
        //creo labels, las uno en hbox. luego las pongo abajo.
        
        
        
        Scene vista = new Scene(confi);
        
        piso.setScene(vista);
        piso.show();
        
    
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        
        System.out.println("Hello world!");
    }
 
}