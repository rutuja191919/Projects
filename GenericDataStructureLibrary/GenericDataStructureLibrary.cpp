#include<iostream>
using namespace std;

template<class T>
struct singlynode
{
 T data;
 struct singlynode *next;
};

template<class T>
struct doublynode
{
 T data;
 struct doublynode<T> *next;
 struct doublynode<T> *prev;
};

template<class T>
class SinglyLL
{
   private:
     struct singlynode<T> *head;
     int count;

   public:
    SinglyLL();
    void InsertFirst(T);
    void InsertLast(T);
    void InsertAtPos(T, int);
    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int);
	int SearchFirstOccu(T);
	int SearchLastOccu(T);
    void Display();
    int Count();
};

template<class T>
class SinglyCLL
{
   private:
     struct singlynode<T> *head;
	 struct singlynode<T> *tail;
     int count;

   public:
    SinglyCLL();
    void InsertFirst(T);
    void InsertLast(T);
    void InsertAtPos(T, int);
    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int);
	int SearchFirstOccu(T);
	int SearchLastOccu(T);
    void Display();
    int Count();
};

template<class T>
class DoublyLL
{
   private:
     struct doublynode<T> *head;
     int count;

   public:
    DoublyLL();
    void InsertFirst(T);
    void InsertLast(T);
    void InsertAtPos(T, int);
    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int);
	int SearchFirstOccu(T);
	int SearchLastOccu(T);
    void Display();
    int Count();
};

template<class T>
class DoublyCLL
{
   private:
     struct doublynode<T> *head;
	 struct doublynode<T> *tail;
     int count;

   public:
    DoublyCLL();
    void InsertFirst(T);
    void InsertLast(T);
    void InsertAtPos(T, int);
    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int);
	int SearchFirstOccu(T);
	int SearchLastOccu(T);
    void Display();
    int Count();
};

template<class T>
class Stack
{
   private:
     struct singlynode<T> * head;
     int count;

   public:
    Stack();
    void Push(T);
    T Pop();
    void Display();
    int Count();
};

template<class T>
class Queue
{
   private:
     struct singlynode<T> *head;
     int count;

   public:
    Queue();
    void Enqueue(T);
    T Dequeue();
    void Display();
    int Count();
};

template<class T>
SinglyLL<T> :: SinglyLL()
{
  head = NULL;
  count = 0;
}

template<class T>
void SinglyLL<T> :: InsertFirst(T no)
{
  struct singlynode<T> * newn = NULL;
	
	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
	if(head == NULL)
	{
		head = newn;		
	}
	else
	{
		newn->next = head;
		head = newn;
	}
  count++;
}

template<class T>
void SinglyLL<T> :: InsertLast(T no)
{
  struct singlynode<T> *newn = NULL;
	
	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
	if(head == NULL)
	{
		head = newn;		
	}
	else
	{
		 struct singlynode<T> *temp = head;
		 
		 while(temp->next != NULL)
		 {
			temp = temp->next; 
		 }
		 temp->next = newn;
	}
  count++;
}

template<class T>
void SinglyLL<T> :: InsertAtPos(T no, int pos)
{
  if(pos < 1 && pos > (count + 1))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(pos == 1)
	{
		 InsertFirst(no);
	}
	else if(pos == count)
	{
		InsertLast(no);
	}
	else
	{
	  struct singlynode<T>  *newn = NULL;
	  int iCnt = 0;
	  struct singlynode<T> *temp = head;
		
	  newn = new struct singlynode<T>;
	
	  newn->data = no;
	  newn->next = NULL;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
        temp = temp->next;			
		}	
		newn->next = temp->next;
		temp->next = newn;

    count++;
	}
}

template<class T>
void SinglyLL<T> :: DeleteFirst()
{
	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return;
	}
	else
	{
		struct singlynode<T> *temp = head;
		head = head->next;
    delete temp;		
	}
	count--;
}

