package uk.lonm.dp.easy.rovarspraket;
/*/r/DailyProgrammer Challenge Easy 212 Bonus*/
public class Decoder {
	public String decode(String s){
		char[] a = s.toCharArray();
		String e = "";
		for (int i = 0; i < a.length; i++){
			if(isConsonant(a[i])){ 
				e = e + a[i];
				i++;
				i++;
			}else{
				e = e + a[i];
			}
		}
		return e;
	}
	private boolean isConsonant(char s){
		return "bcdfghjklmnpqrstvwxz".contains((""+s).toLowerCase());
	}
}
