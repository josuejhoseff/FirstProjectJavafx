package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.management.loading.PrivateClassLoader;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErroName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML 
	public void onBtSaveAction() {
		System.out.println("btSave");
	}
	
	@FXML 
	public void onBtCancelAction() {
		System.out.println("btCancel");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	public void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

}
