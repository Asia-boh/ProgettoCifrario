package cifrario;

public class CifrarioBlocchi {
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
	public static void main(String args[]) {
		System.out.println(CifrarioBlocchi.cripta("LAUREATO_1", "OLE"));
	}
}
