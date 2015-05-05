package dp.easy.rovarspraket;
/*/r/DailyProgrammer Challenge Easy 212 */
public class Encoder {
	public String encode(String s){
		char[] a = s.toCharArray();
		String e = "";
		for (char c : a)
			if(isConsonant(c)) e = e + encodeConsonant(c); else e = e + c;
		return e;
	}
	private String encodeConsonant(char s){
		return s+"o"+s;
	}
	private boolean isConsonant(char s){
		return "bcdfghjklmnpqrstvwxz".contains((""+s).toLowerCase());
	}
}
