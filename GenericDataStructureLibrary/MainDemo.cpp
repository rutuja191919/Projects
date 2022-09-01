#include "GenericDataStructureLibrary.cpp"

int main()
{
  int choice = 1;
  int iEle = 0;
  char cEle = '\0';

  SinglyLL<int> sobj;
  SinglyLL<char> scobj;
  SinglyCLL<int> ssobj;
  SinglyCLL<char> sscobj;
  DoublyLL<int> dobj;
  DoublyLL<char> dcobj;
  DoublyCLL<int> ddobj;
  DoublyCLL<char> ddcobj;
  Stack<int> stacki;
  Stack<char> stackc;
  Queue<int> queuei;
  Queue<char> queuec;

  while(choice != 0)
  {
  cout<<endl<<"GENERIC DATA STRUCTURES"<<endl;
  cout<<"1. Singly Linked List"<<endl;
  cout<<"2. Singly Circular Linked List"<<endl;
  cout<<"3. Doubly Linked List"<<endl;
  cout<<"4. Doubly Circular Linked List"<<endl;
  cout<<"5. Stack"<<endl;
  cout<<"6. Queue"<<endl;
  cout<<"7. Terminate the application"<<endl;

  cout<<"Enter your choice\n";
  cin>>choice;

  switch(choice)
  {
    case 1:
          sobj.InsertFirst(100);
          sobj.InsertFirst(80);
          sobj.InsertFirst(60);
          sobj.InsertFirst(30);
          sobj.InsertFirst(20);
          sobj.InsertLast(110);
          sobj.InsertAtPos(30,2);
          sobj.DeleteFirst();
          sobj.DeleteLast();
          //sobj.DeleteAtPos(2);

          cout<<"Enter the element to search first ocuurance : "<<endl;
          cin>>iEle;
          cout<<"The first occurance of the element is at position: "<<sobj.SearchFirstOccu(iEle)<<endl;

          cout<<"Enter the element to search Last ocuurance : "<<endl;
          cin>>iEle;
          cout<<"The last occurance of the element is at position: "<<sobj.SearchLastOccu(iEle)<<endl;

          sobj.Display();
          
          cout<<"The number of nodes are : "<<sobj.Count()<<endl;

          scobj.InsertFirst('D');
          scobj.InsertFirst('C');
          scobj.InsertFirst('C');
          scobj.InsertFirst('B');
          scobj.InsertFirst('A');
          scobj.InsertLast('F');
          scobj.InsertAtPos('G',2);
          scobj.DeleteFirst();
          scobj.DeleteLast();
          scobj.DeleteAtPos(2);
    
          /*cout<<"Enter the element to search Last ocuurance : "<<endl;
          cin>>iEle;
          cout<<"The last occurance of the element is at position: "<<scobj.SearchLastOccu(iEle)<<endl;*/
          cout<<"The number of nodes are : "<<sobj.Count()<<endl;

          cout<<"Enter the element to search first occurance : "<<endl;
          cin>>cEle;
          cout<<"The first occurance of the element is at position: "<<scobj.SearchFirstOccu(cEle)<<endl;

          cout<<"Enter the element to search last occurance : "<<endl;
          cin>>cEle;
          cout<<"The last occurance of the element is at position: "<<scobj.SearchLastOccu(cEle)<<endl;
          
          scobj.Display();
          
          cout<<"The number of nodes are : "<<scobj.Count()<<endl;
          break;

   case 2:
        ssobj.InsertFirst(100);
        ssobj.InsertFirst(80);
        ssobj.InsertFirst(60);
        ssobj.InsertFirst(60);
        ssobj.InsertFirst(40);
        ssobj.InsertFirst(20);
        ssobj.InsertLast(110);  
        ssobj.InsertAtPos(30,2);
        ssobj.DeleteFirst();
        ssobj.DeleteLast();
        ssobj.DeleteAtPos(2);

        cout<<"Enter the element to search first ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The first occurance of the element is at position: "<<ssobj.SearchFirstOccu(iEle)<<endl;

        cout<<"Enter the element to search Last ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The last occurance of the element is at position: "<<ssobj.SearchLastOccu(iEle)<<endl;

        ssobj.Display();
        
        cout<<"The number of nodes are : "<<ssobj.Count()<<endl;

        sscobj.InsertFirst('D');
        sscobj.InsertFirst('C');
        sscobj.InsertFirst('B');
        sscobj.InsertFirst('B');
        sscobj.InsertFirst('B');
        sscobj.InsertFirst('A');
        sscobj.InsertLast('F');
        sscobj.InsertAtPos('G',2);
        sscobj.DeleteFirst();
        sscobj.DeleteLast();
        sscobj.DeleteAtPos(2);
          
        cout<<"Enter the element to search first occurance : "<<endl;
        cin>>cEle;
        cout<<"The first occurance of the element is at position: "<<sscobj.SearchFirstOccu(cEle)<<endl;

        cout<<"Enter the element to search last occurance : "<<endl;
        cin>>cEle;
        cout<<"The last occurance of the element is at position: "<<sscobj.SearchLastOccu(cEle)<<endl;

        cout<<"The number of nodes are : "<<sscobj.Count()<<endl;
        sscobj.Display();

        
        break;

    case 3 :
        dobj.InsertFirst(100);
        dobj.InsertFirst(80);
        dobj.InsertFirst(60);
        dobj.InsertFirst(60);
        dobj.InsertFirst(60);
        dobj.InsertFirst(40);
        dobj.InsertFirst(20);
        dobj.InsertLast(110);
        dobj.InsertAtPos(30,2);
        dobj.DeleteFirst();
        dobj.DeleteLast();  
        dobj.DeleteAtPos(2);
        
        cout<<"Enter the element to search first ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The first occurance of the element is at position: "<<dobj.SearchFirstOccu(iEle)<<endl;

        cout<<"Enter the element to search Last ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The last occurance of the element is at position: "<<dobj.SearchLastOccu(iEle)<<endl;

        dobj.Display();

        cout<<"The number of nodes are : "<<dobj.Count()<<endl;

        dcobj.InsertFirst('A');
        dcobj.InsertFirst('F');
        dcobj.InsertFirst('W');
        dcobj.InsertFirst('W');
        dcobj.InsertFirst('O');
        dcobj.InsertFirst('Q');
        dcobj.InsertLast('L');
        dcobj.InsertAtPos('T',2);
        dcobj.DeleteFirst();
        dcobj.DeleteLast();
        dcobj.DeleteAtPos(2);

        cout<<"Enter the element to search first occurance : "<<endl;
        cin>>cEle;
        cout<<"The first occurance of the element is at position: "<<dcobj.SearchFirstOccu(cEle)<<endl;

        cout<<"Enter the element to search last occurance : "<<endl;
        cin>>cEle;
        cout<<"The last occurance of the element is at position: "<<dcobj.SearchLastOccu(cEle)<<endl;

        dcobj.Display();  
          
        cout<<"The number of nodes are : "<<dcobj.Count()<<endl;
        break;

    case 4 :
        ddobj.InsertFirst(100);
        ddobj.InsertFirst(80);
        ddobj.InsertFirst(60);
        ddobj.InsertFirst(40);
        ddobj.InsertFirst(20);
        ddobj.InsertLast(110);
        ddobj.InsertAtPos(30,2);
        ddobj.DeleteFirst();
        ddobj.DeleteLast();  
        ddobj.DeleteAtPos(2);

        cout<<"Enter the element to search first ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The first occurance of the element is at position: "<<ddobj.SearchFirstOccu(iEle)<<endl;

        cout<<"Enter the element to search Last ocuurance : "<<endl;
        cin>>iEle;
        cout<<"The last occurance of the element is at position: "<<ddobj.SearchLastOccu(iEle)<<endl;
        
        ddobj.Display();
        
        cout<<"The number of nodes are : "<<ddobj.Count()<<endl;

        ddcobj.InsertFirst('A');
        ddcobj.InsertFirst('F');
        ddcobj.InsertFirst('W');
        ddcobj.InsertFirst('O');
        ddcobj.InsertFirst('Q');
        ddcobj.InsertLast('L');
        ddcobj.InsertAtPos('T',2);
        ddcobj.DeleteFirst();
        ddcobj.DeleteLast();
        ddcobj.DeleteAtPos(2);

        cout<<"Enter the element to search first ocuurance : "<<endl;
        cin>>cEle;
        cout<<"The first occurance of the element is at position: "<<ddcobj.SearchFirstOccu(cEle)<<endl;

        cout<<"Enter the element to search Last ocuurance : "<<endl;
        cin>>cEle;
        cout<<"The last occurance of the element is at position: "<<ddcobj.SearchLastOccu(cEle)<<endl;
        
        ddcobj.Display();    
        
        cout<<"The number of nodes are : "<<ddcobj.Count()<<endl;
        break;

    case 5 :
        stacki.Push(10);
        stacki.Push(20);
        stacki.Push(30);
        stacki.Push(40);
        stacki.Push(50);

        stacki.Display();
        cout<<"The number of nodes are : "<<stacki.Count()<<endl;
  
        cout<<"Popped Element is : "<<stacki.Pop()<<endl;

        stacki.Display();
        cout<<"The number of nodes are : "<<stacki.Count()<<endl;

        stackc.Push('A');
        stackc.Push('B');
        stackc.Push('C');
        stackc.Push('D');
        stackc.Push('E');

        stackc.Display();
        cout<<"The number of nodes are : "<<stackc.Count()<<endl;
  
        cout<<"Popped Element is : "<<stackc.Pop()<<endl;

        stackc.Display();
        cout<<"The number of nodes are : "<<stackc.Count()<<endl;
        break;
    
    case 6 :
        queuei.Enqueue(11);
        queuei.Enqueue(21);
        queuei.Enqueue(51);
        queuei.Enqueue(61);
        queuei.Enqueue(101);

        queuei.Display();
        cout<<"The number of nodes are : "<<queuei.Count()<<endl;
  
        cout<<"Popped Element is : "<<queuei.Dequeue()<<endl;

        queuei.Display();
        cout<<"The number of nodes are : "<<queuei.Count()<<endl;

        queuec.Enqueue('A');
        queuec.Enqueue('B');
        queuec.Enqueue('C');
        queuec.Enqueue('D');
        queuec.Enqueue('E');

        queuec.Display();
        cout<<"The number of nodes are : "<<queuec.Count()<<endl;
  
        cout<<"Popped Element is : "<<queuec.Dequeue()<<endl;

        queuec.Display();
        cout<<"The number of nodes are : "<<queuec.Count()<<endl;
        break;

   case 7:
        choice = 0;
        break;

    default:
       cout<<"Invalid choice\n";
  }
  }
  return 0;
}