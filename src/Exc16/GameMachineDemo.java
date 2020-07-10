package Exc16;

public class GameMachineDemo {
    public static void main(String[] args) {

        GameMachineController gameMachineController = new GameMachineController();

        Game game1 = new Game("Tetris", 10);
        Game game2 = new Game("Snake", 20);
        Game game3 = new Game("Saper", 15);
        Game game4 = new Game("Checkers", 30);

        gameMachineController.putGameintoMachine(game1);
        gameMachineController.putGameintoMachine(game2);
        gameMachineController.putGameintoMachine(game3);
        gameMachineController.putGameintoMachine(game4);

        gameMachineController.start();

    }
}
