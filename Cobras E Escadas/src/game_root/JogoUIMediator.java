package game_root;

import javafx.application.Application;
import javafx.stage.Stage;

//mediador para resolver um problema relacionado ao JavaFX
public class JogoUIMediator extends Application
{
	private JogoUI jogoUI;
	
	public JogoUIMediator() 
	{
		jogoUI = new JogoUI(this);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		jogoUI.start(primaryStage);
	}
	
	@Override
	public void stop() throws Exception 
	{
		super.stop();
	}
	
	//Main da aplica��o
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
