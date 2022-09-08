package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("BTNEW");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inititalizeNodes();
		
	}
	private void inititalizeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("ID")); //inicializar a coluna para não ter erro
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));//inicializar a coluna para não ter erro
		
		Stage stage =(Stage) Main.getMainScene().getWindow(); // fazer com que ...
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());// a tabela fique no mesmo tamanho da tela
	}

}