template<class T>
void SinglyLL<T> :: DeleteLast()
{
	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return;
	}
	else
	{
		struct singlynode<T> *temp = head;
		
		while(temp->next->next != NULL)
		{
			temp = temp->next;
		}
		delete temp->next;
		temp->next = NULL;
	}
	count--;
}

template<class T>
void SinglyLL<T> :: DeleteAtPos(int pos)
{
	if(pos < 1 || pos > count)
	{
		printf("Invalid Position\n");
		return;
	}
	
	if(pos == 1)
	{
		 DeleteFirst();
	}
	else if(pos == count)
	{
		DeleteLast();
	}
	else
	{
		struct singlynode<T> *temp = head;
		struct singlynode<T> *temp1 = NULL;
		int iCnt = 0;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
          temp = temp->next;			
		}
		temp1 = temp->next;
		temp->next = temp1->next;
		delete temp1;

		count--;
	}
}

template<class T>
int SinglyLL<T> :: SearchFirstOccu(T no)
{
	struct singlynode<T> *temp = head;
	int iPos = 1;

	while(temp != NULL)
	{
		if(temp->data == no)
		{
			break;
		}
		iPos++;
		temp = temp->next;
	}
	return iPos;
} 

template<class T>
int SinglyLL<T> :: SearchLastOccu(T no)
{
	struct singlynode<T> *temp = head;
	int iPos = 1, iIndex = 0;

	while(temp != NULL)
	{
		if(temp->data == no)
		{
			iIndex = iPos;
		}
		iPos++;
		temp = temp->next;
	}
	return iIndex;
}

template<class T>
void SinglyLL<T> :: Display()
{
    struct singlynode<T> *temp = head;
	
	while(temp != NULL)
	{ 
    cout<<"| "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"NULL"<<endl;
}

template<class T>
int SinglyLL<T> :: Count()
{
  return count;
}

//SinglyCLL

template<class T>
SinglyCLL<T> :: SinglyCLL()
{
  head = NULL;
  tail = NULL;
  count = 0;
}

template<class T>
void SinglyCLL<T> :: InsertFirst(T no)
{
    struct singlynode<T> *newn = NULL;
	
	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
	if(head == NULL)
	{
		head = newn;		
		tail = newn;
	}
	else
	{
		newn->next = head;
		head = newn;
	}
	tail->next = head;

  count++;
}

template<class T>
void SinglyCLL<T> :: InsertLast(T no)
{ 
    struct singlynode<T> *newn = NULL;
	
	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
	if(head == NULL)
	{
		head = newn;		
		tail = newn;
	}
	else
	{
		 tail->next = newn;
		 tail = newn;
	}
	tail->next = head;

  count++;
}

template<class T>
void SinglyCLL<T> :: InsertAtPos(T no, int pos)
{
  if(pos < 1 && pos > (count + 1))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(pos == 1)
	{
		 InsertFirst(no);
	}
	else if(pos == count)
	{
		InsertLast(no);
	}
	else
	{
	  struct singlynode<T> *newn = NULL;
	  int iCnt = 0;
	  struct singlynode<T> *temp = head;
		
	  newn = new struct singlynode<T>;
	
	  newn->data = no;
	  newn->next = NULL;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
        temp = temp->next;			
		}	
		newn->next = temp->next;
		temp->next = newn;

    count++;
	}
}

template<class T>
void SinglyCLL<T> :: DeleteFirst()
{
	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return;
	}
	else
	{
		struct singlynode<T> *temp = head;
		head = head->next;
        delete temp;		
	}
	tail->next = head;

	count--;
}

template<class T>
void SinglyCLL<T> :: DeleteLast()
{
	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return;
	}
	else
	{
		struct singlynode<T> * temp = head;
		
		while(temp->next != tail)
		{
			temp = temp->next;
		}
		free(tail);
		tail = temp;
	}
	tail->next = head;

	count--;
}

