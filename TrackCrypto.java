import java.text.DecimalFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	public class TrackCrypto {
		JFrame f;
		//data from Crypto.com
		String nameIndexes[] = {"Bitcoin", "XRP", "Ethereum", "Solana", "Stellar", "Cardano", "Shiba Inu", "Algorand", "Decentraland","Hedera","The Sanbox","XDC Network","Polkaste","Akash Network","DIA","Injective","Numeraine","Ocean Protocol","UniBot","NKN","Litecoin" };
		String symbolIndexes[] = {"BTC", "XRP","ETH","SOL","XLM","ADA","SHIB","ALGO","MANA","HBAR","SAND","XDC","POLS","AKT","DIA","INJ","NMR","OCEAN","UNIBOT","NKN","LTC"};
		String data [][]= {{"Bitcoin (BTC)", "30335.31", "0.37"},{"XRP (XRP)","0.7830","0.1"},{"Ethereum (ETH)","1925.62","0.7"},{"Solana (SOL)","26.12","0.90"},{"Stellar (XLM)", "0.1600", "0.456"},{"Cardano (ADA)", "0.3199", "0.10"},{"Shiba Inu (SHIB)", "0.0008", "0.69"},{"Algorand (ALGO)", "0.1173","0.52"},{"Decentraland (MANA)","0.4121","0.31"},{"Hedera (HBAR)","0.05655","0.54"},{"The Sandbox (SAND)","0.4538","0.59"},{"XDC Network (XDC)","0.0421","0.78"},{"Polkaste (POLS)","0.3433","0.74"},{"Akash Network (AKT)","0.67","0.85"},{"DIA (DIA)","0.293","0.19"},{"Injective (INJ)","9.0300","0.03"},{"Numeraire (NMR)","13.2400","0.04"},{"Ocean Protocol(OCEAN)","0.3812","0.06"},{"UniBot (UNIBOT)","127.81","0.35"},{"Worlcoin (WLD)","2.510","0.52"},{"NKN (NKN)","0.093","0.04"},{"Litecoin (LTC)","90.190","0.03"},{"WAX (WAXP)","0.0598","0.613"},{"Gala (GALA)","0.02519","0.617"}};
		String column[]= {"Coin name", "Coin Price (USD)", "Tendency to increase every 24 hours"};
		String coin;
		double totalCoins;
		String coinToSave;
		List<String[]> purchasedCryptos;
		Scanner in = new Scanner(System.in);
	 	TrackCrypto(){
			f = new JFrame();
			JTable jt = new JTable(data,column);
			jt.setBounds(30,40,200,300);
			JScrollPane sp=new JScrollPane(jt);
			f.add(sp);
			f.setSize(300,400);
			f.setVisible(true);
			purchasedCryptos = new ArrayList<>();
		}
		
	 	public String getPrice() {
	 		String coin = in.nextLine();
	 		int index = Arrays.asList(nameIndexes).indexOf(coin);
	 		if(index == -1) {
	 			index = Arrays.asList(symbolIndexes).indexOf(coin);
	 		}
	 		
	 		if(index == -1) {
	 			System.out.println("Please enter a valid name or a valid symbol");
	 			return "";
	 		}
	 		
	 		return data[index][1];
	 		
	 	}
	 	
	 	public String getTendency() {
	 		String coin = in.nextLine();
	 		int index = Arrays.asList(nameIndexes).indexOf(coin);
	 		if(index == -1) {
	 			index = Arrays.asList(symbolIndexes).indexOf(coin);
	 		}
	 		
	 		if(index == -1) {
	 			System.out.println("Please enter a valid name or a valid symbol");
	 			return "";
	 		}
	 		
	 		return data[index][2];
	 		
	 	}
	 	public void buyCoin () {
	 		System.out.println("Please enter the amount to invest");
	 		double dollars = Double.parseDouble(in.nextLine());
	 		System.out.println("Which coin would you like to buy, type the name and you automatically would see the price");
	 	    coin = in.nextLine();
	 		int index = Arrays.asList(nameIndexes).indexOf(coin);
	 		if(index == -1) {
	 			index = Arrays.asList(symbolIndexes).indexOf(coin);
	 		}
	 		
	 		while(index == -1) {
	 			System.out.println("Please enter a valid name or a valid symbol");
	 			 coin = in.nextLine();
	 	 		 index = Arrays.asList(nameIndexes).indexOf(coin);
	 			System.out.println("");
	 		}
	 		String priceasString = data[index][1];
	 		double priceasInt = Double.parseDouble(priceasString);
	 		totalCoins = dollars/priceasInt;
	 		DecimalFormat df = new DecimalFormat("#.##");
	 		String[] purchasedCryptoInfo = new String[3];
	        purchasedCryptoInfo[0] = coin;
	        purchasedCryptoInfo[1] = String.valueOf(totalCoins);
	        purchasedCryptoInfo[2] = priceasString;
	        purchasedCryptos.add(purchasedCryptoInfo);
	        System.out.println("Confirmed !!! you just bought a total of " + df.format(totalCoins) + " " + coin + " coins.");
	    }
	        	/* coinToSave = String.valueOf(totalCoins);
	            String[][] yourCoins= new String [1][2];//trying to save the name of the coin and the total amount in a 2D array
	 	 		yourCoins[0][0]= coin;
	 	 		yourCoins[0][1]= coinToSave;
	 	 		savedCryptos.add(yourCoins);
	 	 			System.out.println(Arrays.deepToString(yourCoins));*/
	 	public void displaySavedCryptos() {
	 		  
	 		        System.out.println("Saved Crypto Coins:");
	 		        for (String[] cryptoInfo : purchasedCryptos) {
	 		            String coinName = cryptoInfo[0];
	 		            double totalAmount = Double.parseDouble(cryptoInfo[1]);
	 		            String priceasString = cryptoInfo[2];
	 		            double priceasInt = Double.parseDouble(priceasString);
	 		            DecimalFormat df = new DecimalFormat("#.##");
	 		            System.out.println(coinName + ": " + df.format(totalAmount) + " coins. (Total Value: $" + df.format(totalAmount * priceasInt) + ")");
	 		        	}
	 		    }   
		}
	 	