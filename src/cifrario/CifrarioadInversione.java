package cifrario;

public class CifrarioadInversione {
	public static String cifra(String codice) {
		StringBuilder codicecifrato = new StringBuilder ();
		for(int i= codice.length()-1; i>=0; i--) {
			codicecifrato.append(codice.charAt(i));
		}
		return codicecifrato.toString();
	}
	public static String decifra(String codicecifrato) {
		return cifra(codicecifrato);
	}
	public static void main (String[]args) {
		String codice = "Sono Paolo Bonolis";
		String codicecifrato = cifra(codice);
		System.out.println("Testo cifrato:"+ codicecifrato);
		String codicedecodificato = decifra(codicecifrato);
		System.out.println("Testo decifrato:"+codicedecodificato);
	}
}
