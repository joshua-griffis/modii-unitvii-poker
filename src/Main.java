import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    int balance = 100;
    int antee = 5;
    int pot = 0;
    int players = 2;
    int rounds = 1;
    String spade = Character.toString('♠') ;
    String diamond = Character.toString('⬥');
    String heart = Character.toString('♥');
    String club = Character.toString('♣');
    String value;
    String suit;
    ArrayList<ArrayList<String>> hand = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> flop = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> player2Hand = new ArrayList<ArrayList<String>>();
    Boolean fold = false;

    public String setValue() {
        Random rand = new Random();
        int upperBoundValue = 14;
        var randomValue = rand.nextInt(upperBoundValue);

        if (randomValue == 0 || randomValue == 13) {
            value = "A";
        } else if (randomValue == 12) {
            value = "K";
        } else if (randomValue == 11) {
            value = "Q";
        } else if (randomValue == 10) {
            value = "J";
        } else {
            randomValue += 1;
            value = String.valueOf(randomValue);
        } return value;
    }
    public String setSuit() {
        Random rand = new Random();
        int upperBoundSuit = 4;
        var randomSuit = rand.nextInt(upperBoundSuit);
        if (randomSuit == 0) {
            suit = spade;
        } else if (randomSuit == 1) {
            suit = diamond;
        } else if (randomSuit == 2) {
            suit = heart;
        } else {
            suit = club;
        } return suit;
    }

    public ArrayList<String> setCard() {
        ArrayList<String> card = new ArrayList<String>();
        card.add(setValue());
        card.add(setSuit());
        return card;
    }
    public void setCards() {
        hand.add(setCard());
        hand.add(setCard());
        flop.add(setCard());
        flop.add(setCard());
        flop.add(setCard());
    }

//    public void setReverseValue(val) {
//
//    }



    public static void main(String[] args) {
        Main poker = new Main();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Poker" + " " + poker.spade + " " + poker.diamond + " " + poker.heart + " " + poker.club);
            System.out.println("(Texas Hold em)");
            while (true) {
                System.out.println("Antee: $" + poker.antee * poker.rounds);
                System.out.println("[play]");
                System.out.println("Balance: $" + poker.balance);
                String userInput = scan.nextLine();
                if (userInput.equals("quit")) {
                    System.out.println("Thanks for playing ;) <3");
                    break;
                } else if (userInput.equals("play")) {
                    poker.balance -= (poker.antee * poker.rounds);
                    System.out.println("- $" + (poker.antee * poker.rounds));
                    poker.setCards();
                    poker.pot += ((poker.antee * poker.rounds) * poker.players);
                    break;
                } else {
                    System.out.println("try again ;p");
                }
            }

            while (poker.fold.equals(false)) {
                System.out.println("Pot: $" + poker.pot);
                System.out.println("Balance: $" + poker.balance);
                System.out.println("Hand: " + poker.hand);
                System.out.println("[bet], [fold], [check]");
                String userInputII = scan.nextLine();
                if (userInputII.equals("bet")) {
                    System.out.println("how much?");
                    int userInputIII = scan.nextInt();
                    System.out.println("- $" + userInputIII);
                    poker.balance -= userInputIII;
                    poker.pot += (userInputIII * poker.players);
                    break;
                } else if (userInputII.equals("fold")) {
                    poker.fold = true;
                    break;
                } else if (userInputII.equals("check")) {
                    System.out.println("- $" + 0);
                    break;
                } else {
                    System.out.println(";p");
                }
            }
            while (poker.fold.equals(false)) {
                System.out.println("Flop: " + poker.flop);
                System.out.println("Pot: $" + poker.pot);
                System.out.println("Balance: $" + poker.balance);
                System.out.println("Hand: " + poker.hand);
                System.out.println("[bet], [fold], [check]");
                String userInputIV = scan.nextLine();
                System.out.println("~~~" + userInputIV);
                if (userInputIV.equals("bet")) {
                    System.out.println("how much?");
                    int userInputV = scan.nextInt();
                    System.out.println("- $" + userInputV);
                    poker.balance -= userInputV;
                    poker.pot += (userInputV * poker.players);
                    break;
                } else if (userInputIV.equals("fold")) {
                    poker.fold = true;
                    break;
                } else if (userInputIV.equals("check")) {
                    System.out.println("- $" + 0);
                    break;
                } else {
                    System.out.println(";p");
                }
            }
            poker.flop.add(poker.setCard());
            while (poker.fold.equals(false)) {

                System.out.println("Turn: " + poker.flop);
                System.out.println("Pot: $" + poker.pot);
                System.out.println("Balance: $" + poker.balance);
                System.out.println("Hand: " + poker.hand);
                System.out.println("[bet], [fold], [check]");
                String userInputVI = scan.nextLine();
                System.out.println("~~~" + userInputVI);
                if (userInputVI.equals("bet")) {
                    System.out.println("how much?");
                    int userInputVII = scan.nextInt();
                    System.out.println("- $" + userInputVII);
                    poker.balance -= userInputVII;
                    poker.pot += (userInputVII * poker.players);
                    break;
                } else if (userInputVI.equals("fold")) {
                    poker.fold = true;
                    break;
                } else if (userInputVI.equals("check")) {
                    System.out.println("- $" + 0);
                    break;
                } else {
                    System.out.println(";p");
                }
            }
            poker.flop.add(poker.setCard());
            while (poker.fold.equals(false)) {

                System.out.println("River: " + poker.flop);
                System.out.println("Pot: $" + poker.pot);
                System.out.println("Balance: $" + poker.balance);
                System.out.println("Hand: " + poker.hand);
                System.out.println("[bet], [fold], [check]");
                String userInputIIX = scan.nextLine();
                System.out.println("~~~" + userInputIIX);
                if (userInputIIX.equals("bet")) {
                    System.out.println("how much?");
                    int userInputIX = scan.nextInt();
                    System.out.println("- $" + userInputIX);
                    poker.balance -= userInputIX;
                    poker.pot += userInputIX;
                    break;
                } else if (userInputIIX.equals("fold")) {
                    poker.fold = true;
                    break;
                } else if (userInputIIX.equals("check")) {
                    System.out.println("- $" + 0);
                    break;
                } else {
                    System.out.println(";p");
                }
            }
            poker.player2Hand.add(poker.setCard());
            poker.player2Hand.add(poker.setCard());
            System.out.println("Final: " + poker.flop);
            boolean test = poker.flop.contains(poker.player2Hand);
            System.out.println("Opponents Hand: " + poker.player2Hand);
            System.out.println("Hand: " + poker.hand);
            if (!test && !poker.fold) {
                System.out.println("YOU WIN!!");
                System.out.println("+ $" + poker.pot);
                poker.balance += poker.pot;
                System.out.println("Balance: $" + poker.balance);
            } else {
                System.out.println("YOU LOSE!!");
                System.out.println("Balance: $" + poker.balance);
            }
            while (true) {
                System.out.println("Play again? [yes] [no]");
                String userInputX = scan.nextLine();
                if (userInputX.equals("no")) {
                    System.out.println("THANKS FOR PLAYING!!! <3 <3 <3 " + poker.heart + " " + poker.heart + " " + poker.heart);
                    break;
                } else if (userInputX.equals("yes")) {
                    poker.rounds++;
                    System.out.println("Round: " + poker.rounds);
                    poker.hand.clear();
                    poker.flop.clear();
                    poker.player2Hand.clear();
                    poker.fold = false;
                    break;
                } else {
                    System.out.println(";p");
                }
            }
        }
    }
}