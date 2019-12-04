package game_root;

import java.util.HashMap;

import game_map.casas.CasaAbstrata;
import game_map.casas.CasaEspecialAbstrata;
import game_map.iterador_mapa.IIteradorMapa;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JogoUI extends Application implements IJogoObservador
{
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 10;
	
	private ControladorJogo controlador;
	private AnchorPane mapaPane;
	private GridPane mapaGrid;
	private GridPane jogadoresGrid;
	private Pane rootPane;
	private Button avançarButton;
	private Label resultadoLabel;
	
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
		
		//Botão de avançar turno
		avançarButton = new Button("Rodar Dado");
		avançarButton.setOnAction(event ->
		{
			controlador.jogarTurnoAcao();
		});
		turnoPane.getChildren().add(avançarButton);
		AnchorPane.setTopAnchor(avançarButton, 10.0);
		AnchorPane.setLeftAnchor(avançarButton, 10.0);
		
		resultadoLabel = new Label("Resultado: ");
		resultadoLabel.setStyle("-fx-font-weight: bold");
		turnoPane.getChildren().add(resultadoLabel);
		AnchorPane.setBottomAnchor(resultadoLabel, 10.0);
		AnchorPane.setLeftAnchor(resultadoLabel, 10.0);
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
		
		iIteradorMapa.reset();
		for (int i = 0; i < JogoUI.ROW_SIZE; i++) 
		{
			for (int j = 0; j < JogoUI.COLUMN_SIZE; j++) 
			{
				CasaAbstrata casa = iIteradorMapa.next();
				
				if (casa instanceof CasaEspecialAbstrata)
				{
					CasaEspecialAbstrata casaEspecial = (CasaEspecialAbstrata)casa;
					
					int pos = 10*i+j;
					Platform.runLater(() ->
					{
						GridCellMapa cell = (GridCellMapa) mapaGrid.getChildren().get(pos);
						Bounds cellBounds = cell.localToScene(cell.getBoundsInLocal());
						
						GridCellMapa cellDestino = (GridCellMapa) mapaGrid.getChildren().get(99-casaEspecial.getDestino());
						Bounds cellDestinoBounds = cellDestino.localToScene(cellDestino.getBoundsInLocal());
						
						Line line = new Line(cellBounds.getMaxX()-cellBounds.getWidth()/2, 
								cellBounds.getMaxY()-cellBounds.getHeight()/2, 
								cellDestinoBounds.getMaxX()-cellDestinoBounds.getWidth()/2,
								cellDestinoBounds.getMaxY()-cellDestinoBounds.getHeight()/2);
						line.setStroke(Color.valueOf(casa.getCor() + "33"));
						if (casaEspecial.getDestino() == 0)
						{
							line.setStroke(Color.TRANSPARENT);
						}
						
						rootPane.getChildren().add(line);
					});
				}
			}
		}
		
		mapaGrid.setGridLinesVisible(false);
		mapaGrid.setGridLinesVisible(true);
		
		lastPosicoes = jogadorPosicoes;
	}
	
	private void moverJogadores(MovimentoEvent movimentoEvent, HashMap<Integer, Integer> jogadorPosicoes)
	{
		
	}
	
	private void setTelaVencedor(String vencedor)
	{
		Label vencedorLabel = new Label(vencedor + " chegou na casa 100 e ganhou a partida!");
		vencedorLabel.setAlignment(Pos.CENTER);
		vencedorLabel.setTextFill(Color.valueOf("ffffff"));
		vencedorLabel.setStyle("-fx-background-color: black");
		
		Rectangle shadeRectangle = new Rectangle(rootPane.getWidth(), rootPane.getHeight());
		shadeRectangle.setFill(Color.valueOf("777777aa"));
		
		StackPane vencerPane = new StackPane(shadeRectangle, vencedorLabel);
		vencerPane.setAlignment(Pos.CENTER);
		
		rootPane.getChildren().add(vencerPane);
		rootPane.setDisable(true);
	}
	
	private String construirResultadoText(MovimentoEvent event)
	{
		String ret = "Jogador " + event.getJogador() + " se movimenta " + event.getMovimentoDado() + " casas para a frente";
		if (event.getMovimentoEspecial() != 0)
		{
			ret += ", cai numa casa especial e vai " + event.getMovimentoEspecial();
			
			if (event.getMovimentoEspecial() < 0)
				ret += " para trás.";
			else
				ret += " para frente.";
		}
		
		return ret;
	}
	
	@Override
	public void stop() throws Exception 
	{
		super.stop();
	}

	@Override
	public void posicoesMudadas(MovimentoEvent movimentoEvent, 
			HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> jogadorPosicoes) 
	{
		if (lastIIteradorMapa == null)
			return;
		lastIIteradorMapa.reset();
		
		if (movimentoEvent != null)
		{
			resultadoLabel.setText("Resultado: " + construirResultadoText(movimentoEvent));
		}
		
		//Checagem de vencedor
		jogadorPosicoes.forEach((jogador, posicao) ->
		{
			if (posicao >= 99)
			{
				setTelaVencedor("J" + jogador);
			}
		});

		desenharCasas(lastIIteradorMapa, jogadoresCores, jogadorPosicoes);
	}

	@Override
	public void mapaMudado(IIteradorMapa iIteradorMapa) 
	{
		lastIIteradorMapa = iIteradorMapa;
		desenharCasas(iIteradorMapa, null, null);
	}
}
