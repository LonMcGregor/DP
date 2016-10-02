#pragma once

class LinkedList
{
public:
	explicit LinkedList(std::string word) : StoredWord(word){}
	bool HasNext() const;
	LinkedList * Next() const;
	LinkedList * Append(std::string word);
	void Print() const;
private:
	std::string StoredWord;
	LinkedList * NextNode = nullptr;
};