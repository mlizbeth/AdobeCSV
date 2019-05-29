package io.valhala.adobecsv.main;


import java.io.File;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/*
 * TODO
 * Set outFile via GUI.
 * Sort inFile before parsing 
 * Diff system
 * set mode via GUI
 * Clean up Writer.class
 */

public class Main extends Application {

	private Mode mode;
	private Label operationMode = new Label("Operation Mode");
	private CheckBox studentMode = new CheckBox("Student");
	private CheckBox staffMode = new CheckBox("Faculty/Staff");
	final FileChooser fileChooser = new FileChooser();
	
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
		vBox.getChildren().add(operationMode);
		vBox.getChildren().add(studentMode);
		vBox.getChildren().add(staffMode);
		
		Scene scene = new Scene(vBox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Comma Separated Values", "*.csv"));
		
		openItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				configureFileChooser(fileChooser);
				List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
				if(list != null) {
					for(File file : list) {
						/*
						 * TODO
						 * Read file data and store in HashTable or other viable structure.
						 */
						Writer writer = new Writer(Mode.STUDENT);
						writer.setInFile(file.toString());
					}
				}
			}
		});
	}
	
	private static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("Choose CSV File");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
	}
}
