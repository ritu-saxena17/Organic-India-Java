/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import ConnectionUtil.ConnectionUtil;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static loginapplication.FXMLDocumentController.names;

/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class FXMLMenuController implements Initializable 
{   
    
    @FXML
    private TextField textEmail;
    
    @FXML
    private PasswordField textPassword;
    
    @FXML
    private AnchorPane rootpane;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    static String names=new String();  
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
 
    public FXMLMenuController() 
    {
        connection = ConnectionUtil.connectdb();
    }
    
    @FXML
     public void signup(ActionEvent event) throws FXMLMenuController.IOException 
    {
        String email = textEmail.getText();
        String name=email;
	names= name;
        String password = textPassword.getText();
        
        if(email.isEmpty())
        {
            infoBox("Username Field is empty", null, "Failed");
        }
        else if(password.isEmpty())
        {
            infoBox("Password Field is empty", null, "Failed");
        }
        else if(password.length()<6)
        {
            infoBox("Password should be greater than 6 ", null, "Failed");
        }
        else
        {
            try
            {
                String sql = "SELECT * FROM login WHERE email = ? and password = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
               
                while(resultSet.next())
                { 
                    String rs=resultSet.getString(1);
                    if(rs.equals(email))
                    {
                        infoBox("Please enter another name, name already exists", null, "Failed");
                    }
                }
                
                String sql1 = "INSERT into login values(?,?)";
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                int rS=preparedStatement.executeUpdate();
                
                if(rS==1)
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
            catch(Exception e)
            {
                e.printStackTrace();
            }
        
        }   
    }
    public static void infoBox(String infoMessage, String headerText, String title)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    @FXML
    public void Back(ActionEvent event) throws Exception
    {         
       try 
        {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            rootpane.getChildren().setAll(pane);
            
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
        
    }    

    private static class IOException extends Exception {

        public IOException() {
        }
    }
}