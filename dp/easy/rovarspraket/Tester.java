package uk.lonm.dp.easy.rovarspraket;
/*/r/DailyProgrammer Challenge Easy 212 Te*/
public class Tester {
	public static void main(String[] args) {
		Encoder e = new Encoder();
		Decoder d = new Decoder();
		if(args.length > 1)
			for (int i = 2; i < args.length; i++){
				args[1] = args[1] + " "+args[i];
			}
		if (args[0].equals("e"))
			System.out.println(e.encode(args[1]));
		else if(args[0].equals("d"))
			System.out.println(d.decode(args[1]));
	}
}
