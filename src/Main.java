import org.jfugue.player.Player;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			
			int height = 750;
			int width = 1000;
			StackPane root = new StackPane();
			Player player = new Player();
			
			root.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					double x = event.getSceneX();
					double y = event.getSceneY();
					
					System.out.println("Position x: " + x);
					System.out.println("Position y: " + y);
					
					int pitch = 127 - (int) (y*127/height);
					int volume = (int) (x*16383/width);
					
					System.out.println("Pitch : " + pitch);
					System.out.println("Volume: " + volume);
					
					player.play("X[Volume]=" + volume + " " + Integer.toString(pitch));
					
				}
				
			});
			
			primaryStage.setTitle("Music App");
			primaryStage.setScene(new Scene(root, width, height));
			primaryStage.show();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
