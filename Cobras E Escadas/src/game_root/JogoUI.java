package game_root;

import java.util.Scanner;

public class JogoUI {
    public static void main(String[] args) {
        ControladorJogo con = new ControladorJogo();
        Scanner scan = new Scanner(System.in);
        String op = scan.nextLine();

        if(op == "comecar"){
            int quantidadeJogadores = 2;
            con.comecar(quantidadeJogadores);
        }else if(op == "jogarTurno"){
            
        }
        scan.close();
    }
}
