package game_root;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import game_entities.jogador.IIteradorJogador;
import game_entities.jogador.JogadoresPosicao;
import game_map.CasaAbstrata;
import game_map.IIteradorMapa;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JogoUI extends Application implements IJogoObservador
{
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 10;
	
	private ControladorJogo controlador;
	private AnchorPane mapaPane;
	private GridPane mapaGrid;
	private GridPane jogadoresGrid;
	private Pane rootPane;
	
	private AnchorPane turnoPane;
	
	private IIteradorMapa lastIIteradorMapa;
	private HashMap<Integer, Integer> lastPosicoes;
	
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
		mapaPane = new AnchorPane();
		
		AnchorPane.setTopAnchor(mapaPane, 0.0);
		AnchorPane.setRightAnchor(mapaPane, 0.0);
		AnchorPane.setLeftAnchor(mapaPane, 0.0);
		AnchorPane.setBottomAnchor(mapaPane, 80.0);
		
		mapaGrid = new GridPane();
		mapaPane.getChildren().add(mapaGrid);
		AnchorPane.setTopAnchor(mapaGrid, 0.0);
		AnchorPane.setRightAnchor(mapaGrid, 0.0);
		AnchorPane.setLeftAnchor(mapaGrid, 0.0);
		AnchorPane.setBottomAnchor(mapaGrid, 0.0);
		
		jogadoresGrid = new GridPane();
		mapaPane.getChildren().add(jogadoresGrid);
		AnchorPane.setTopAnchor(jogadoresGrid, 0.0);
		AnchorPane.setRightAnchor(jogadoresGrid, 0.0);
		AnchorPane.setLeftAnchor(jogadoresGrid, 0.0);
		AnchorPane.setBottomAnchor(jogadoresGrid, 0.0);
		
		turnoPane = new AnchorPane();
		AnchorPane.setTopAnchor(turnoPane, 411.0);
		AnchorPane.setRightAnchor(turnoPane, 0.0);
		AnchorPane.setLeftAnchor(turnoPane, 0.0);
		AnchorPane.setBottomAnchor(turnoPane, 0.0);
		
		rootPane = new AnchorPane();
		rootPane.getChildren().add(setUpMenu());
		
		Scene scene = new Scene(rootPane, 640, 480);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cobras e Escadas");
		primaryStage.setResizable(false);
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
			controlador.iniciarJogoAcao(4, this);
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
		rootPane.getChildren().add(turnoPane);
		
		Button avançarButton = new Button("Rodar Dado");
		avançarButton.setOnAction(event ->
		{
			controlador.jogarTurnoAcao();
		});
		turnoPane.getChildren().add(avançarButton);
	}
	
	private void desenharCasas(IIteradorMapa iIteradorMapa, HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> jogadorPosicoes)
	{
		if (lastPosicoes == null)
			lastPosicoes = jogadorPosicoes;
		
		mapaGrid.getChildren().clear();
		
		for (int i = 0; i < JogoUI.ROW_SIZE; i++) 
		{
			for (int j = 0; j < JogoUI.COLUMN_SIZE; j++)
			{
				CasaAbstrata casa = iIteradorMapa.next();
				if (casa == null)
					continue;
				
				GridCellMapa cell = new GridCellMapa(casa, iIteradorMapa.index()+1);
				cell.addJogadores(jogadoresCores, jogadorPosicoes);
				
				mapaGrid.add(cell, j, i);
			}
		}
		
		if (jogadorPosicoes != null)
		{
			jogadorPosicoes.forEach((jogador, posicao) ->
			{
				PathTransition pathTransition = new PathTransition();
				pathTransition.setDuration(Duration.seconds(3));
				
			});
		}
		
		mapaGrid.setGridLinesVisible(false);
		mapaGrid.setGridLinesVisible(true);
		
		lastPosicoes = jogadorPosicoes;
	}
	
	@Override
	public void stop() throws Exception 
	{
		super.stop();
	}

	@Override
	public void posicoesMudadas(HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> jogadorPosicoes) 
	{
		if (lastIIteradorMapa == null)
			return;
		lastIIteradorMapa.reset();

		desenharCasas(lastIIteradorMapa, jogadoresCores, jogadorPosicoes);
	}

	@Override
	public void mapaMudado(IIteradorMapa iIteradorMapa) 
	{
		lastIIteradorMapa = iIteradorMapa;
		desenharCasas(iIteradorMapa, null, null);
	}

	@Override
	public void novoTurno(String jogadoratual) 
	{
		
	}
}
