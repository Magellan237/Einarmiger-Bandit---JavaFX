package Praktikum1;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BanditJavaFX extends Application{
	
	Label infolabel = new Label();

	WalzeService [] service = new WalzeService[3];
	
	//Binden einer URL an einen Imageview mittels ImageBinding
	ImageView v11 = new ImageView();
	ImageView v12 = new ImageView();
	ImageView v13 = new ImageView();
	
	ImageView v21 = new ImageView();
	ImageView v22 = new ImageView();
	ImageView v23 = new ImageView();
	
	ImageView v31 = new ImageView();
	ImageView v32 = new ImageView();
	ImageView v33 = new ImageView();
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane pane=new GridPane();
		
		
		for (int i=0; i< 3; i++) {
			service[i] = new WalzeService(6);
		}
		//Bindung der Image-Property von ImageView-Objekten an die valueProperty-Objekte von 03 verschiedenen Service-Objekten
		v11.imageProperty().bind(new ImageBinding(service[0].valueProperty(), -1));
		v12.imageProperty().bind(new ImageBinding(service[0].valueProperty(),0));
		v13.imageProperty().bind(new ImageBinding(service[0].valueProperty(),1));

		v21.imageProperty().bind(new ImageBinding(service[1].valueProperty(),-1));
		v22.imageProperty().bind(new ImageBinding(service[1].valueProperty(),0));
		v23.imageProperty().bind(new ImageBinding(service[1].valueProperty(),1));

		v31.imageProperty().bind(new ImageBinding(service[2].valueProperty(),-1));
		v32.imageProperty().bind(new ImageBinding(service[2].valueProperty(),0));
		v33.imageProperty().bind(new ImageBinding(service[2].valueProperty(),1));


		pane.add(v11, 1,1);
		pane.add(v12, 1,2);
		pane.add(v13, 1,3);

		pane.add(v21, 2,1);
		pane.add(v22, 2,2);
		pane.add(v23, 2,3);

		pane.add(v31, 3,1);
		pane.add(v32, 3,2);
		pane.add(v33, 3,3);

		pane.add(infolabel,10,10);
		evaluation();
		Scene scene = new Scene(pane, 750, 750);

		scene.setOnMouseClicked(new EventHandler<MouseEvent> ()
		{
			@Override
			public void handle(MouseEvent event
					)
			{
				for(WalzeService serviceThread: service) {
					serviceThread.restart();
				}
				infolabel.setText("Spiel läuft...");
			}
		});
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle(" Bandit_JAVAFX ");
		primaryStage.show();
	}
	//überprüft den Gewinn oder Verlust des Spiels
	private void evaluation(){
	for (WalzeService iService:service) {
		iService.setOnSucceeded(event -> { 	//iService-Objekt Aufgabe erfolgreich abgeschlossen
			boolean alleFertig = true;	
			for (WalzeService jService:service) {
				if (jService.getState().equals(Worker.State.RUNNING))//überpruft für jedes Jservice-Objekt,ob es sich im Zustand RUnning befindet
					alleFertig = false;
			}
			if (alleFertig) {
					if (service[0].getValue().equals(service[1].getValue()) && service[0].getValue().equals(service[2].getValue())) {
						
						infolabel.setText("Spiel gewonnen ");
					}
					else {
						infolabel.setText("Spiel verloren -- Klicken um neuzustarten");
						
					}
				}	
		});
	}
	
}

public static void main(String[] args) {
		launch(args);
	}


}