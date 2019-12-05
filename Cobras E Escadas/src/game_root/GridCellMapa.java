package game_root;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridCellMapa extends AnchorPane
{
	private int casaIndex;
	private HashMap<Integer, Label> jogadoresLabel;
	
	public GridCellMapa(String cor, int index) 
	{
		jogadoresLabel = new HashMap<Integer, Label>();
		casaIndex = index;
		
		//numero da casa
		Label casaLabel = new Label("" + index);
		casaLabel.setAlignment(Pos.CENTER);		
		casaLabel.setStyle("-fx-background-color: " + cor + ";");
		AnchorPane.setTopAnchor(casaLabel, 0.0);
		AnchorPane.setBottomAnchor(casaLabel, 0.0);
		AnchorPane.setLeftAnchor(casaLabel, 0.0);
		AnchorPane.setRightAnchor(casaLabel, 0.0);
		getChildren().add(casaLabel);
		
		GridPane.setHgrow(this, Priority.ALWAYS);
		GridPane.setVgrow(this, Priority.ALWAYS);
		setMaxWidth(Double.POSITIVE_INFINITY);
		setMaxHeight(Double.POSITIVE_INFINITY);
	}
	
	//renderizar os jogadores
	public void addJogadores(HashMap<Integer, String> jogadoresCores, HashMap<Integer, Integer> posicaoJogador)
	{
		if (jogadoresCores != null && posicaoJogador != null)
		{
			posicaoJogador.forEach((jogador, posicao) ->
			{
				//só renderiza se o jogador estiver nessa celula
				if (posicao+1 != casaIndex)
					return;
				
				String cor = jogadoresCores.get(jogador);
				
				Label jogadorLabel = new Label("J" + jogador);
				jogadorLabel.setStyle("-fx-background-color: " + cor + ";");
				
				getChildren().add(jogadorLabel);
				//posicionamento para cada jogador
				if (jogador == 1)
				{
					AnchorPane.setTopAnchor(jogadorLabel, 0.0);
					AnchorPane.setLeftAnchor(jogadorLabel, 0.0);
				}
				else if (jogador == 2)
				{
					AnchorPane.setTopAnchor(jogadorLabel, 0.0);
					AnchorPane.setRightAnchor(jogadorLabel, 0.0);
				}
				else if (jogador == 3)
				{
					AnchorPane.setBottomAnchor(jogadorLabel, 0.0);
					AnchorPane.setLeftAnchor(jogadorLabel, 0.0);
				}
				else 
				{
					AnchorPane.setBottomAnchor(jogadorLabel, 0.0);
					AnchorPane.setRightAnchor(jogadorLabel, 0.0);
				}
				
				jogadoresLabel.put(jogador, jogadorLabel);
			});
		}
	}
	
	public Label getJogadorLabel(int jogador)
	{
		if (jogadoresLabel.containsKey(jogador))
			return jogadoresLabel.get(jogador);
		else
			return null;
	}
}
