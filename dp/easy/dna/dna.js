    // /r/DailyProgrammer Challenge Easy 207
    function correlate(string){
        string = string.toUpperCase();
        var pairs = "";
        for (var i = 0; i < string.length; i++){
            if(string.charAt(i)==='A')
                pairs = pairs + 'T';
            else if(string.charAt(i)==='T')
                pairs = pairs + 'A';
            else if(string.charAt(i)==='G')
                pairs = pairs + 'C';
            else if(string.charAt(i)==='C')
                pairs = pairs + 'G';
            else{
                pairs = "error in input";
                return pairs;
            }
        }
        return pairs;
    }
    // /r/DailyProgrammer Challenge Easy 207 Bonus
    // copied json from /u/reboticon because I have better things to do with my time
    function name(string){
        var codons = {'TTT':'Phe', 'TTC':'phe', 'TTA':'leu','TTG':'Leu','CTT':'Leu','CTC':'Leu',
             'CTA':'Leu','CTG':'Leu','ATT':'Lle','ATC':'Lle','ATA':'Lle','ATG':'Met',
             'GTT':'Val','GTC':'Val','GTA':'Val','GTG':'Val','TCT':'Ser','TCC':'Ser',
             'TCA':'Ser','TCG':'Ser','CCT':'Pro','CCC':'Pro','CCA':'Pro','CCG':'Pro',
             'ACT':'Thr','ACC':'Thr','ACA':'Thr','ACG':'Thr','GCT':'Ala','GCC':'Ala',
             'GCA':'Ala','GCG':'Ala','TAT':'Tyr','TAC':'Tyr','TAA':'Stop','TAG':'Stop',
             'CAT':'His','CAC':'His','CAA':'Gln','CAG':'Gln','AAT':'Asn','AAC':'Asn',
             'AAA':'Lys','AAG':'Lys','GAT':'Asp','GAC':'Asp','GAA':'Glu','GAG':'Glu',
             'TGT':'Cys','TGC':'Cys','TGA':'Stop','TGG':'Trp','CGT':'Arg','CGC':'Arg',
             'CGA':'Arg','CGG':'Arg','AGT':'Ser','AGC':'Ser','AGA':'Arg','AGG':'Arg',
             'GGT':'Gly','GGC':'Gly','GGA':'Gly','GGG':'Gly'};
        string = string.toUpperCase();
        if(string.length%3!=0)
            return 'error in input';
        bases = "";
        while(!(string==="")){
            base = string.substr(0,3);
            bases = bases + codons.base;
            string = string.substr(3);
        }
        return bases;
    }