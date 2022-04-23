import java.util.*; 
import java.util.Scanner;

public class PasswordGenerator {
	/** 
	 * Special characters 
	 *
	 * @return Returns n array of chars containing all valid special characters
	 */
	public static char[] getSpecialCharacters() {
		final char[] SPECIAL_CHARS = {'!', '@', '#', '_', '.', '*'};
		return SPECIAL_CHARS;
	}
	/** 
	 * Valid password characters 
	 * @return Returns String containing all valid password characters
	 */
	public static final String getValidPasswordCharacters() {
		final String PASSWORD_CHARS = "abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVEWXYZ0123456789";
		return PASSWORD_CHARS;
	}
	/** 
	 * @return Returns a single String of 140 four-letter words than can be used in a password.
	 */
	public static final String getAllFourLetterWords() {
		final String FOUR_LETTER_WORDS =
			"able bane barn bile blip boat bolt bran brat brim bulb "+
			"bull burn cane card cart clan clip cold cone core dart "+
			"deny dial dang dirk dolt door dote drip drop dupe each "+
			"earn easy fast fest file five flap flip flop foal folk "+
			"fort four full gave give gone grin hard hurt idle isle "+
			"join king knit knob land lane lard link list live long "+
			"lung made main many mile mine moat mole mote mule nine "+
			"norm note paid part pick pile ping pipe plan pole pong "+
			"port prim pull quid quip quit rain rang redo ring ripe "+
			"role root rote rung sand sang silk sing sink slam slow "+
			"song sort spam sulk take tame tang tide tile time tint "+
			"toll tone took tote trap trip turn undo vile volt vote "+
			"wart wing woke wool wore writ zero zoom";
	   return FOUR_LETTER_WORDS;
	}

	
	
	/** 
	 * Create a password 
	 * @return Returns a password meeting all of the specifications
	 */
	public static String createPassword() {
		String password = "";
		String[] words = getAllFourLetterWords().split(" ") ;
		
		//System.out.print(length);
		
		int randomIndex = (int) (Math.random() * words.length );
		//System.out.print (words [randomIndex]);
		String randomWord = words [randomIndex];
		password = password + randomWord;
		
		//get special character
		 char[] specialChar= getSpecialCharacters();
		 int randomIndexSpecialChar = (int) (Math.random() * specialChar.length);
		 char randomSpecialChar = specialChar [randomIndexSpecialChar];
		 password = password + randomSpecialChar;
		 
		 
		 //generate two random numbers
		 int num1 = (int) (Math.random() * 10);
		 int num2 = (int) (Math.random() * 10);
		 password = password + num1 + num2;
		 
		 String validPasswordChar= getValidPasswordCharacters();
		 for (int i = 0; i < 5; i++) {
			 int randomIndexPasswordChar = (int) (Math.random() * validPasswordChar.length() );
			 password = password + (validPasswordChar.charAt(randomIndexPasswordChar));
		 }
		 return password; 
	}

	/** 
	 * Return true if this password is unique to the list of generated passwords.  
	 */	
	// TODO: Write the method isUniquePassword. 
	public static boolean isUniquePassword(String aPassword, String allPasswords ) {
		if (allPasswords.contains(aPassword)) {
			return false;
		}
		else {
			return true;
		}	
	}

	/**
	 * Add aPassword to the list of unique passwords
	 * @param aPassword: the password to add
	 * @param passwordList: A string containing all unique passwords, separated by spaces
	 * @return Updated passwordList with the new password
	 */
	public static String addUniquePassword(String aPassword, String passwordList) {
		passwordList = passwordList + aPassword + " ";
		
		return passwordList;
	}
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many passwords do you want to generate? ");
		int numPasswords = scanner.nextInt();
		scanner.close();
		
		String uniquePasswords = "";
		int i =0;
		while ( i< numPasswords ) {
			String aPassword = createPassword ();
			boolean isUnique=isUniquePassword(aPassword, uniquePasswords );
					
			//System.out.println(aPassword);
			
			if (isUnique) {
				uniquePasswords = addUniquePassword(aPassword, uniquePasswords);
				i++;
			}
		}
		
		String[] allPasswords = uniquePasswords.split(" ");
		for (int j = 0; j < allPasswords.length; j++ ) {
			System.out.println(j+1 + ": " + allPasswords[j] );
		}
	}
}
