package game_root;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	//como as linhas e colunas serao mostradas
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 10;
	
	//partes da interface
	private ControladorJogo controlador;
	private AnchorPane mapaPane;
	private GridPane mapaGrid;
	private GridPane jogadoresGrid;
	private Pane rootPane;
	private Button avançarButton;
	private Label resultadoLabel;
	private AnchorPane turnoPane;
	
	//estado de casas do observavel
	private List<String> lastCores;
	private List<Integer> lastDestinos;
	private int quantidadeJogadores;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		controlador = new ControladorJogo();
		
		//inicializar conteieners e star ancoras
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
		
		//inicializar a scene e mostrar a janela da aplicacao
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
			setUpJogadoresSeleção();
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
	
	//tela de selecionar quantidade de jogadores
	private void setUpJogadoresSeleção()
	{
		rootPane.getChildren().clear();
		
		Label fieldLabel = new Label("Insira a quantidade de jogadores(1-4):");
		
		TextField quantidadeField = new TextField("2");
		quantidadeField.setPromptText("Quantidade...");
		quantidadeField.setMaxWidth(100);
		//só deixar o usuário digitar de 2 a 4 no campo
		quantidadeField.textProperty().addListener((e, oldVal, newVal) ->
		{
			if (!newVal.matches("[2-4]*"))
			{
				quantidadeField.setText(oldVal);
			}
			
			if (!newVal.isEmpty() && (Integer.parseInt(newVal) > 4 || Integer.parseInt(newVal) < 2))
			{
				quantidadeField.setText(oldVal);
			}
		});
		
		Button confirmarButton = new Button("Confirmar");
		//começar o jogo
		confirmarButton.setOnAction(actionEvent ->
		{
			quantidadeJogadores = Integer.parseInt(quantidadeField.getText());
			setUpJogo();
			controlador.comecar(quantidadeJogadores, this);
		});
		
		VBox vBox = new VBox(fieldLabel, quantidadeField, confirmarButton);
		vBox.setSpacing(13);
		vBox.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(vBox, 0.0);
		AnchorPane.setRightAnchor(vBox, 0.0);
		AnchorPane.setLeftAnchor(vBox, 0.0);
		AnchorPane.setBottomAnchor(vBox, 0.0);
		
		rootPane.getChildren().add(vBox);
	}
	
	private void setUpJogo()
	{
		//limpar o conteiner principal
		rootPane.getChildren().clear();
		rootPane.getChildren().add(mapaPane);
		rootPane.getChildren().add(turnoPane);
		
		//Botão de avançar turno e texto de resultado
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
	
	private void desenharCasas(List<String> coresCasas, 
			List<Integer> destinoCasas, 
			HashMap<Integer, String> jogadoresCores, 
			HashMap<Integer, Integer> jogadorPosicoes)
	{
		mapaGrid.getChildren().clear();
		
		Iterator<String> coresIterator = coresCasas.listIterator();
		for (int i = JogoUI.ROW_SIZE-1; i >= 0; i--) 
		{
			for (int j = JogoUI.COLUMN_SIZE-1; j >= 0; j--)
			{
				//calcular indice
				int index = JogoUI.ROW_SIZE*i + j;
				
				String cor = coresIterator.next();
				
				//iniciar celula e renderizar os jogadores nela
				GridCellMapa cell = new GridCellMapa(cor, index+1);
				cell.addJogadores(jogadoresCores, jogadorPosicoes);
				//se a linha for um numero impar renderizar invertida pra ficar um caminho bonito
				if (i % 2 == 0)
				{
					mapaGrid.add(cell, j, JogoUI.ROW_SIZE-i);
				}
				else
				{
					mapaGrid.add(cell, JogoUI.COLUMN_SIZE-j-1, JogoUI.ROW_SIZE-i);
				}
			}
		}
		
		//Desenhar linhas dizendo onde as casas especiai vão
		Iterator<Integer> destinoIterator = destinoCasas.iterator();
		for (int i = 0; i < JogoUI.ROW_SIZE; i++) 
		{
			for (int j = 0; j < JogoUI.COLUMN_SIZE; j++) 
			{
				int destino = destinoIterator.next();
				
				//se destino != 0 é porque a casa é uma especial
				if (destino != 0)
				{
					int pos = 10*i+j;
					Platform.runLater(() ->
					{
						//alguns cálculos de coordenadas
						GridCellMapa cell = (GridCellMapa) mapaGrid.getChildren().get(pos);
						Bounds cellBounds = cell.localToScene(cell.getBoundsInLocal());
						
						GridCellMapa cellDestino = (GridCellMapa) mapaGrid.getChildren().get(99-destino);
						Bounds cellDestinoBounds = cellDestino.localToScene(cellDestino.getBoundsInLocal());
						
						Line line = new Line(cellBounds.getMaxX()-cellBounds.getWidth()/2, 
								cellBounds.getMaxY()-cellBounds.getHeight()/2, 
								cellDestinoBounds.getMaxX()-cellDestinoBounds.getWidth()/2,
								cellDestinoBounds.getMaxY()-cellDestinoBounds.getHeight()/2);
						line.setStroke(Color.valueOf(coresCasas.get(pos) + "33"));
						if (destino == 0)
						{
							line.setStroke(Color.TRANSPARENT);
						}
						
						rootPane.getChildren().add(line);
					});
				}
			}
		}
		
		//Mostrar linhas entre as celulas da tabela
		mapaGrid.setGridLinesVisible(false);
		mapaGrid.setGridLinesVisible(true);
		
		//cache
		lastCores = coresCasas;
		lastDestinos = destinoCasas;
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
		int jogador = event.getJogador();
		
		//por causa do jeito circular que o iterador jogador funfa
		if (jogador == 0)
			jogador = quantidadeJogadores;
		
		String ret = "Jogador " + jogador + " se movimenta " + event.getMovimentoDado() + " casas para a frente e";
		ret += " cai na casa " + (event.getCasaInicial()+event.getMovimentoDado()+1);
		
		return ret;
	}
	
	private String construirResultadoEspecial(MovimentoEvent movimentoEvent)
	{
		String ret = "Resultado: a casa especial fez você ";
		
		if (movimentoEvent.getMovimentoEspecial() < 0)
		{
			ret += "voltar ";
		}
		else 
		{
			ret += "avançar ";
		}
		
		int casaFinal = (movimentoEvent.getCasaInicial()+movimentoEvent.getMovimentoDado()+movimentoEvent.getMovimentoEspecial())+1;
		ret += "para a casa " + casaFinal;
		
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
		if (lastCores == null || lastDestinos == null)
			return;
		
		//texto de resultado
		if (movimentoEvent != null)
		{
			resultadoLabel.setText("Resultado: " + construirResultadoText(movimentoEvent));
		}
		
		//checagem de jogadores
		jogadorPosicoes.forEach((jogador, posicao) ->
		{
			//Checagem de vencedor para mostrar a tela de vitória
			if (posicao >= 99)
			{
				setTelaVencedor("J" + jogador);
			}
			
			//se o jogador pisar numa casa especial parar pra mostrar isso
			if (movimentoEvent != null && jogador == movimentoEvent.getJogador() && movimentoEvent.getMovimentoEspecial() != 0)
			{
				int oldPosicao = posicao;
				
				jogadorPosicoes.put(jogador, movimentoEvent.getCasaInicial() + movimentoEvent.getMovimentoDado());
				resultadoLabel.setText(resultadoLabel.getText() + ", casa especial!");
				avançarButton.setText("Continuar...");
				
				//setar clique do botão para o continuar
				avançarButton.setOnAction(actionEvent ->
				{
					avançarButton.setText("Rodar dado");
					jogadorPosicoes.put(jogador, oldPosicao);
					desenharCasas(lastCores, lastDestinos, jogadoresCores, jogadorPosicoes);
					
					resultadoLabel.setText(construirResultadoEspecial(movimentoEvent));
					
					//setar clique do botão para o original
					avançarButton.setOnAction(actionEvent2 ->
					{
						controlador.jogarTurnoAcao();
					});
				});
			}
		});
		
		desenharCasas(lastCores, lastDestinos, jogadoresCores, jogadorPosicoes);
	}

	@Override
	public void mapaMudado(List<String> coresCasas, List<Integer> destinoCasas) 
	{
		desenharCasas(coresCasas, destinoCasas, null, null);
	}
	
	//Main da aplicaï¿½ï¿½o
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
