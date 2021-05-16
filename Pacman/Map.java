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

public class Map extends Pane{
Scanner scan = new Scanner(System.in);
	//creating objects
	//size of cells in px
	private int unit = 50;
	 //size of the map
	private int size = scan.nextInt();
 	//map presented as a matrix
	private int[][] map;
	//starting position
	private Position start; 

	public Map(String map){
		//loading our map from map.txt
		load(new File(map));
		//algorithm for creating cells for the map
		for (int i = 0; i<this.map.length; i++){
			for (int j = 0; j<this.map[i].length; j++){
				//creating map cells
				Rectangle cells = new Rectangle((j*unit), (i*unit),unit, unit); 
				//giving color
				cells.setFill(WHITE); 
				//setting strokes for cells
				cells.setStroke(BLACK); 
				if (this.map[i][j] == 1){cells.setFill(BLACK);}
				//adding the cells to the map
				this.getChildren().add(cells); 
			}
		}
	}

	public int getUnit(){
		return unit;
	}

	public int getSize(){
		return size;
	}

	public int[][] getMap(){
		return map;
	}

	public String toString(){
		return Arrays.deepToString(map);
	}

	public Position getStartPosition(){
		return start;
	}

	public int getValueAt(int x, int y) {
		return map[y][x];
	}

	//My additional method for reading txt file
	public void load(File file){
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			read(scanner);
		}
		catch (FileNotFoundException localFileNotFoundException) {System.out.println("Map does not exist!");}
	}

	public void read(Scanner scan){
		map = new int[size][size];
		int index = 0;
		while (scan.hasNext()){
			String[] temp = scan.nextLine().split(" ");
			for (int i = 0; i<size; i++){
				map[index][i] = Integer.parseInt(temp[i]);
				if (map[index][i]==2){
					start = new Position(i, index);
				}
			} 
			index++;
		}
	}
}
					