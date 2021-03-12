#include <iostream>
#include <map>
using std::string;

class Cat {
public:
	int infection;
	int c;
	string name;

	Cat(int infection, int c, string name)
		: infection(infection), c(c), name(name)
	{
	}
};

//P2 NEW NODE
bool operator<(const Cat& p1, const Cat& p2) {
	if ((p1.infection > p2.infection) || ((p1.infection == p2.infection) && (p1.c < p2.c))) {
		return true;
	}
	else {
		return false;
	}
}

//map for updating data quickly
std::map<Cat, int> updatemap;
//map for finding cats quickly
std::map<string, Cat> catmap;
//kölapp
int kl;

void ArriveAtClinic(string catName, int infectionLevel) {
	Cat cat = Cat(infectionLevel, kl, catName);
	catmap.insert(std::pair<string, Cat>(catName, cat));
	updatemap.insert(std::pair <Cat, int>(cat, cat.infection));
	kl++;
}

void UpdateInfectionLevel(string catName, int increaseInfection) {
	Cat cat = Cat(-1,-1,"");
	std::map<string, Cat>::iterator it = catmap.find(catName);
	if (it != catmap.end())
		cat = it->second;

	auto node = updatemap.find(cat);
	if (node != updatemap.end()) {
		Cat upcat = std::move(node->first);
		int const q = upcat.c;
		int const value = upcat.infection;
		updatemap.erase(node);
		if ((value + increaseInfection) > 100) {
			updatemap.insert(std::pair <Cat, int>(Cat(100,q,catName), 100));
			it->second = Cat(100, q, catName);
		}
		else { 
			updatemap.insert(std::pair <Cat, int>(Cat(increaseInfection + value, q,catName), increaseInfection+value)); 
			it->second = Cat(increaseInfection + value, q, catName);
		}
	}
}

void Treated(string catName) {
	Cat cat = Cat(-1, -1,"");
	std::map<string, Cat>::iterator it = catmap.find(catName);
	if (it != catmap.end())
		cat = it->second;
	catmap.erase(it);

	std::map<Cat, int>::iterator node = updatemap.find(cat);
	if (node != updatemap.end()) {
		updatemap.erase(node);
	}
}

void Query() {
	if (updatemap.size() > 0) {
		Cat cat = updatemap.begin()->first;
		std::cout << cat.name << std::endl;
	}
	else {
		std::cout << "The clinic is empty" << std::endl;
	}
}

int main() {
	kl = 0;
	int N;
	std::cin >> N;

	for (int i = 0; i < N; i++) {
		int start, infection = 0;
		string name;

		std::cin >> start;

		if (start == 0 || start == 1) {
			std::cin >> name >> infection;
		}
		else if (start == 2) {
			std::cin >> name;
		}

		if (start == 0) { ArriveAtClinic(name, infection); }
		else if (start == 1) { UpdateInfectionLevel(name, infection); }
		else if (start == 2) { Treated(name); }
		else if (start == 3) { Query(); }
	}
}