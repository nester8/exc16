package Exc16;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMachineController {

    private ArrayList<Game> gameList = new ArrayList<>();
    private GameMachine gameMachine = new GameMachine(gameList);

    public void start(){
        gameMachine.menu();
    }

    public void putGameintoMachine(Game game){
        gameList.add(game);
    }


}
