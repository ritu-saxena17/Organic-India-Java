/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class ThankuController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    Stage dialogStage = new Stage();
    Scene scene;
      
     public void Continue(ActionEvent event) throws Exception
    {               
        try 
        {  
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
  
     
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }   
    public static void main(String[] args)
    {
        File f1 = new File("items.txt");
        boolean success = f1.delete();

        if (!success)
        {
 
            System.out.println("Deletion failed.");

            System.exit(0);
        }
        else
        {
        System.out.println("File deleted.");
        }
    }
    
}
