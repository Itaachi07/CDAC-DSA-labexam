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
		
		public Employee()
		{
			
		}

		public Employee(int emp_id, String name, String age, String dept_name, double salary) {
			this.emp_id = emp_id;
			this.name = name;
			this.age = age;
			this.dept_name = dept_name;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [Emp_id=" + emp_id + ", Name=" + name + ", Age=" + age + ", Dept_Name=" + dept_name
					+ ", Salary=" + salary + "]";
		}
		
		void acceptdetails()
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
		
		void isStackFull()
		{
			if(size==5)
			{
				throw new RuntimeException("Stack OverFlow");
			} else System.out.println("Stack is not Full");
		}
		
		void isStackEmpty()
		{
			if(size==0)
			{
				throw new RuntimeException("Stack UnderFlow");
			} else System.out.println("Stack is not Empty");
		}
		
		void push(Employee e)
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
					}else {
							newNode.next= top;
							top.prev=newNode;
							top = newNode;
						}	
					size++;
					System.out.println("Size of Stack is "+size);
				}
		}
		void pop(Employee e)
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
		
		
	}




public class Employee_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
