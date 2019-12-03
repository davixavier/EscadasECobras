package game_root;

import java.util.List;

import game_map.Mapa;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class MapaPane extends GridPane
{
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 10;
	
	private Mapa mapa;
	
	public MapaPane(Mapa mapa) 
	{
		super();
		setAlignment(Pos.CENTER);
		
		this.mapa = mapa;
		
		desenharCasas();
	}
	
	private void desenharCasas()
	{
		for (int i = 0; i < ROW_SIZE; i++) 
		{
			for (int j = 0; j < COLUMN_SIZE; j++) 
			{
				Rectangle casaRect = new Rectangle();
				casaRect.setStyle("-fx-background-color: " + mapa.getCasa(ROW_SIZE * i + j).getCor() + ";");
				
				add(casaRect, j, i);
			}
		}
	}
}
