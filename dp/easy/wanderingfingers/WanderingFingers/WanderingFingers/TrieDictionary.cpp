#include "stdafx.h"
#include "TrieDictionary.h"


bool TrieDictionary::Find(std::string word) const
{
	if (word.empty())
		return EndPoint;
	auto intOfChar = FirstLetterOfWord(word);
	word = word.substr(1);
	auto nextChild = Children[intOfChar];
	if (nextChild == nullptr)
		return false;
	return nextChild->Find(word);
}

bool TrieDictionary::Insert(std::string word)
{
	if (word.empty())
	{
		auto previously = EndPoint;
		EndPoint = true;
		return !previously;
	}
	auto intOfChar = FirstLetterOfWord(word);
	word = word.substr(1);
	if (Children[intOfChar] == nullptr)
		Children[intOfChar] = new TrieDictionary();
	return Children[intOfChar]->Insert(word);
}

int TrieDictionary::FirstLetterOfWord(std::string word)
{
	int i(word[0]);
	int a('a');
	return i - a;
}
