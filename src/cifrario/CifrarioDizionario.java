package cifrario;

public class CifrarioDizionario {
	
	// Funzione per cifrare il testo 
	
	public static  String Cifratura(String ; testoCifrario) {
		StringBuilder s1= new StringBuilder();
		for(int i=0; i<testoCifrario.length();i++) {
			char c = testoCifrario.charAt(i);
			if (Character.isLetter(c)) {
			char charSpostato= (char)(((int)+ shift-'a')% 26 +'a');
				s1.append(CifraturaDizionario.get(c));
				
			}else {
				s1.append(c);
			}
		}
	return cifrato.toString();
	}



