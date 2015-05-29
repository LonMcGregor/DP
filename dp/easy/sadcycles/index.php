<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sad Cycles</title>
    </head>
    <body>
        <?php
        /*
         * This is the Sad Cycles program implemented in PHP
         * More info at /r/DailyProgrammer, task #215 Easy
         */
        
        /*
         * Input: base, int
         *      : number, int
         * Process:
         *      sum each digit of n^b
         *      repeat for result of this until cycle is reached
         * Output:
         *      A sad cucle for the given number and base
         */
        
        
        /*
         * calculate the output for a given digit and its base
         */
        function calcDigit($digit, $base){
            return $digit ** $base;
        }
        
        /*
         * Sum the digits of a number n, for a given base b
         */
        function sumNumber($num, $base){
            $numStr = "".$num;
            $length = strlen($numStr);
            $sum = 0;
            for ($i = 0; $i < $length; $i++){
                $currentStr = substr($numStr, $i, 1);
                $currentDig = 0+$currentStr;
                $sum += calcDigit($currentDig,$base);
            }
            return $sum;
        }
        
        /*
         * bool - Check if a number is in a cycle
         */
        function checkCycle($cycle, $num){
            foreach ($cycle as $i){
                if ($i == $num){
                    return true;
                }
            }
            return false;
        }
        
        /*
         * format a cycle for printing
         */
        function formatCycle($cycle){
            $cStr = "";
            foreach($cycle as $i){
                $cStr .= $i;
                $cStr .= ", ";
            }
            $cStr = substr($cStr, 0, (strlen($cStr)-2));
            return $cStr;
        }
        
        /*
         * gets the actual loop, given a looping number
         */
        function findLoop($cycle, $loopNum){
            $loopstarted = false;
            $newArr = array();
            foreach ($cycle as $i) {
                if ($i == $loopNum && !$loopstarted){
                    $loopstarted = true;
                }
                if($loopstarted){
                    array_push($newArr, $i);
                }
            }
            return $newArr;
        }
        
        /*
         * Find the sad cycle for a given number and base
         */
        function findCycle($num, $base){
            $cycle = array();
            $currentNum = sumNumber($num, $base);
            do{
                array_push($cycle, $currentNum);
                $currentNum = sumNumber($currentNum, $base);
            } while(!checkCycle($cycle, $currentNum));
            print formatCycle(findLoop($cycle, $currentNum));
        }
        
        findCycle(117649, 5);
        
        ?>
    </body>
</html>
