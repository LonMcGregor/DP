#include <iostream>
#include <string>
using namespace std;

bool anagram(string s);
string* splitwords(string s);

void main(){
	while (true)
	{
		string word;
		cin >> word;
		bool result = anagram(word);
        /*cout << words[0] << " is ";
		if (!result) cout << "NOT ";
        cout << "an anagram of " << words[1] << endl;*/
	}
}

bool anagram(string whole)
{
	string words[2] = splitwords(whole);
		cout << words[0] << " & " << words[1];
	exit(0);
	/*int alphabet[26];
	string words[2];
	for (int i = 0; i < 26; i++)
	{
		alphabet[i] = 0;
	}
	words[0] = "";
	words[1] = "";
	int mode = 3;
	int position = 1;
	for (int i = 0; i < 2; i++)
	{
		mode -= 2;
		while (true)
		{
			char currentChar = whole[position++];
			if (currentChar == '"') break;
			words[0] += currentChar;
			int intChar(currentChar);
			if (int('A') <= intChar && intChar <= int('Z')) intChar += (int('a') - int('A'));
			if (int('a') <= intChar && intChar <= int('z')) alphabet[(intChar - int('a'))] += mode;
		}
		position += 4;
	}
	for (int i = 0; i < 26; i++)
	{
		if (alphabet[i] != 0)
		{
			return false;
		}
	}*/
	return true;
}

string[] splitwords(string whole)
{
	int position = 0;
	string words[2];
	while(true)
	{
		char currentChar = whole[position++];
		if (currentChar == '"') break;
	}
	while(true)
	{
		char currentChar = whole[position++];
		if (currentChar == '"') break;
		words[0] += currentChar;
	}
	while (true)
	{
		char currentChar = whole[position++];
		if (currentChar == '"') break;
	}
	while (true)
	{
		char currentChar = whole[position++];
		if (currentChar == '"') break
		words[1] += currentChar;
	}
	return words;
}