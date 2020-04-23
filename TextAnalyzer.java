package application;

/**
 * <h1>Word Occurrences</h1>
 * The program counts the number of a times words
 * appears in the text.
 * 
 * I have no idea how much detail you wanted documented.
 * So I just did the basics.
 * 
 * @author Teresa Scudder 
 * @version 3.0
 * @since 4/1/2020
 */

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TextAnalyzer extends Application {

	/**
	 * Override method to produce the output *
	 * 
	 * @param s first parameter in the start method
	 * @return Output
	 */

	@Override
	public void start(Stage s) {

		// title for the stage
		s.setTitle("Text Analyzer");

		// create a button
		Button button = new Button("Click to run");

		// create a stack pane
		TilePane title = new TilePane();

		// create a label
		Label l = new Label("Word          :          Count");

		// Read in the file
		URLReader obj = new URLReader();

		// run
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

			private Labeled TextLine;

			@Override
			public void handle(ActionEvent e) {

				// mapping the array
				Map<String, Integer> map;

				// variables
				String inputString = null;

				if (inputString == null) {
					
					// string from URLReader
					try {
						inputString = obj.main();
					} catch (MalformedURLException e2) {
						e2.printStackTrace();
					}
					// word array
					String[] wordsArray = inputString.split("\\s+");
					map = new HashMap<>();
					String[] var10 = wordsArray;
					int var9 = wordsArray.length;
					// count words
					for (int var8 = 0; var8 < var9; ++var8) {
						String word = var10[var8];
						if (map.containsKey(word)) {
							int count = map.get(word);
							map.put(word, count + 1);
						} else {
							map.put(word, 1);
						}

					}
					// output
					Iterator<Entry<String, Integer>> var13 = map.entrySet().iterator();
					while (var13.hasNext()) {
						Entry<String, Integer> entry = (Entry<String, Integer>) var13.next();
						this.TextLine.setText((String) entry.getKey() + " : " + entry.getValue());
					}
				}else {
					System.out.println("NullPointerException thrown!");
				}

			}

		};

		// when button is pressed
		button.setOnAction(event);

		// add button
		title.getChildren().add(button);

		title.getChildren().add(l);

		Scene scene = new Scene(title, 400, 400);

		s.setScene(scene);
		s.show();

		// }
	}

	/**
	 * This is the main method which produces the window and contents from the start
	 * method
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		launch(args);
		// CreateTable();
	}

	/*
	 * public static void post() throws Exception{
	 * 
	 * final String var1 = "the";
	 * 
	 * try { Connection con = getConnection(); PreparedStatement posted =
	 * con.prepareStatement("entry.getKey"); } finally { System.out.println("nope");
	 * } }
	 * 
	 * private static PreparedStatement prepareStatement(String string) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public static void CreateTable() throws Exception{ try { Connection con =
	 * getConnection(); PreparedStatement create = con.
	 * prepareStatement("CREATE TABLE IF NOT EXISTS word(id int NOT NULL AUTO_INCREMENT, words varchar(50), count int"
	 * ); create.executeUpdate();
	 * 
	 * }catch(Exception e) { System.out.print(e); } finally
	 * {System.out.println("Function Complete!");} }
	 * 
	 * 
	 * public static Connection getConnection() throws Exception{
	 * 
	 * try { String driver = "com.mysql.jdbc.Driver"; String url =
	 * "jdbc:mysql://localhost:3306/wordOccurences"; Class.forName(driver);
	 * 
	 * Connection conn = DriverManager.getConnection(url);
	 * System.out.print("it worked"); return conn;
	 * 
	 * }catch(Exception e) {System.out.println(e);}
	 * 
	 * return null;
	 * 
	 * }
	 */
}
