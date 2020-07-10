package Exc16;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameMachine {

    private List<Game> gameList = new ArrayList<>();

    public GameMachine(List<Game> gameList) {
        this.gameList = gameList;
    }

    public void menu(){
        boolean running = true;

        while(running)

        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Wyświetl listę gier");
            System.out.println("2. Wyszukaj grę");
            System.out.println("3. Wyjście");
            try {
                int userChoice = scanner.nextInt();
                if (userChoice > 3 || userChoice < 1) {
                    System.out.println("Nieprawidłowa wartość");
                    continue;
                } else {
                    switch (userChoice) {
                        case 1:
                            showGameList();
                            System.out.println("1. Kup grę");
                            System.out.println("2. Powrót");
                            userChoice = scanner.nextInt();
                            if (userChoice > 2 || userChoice < 1){
                                System.out.println("Nieprawidłowa wartość");
                            continue;
                            } else {
                            switch (userChoice){
                                case 1:
                                    System.out.println("Wpisz nazwę gry");
                                    Scanner scanner1 = new Scanner(System.in);
                                    String gameName = scanner1.nextLine();
                                    sellGame(findGame(gameName));
                                case 2: continue;
                                }
                            }
                        case 2:
                            System.out.println("Wpisz nazwę gry");
                            Scanner scanner1 = new Scanner(System.in);
                            String gameName = scanner1.nextLine();
                            Game chosenGame = findGame(gameName);
                            System.out.println(chosenGame);
                            System.out.println("1. Kup grę");
                            System.out.println("2. Powrót");
                            userChoice = scanner.nextInt();
                            if (userChoice > 2 || userChoice < 1){
                                System.out.println("Nieprawidłowa wartość");
                                continue;
                            } else {
                                switch (userChoice){
                                    case 1: sellGame(findGame(gameName));
                                    case 2: continue;
                                }
                            }
                        case 3:
                            running = false;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Należy podać liczbę");
            }
        }
    }

    public void sellGame(Game game){
        System.out.println("Wybrana gra kosztuje: " + game.getPrice() + ", wrzuć pieniądze");
        Scanner scanner = new Scanner(System.in);
        int userCash = scanner.nextInt();
        int allCash = userCash;
        while (allCash < game.getPrice()){
            System.out.println("Potrzeba jeszcze: " + (game.getPrice() - allCash) + ", wrzuć pieniądze");
            userCash = scanner.nextInt();
            allCash += userCash;
        }
            System.out.println("Kupiłeś grę " + game.getName() + ", reszta: " + (allCash - game.getPrice()));
            gameList.remove(game);
    }

    public void showGameList(){
        for (Game game : gameList) {
            System.out.println(game);
        }
    }

    public Game findGame(String name){
        for (Game game : gameList) {
            if(game.getName().equals(name)){
                return game;
            }
        }
        throw new GameMachineException("Nie znaleziono takiej gry");
    }

}
