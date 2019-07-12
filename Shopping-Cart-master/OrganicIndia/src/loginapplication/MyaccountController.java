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
import javafx.stage.Stage;
import loginapplication.CartController;

/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class MyaccountController implements Initializable 
{

    /**
     * Initializes the controller class.
     */
    Stage dialogStage = new Stage();
    Scene scene;
    
    @FXML
    private Label label;
     
    @FXML
    private Label labe2;
    
    @FXML
    private Label labe3;
    
    @FXML
    private Label labe4;
    
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
        public void back(ActionEvent event) throws Exception
    {               
        try 
        {
           Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("MainPage.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
      public void Save(ActionEvent event) throws Exception
    {               
        try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Checkout.fxml")));
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
         try 
        {
            CartController fd=new CartController();
            String name=fd.Name();
            label.setText(name);
            
            String email=fd.Email();
            labe2.setText(email);
            
            String phone=fd.Phone();
            labe3.setText(phone);
            
            String adr=fd.Adr();
            labe4.setText(adr);
        } 
        catch (Exception ex) 
        {
        System.err.println(ex);
        }
    }    
    
}
