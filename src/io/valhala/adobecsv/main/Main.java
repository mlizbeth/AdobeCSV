package io.valhala.adobecsv.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * TODO
 * Set inFile and outFile via GUI.
 * Sort inFile before parsing 
 * Diff system
 * set mode via GUI
 */

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Adobe CSV Tool");
		primaryStage.setHeight(300);
		primaryStage.setWidth(400);
		
		MenuBar menu = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem openItem = new MenuItem("Open");
		menu.getMenus().add(fileMenu);
		fileMenu.getItems().add(openItem);
		
		VBox vBox = new VBox(menu);
		
		Scene scene = new Scene(vBox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Writer writer = new Writer(Mode.STUDENT);
		
	}

}