template<class T>
void SinglyCLL<T> :: DeleteAtPos(int pos)
{
	if(pos < 1 || pos > count)
	{
		printf("Invalid Position\n");
		return;
	}
	
	if(pos == 1)
	{
		 DeleteFirst();
	}
	else if(pos == count)
	{
		DeleteLast();
	}
	else
	{
		struct singlynode<T> *temp = head;
		struct singlynode<T> *temp1 = NULL;
		int iCnt = 0;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
          temp = temp->next;			
		}
		temp1 = temp->next;
		temp->next = temp1->next;
		delete temp1;

		count--;
	}
}

template<class T>
int SinglyCLL<T> :: SearchFirstOccu(T no)
{
	struct singlynode<T> *temp = head;
	int iPos = 1;

	do
	{
		if(temp->data == no)
		{
			break;
		}
		iPos++;
		temp = temp->next;
	}while(temp != head);
	return iPos;
}

template<class T>
int SinglyCLL<T> :: SearchLastOccu(T no)
{
	struct singlynode<T> *temp = head;
	int iPos = 1, iIndex = 0;;

	do
	{
		if(temp->data == no)
		{
			iIndex = iPos;
		}
		iPos++;
		temp = temp->next;
	}while(temp != head);
	return iIndex;
}

template<class T>
void SinglyCLL<T> :: Display()
{
    struct singlynode<T> *temp = head;
	do
	{ 
    cout<<"| "<<temp->data<<" |->";
		temp = temp->next;
	}while(temp != head);
	cout<<"| "<<temp->data<<"|->"<<endl;
}

template<class T>
int SinglyCLL<T> :: Count()
{
  return count;
}

template<class T>
DoublyLL<T> :: DoublyLL()
{
  head = NULL;
  count = 0;
}

template<class T>
void DoublyLL<T> :: InsertFirst(T no)
{
    struct doublynode<T> *newn = NULL;
	
	newn = new struct doublynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(head == NULL)
	{
		head = newn;	
	}
	else
	{
		newn->next = head;
		head->prev = newn;
		head = newn;
	}
	count++;
}

template<class T>
void DoublyLL<T> :: InsertLast(T no)
{
    struct doublynode<T> * newn = NULL;
	
	newn = new struct doublynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(head == NULL)
	{
		head = newn;			
	}
	else
	{
		 struct doublynode<T> * temp = head;

		 while(temp->next != NULL)
		 {
			temp = temp->next;
		 }
		 temp->next = newn;
		 newn->prev = temp;
	}
   count++;
}

template<class T>
void DoublyLL<T> :: InsertAtPos(T no, int pos)
{
  if(pos < 1 && pos > (count + 1))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(pos == 1)
	{
		 InsertFirst(no);
	}
	else if(pos == count)
	{
		InsertLast(no);
	}
	else
	{
	  struct doublynode<T> *newn = NULL;
	  int iCnt = 0;
	  struct doublynode<T> *temp = head;
		
	  newn = new struct doublynode<T>;
	
	  newn->data = no;
	  newn->next = NULL;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
        temp = temp->next;			
		}	
		newn->next = temp->next;
		temp->next->prev = newn;
		temp->next = newn;
		newn->prev = temp;

    count++;
	}
}

template<class T>
void DoublyLL<T> :: DeleteFirst()
{
	if(head == NULL)
	{
		cout<<"Linked List is empty"<<endl;
		return;
	}
	else
	{
		struct doublynode<T> *temp = head;
		head = head->next;
		head->prev = NULL;
		delete temp;
	}
	count--;
}

template<class T>
void DoublyLL<T> :: DeleteLast()
{
	if(head == NULL)
	{
		cout<<"Linked List is empty"<<endl;
		return;
	}
	else
	{
	   struct doublynode<T> *temp = head;
	   
	   while(temp->next->next != NULL)
	   {
		   temp = temp->next;
	   }
       delete temp->next;
	   temp->next = NULL;
	}
	count--;
}

