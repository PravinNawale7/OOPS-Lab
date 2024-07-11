/* Practical 3 
Design a base class with name, date of birth, blood group and another base
class consisting of the data members such as height and weight. Design
one more base class consisting of the insurance policy number and contact
address. The derived class contains the data members’ telephone numbers
and driving license number. Write a menu driven program to carry out the
following things: i. Build a master table ii. Display iii. Insert a new entry
iv. Delete entry v. Edit vi. Search for a record
*/

#include<iostream>
#include<string.h>
using namespace std;

class a {
protected:
    char name[10];
    int dd, mm, yyyy;
    char bg[10];
};

class b {
protected:
    float height, weight;
};

class c {
protected:
    long int policyno;
    char addr[10];
};

class employee : public a, public b, public c {
public:
    long lcno;
    long long phone;
    int key;

    int accept() {
        cout << "\nEnter details" << endl;
        cout << "Enter Your Name:- ";
        cin >> name;
        cout << "Enter Your Birth Date:- ";
        cin >> dd;
        cout << "Enter Your Birth Month:- ";
        cin >> mm;
        cout << "Enter Your Birth Year:- ";
        cin >> yyyy;
        cout << "Enter Your Blood Group:- ";
        cin >> bg;
        cout << "Enter Your Height:- ";
        cin >> height;
        cout << "Enter Your Weight:- ";
        cin >> weight;
        cout << "Enter Your Policy Number:- ";
        cin >> policyno;
        cout << "Enter Your Address:- ";
        cin >> addr;
        cout << "Enter Your Lisense Number:- ";
        cin >> lcno;
        cout << "Enter Your Phone Number:- ";
        cin >> phone;
        cin.ignore();
    }

    int display() {
        
        
        cout << "\n" << name << "\t" << dd << "\t" << mm << "\t" << yyyy << "\t" << bg << "\t" << height << "\t" << weight << "\t" << policyno << "\t"<< "\t" << addr << "\t" << lcno << "\t" << phone;
    }

    int search(char key[10]) {
        if (strcmp(name, key) == 0) {
            return 1;
        } else
            return 0;
    }
};

int main() {
    int n = 0; 
    char key[10];
    employee e[10];
    int ch;
    int i;
    do {
        cout << "\nRecords Database" << "\n" << "\n1.Add Master Table" << "\n" << "2.Display" << "\n" << "3.Search" << "\n" << "4.Modify" << "\n" << "5.Insert" << "\n" << "6.Delete" << "\n7.Exit" << "\nEnter Your Choice:- ";
        cin >> ch;
        switch (ch) {
            case 1:
                cout << "\nEnter number of entries you want to add:- ";
                cin >> n; 
                for (int i = 0; i < n; ++i)
                    e[i].accept();
                break;

            case 2:
            	cout << "\nDetails You Have Entered:";
            	cout << "\n" << "Name" << "\t" << "Day" << "\t" << "Month" << "\t" << "Year" << "\t" << "bg" << "\t" << "height" << "\t" << "weight" << "\t" << "policyno" << "\t" << "addr" << "\t" << "lcno" << "\t" << "phone";
                for (int i = 0; i < n; i++)
                    e[i].display();
                break;

            case 3:
                cout << "\nEnter name you want to search:- ";
                cin >> key;
                for (int i = 0; i < n; i++)
                    if (e[i].search(key)) {
                        cout << "Entry found";
                        break;
                    }
                if (i == n) {
                    cout << "\nRecord not found";
                }
                break;

            case 4:
                cout << "\nEnter name of the person:- ";
                cin >> key;
                for (int i = 0; i < n; i++)
                    if (e[i].search(key)) {
                        e[i].accept();
                        break;
                    }
                if (i == n) {
                    cout << "\nRecord not present";
                    break;
                }
                break;

            case 5:
                if (n < 10) { 
                    e[n++].accept();
                } else {
                    cout << "\nCannot add more entries. Limit reached.";
                }
                break;

            case 6:
                cout << "\nEnter name of the person:- ";
                cin >> key;
                for (int i = 0; i < n; i++) {
                    if (e[i].search(key)) {
                        for (int j = i; j < n - 1; j++) {
                            e[j] = e[j + 1];
                        }
                        n--;
                        break; 
                    }
                }
                if (i == n)
                    cout << "\nRecord not present";
                break;

            case 7:
                cout << "\nExiting...";
                break;
        }
    } while (ch != 7);
}

