import java.util.*;

public class Solitairemain {
    public static void main(String[] args) {

        Stack<Card>[] field = new Stack[7];
        Stack<Card>[] finish = new Stack[4];
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
            for(int lcvx=0;lcvx<=lcv;lcvx++){
                field[lcvx].add(fun.draw());
                if (lcvx==lcv){
                    field[lcv].peek().flip();
                }
            }
        }

        for(int lcv=0;lcv<7;lcv++){
            System.out.print(field[lcv].toString());
            System.out.println();
        }


    }
}
