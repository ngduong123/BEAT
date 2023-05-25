package main.java.controllers;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.plaf.RootPaneUI;

public class MainController implements Initializable {
    
    Parent root = null;

    @FXML
    private ImageView imvLogo;
    @FXML
    private Label lblLogo;
    @FXML
    private ImageView imvClose;
    @FXML
    private ImageView imvResize;
    @FXML
    private ImageView imvMinimize;
    @FXML
    private VBox vbxLeftSideBar;
    @FXML
    private AnchorPane acpWindowTitleBar;
    @FXML
    private BorderPane bdpContentTab;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnLikedTracks;
    @FXML
    private Button btnAboutUs;
    @FXML
    private Button btnLogIn;
    
    private Button[] btnLeftSideBar;
    
    public void removeColorLeftSideBar() {
        for(Button btn : btnLeftSideBar) {
            btn.setStyle("-fx-text-fill: #505050;");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLeftSideBar = new Button[] {btnHome, btnSearch, btnLikedTracks, btnAboutUs, btnLogIn};
        
        //on open
        btnHome.setStyle("-fx-text-fill: #000;");
        try {
            root = FXMLLoader.load(new File("src/main/resources/views/Home.fxml").toURI().toURL());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        bdpContentTab.setCenter(root);
    }    

    
    
    @FXML
    private void openTab(ActionEvent event) {
        Object node = event.getSource();
        Button btn = (Button)node;
        
        removeColorLeftSideBar();
        btn.setStyle("-fx-text-fill: #000;");
        
        String tabName = btn.getText().replace(" ", "");
        try {
            root = FXMLLoader.load(new File("src/main/resources/views/" + tabName + ".fxml").toURI().toURL());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        bdpContentTab.setCenter(root);
    }

    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void resize(MouseEvent event) {
//        Stage stage = (Stage) imvResize.getScene().getWindow();
//
//        if (stage.isFullScreen()) {
//            stage.setFullScreen(false);
//        }
//        else {
//            stage.setFullScreen(true);
//        }
    }

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage = (Stage) imvMinimize.getScene().getWindow();
        stage.setIconified(true);
    }

}
