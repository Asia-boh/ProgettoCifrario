package cifrario;

import java.util.ArrayList;

public class CifrarioOccorrenze {
	public static String cripta(String informazione){
		int ascii[] = new int[96];
		boolean asciiCheck[] = new boolean[96];
		String stringaCriptata = "";
		int letteraInt;
		char letteraChar;
		for(int i = 0; i < informazione.length(); i++) {
			letteraInt = informazione.charAt(i);
			ascii[letteraInt-32]++;
		}
		for(int i = 0; i < informazione.length(); i++) {
			letteraChar = informazione.charAt(i);
			if(ascii[letteraChar-32]>0 && !asciiCheck[letteraChar-32]) {
				stringaCriptata += letteraChar;
				for(int j = 0; j < informazione.length(); j++) {
					if(letteraChar == informazione.charAt(j)) {
						stringaCriptata += "-" + j;
					}
				}
				asciiCheck[letteraChar-32] = true;
				stringaCriptata += " ";
			}
		}
		return stringaCriptata;
	}
	
	public static String decripta(String informazioneCriptata){
		ArrayList<String> lettere = new ArrayList<>();
		String s = "";
		for(int i = 0; i < informazioneCriptata.length(); i++) {
			s += informazioneCriptata.charAt(i);
			if(informazioneCriptata.length() > i+1 && informazioneCriptata.charAt(i+1) == ' ') {
				lettere.add(s);
				s = "";
				i++;
			}
		}
		ArrayList<Character> stringaDecriptata = new ArrayList<>();
		for(int i = 0; i < lettere.size(); i++) {
			int c = 0;
			int multiplier = 1;
			for(int j = lettere.get(i).length() - 1; j > 0; j--) {
				if(lettere.get(i).charAt(j) != '-') {
					c += (lettere.get(i).charAt(j) - 48) * multiplier;
					multiplier *= 10;
				}
				else {
					while(stringaDecriptata.size() <= c) {
						stringaDecriptata.add(null);
					}
					stringaDecriptata.set(c, lettere.get(i).charAt(0));
					multiplier = 1;
					c = 0;
				}
			}
		}
		s = "";
		for (Character c : stringaDecriptata) {
			s += c;
		}
		return s;
	}
}
