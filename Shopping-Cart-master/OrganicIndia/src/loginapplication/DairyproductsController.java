/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Prajna Shetty
 */
public class DairyproductsController implements Initializable
{
    
    @FXML
    private Spinner<Integer> spinner1;
    
    @FXML
    private Spinner<Integer> spinner2;
    
    @FXML
    private Spinner<Integer> spinner3;
    
    @FXML
    private Spinner<Integer> spinner4;
    /**
     * Initializes the controller class.
     */
    Stage dialogStage = new Stage();
    Scene scene;
    
     @FXML
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
    @FXML
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
    
    
    static float bill=0;
    
    @FXML
    public void add1(ActionEvent event) throws Exception
    {  
        try
        {
            int value1 = (Integer) spinner1.getValue();
            if(value1>0)
            {
            FileWriter fw = new FileWriter("items.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("          Amul Ghee                  "+value1+"                               "+(value1*160));
            bill+=value1*40;
            pw.flush();
            pw.close();
            }
        }
        catch(IOException e)
        {
            out.println("error!!!");
        }   
    }
    
    @FXML
    public void add2(ActionEvent event) throws Exception
    {  
        try
        {
            int value2 = (Integer) spinner2.getValue();
            if(value2>0)
            {
            FileWriter fw = new FileWriter("items.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("          Nandini Milk               "+value2+"                                "+(value2*25));
            bill+=value2*10;
            pw.flush();
            pw.close();
            }
        }
        catch(IOException e)
        {
            out.println("error!!!");
        }   
    }
   
    @FXML
    public void add3(ActionEvent event) throws Exception
    {  
        try
        {   
            int value3 = (Integer) spinner3.getValue();
            if(value3>0)
            {
            FileWriter fw = new FileWriter("items.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("          Amul Butter                "+value3+"                                "+(value3*50));
            bill+=value3*20;
            pw.flush();
            pw.close();
            }
        }
        catch(IOException e)
        {
            out.println("error!!!");
        }   
    }
    
    @FXML
    public void add4(ActionEvent event) throws Exception
    {  
        try
        {
            int value4 = (Integer) spinner4.getValue();
            if(value4>0)
            {
            FileWriter fw = new FileWriter("items.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("          Nandini Cheese          "+value4+"                                "+(value4*20));
            bill+=value4*20;
            System.out.print(bill);
            pw.flush();
            pw.close();
            }
        }
        catch(IOException e)
        {
            out.println("error!!!");
        }   
    }
    
     public float returnbill()
    {
        return bill;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        SpinnerValueFactory<Integer> spin1=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.spinner1.setValueFactory(spin1);
        SpinnerValueFactory<Integer> spin2=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.spinner2.setValueFactory(spin2);
        SpinnerValueFactory<Integer> spin3=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.spinner3.setValueFactory(spin3);
        SpinnerValueFactory<Integer> spin4=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,0);
        this.spinner4.setValueFactory(spin4);
    }   
}
