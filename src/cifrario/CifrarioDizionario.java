package cifrario;

public class CifrarioDizionario {
	public static String cripta(String information) {
		String stringCript="";
		char letter;
		for(int i=0;i < information.length();i++) {
			letter=information.charAt(i);
			if(information.charAt(i) >= 65 && information.charAt(i)<= 90) {
				letter= (char)(122 -(information.charAt(i)+32 - 97));
			}
			if(information.charAt(i)>= 97 && information.charAt(i)<=122) {
				letter= (char)(90 - (information.charAt(i)- 32 - 65));
			}
			stringCript += letter;
		}
		return stringCript;
	}
	public static String decripta(String information) {
		return cripta(information);
		
	}
	public static void main(String args[]) {
		String information= "Ragazzuoli.... bada come la fuma ma che siehe grulli";
		System.out.println(CifrarioDizionario.cripta(information));
		String informationCriptata= CifrarioDizionario.cripta(information);
		System.out.println(CifrarioDizionario.cripta(informationCriptata));
	}
}
	
	



