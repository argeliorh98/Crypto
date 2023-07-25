import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	 class UserRegistration {
	     Scanner in = new Scanner(System.in);
	     String firstName;
	     String lastName;
	     String address ="";
	     ArrayList<Integer> ssn;
	     String email;
	     String password;
	     String cardNumber;
		 int cardExpm;
		 int cardExpy;
		 int cvv;
		 String nameCard1st;
		 String nameCardLast;

    public UserRegistration(String firstName, String lastName, String address, ArrayList<Integer> ssn, String email, String password,String cardNumber, int cardExpm, int cardExpy, String nameCard1st,String nameCardLast)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.cardNumber = cardNumber;
        this.cardExpm = cardExpm;
        this.cardExpy = cardExpy;
        this.nameCard1st = nameCard1st;
        this.nameCardLast = nameCardLast;
    }

    public String getFirstName() {
        System.out.println("Please enter your first name");
        firstName = in.nextLine();
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(firstName);
        while (m.find()) {
            System.out.println("Please enter the first name again. Make sure to enter just letters");
            firstName = in.nextLine();
            m = p.matcher(firstName);
        }
        return "Valid first name: " + firstName;
    }

    public String getLastName() {
        System.out.println("Please enter your last name");
        lastName = in.nextLine();
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(lastName);
        while (m.find()) {
            System.out.println("Please enter the last name again. Make sure to enter just letters");
            lastName = in.nextLine();
            m = p.matcher(lastName);
        }
        return "Valid last name: " + lastName;
    }

    public void getAddress() {
        System.out.println("Enter the street");
        String street = in.nextLine();
        System.out.println("Enter the City");
        String city = in.nextLine();
        System.out.println("Enter the State");
        String state = in.nextLine();
        String zipCode;
        do {
            System.out.println("Enter the zip code");
            zipCode = in.nextLine();
            if (zipCode.length() != 5) {
                System.out.println("INVALID ZIPCODE. Zipcode has 5 digits");
            }
        } while (zipCode.length() != 5); // try and catch make sure to enter digits
     ;
        address = street + " " + city + " " + state + ", " + zipCode;
        System.out.println( "Confirmed address : " + address);
    }

    public ArrayList<Integer> getSocialSecurity() {
        ssn = new ArrayList<>();
        System.out.println("Enter your Social Security. Make sure to enter the 9 digits of your SS");
        String ssnInput = in.nextLine();
        while (ssnInput.length() != 9 || !ssnInput.matches("[0-9]+")) {
            System.out.println("INVALID SOCIAL SECURITY NUMBER. (Make sure to enter 9 digits of your social security)");
            System.out.println("Enter your Social Security again");
            ssnInput = in.nextLine();
        }

        for (int i = 0; i < ssnInput.length(); i++) {
            int digit = Character.getNumericValue(ssnInput.charAt(i));
            ssn.add(digit);
        }

        return ssn;
    }

    public String emailAddress() {
        System.out.println("Please enter your personal email");
        String email = in.nextLine();
        Pattern p = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(email);
        while (!m.matches()) {
            System.out.println("Invalid email format, please enter a valid email");
            email = in.nextLine();
            m = p.matcher(email);
        }
        System.out.println("Reenter your email");
        String reemail = in.nextLine();
        while (!email.equals(reemail)) {
            System.out.println("Email does not match, please enter the email again");
            reemail = in.nextLine();
        }
        return "Confirmed email: " + reemail;
    }

    public void formatPassword() {
        System.out.println("Please create your password");
        System.out.println("YOUR PASSWORD MUST CONTAIN:");
        System.out.println("*at least 8 characters\n" + "*one uppercase letter\n" + "*one lowercase letter\n"
                + "*one digit\n" + "*one special character");

        password = in.nextLine();
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%^&*()_+|<>?{}\\[\\]-]");
        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        while (!hasLetter.find() || !hasDigit.find() || !hasSpecial.find() || password.length() < 8) {
            System.out.println("INVALID PASSWORD, PLEASE TRY AGAIN !!!");
            password = in.nextLine();
            hasLetter = letter.matcher(password);
            hasDigit = digit.matcher(password);
            hasSpecial = special.matcher(password);
        }

        System.out.print("Valid password: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void confirmedAccount() {
        System.out.println("ACCOUNT CREATED PLEASE PROCEED TO REGISTER YOUR DEBIT OR CREDIT CARD");
    }
    public void getCardInfo() {
		System.out.println("Please enter your card number");
		cardNumber = in.nextLine();
		Pattern p = Pattern.compile("[0-9]{16}");
		Matcher m = p.matcher(cardNumber);
		while (!m.matches()) {
			System.out.println("PLEASE ENTER VALID CARD NUMBER");
			cardNumber = in.nextLine();
			m = p.matcher(cardNumber);
		}
		System.out.println ( "Valid card #: " + cardNumber);
	}
	public void getCardExpiration () {
		System.out.println("Enter card expiration, format MM/YY (TWO DIGITS MONTH, TWO DIGITS YEAR)");
		cardExpm = in.nextInt();
		cardExpy = in.nextInt();
		DecimalFormat formatter = new DecimalFormat("00");
		while (cardExpm < 1 || cardExpm > 12 || cardExpy < 23 || cardExpy > 33  ) {
			System.out.println("PLEASE ENTER VALID CARD EXPIRATION");
			cardExpm = in.nextInt();
			cardExpy = in.nextInt();
		}
		String cardformatm = formatter.format(cardExpm);
		String cardformaty = formatter.format(cardExpy);
		System.out.println("Valid card Exp: " + cardformatm + " / " + cardformaty);
	}
	public void getCVVcard () {
	       System.out.println("Enter card CVV");
	        try {
	            cvv = in.nextInt();
	        } 
	        catch (Exception e) {
	            System.out.println("INVALID CVV");
	            in.close();
	            return; 
	        }
	        String cvvLength = Integer.toString(cvv);
	        while (cvvLength.length() != 3) {
	            System.out.println("PLEASE ENTER VALID CVV");
	            cvv = in.nextInt();
	            cvvLength = Integer.toString(cvv); 
	        }

	        System.out.println("Valid CVV: " + cvvLength);
   }
	public void nameonCard () {
		System.out.println("Enter name on card");
		nameCard1st = in.nextLine();
		nameCardLast = in.nextLine();
		String method1stName = firstName.trim();//this variable gets the first name from the method getFirstName
		String methodLastName = lastName.trim();//this variable gets the last name from the method getLastName
		while(!nameCard1st.equalsIgnoreCase(method1stName) || !nameCardLast.equalsIgnoreCase(methodLastName)) {
			System.out.println("NAME ON CARD DO NOT MATCH WITH NAME ON ACCOUNT");
			System.out.println("To avoid fraud, we do not accept cards that have a different name from the account holder.");
			nameCard1st = in.nextLine();
			nameCardLast = in.nextLine();
		}
		System.out.println("Valid name: " + nameCard1st + " " + nameCardLast);
		System.out.println ("CARD ADDED, PLEASE CHECK OUR MANU IN ORDER TO BUY CRYPTO COINS");
	}
	

    }