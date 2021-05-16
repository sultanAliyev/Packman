
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
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

class MyPlayer implements Player{

	//Pacman
	private Circle packman; 

	private Map map; 
	//position object
	private Position position; 
	
	MyPlayer(Map map){
		this.map = map; 
		this.position = map.getStartPosition(); 
		//creating packman in the right place in the map
		packman = new Circle(position.getX()*map.getUnit()+25, position.getY()*map.getUnit()+25, map.getUnit()/2);
		//stroke color
		packman.setStroke(BLACK); 
		//Pacman colored
		packman.setFill(RED);
		//adding packman to the map
		this.map.getChildren().add(packman);
	}

	
	//following method as almost the same!!!
	public void moveUp(){
		//checking situation in the map
		position.setY(position.getY()-1);
		if (position.getY()<0) {
			position.setY(0); 
			wrong();
		}
		//checking situation with player
		else if (map.getMap()[position.getY()][position.getX()] != 1) packman.setCenterY(position.getY()*map.getUnit()+25);

		else {
			position.setY(position.getY()+1);
			wrong();
		}
	}

	public void moveLeft(){
		//checking situation in the map
		position.setX(position.getX()-1);
		if (position.getX()<0) {
			position.setX(0);
			wrong();
		}
		//checking situation with player
		else if (map.getMap()[position.getY()][position.getX()] != 1) packman.setCenterX(position.getX()*map.getUnit()+25);

		else {
			position.setX(position.getX()+1);
			wrong();
		}
	}

	public void moveDown(){
		//checking situation in the map
		position.setY(position.getY()+1);
		if (position.getY()>map.getSize()-1) {
			position.setY(map.getSize()-1);
			wrong();
		}
		//checking situation with player
		else if (map.getMap()[position.getY()][position.getX()] != 1) packman.setCenterY(position.getY()*map.getUnit()+25);

		else {
			position.setY(position.getY()-1);
			wrong();
		}
	}

	public void moveRight(){
		//checking situation in the map
		position.setX(position.getX()+1);
		if (position.getX()>map.getSize()-1) {
			position.setX(map.getSize()-1);
			wrong();
		}
		//checking situation with player
		else if (map.getMap()[position.getY()][position.getX()] != 1) packman.setCenterX(position.getX()*map.getUnit()+25);

		else {
			position.setX(position.getX()-1);
			wrong();
		}
	}

	//return position
	public Position getPosition(){
		return position;
	}

	
	public void wrong() {
		System.out.println("Invalid position!");
	}

}