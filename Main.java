import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	UserRegistration user = new UserRegistration (null, null, null, null, null, null, null, 0, 0, null, null);
	user.getFirstName();
	user.getLastName();
	user.getAddress();
	user.getSocialSecurity();
	user.emailAddress();
	user.formatPassword();
	user.confirmedAccount();
	user.getCardInfo();
	user.getCardExpiration();
    user.getCVVcard();
	user.nameonCard();
		
		TrackCrypto crytp = new TrackCrypto();
		int option = -1;
        Scanner in = new Scanner (System.in);
		while(option != 5) {
			System.out.println("Select one of the next options");
			System.out.println("1- Check price of the crypto coin");
			System.out.println("2- Check tendency to increase");
			System.out.println("3- Buy crypto");
			System.out.println("4- Check your wallet");
			System.out.println("5- Exit");
			option = in.nextInt();
			switch(option) {
			case 1:
				System.out.println("What coin do you want to check the price? Enter name or symbol");
				System.out.println("The price of the coin is $" + crytp.getPrice());
				break;
			case 2:
				System.out.println("What coin do you want to check the tendency? Enter name or symbol");
				System.out.println("The tendency to increase is " + crytp.getTendency()+ "%");
				break;
			case 3:
				crytp.buyCoin();
				break;
			case 4:
				 crytp.displaySavedCryptos();
				break;
			case 5:
				System.out.println("  ");
				break;
			default:
				System.out.println("Choice must be a value between 1 and 5");
			}
            	
		
			
		}
		
	}

}