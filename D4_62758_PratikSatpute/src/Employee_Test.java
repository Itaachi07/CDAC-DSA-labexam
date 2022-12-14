import java.util.Scanner;

//Write a program to implement stack of Employee using doubly linear linked list.
//Every Employee contains information like emp_id, name,age, dept_name and salary.


class Employee
	{
		private int emp_id;
		private String name;
		private String age;
		private String dept_name;
		private double salary;	
		
		public Employee() //Parameterless Constructor
		{
			
		}

		public Employee(int emp_id, String name, String age, String dept_name, double salary) //Parameterized Constructor
		{
			this.emp_id = emp_id;
			this.name = name;
			this.age = age;
			this.dept_name = dept_name;
			this.salary = salary;
		}

		@Override
		public String toString() //To String method
		{
			return "Employee [Emp_id=" + emp_id + ", Name=" + name + ", Age=" + age + ", Dept_Name=" + dept_name
					+ ", Salary=" + salary + "]";
		}
		
		void acceptdetails() //Method To accept details from user
		{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter Employee ID ");
			emp_id = sc.nextInt();
			System.out.println("Enter Name ");
			name = sc.next();
			System.out.println("Enter age");
			age= sc.next();
			System.out.println("Enter Department name");
			dept_name=sc.next();
			System.out.println("Enter Salary");
			salary= sc.nextDouble();
		}
		
	}
//END OF EMPLOYEE CLASS
//******************************************************************************************************

class Stack
	{
		int size =0;
		static class Node
		{
			private Employee data;
			private Node next;
			private Node prev;
			
			public Node(Employee data)
			{
				this.data=data;
				this.next=null;
				this.prev= null;
			}
		}
		private Node head;
		private Node top;
		
		public Stack()
		{
			this.top=null;
		}
		
		void isStackFull() // Method to Check Stack is full
		{
			if(size==5)
			{
				throw new RuntimeException("Stack OverFlow");
			} else System.out.println("Stack is not Full");
		}
		
		void isStackEmpty()  // Method to Check Stack is Empty
		{ 
			if(size==0)
			{
				throw new RuntimeException("Stack UnderFlow");
			} else System.out.println("Stack is not Empty");
		}
		
		void push(Employee e) //Method to push data into stack using DLLL  
		{
			//if stack is full
			if(size ==5)
			{
				throw new RuntimeException("Stack OverFlow.... You can Enter only 5 Entries ");
			} else
				{
					//create a New Node
					Node newNode = new Node(e);
					//is stack is UnderFlow
					if(size ==0)
					{
						top = newNode;
					}else //new node is added at first position
							{
							newNode.next= top;
							top.prev=newNode;
							top = newNode;
						}	
					size++;
					System.out.println("Size of Stack is "+size);
				}
		}
		void pop(Employee e) //Method to delete the element at top
		{
			//stack is UndeFlow
			if(size ==0)
			{
				throw new RuntimeException("Stack UnderFlow.");
			} else {
				// is stack contains only one node
				if(top.next==null)
					{
						top=null;
					}
				else {
						top.next.prev=null;
						top=top.next;
					}
				size--;
				System.out.println("Size of Stack is "+size);
				}
			
		}
		
		void top() //Method to peak element at top
		{	
			//is stack is UnderFlow
			if(size ==0)
			{
				throw new RuntimeException("Stack UnderFlow.");
			} else
			{
				//if Stack is Not Empty
				System.out.println("The Top element is : "+top.data);
			}
		}
		
	}

//End of Class Stack
//*********************************************************************************************


public class Employee_Test {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Stack s= new Stack();
		Employee e =null;
		int choice;
		
		do {
			System.out.println("********************************************************************");
			System.out.println("Menu");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top");
			System.out.println("4. is Stack Empty");
			System.out.println("5. is Stack Full");
			System.out.println("0. Exit");
			System.out.println("********************************************************************");
			System.out.println("Enter Choice ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
					try {
						e= new Employee();
						System.out.println("Enter Employee details");
						e.acceptdetails();
						s.push(e);
						System.out.println(e+ " Pushed into Stack");
					}
					catch(RuntimeException r)
					{
						System.out.println(r.getMessage());
					}
				break;
				
			case 2:
				try {
					s.pop(e);
					System.out.println( "Employee Popped Successfully");
				}
				catch(RuntimeException r)
				{
					System.out.println(r.getMessage());
				}
			break;
			
			case 3:
				try {
					s.top();
				}
				catch(RuntimeException r)
				{
					System.out.println(r.getMessage());
				}
			break;
			
			case 4:
				try {
					s.isStackEmpty();
				}
				catch(RuntimeException r)
				{
					System.out.println(r.getMessage());
				}
			break;
			
			case 5:
				try {
					s.isStackFull();
				}
				catch(RuntimeException r)
				{
					System.out.println(r.getMessage());
				}
			break;
			}
						
		}while (choice!=0);

	}
}
