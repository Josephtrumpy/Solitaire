import java.util.*;

public class Solitairemain {
    public static void main(String[] args) {

        Stack<Card>[] field = new Stack[7];
        Stack<Card>[] finish = new Stack[4];
        Stack<Card> middle = new Stack();
        Deck fun = new Deck();

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


        for(int lcv =0;lcv<7;lcv++){
            

            for(int lcvx=0;lcvx<=lcv-1;lcvx++){
                field[lcv].add(fun.draw());
            }
            field[lcv].add(fun.draw());

            field[lcv].peek().flip();
        }
for (int x=0;x<10;x++){
        for(int lcv=0;lcv<7;lcv++){
            System.out.print(field[lcv].toString());
            System.out.println();
        }

        Scanner s = new Scanner(System.in);

        System.out.println("Do you want to move a card");

        String str = s.nextLine();

        if (str.equalsIgnoreCase("yes")){
            System.out.println("Where do you want to move from? (1-7)");
            int from = s.nextInt();
            System.out.println("Where do you want to move to? (1-7)");
            int to = s.nextInt();

            if (field[from-1].isEmpty()){
                System.out.println("That stack is empty. Try again.");
            } else {
                Card temp = field[from-1].peek();
                if (field[to-1].isEmpty()){
                    if (temp.getRank() == 13){
                        field[to-1].add(field[from-1].pop());
                    } else {
                        System.out.println("You can only move a King to an empty stack. Try again.");
                    }
                } else {
                    Card temp2 = field[to-1].peek();
                    System.out.println(temp.isRed());
                    System.out.println(temp2.isRed());
                    System.out.println(temp.getRank());
                    System.out.println(temp2.getRank());
                    if (temp.isRed() != temp2.isRed() && temp.getRank() == temp2.getRank()-1){
                        field[to-1].add(field[from-1].pop());

                        field[from-1].peek().flip();
                    } else {

                        while (field[from-1].peek().isFaceUp() != false) {
                            middle.add(field[from-1].peek());
                            field[from-1].pop();
                        }

                        if (temp.isRed() != temp2.isRed() && temp.getRank() == temp2.getRank()-1){
                            field[to-1].add(middle.peek());
                            middle.pop();
                        }
                        else{
                            while(middle.size() > 0){
                                
                            field[from-1].add(middle.peek());
                            middle.pop();

                            }
                            
                            System.out.println("You can only move a card onto a card of the opposite color and one rank higher. Try again.");
                        }
                        

                        
                    }
                }
            }
        }
    
    }
}
}