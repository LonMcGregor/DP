#include "stdafx.h"
#include "LinkedList.h"
#include <iostream>

bool LinkedList::HasNext() const
{
	return NextNode != nullptr;
}

LinkedList * LinkedList::Next() const
{
	return NextNode;
}

LinkedList * LinkedList::Append(std::string word)
{
	if (HasNext()) return NextNode->Append(word);
	NextNode = new LinkedList(word);
	return NextNode;
}

void LinkedList::Print() const
{
	std::cout << StoredWord;
	if (HasNext())
	{
		std::cout << ", ";
		NextNode->Print();
	}
}