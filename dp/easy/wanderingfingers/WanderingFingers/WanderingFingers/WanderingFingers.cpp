// WanderingFingers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "TrieDictionary.h"
#include <iostream>


int main()
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

