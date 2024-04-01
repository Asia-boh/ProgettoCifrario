package cifrario;

public class CifrarioBlocchi {
	
	// Asia Andrea Fusi: cifrario a blocchi
	
	public static String cripta(String informazione, String key){
		String keyRipetuta = "";
		int k = 0;
		while(keyRipetuta.length() < informazione.length()) {
			keyRipetuta += key.charAt(k);
			if(k == key.length() - 1 ) {
				k = 0;
			}
			else {
				k++;
			}
		}
		String stringaCriptata = "";
		for(int i = 0; i < keyRipetuta.length(); i++){
			char lettera = (char) ((keyRipetuta.charAt(i) + informazione.charAt(i) - 64) %96 + 32);
			stringaCriptata += lettera;
		}
		return stringaCriptata;
	}
	public static String decripta(String informazioneCriptata, String key){
		String newKey = "";
		char lettera;
		for(int i = 0; i < key.length(); i++) {
			lettera = (char) (160 - key.charAt(i));
			newKey += lettera;
		}
		return CifrarioBlocchi.cripta(informazioneCriptata, newKey);
	}
}
