//DP EASY 265-B
//Solution by Exact Find

namespace uk.lonm.dp.easy{

using System;

public class PermCombB {
    
    public void perm(int permBase, long index){
        int[] available = range(permBase);
        int[] factoradic = convertDecimalToFactoradic(index, permBase);
        string solution = null;
        foreach(int factorial in factoradic){
            if(solution==null){
                solution = "";
            } else {
                solution += " ";
                solution += factorial.ToString();
            }
            available = removeItemFromIndexOfArray(available, factorial);
        }
        Console.WriteLine(solution);
    }
    
    private int[] convertDecimalToFactoradic(long input, int newBase){
        string factoradic = "";
        while(input != 0){
            long remainder = input % newBase;
            input = input / newBase;
            factoradic += remainder.ToString();
        }
        factoradic += "0";
        char[] factoradicCharArray = factoradic.ToCharArray();
        int[] factoradicArray = new int[factoradic.Length];
        int i = 0;
        foreach(char s in factoradicCharArray){
            factoradicArray[i++] = Convert.ToInt32(s);
        }
        Console.WriteLine("Found factoradic {0}", factoradic);
        return factoradicArray;
    }
    
    private int[] removeItemFromIndexOfArray(int[] input, int index){
        int[] newArray = new int[input.Length-1];
        int newPosition = 0;
        for(int i = 0; i < input.Length; i++){
            if(i!=index) newArray[newPosition++] = input[i];
        }
        return newArray;
    }
    
    private int[] range(int max){
        int[] r = new int[max];
        for (int i = 0; i < max; i++){
            r[i] = i;
        }
        return r;
    }
    
    public void comb(int value, int count, long index){
        
    }
    
}

public class Runner{
    public static void Main(string[] args){
        PermCombB pc = new PermCombB();
        if(args.Length==4 && args[0]=="perm" && args[1]=="what"){
            //
        } else if(args.Length==4 && args[0]=="perm"){
            pc.perm(Convert.ToInt32(args[3]), Convert.ToInt64(args[1]));
        } else if(args.Length==6 && args[0]=="comb" && args[1]=="what"){
            //
        } else if(args.Length==6 && args[0]=="comb"){
            //
        } else {
            Console.WriteLine("Usage:\n\t.\\PermComb.exe perm 312354 of 42\n \t\tGives the 312354th permutation of the first 42 numbers.\n\t.\\PermComb.exe perm what 0 12 5\n \t\tGives the position this number appears at in the smallest permutation list containing it.\n\t.\\PermComb.exe comb 1212 from 5 of 100\n \t\tGives the 1212nd item in a list of combinations of 5 from the first 100 numbers.\n\t.\\PermComb.exe comb what 0 3 4 3 in 4 of 6\n \t\tGives the position this item appears in a list of combinations of 4 from the first 6 numbers.");
        }
    }
}

}
