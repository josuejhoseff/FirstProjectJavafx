package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("MenuSeller");
	}

	@FXML
	public void onMenuDepartmentAction() {
		loadView2("/gui/DepartmentList.fxml");
	}

	@FXML
	public void onMenuAboutAction() {
		loadView("/gui/About.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	private synchronized void loadView(String absoluteName) { //synchronized para este elemento rodar sem interrupção
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent(); //getRoot() pega o primeiro elemento
			
			Node mainMenu = mainVBox.getChildren().get(0);//get(0) é a posição do elemento (primeiro filho) neste caso a barra de menu
			mainVBox.getChildren().clear(); //limpo tudo
			mainVBox.getChildren().add(mainMenu);// adiciono a barra de menu novamente e
			mainVBox.getChildren().addAll(newVBox);// adiciono a nova cena que sera exibida
			
			
		}
		catch(IOException e) {
			Alerts.showAlerts("IO Exception","Erro loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	private synchronized void loadView2(String absoluteName) { //synchronized para este elemento rodar sem interrupção
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent(); //getRoot() pega o primeiro elemento
			
			Node mainMenu = mainVBox.getChildren().get(0);//get(0) é a posição do elemento (primeiro filho) neste caso a barra de menu
			mainVBox.getChildren().clear(); //limpo tudo
			mainVBox.getChildren().add(mainMenu);// adiciono a barra de menu novamente e
			mainVBox.getChildren().addAll(newVBox);// adiciono a nova cena que sera exibida
			
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
			
		}
		catch(IOException e) {
			Alerts.showAlerts("IO Exception","Erro loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
