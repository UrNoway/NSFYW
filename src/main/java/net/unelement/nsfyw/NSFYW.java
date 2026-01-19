package net.unelement.nsfyw;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Not Safe For Your Wife
 */
public class NSFYW {

    static void main(String[] args) {
        App.main(args);
    }

    public static class App extends Application {

        public static void main(String[] args) {
            Application.launch(App.class, args);
        }

        @Override
        public void start(Stage stage) {
            stage.setTitle("Hello World!");

            WebView webView = new WebView();

            webView.getEngine().load("https://www.google.fr");

            VBox vBox = new VBox(webView);
            Scene scene = new Scene(vBox, 960, 600);

            stage.setScene(scene);
            stage.show();
        }
    }
}
