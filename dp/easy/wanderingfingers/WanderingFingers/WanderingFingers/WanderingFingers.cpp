// WanderingFingers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "WanderingFingers.h"

void main()
{
	using namespace std;
	auto td = TrieDictionary();
	ifstream inf("..\\enable1.txt");

	if(!inf)
	{
		cerr << "Never mind";
		return;
	}

	cout << "Loading Dictionary..." << "\n";
	while (inf)
	{
		string strInput;
		inf >> strInput;
		//cout << strInput << endl;
		td.Insert(strInput);
	}
	cout << "Loading Complete!" << "\n";

	while(true)
	{
		cout << "Enter your swipe-word > ";
		string myWord;
		getline(cin, myWord);

		//<letters> to take off: [dont take a letter, 1st letter, 2nd letter, 3rd letter, ..., n-1th letter]
		//always leave on the 0th and nth letter
		auto validWords = new LinkedList("Valid Words");
		TestWords(myWord, validWords, td);
		validWords->Print();
	}
}

void TestWords(std::string word, LinkedList * validWords, TrieDictionary td)
{
	using namespace std;
	if (td.Find(word)) validWords->Append(word);
	if (word.size() <= 5) return;
	for (auto i = 1; i < word.size() - 1; i++)
	{
		auto newword = word.substr(0,i) + word.substr(i+1);
		cout << newword << " - " << word.size() << " - " << i << "\n";
		if (td.Find(newword)) validWords->Append(newword);
		TestWords(newword, validWords, td);
	}
}



int test()
{
	auto td = TrieDictionary();
	auto counter = 12;
	std::cout << ++counter << " - " << (td.Find("a")  == false) << "\n";
	std::cout << ++counter << " - " << (td.Find("aa")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("m")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("mm")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("z")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("zz")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("amz")== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("zma")== false) << "\n";
	counter++;
	std::cout << ++counter << " - " << (td.Insert("a")== true) << "\n";
	std::cout << ++counter << " - " << (td.Find("a")	== true) << "\n";
	std::cout << ++counter << " - " << (td.Find("aa")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("amz")== false) << "\n";
	counter++;
	std::cout << ++counter << " - " << (td.Insert("aa") == true) << "\n";
	std::cout << ++counter << " - " << (td.Find("a")	== true) << "\n";
	std::cout << ++counter << " - " << (td.Find("aa")	== true) << "\n";
	std::cout << ++counter << " - " << (td.Find("amz")== false) << "\n";
	counter++;
	std::cout << ++counter << " - " << (td.Insert("zma") == true) << "\n";
	std::cout << ++counter << " - " << (td.Find("z")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("zz")	== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("amz")== false) << "\n";
	std::cout << ++counter << " - " << (td.Find("zma")== true) << "\n";
	counter++;
	std::cout << ++counter << " - " << (td.Insert("zma") == false) << "\n";
	std::cout << ++counter << " - " << (td.Find("zma") == true) << "\n";

	std::cin.get(); //pause
    return 0;
}

