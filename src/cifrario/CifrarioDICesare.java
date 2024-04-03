package cifrario;

public class CifrarioDICesare {
	//Leonardo Forte
	
	
	//metodo per cifrare il testo
	
	public static String cifratura(String testoCifrato, int shift) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0; i<testoCifrato.length(); i++) {
			char c = testoCifrato.charAt(i);
			if(Character.isLowerCase(c)){
				char charSpostato =(char)(((int)c+shift-'a') % 26 +'a');
				s1.append(charSpostato);
			}
			else if(Character.isUpperCase(c)) {
				char charSpostato =(char)(((int)c+shift-'A') % 26 +'A');
				s1.append(charSpostato);
			}
				else {
				s1.append(c);
			}
		}
		return s1.toString();
	}
	
	//metodo per decifrare il testo
	
	public static String decifratura(String s1, int shift) {
		return cifratura(s1,26-shift);
	}
}
