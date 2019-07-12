/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import loginapplication.BakeryController;
import loginapplication.DairyproductsController;
import static loginapplication.FXMLDocumentController.names;
import loginapplication.FarmFreshController;
import loginapplication.CartController;

/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class CheckoutController implements Initializable 
{

    /**
     * Initializes the controller class.
     */
    @FXML TextArea YourTextArea;
    
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
    
     public void Place(ActionEvent event) throws Exception
    {               
        try 
        {
           Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Thanku.fxml")));
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
         public void back(ActionEvent event) throws Exception
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
         
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       try 
        {   
            BakeryController bc = new BakeryController();
            float bill1= bc.returnbill();
            DairyproductsController dc = new DairyproductsController();
            float bill2= dc.returnbill();
            FarmFreshController fc = new FarmFreshController();
            float bill3= fc.returnbill();
            float bill=bill1+bill2+bill3;
            String b1=Float.toString(bill);
            YourTextArea.appendText("\n  Rs. "+b1); 
            
            
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
