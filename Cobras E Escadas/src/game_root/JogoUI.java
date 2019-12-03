package game_root;

import game_entities.jogador.JogadoresPosicao;
import game_map.IIteradorMapa;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JogoUI extends Application implements IJogoObservador
{
	private ControladorJogo controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		controlador = new ControladorJogo();
		
		AnchorPane root = new AnchorPane();
		root.getChildren().add(setUpMenu());
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cobras e Escadas");
		primaryStage.show();
	}
	
	private Pane setUpMenu()
	{
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);
		
		//Botoes do menu e suas acoes
		Button iniciarButton = new Button("Iniciar Jogo");
		iniciarButton.setOnAction(e -> controlador.iniciarJogoAcao());
		Button sairButton = new Button("Sair");
		sairButton.setOnAction(e -> Platform.exit());
		
		vbox.getChildren().add(iniciarButton);
		vbox.getChildren().add(sairButton);
		
		AnchorPane.setTopAnchor(vbox, 0.0);
		AnchorPane.setRightAnchor(vbox, 0.0);
		AnchorPane.setLeftAnchor(vbox, 0.0);
		AnchorPane.setBottomAnchor(vbox, 0.0);
		
		return vbox;
	}
	
	@Override
	public void stop() throws Exception 
	{
		super.stop();
	}

	@Override
	public void posicoesMudadas(JogadoresPosicao posicoes) 
	{
		
	}

	@Override
	public void mapaMudado(IIteradorMapa iIteradorMapa) 
	{
		
	}

	@Override
	public void novoTurno(String jogadoratual) 
	{
		
	}
}
