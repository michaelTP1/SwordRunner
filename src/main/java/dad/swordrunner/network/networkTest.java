package dad.swordrunner.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

import dad.swordrunner.ClientModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class networkTest extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ClientModel model = new ClientModel();
		Server server;
		Thread serverThread;
		ClientConnectionTask clientConnectionTask;
		Thread clientConnectionThread;
		
		model.setPort(2000);
		try {
			
		model.setIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		server = new Server(model);
		serverThread = new Thread(server);
		serverThread.start();

		clientConnectionTask = new ClientConnectionTask(model);

		System.out.println("asgsdafasdfasdfdasfasdf");
		clientConnectionTask.setOnSucceeded(e -> startGame());
		clientConnectionThread = new Thread(clientConnectionTask);

		clientConnectionThread.start();		
	}
	public static void main(String[] args){
		launch(args);
	}

	private static void startGame() {
		System.out.println("jaja todo ok");
	}

}