template<class T>
void DoublyLL<T> :: DeleteAtPos(int pos)
{
	if(pos < 1 && pos > count)
	{
		cout<<"Invalid Position"<<endl;
		return;
	}
	
	if(pos == 1)
	{
		 DeleteFirst();
	}
	else if(pos == count)
	{
		DeleteLast();
	}
	else
	{
		struct doublynode<T> *temp = head;
		struct doublynode<T> *temp1 = NULL;
		int iCnt = 0;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
          temp = temp->next;			
		}	

		temp->next = temp->next->next;
		delete temp->next->prev;
		temp->next->prev = temp;

		count--;
	}
}

template<class T>
int DoublyLL<T> :: SearchFirstOccu(T no)
{
	struct doublynode<T> *temp = head;
	int iPos = 1;

	while(temp != NULL)
	{
		if(temp->data == no)
		{
			break;
		}
		iPos++;
		temp = temp->next;
	}
	return iPos;
}

template<class T>
int DoublyLL<T> :: SearchLastOccu(T no)
{
	struct doublynode<T> *temp = head;
	int iPos = 1, iIndex = 0;

	while(temp != NULL)
	{
		if(temp->data == no)
		{
			iIndex = iPos;
		}
		iPos++;
		temp = temp->next;
	}
	return iIndex;
}

template<class T>
void DoublyLL<T> :: Display()
{
  struct doublynode<T> *temp = head;
	
	do
	{ 
        cout<<"| "<<temp->data<<" |=>";
		temp = temp->next;
	}while(temp != NULL);
	cout<<"NULL"<<endl;
}

template<class T>
int DoublyLL<T> :: Count()
{
  return count;
}

template<class T>
DoublyCLL<T> :: DoublyCLL()
{
  head = NULL;
  tail = NULL;
  count = 0;
}

template<class T>
void DoublyCLL<T> :: InsertFirst(T no)
{
    struct doublynode<T> *newn = NULL;
	
	newn = new struct doublynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(head == NULL)
	{
		head = newn;		
		tail = newn;
	}
	else
	{
		newn->next = head;
		head->prev = newn;
		head = newn;
	}
	tail->next = head;
	head->prev = tail;
    
	count++;
}

template<class T>
void DoublyCLL<T> :: InsertLast(T no)
{
    struct doublynode<T> *newn = NULL;
	
	newn = new struct doublynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(head == NULL)
	{
		head = newn;	
        tail = newn;		
	}
	else
	{
		 tail->next = newn;
		 newn->prev = tail;
		 tail = newn;
	}
	tail->next = head;
	head->prev = tail;
  count++;
}

template<class T>
void DoublyCLL<T> :: InsertAtPos(T no, int pos)
{
  if(pos < 1 && pos > (count + 1))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(pos == 1)
	{
		 InsertFirst(no);
	}
	else if(pos == count)
	{
		InsertLast(no);
	}
	else
	{
	  struct doublynode<T> *newn = NULL;
	  int iCnt = 0;
	  struct doublynode<T> *temp = head;
		
	  newn = new struct doublynode<T>;
	
	  newn->data = no;
	  newn->next = NULL;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
        temp = temp->next;			
		}	
		newn->next = temp->next;
		temp->next = newn;

    count++;
	}
}

template<class T>
void DoublyCLL<T> :: DeleteFirst()
{
	if(head == NULL)
	{
		cout<<"Linked List is empty"<<endl;
		return;
	}
	else
	{
		head = head->next;
		delete tail->next;
	}
	tail->next = head;
	head->prev = tail;
	count--;
}

template<class T>
void DoublyCLL<T> :: DeleteLast()
{
	if(head == NULL)
	{
		cout<<"Linked List is empty"<<endl;
		return;
	}
	else
	{
	   struct doublynode<T> *temp = head;
	   
	   while(temp->next != tail)
	   {
		   temp = temp->next;
	   }
       delete tail;
	   tail = temp;
	}
	tail->next = head;
	head->prev = tail;
	count--;
}

