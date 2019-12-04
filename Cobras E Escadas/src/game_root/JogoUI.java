package game_root;

import game_entities.jogador.JogadoresPosicao;
import game_map.CasaAbstrata;
import game_map.IIteradorMapa;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JogoUI extends Application implements IJogoObservador
{
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 10;
	
	private ControladorJogo controlador;
	private GridPane mapaPane;
	private Pane rootPane;
	
	//mediator
	private JogoUIMediator mediator;
	
	public JogoUI(JogoUIMediator mediator) 
	{
		this.mediator = mediator;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		controlador = new ControladorJogo();
		mapaPane = new GridPane();
		
		rootPane = new AnchorPane();
		rootPane.getChildren().add(setUpMenu());
		
		Scene scene = new Scene(rootPane, 640, 480);
		
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
		iniciarButton.setOnAction(event -> 
		{
			setUpMapa();
			controlador.iniciarJogoAcao(2, this);
		});
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
	
	private void setUpMapa()
	{
		rootPane.getChildren().clear();
		rootPane.getChildren().add(mapaPane);
		
		AnchorPane.setTopAnchor(mapaPane, 0.0);
		AnchorPane.setRightAnchor(mapaPane, 0.0);
		AnchorPane.setLeftAnchor(mapaPane, 0.0);
		AnchorPane.setBottomAnchor(mapaPane, 0.0);
	}
	
	private void desenharCasas(IIteradorMapa iIteradorMapa)
	{
		mapaPane.getChildren().clear();
		
		for (int i = 0; i < JogoUI.ROW_SIZE; i++) 
		{
			for (int j = 0; j < JogoUI.COLUMN_SIZE; j++)
			{
				CasaAbstrata casa = iIteradorMapa.next();
				if (casa == null)
					continue;
				
				Rectangle rectangle = new Rectangle(10, 10);
				rectangle.setFill(Color.valueOf(casa.getCor()));
				
				mapaPane.add(rectangle, j, i);
			}
		}
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
		desenharCasas(iIteradorMapa);
	}

	@Override
	public void novoTurno(String jogadoratual) 
	{
		
	}
}
