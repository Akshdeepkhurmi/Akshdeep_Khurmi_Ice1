import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card: ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the suit of your card (Heart, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Set the card value of your choice (1-13)
        luckyCard.setSuit("Hearts"); // Set the suit of your choice ("Hearts", "Diamonds", "Spades", "Clubs")
        
        boolean foundUserCard = false;
        boolean foundLuckyCard = false;
        
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                foundUserCard = true;
            }
            
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                foundLuckyCard = true;
            }
            
            if (foundUserCard && foundLuckyCard) {
                break;
            }
        }
        
        if (foundUserCard) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was not found in the magic hand.");
        }
        
        if (foundLuckyCard) {
            System.out.println("The lucky card is in the magic hand!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
    
}
