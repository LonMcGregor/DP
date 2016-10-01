#pragma once
#include <string>

class TrieDictionary
{
public:

	bool Find(std::string word) const;

	bool Insert(std::string word);

private:

	TrieDictionary* Children[26];
	bool EndPoint = false;

	static int FirstLetterOfWord(std::string word);
};