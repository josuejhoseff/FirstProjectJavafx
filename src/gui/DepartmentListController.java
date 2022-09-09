package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	public void setDepartmentService(DepartmentService Service) {//injetar dependencia
		this.service = Service;
	}
	
	@FXML
	public void onBtNewAction() {
		System.out.println("BTNEW");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inititalizeNodes();
		
	}
	private void inititalizeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id")); //inicializar a coluna para não ter erro
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));//inicializar a coluna para não ter erro
		
		Stage stage =(Stage) Main.getMainScene().getWindow(); // fazer com que ...
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());// a tabela fique no mesmo tamanho da tela
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Table was null");
		}
		List<Department>list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
		
	}

}
