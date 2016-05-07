//DP EASY 265-1
//Solution by bruteforce

namespace uk.lonm.dp.easy{

using System;

public class PermComb {
    
    public void perm(int value, int count){
        int[] availableInts = new int[value];
        for (int i = 0; i < value; i++){
            availableInts[i] = i;
        }
        int[][] allPerms = doPerm(availableInts);
        int countup = 0;
        foreach(int[] item in allPerms){
            if(countup++ == count-1){
                Console.WriteLine(arrToStr(item));
            }
        }
    }
    
    private int[][] doPerm(int[] available){
        if(available.Length == 1){
            return new int[1][]{available};
        }
        int foundSolutions = 0;
        int availablePermutations = fact(available.Length);
        int[][] solution = new int[availablePermutations][];
        foreach(int choice in available){
            int[] nextArr = removeFirstInstanceOfItemFromArray(available, choice);
            int[][] children = doPerm(nextArr);
            foreach(int[] child in children){
                solution[foundSolutions++] = newArrayHead(choice, child);
            }
        }
        return solution;
    }
    
    private int fact(int i){
        if(i < 2){
            return 1;
        }
        return i * fact(i-1);
    }
    
    private int[] newArrayHead(int a, int[] b){
        int[] c = new int[b.Length + 1];
        b.CopyTo(c, 1);
        c[0] = a;
        return c;
    }
    
    private int[] removeFirstInstanceOfItemFromArray(int[] array, int item){
        int[] newArr = new int[array.Length-1];
        bool found = false;
        int i = 0;
        foreach(int arrayitem in array){
            if(!found && arrayitem == item){
                found = true;
                continue;
            }
            newArr[i++] = arrayitem;
        }
        return newArr;
    }
        
    public void combo(int value, int count){
        return;
    }
    
    private string arrToStr(int[] arr){
        string s = "";
        for(int i = 0; i < arr.Length - 1; i++){
            s += arr[i];
            s += " ";
        }
        s += arr[arr.Length-1];
        return s;
    }
    
}

public class Runner{
    public static void Main(string[] args){
        PermComb pc = new PermComb();
        if(args[0]=="perm"){
            pc.perm(Int32.Parse(args[3]), Int32.Parse(args[1]));
        } else if(args[0]=="help"){
            Console.WriteLine("Usage:\n\t.\\PermComb.exe perm 3 of 4\n \t\tGives the 3rd permutation of the first 4 numbers.\n\t.\\PermComb.exe comb 3 in 4 of 6\n \t\tGives the 3rd value in the combinations of 4 of the first 6 numbers.");
        }
    }
}

}
