package cifrario;

public class CifraioDICesare {

	//metodo per cifrare il testo
	
	public static String Cifratura(String testoCifrato, int shift) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0; i<testoCifrato.length(); i++) {
			char c = testoCifrato.charAt(i);
			if(Character.isLetter(c)) {
				char charSpostato =(char)(((int)c+shift-'a') % 26 +'a');
				s1.append(charSpostato);
			} else {
				s1.append(c);
			}
		}
		return s1.toString();
	}
	
	//metodo per decifrare il testo
	
	public static String Decifratura(String s1, int shift) {
		return Cifratura(s1,26-shift);
	}
}
