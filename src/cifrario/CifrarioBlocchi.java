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
	public static String decripta(String informazioneCriptata, String key){
		String newKey = "";
		char lettera;
		for(int i = 0; i < key.length(); i++) {
			lettera = (char) (160 - key.charAt(i));
			newKey += lettera;
		}
		return CifrarioBlocchi.cripta(informazioneCriptata, newKey);
	}
	public static void main(String args[]) {
		String info = "Se n'immondo ci fosse un po' di bene e ognun si honsiderasse su fratello, ci sarebbe meno pensieri e meno pene e il mondo ne sarebbe assai piu bello";
		String key = "sesso boolean";
		System.out.println(CifrarioBlocchi.cripta(info, key));
		String infoCriptata = CifrarioBlocchi.cripta(info, key);
		System.out.println(CifrarioBlocchi.decripta(infoCriptata, key));
	}
}
