/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import ConnectionUtil.ConnectionUtil;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static loginapplication.BakeryController.bill;
import static loginapplication.FXMLMenuController.infoBox;
 

/**
 *
 * @author Prajna Shetty
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textEmail;
    @FXML
    private PasswordField textPAssword;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    static String names=new String();  
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
 
    public FXMLDocumentController()
    {
        connection = ConnectionUtil.connectdb();
    }
    @FXML
    private void loginAction(ActionEvent event)
    {
        String email = textEmail.getText();
        String name=email;
	names= name;
        String password = textPAssword.getText();
        
      if(email.isEmpty())
        {
            infoBox("Username Field is empty", null, "Failed");
        }
        else if(password.isEmpty())
        {
            infoBox("Password Field is empty", null, "Failed");
        }
         
    
        String sql = "SELECT * FROM login WHERE email = ? and password = ?";
        
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
            {
                infoBox("Please enter correct Email and Password", null, "Failed");
            }
            else
            {
                infoBox("Login Successfull",null,"Success" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("MainPage.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void infoBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    @FXML
    public void Signup(ActionEvent event) throws Exception
    {   try 
        {
            Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    @FXML
    public String returnnames()
    {
        return names;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
