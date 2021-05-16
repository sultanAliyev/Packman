import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import static javafx.scene.paint.Color.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.*;
import java.io.*;
import java.util.*;

public class Game extends Application{
	//creating objects
	private static Map map;
	private static Player player;
	private static Food food;
	
	public void start(Stage primaryStage){
		//initialization of ofjects
		player = new MyPlayer(map);
		food = new Food(map, player);
		Scene scene = new Scene(map);

//event-handler for movment of packman
		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case RIGHT:
					player.moveRight();
					break;
				case LEFT:
					player.moveLeft();
					break;
				case UP:
					player.moveUp();
					break;
				case DOWN:
					player.moveDown();
					break;
			}
		});

		primaryStage.setScene(scene);
		primaryStage.setTitle("Week 13");
		primaryStage.show();
	}
	//launching start method in main
	public static void main(String[] args){
		try{
			map = new Map(args[0]);
			launch(args);
		}
		catch (IndexOutOfBoundsException e){
			//creating scanner
			Scanner scanner = new Scanner(System.in);
			//reading map.txt
			map = new Map(scanner.next());
		}
	}
}