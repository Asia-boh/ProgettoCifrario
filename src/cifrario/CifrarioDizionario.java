package cifrario;

public class CifrarioDizionario {
	// Matteo Mazzanti= CifrarioDizionario
	
	public static   String cripta(String Parolaordine) {
		String stringCript="";
		char letter;
		for(int i=0;i < Parolaordine.length();i++) {
			letter=Parolaordine.charAt(i);
			if(Parolaordine.charAt(i) >= 65 && Parolaordine.charAt(i)<= 90) {
				letter= (char)(122 -(Parolaordine.charAt(i)+32 - 97));
			}
			if(Parolaordine.charAt(i)>= 97 && Parolaordine.charAt(i)<=122) {
			letter= (char)(90 - (Parolaordine.charAt(i)- 32 - 65));
			}
			stringCript += letter;
		}
		return stringCript;
	}
	public static String decripta(String Parolaordine) {
		return cripta(Parolaordine);
		
	}
}

	