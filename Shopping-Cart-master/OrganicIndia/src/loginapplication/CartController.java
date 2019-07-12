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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static loginapplication.FXMLDocumentController.names;


public class CartController implements Initializable
{
   
    @FXML TextArea YourTextArea;
    
    @FXML
    private TextField NAME;
    
    @FXML
    private TextField PHONE;
    
    @FXML
    private TextField EMAIL;
    
    @FXML
    private TextField ADDRESS;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    static String names=new String();  
    static String emails=new String();  
    static String phones=new String();  
    static String adrs=new String();  
    
    @FXML
      public void Account(ActionEvent event) throws Exception
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
      
   
    @FXML
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
    public void Check(ActionEvent event) throws Exception
    {               
        try 
        {
            String name = NAME.getText();
            String name1=name;
            names= name1;
            
            String email = EMAIL.getText();
            String email1=email;
            emails= email1;
            
            String phone = PHONE.getText();
            String phone1=phone;
            phones= phone1; 
            
            String adr1 = ADDRESS.getText();
            String adres=adr1;
            adrs= adres;
            
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
    
     @FXML
    public String Name()
    {
        return names;
    }
    @FXML
    public String Email()
    {
        return emails;
    }
    @FXML
    public String Phone()
    {
        return phones;
    }@FXML
    public String Adr()
    {
        return adrs;
    }
    
         
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try 
        {
            Scanner s = new Scanner(new File("items.txt")).useDelimiter(" ");
            while (s.hasNext()) 
            {
                if (s.hasNext())
                { 
                    YourTextArea.appendText(s.next() + " "); 
                } 
                else 
                {
                   YourTextArea.appendText(s.next() + " ");
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
        System.err.println(ex);
        }
    }    
    
}
