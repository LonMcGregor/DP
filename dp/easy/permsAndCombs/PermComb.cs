//DP EASY 265-A
//Solution by bruteforce

namespace uk.lonm.dp.easy{

using System;

public class PermComb {
    
    public void perm(int value, int count){
        int[][] allPerms = doPerm(range(value));
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
    
    private int[] range(int max){
        int[] r = new int[max];
        for (int i = 0; i < max; i++){
            r[i] = i;
        }
        return r;
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
        
    public void comb(int value, int count, int index){
        int[][] allPerms = doComb(range(value), count, -1);
        int countup = 0;
        foreach(int[] item in allPerms){
            if(countup++ == index-1){
                Console.WriteLine(arrToStr(item));
                return;
            }
        }
    }
        
    private int[][] doComb(int[] available, int k, int head){
        if (k == 1){
            int[][] items = new int[available.Length][];
            int count = 0;
            foreach(int item in available){
                if(item > head){
                    items[count++] = new int[] {item};
                }
            }
            return items;
        }
        int foundSolutions = 0;
        int n = available.Length;
        int availableCombinations = fact(n) / fact(n-k) * fact(k);
        int[][] solution = new int[availableCombinations][];
        foreach(int choice in available){
            if(choice > head){
                int[] nextArr = removeFirstInstanceOfItemFromArray(available, choice);
                int[][] children = doComb(nextArr, k-1, choice);
                foreach(int[] child in children){
                    if(child==null)continue;
                    solution[foundSolutions++] = newArrayHead(choice, child);
                }
            }
        }
        return solution;
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
        if(args.Length==4 && args[0]=="perm"){
            pc.perm(Int32.Parse(args[3]), Int32.Parse(args[1]));
        } else if(args.Length==6 && args[0]=="comb"){
            pc.comb(Int32.Parse(args[5]), Int32.Parse(args[3]), Int32.Parse(args[1]));
        } else {
            Console.WriteLine("Usage:\n\t.\\PermComb.exe perm 3 of 4\n \t\tGives the 3rd permutation of the first 4 numbers.\n\t.\\PermComb.exe comb 3 in 4 of 6\n \t\tGives the 3rd value in the combinations of 4 of the first 6 numbers.");
        }
    }
}

}