template<class T>
void DoublyCLL<T> :: DeleteAtPos(int pos)
{
	if(pos < 1 && pos > count)
	{
		cout<<"Invalid Position"<<endl;
		return;
	}
	
	if(pos == 1)
	{
		 DeleteFirst();
	}
	else if(pos == count)
	{
		DeleteLast();
	}
	else
	{
		struct doublynode<T> *temp = head;
		struct doublynode<T> *temp1 = NULL;
		int iCnt = 0;
		
		for(iCnt = 1; iCnt < (pos - 1); iCnt++)
		{
          temp = temp->next;			
		}	
		temp->next = temp->next->next;
		delete temp->next->prev;
		temp->next->prev = temp;

		count--;
	}
}

template<class T>
int DoublyCLL<T> :: SearchFirstOccu(T no)
{
	struct doublynode<T> * temp = head;
	int iPos = 1;
	do
	{
		if(temp->data == no)
		{
			break;
		}
		iPos++;
		temp = temp->next;
	}while(temp != head);
	return iPos;
}

template<class T>
int DoublyCLL<T> :: SearchLastOccu(T no)
{
	struct doublynode<T> * temp = head;
	int iPos = 1, iIndex = 0;
	do
	{
		if(temp->data == no)
		{
			iIndex = iPos;
		}
		iPos++;
		temp = temp->next;
	}while(temp != head);
	return iIndex;
}

template<class T>
void DoublyCLL<T> :: Display()
{
  struct doublynode<T> *temp = head;
	
	do
	{ 
        cout<<"| "<<temp->data<<" |=>";
		temp = temp->next;
	}while(temp != head);
	cout<<temp->data<<endl;
}

template<class T>
int DoublyCLL<T> :: Count()
{
  return count;
}

template<class T>
Stack<T> :: Stack()
{
  head = NULL;
  count = 0;
}

template<class T>
void Stack<T> :: Push(T no)
{
  struct singlynode<T> * newn = NULL;
	
	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
	if(head == NULL)
	{
		head = newn;		
	}
	else
	{
		newn->next = head;
		head = newn;
	}
  count++;
}

template<class T>
T Stack<T> :: Pop()
{
	T Data = 0;

	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return -1;
	}
	else
	{
		struct singlynode<T> * temp = head;
		head = head->next;
		Data = temp->data;
    delete temp;		
	}
	count--;
	return Data;
}

template<class T>
void Stack<T> :: Display()
{
  struct singlynode<T> *temp = head;
	
	while(temp != NULL)
	{ 
    cout<<"| "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"NULL"<<endl;
}

template<class T>
int Stack<T> :: Count()
{
  return count;
}


template<class T>
Queue<T> :: Queue()
{
  head = NULL;
  count = 0;
}

template<class T>
void Queue<T> :: Enqueue(T no)
{
  struct singlynode<T> *newn = NULL;

	newn = new struct singlynode<T>;
	
	newn->data = no;
	newn->next = NULL;
	
  if(head == NULL)
	{
		head = newn;		
	}
   
  else
  {
    struct singlynode<T> *temp = head;
    while(temp->next != NULL)
    {
      temp = temp->next;
    }
    temp->next = newn; 
  }
  count++;
}

template<class T>
T Queue<T> :: Dequeue()
{
	T Data;

	if(head == NULL)
	{
		printf("Linked List is empty\n");
		return -1;
	}
	else
	{
		struct singlynode<T> *temp = head;
		head = head->next;
		Data = temp->data;
    delete temp;		
	}
	count--;
	return Data;
}

template<class T>
void Queue<T> :: Display()
{
  struct singlynode<T> *temp = head;
	
	while(temp != NULL)
	{ 
    cout<<"| "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"NULL"<<endl;
}

template<class T>
int Queue<T> :: Count()
{
  return count;
}