/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import loginapplication.FXMLDocumentController;
import loginapplication.FXMLMenuController;
/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class MainPageController implements Initializable
{
    @FXML
    private AnchorPane rootpane;
    
    @FXML
    private Label label;
    
    
    /**
     * Initializes the controller class.
     */
    Stage dialogStage = new Stage();
    Scene scene;
    
     public void MyOrder(ActionEvent event) throws Exception
    {               
        try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Cart.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
      public void MyAccount(ActionEvent event) throws Exception
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
    public void Bakery(ActionEvent event) throws Exception
    {               
        try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Bakery.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void Diary(ActionEvent event) throws Exception
    {               
        try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Dairyproducts.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void Veg(ActionEvent event) throws Exception
    {               
        try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("FarmFresh.fxml")));
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
        FXMLDocumentController fd=new FXMLDocumentController();
        String name=fd.returnnames();
        label.setText(name);
        
        FXMLMenuController fm=new FXMLMenuController();
        String name1=fm.returnnames();
        label.setText(name1);
        
    }   
}
