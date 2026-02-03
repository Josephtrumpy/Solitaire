public class Card
{
    private int rank;
    private String suit;
    private boolean faceUp;

    public Card(int r, String s)
    {
        rank = r;
        suit = s;
        faceUp = false;
    }

    public int getRank()
    {
        return rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public boolean isFaceUp()
    {
        return faceUp;
    }

    public void flip()
    {
        faceUp = !faceUp;
    }

    public boolean isRed()
    {
        return suit.equals("Hearts") || suit.equals("Diamonds");
    }

    public String rankName()
    {
        if(rank ==1)
        {
            return "Ace";
        }

        if(rank == 11)
        {
            return "Jack";
        }

        if(rank == 12)
        {
            return "Queen";
        }

        if(rank == 13)
        {
            return "King";
        }

        return String.valueOf(rank);
    }

    public String toString()
    {
        if(!faceUp)
        {
            return "[XX]";

        }

        return "[" + rankName() + " " + suit + "]";
    }
}