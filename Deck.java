public class Deck
{
    private Card[] cards;
    private int size;

    public Deck()
    {
        cards = new Card[52];
        size = 52;

        String [] suits = new String [4];
        suits[0] = "Clubs";
        suits[1] = "Diamonds";
        suits[2] = "Hearts";
        suits[3] = "Spades";
        
        int index = 0;
        int s =0;

        while(s < 4)
        {
            int r =1;

            while(r <=13)
            {
                cards[index] = new Card(r, suits[s]);
                index++;
                r++;
            }

            s++;
        }

        shuffle();
     }

     private void shuffle()
     {
        int lcv = size -1;

        while(lcv > 0)
        {
            int j = (int)(Math.random()*(lcv+1));

            Card temp = cards[lcv];
            cards[lcv] = cards[j];
            cards[j] = temp;
            lcv--;
        }
     }

     public Card draw()
     {
        if(size ==0)
        {
            return null;
        }

        size--;

        return cards[size];

     }

     public void addToTop(Card c)
     {
        cards[size] = c;
        size++;
     }

     public boolean isEmpty()
     {
        return size == 0;
     }

     public int getSize()
     {
        return size;
     }

}