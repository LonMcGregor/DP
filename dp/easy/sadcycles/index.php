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
        error_reporting(0);
        
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
         *      A sad cycle for the given number and base
         */
        class SadCycles{            
            
            /*
             * calculate the output for a given digit and its base
             */
            private function calcDigit($digit, $base){
                return $digit ** $base;
            }

            /*
             * Sum the digits of a number n, for a given base b
             */
            private function sumNumber($num, $base){
                $numStr = "".$num;
                $length = strlen($numStr);
                $sum = 0;
                for ($i = 0; $i < $length; $i++){
                    $currentStr = substr($numStr, $i, 1);
                    $currentDig = 0+$currentStr;
                    $sum += $this->calcDigit($currentDig,$base);
                }
                return $sum;
            }

            /*
             * bool - Check if a number is in a cycle
             */
            private function checkCycle($cycle, $num){
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
            private function formatCycle($cycle){
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
            private function findLoop($cycle, $loopNum){
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
            public function findCycle($num, $base){
                $cycle = array();
                $currentNum = $this->sumNumber($num, $base);
                do{
                    array_push($cycle, $currentNum);
                    $currentNum = $this->sumNumber($currentNum, $base);
                } while(!$this->checkCycle($cycle, $currentNum));
                $this->cycle = $this->formatCycle($this->findLoop($cycle, $currentNum));
            }
            
            public function getCycle(){
                return $this->cycle;
            }

        }
        
        //get attributes
        $num  = $_GET['num'];
        $base = $_GET['base'];

        //calculate things
        $sc = new SadCycles();
        $sc->findCycle($num, $base);

        //print result
        print "<h1>Sad Cycle for ".$num." with base ".$base.":</h1>";
        print "<p>".$sc->getCycle()."</p>";
        
        
        ?>
        <form action="index.php" method="get">
            <h3>Calculate new sad cycle:</h3>
            Number: <input type="number" name="num" />
            Base: <input type="number" name="base" />
            <input type="submit" value="Recalculate" />
        </form>
    </body>
</html>
