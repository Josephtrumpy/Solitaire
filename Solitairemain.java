import java.util.*;

public class Solitairemain {
    public static void main(String[] args) {

        Stack<Card>[] field = new Stack[7];
        Stack<Card>[] finish = new Stack[4];
        Stack<Card> middle = new Stack();
        Stack<Card> drawpile = new Stack<>();
        Deck fun = new Deck();

        Scanner s = new Scanner(System.in);

        field[0] = new Stack<Card>();
        field[1] = new Stack<Card>();
        field[2] = new Stack<Card>();
        field[3] = new Stack<Card>();
        field[4] = new Stack<Card>();
        field[5] = new Stack<Card>();
        field[6] = new Stack<Card>();

        finish[0] = new Stack<Card>();
        finish[1] = new Stack<Card>();
        finish[2] = new Stack<Card>();
        finish[3] = new Stack<Card>();

        for (int lcv = 0; lcv < 7; lcv++) {

            for (int lcvx = 0; lcvx <= lcv - 1; lcvx++) {
                field[lcv].add(fun.draw());
            }
            field[lcv].add(fun.draw());

            field[lcv].peek().flip();
        }

        for (int x = 0; x < 100; x++) {

            for (int lcv = 0; lcv < 7; lcv++) {

                System.out.print(field[lcv].toString());
                System.out.println();
            }

            if (drawpile.size() != 0) {
                System.out.println(drawpile.peek().toString());
            }
            if (finish[0].size() != 0) {
                System.out.println(finish[0].peek().toString());
            }
            if (finish[1].size() != 0) {
                System.out.println(finish[1].peek().toString());
            }
            if (finish[2].size() != 0) {
                System.out.println(finish[2].peek().toString());
            }
            if (finish[3].size() != 0) {
                System.out.println(finish[3].peek().toString());
            }


            System.out.println("Do you want to move a card");

            String str = s.nextLine();

            if (str.equalsIgnoreCase("yes")) {

                System.out.println("Where do you want to move from? (1-8)");
                int from = s.nextInt();
                System.out.println("Where do you want to move to? (1-7) or (9-12) for finishing pile 9 is Clubs, 10 is Diamonds, 11 is Hearts, 12 is Spades");
                int to = s.nextInt();
                int there = 0;
                if (from == 8) {
                    Card temp5 = drawpile.peek();
                    if (to == 9 || to == 10 || to == 11 || to == 12) {

                        if (to == 9) {

                            there = 1;
                        } else  if (to == 10) {
                            there = 2;
                        }
                        else if (to == 11) {
                            there = 3;
                        } else {

                            there = 4;
                                
                        }
                    
                    

                        

                        if (drawpile.isEmpty()) {

                            System.out.println("That stack is empty. Try again.");
                        }

                        if (finish[there - 1].isEmpty()) {

                            if (temp5.getRank() == 1) {

                                finish[there - 1].add(drawpile.pop());
                            } else {

                                System.out.println("You can only add a Ace to an empty stack. Try again.");
                            }

                        } else {

                            Card temp6 = finish[there - 1].peek();

                            if (temp5.isRed() == temp6.isRed() && temp6.getRank() == temp5.getRank() - 1
                                    && temp5.getSuit() == temp6.getSuit()) {

                                finish[there - 1].add(drawpile.peek());
                                drawpile.pop();
                            } else {

                                System.out.println(
                                        "You can only move a card onto a card of the same suit and one rank higher. Try again.");
                            }
                        }
                    }else{
                
                    Card temp3 = drawpile.peek();
                    if (drawpile.isEmpty()) {

                        System.out.println("That stack is empty. Try again.");
                    }

                    if (field[to - 1].isEmpty()) {

                        if (temp3.getRank() == 13) {

                            field[to - 1].add(drawpile.pop());
                        } else {

                            System.out.println("You can only move a King to an empty stack. Try again.");
                        }
                    } else {
                        Card temp4 = field[to - 1].peek();

                        if (temp3.isRed() != temp4.isRed() && temp3.getRank() == temp4.getRank() - 1) {

                            field[to - 1].add(drawpile.peek());
                            drawpile.pop();
                        } else {

                            System.out.println("You can only move a card onto a card of the opposite color and one rank higher. Try again.");
                        }
                    }
                }
                }else if(to == 9 || to == 10 || to == 11 || to == 12) {

                        if (to == 9) {

                            there = 1;
                        } else  if (to == 10) {
                            there = 2;
                        }
                        else if (to == 11) {
                            there = 3;
                        } else {

                            there = 4;
                        }
                            if (field[from-1].isEmpty()) {

                            System.out.println("That stack is empty. Try again.");
                        }
                        Card temp5 = field[from-1].peek();
                        

                        if (finish[there - 1].isEmpty()) {

                            if (temp5.getRank() == 1) {

                                finish[there - 1].add(field[from-1].pop());
                                if(field[from-1].isEmpty() != true){
                                field[from-1].peek().flip();
                                }
                            } else {

                                System.out.println("You can only add a Ace to an empty stack. Try again.");
                            }

                        } else {

                            Card temp6 = finish[there - 1].peek();

                            if (temp5.isRed() == temp6.isRed() && temp6.getRank() == temp5.getRank() - 1
                                    && temp5.getSuit() == temp6.getSuit()) {

                                finish[there - 1].add(field[from-1].peek());
                                field[from-1].pop();
                            } else {

                                System.out.println(
                                        "You can only move a card onto a card of the same suit and one rank higher. Try again.");
                            }
                    }
                }else {

                    if (field[from - 1].isEmpty()) {

                        System.out.println("That stack is empty. Try again.");
                    } else {

                        Card temp = field[from - 1].peek();
                        if (field[to - 1].isEmpty()) {

                            if (temp.getRank() == 13) {

                                field[to - 1].add(field[from - 1].pop());
                                if(field[from - 1].isEmpty() != false){
                                    field[from - 1].peek().flip();
                                }
                            } else {

                                System.out.println("You can only move a King to an empty stack. Try again.");
                            }
                        } else {

                            Card temp2 = field[to - 1].peek();
                            if (temp.isRed() != temp2.isRed() && temp.getRank() == temp2.getRank() - 1) {

                                field[to - 1].add(field[from - 1].pop());

                                if (field[from - 1].isEmpty() == false) {

                                    field[from - 1].peek().flip();
                                }
                            } else {
                                if(field[from-1].isEmpty() != true){
                                while (field[from - 1].peek().isFaceUp() != false) {

                                    middle.add(field[from - 1].peek());
                                    field[from - 1].pop();
                                }
                            }

                                if (temp.isRed() != temp2.isRed() && temp.getRank() == temp2.getRank() - 1) {

                                    field[to - 1].add(middle.peek());
                                    middle.pop();
                                } else {

                                    while (middle.size() > 0) {

                                        field[from - 1].add(middle.peek());
                                        middle.pop();

                                    }

                                    System.out.println(
                                            "You can only move a card onto a card of the opposite color and one rank higher. Try again.");
                                }
                            }
                            } 
                        }
                    }
            } else {
                if (str.equalsIgnoreCase("no")){
                System.out.println("do you want to draw");
                String stri = s.nextLine();

                if (stri.equalsIgnoreCase("yes")) {

                    drawpile.add(fun.draw());
                    drawpile.peek().flip();
                }
                }
            }
        }
    }
}
