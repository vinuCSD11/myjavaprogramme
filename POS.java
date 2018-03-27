/**ADMIN
 * 
 */
package asssignment;

/**
 * @author ADMIN
 *
 */
import java.util.*;
public class POS 
{



	static Scanner scan=new Scanner(System.in);
	static String detail [][]=new String[100][6];
	
   
	public static  void login()
	{	
	
	  String admin[]={"vinu","95@vinu"};
	
	ArrayList<String> cun=new ArrayList<String>();
	ArrayList<String>pswd=new ArrayList<String>();
	cun.add("latha");
	pswd.add("95@latha");
	
	 String position;
	 String username,password;
	
		System.out.println("\n**********************************************       Login      *************************************************");
		System.out.println("Enter your position admin or cashier /n position(admin=0 / cashier=1)");
		position=scan.next();
		System.out.println("User_Name :");
		username=scan.next();
		System.out.println("PassWord :");
		password=scan.next();
		
		if(position.equals("0") && username.equals(admin[0]) && password.equals(admin[1]))
		{
			admin_Login(cun,pswd);
		}
		else if(position.equals("1") && username.equals(cun.get(0)) && password.equals(pswd.get(0)) )
		{
			cashier_Login(username);
		}
		else
		{
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("PassWord or UserName Incorrect !!!");
			System.out.println("Try Again !!!");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			login();
		}
		
		
		
	}
	
	//Cashierlogin
		public static void cashier_Login(String username)
		{
			
			System.out.println("*****************************************************************************************************************\n");
			System.out.println(" 					Hi! "+ username.toUpperCase()+"! WELCOME TO POINT OF SALE SYSTEM.." );
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			
			Add_Item(username);
			
		}
		
		//Add_Item
		public static void Add_Item(String username){
		int TotalPrice=0;
		int cus_no=1;
		
		int Unitprice[]=new int[100];
		int price[]=new int[100];
		int quantity[]=new int[100];
		String product[]=new String[100];
		int quantityNo=0;
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++    		Add Items   	+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println(" %%%%%%           			PLEASE ENTER 0 TO FINISH  ADDING ITEMS !!!!   				%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		for(int i=0;i<100;i++)
		{
			System.out.print("Enter Product Name:");
			product[i]=scan.next();
			
			if(product[i].equals("0"))
			{
				for(int j=0;j<i;j++)
				{
					TotalPrice+=price[j];
				}
				quantityNo=i-1;
				Make_Sale(TotalPrice,quantityNo,Unitprice,price,quantity,product,username);
				break;
			}
			System.out.print("Enter quantity:");
			quantity[i]=scan.nextInt();
			System.out.print("unit Price : ");
			Unitprice[i]=scan.nextInt();
			price[i]=Unitprice[i]*quantity[i];
			System.out.println("Price : "+price[i]);
			System.out.println();
			
		}
		
		
	}
	
	//Make_Sale
	public static void Make_Sale(int TotalPrice,int no,int Unitprice[],int price[],int quantity[],String product[],String username )
	{
		Date date=new Date();
		String str =String.format("Current Date/Time : %tc", date ); 
		int amount_Pay,Balance;
		System.out.println("======================================================");
		System.out.println("Total Price: "+TotalPrice);
		System.out.println("No Of Items : "+no);
		System.out.print("Enter Amount Pay:");
		amount_Pay=scan.nextInt();
		Balance=amount_Pay-TotalPrice;
		System.out.println("Balance Pay:"+Balance);
		System.out.println("======================================================");
		
		
		
		
		detail[0][0]=username;
		detail[0][1]=" ";
		for(int i=0;i<=no;i++)
		{
			detail[0][1]=detail[0][1].concat(product[i] +" "+quantity[i]+"\n");
		}
		detail[0][2]=String.valueOf(TotalPrice);
		detail[0][3]=String.valueOf(amount_Pay);
		detail[0][4]= String.valueOf(Balance);
		detail[0][5]=str;
		
		
		
		
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++   Thank You   +++++++++++++++++++++++++++++++++++++++++++++++\n");
		String answer="y";
		System.out.println("Do you want logout ?(Yes = y // No = n)");
		answer=scan.next();
		if(answer.equals("n")||answer.equals("N")){
			cashier_Login(username);
		}
	}
	

	//Admin_Login
	public  static void admin_Login(ArrayList cun,ArrayList pswd)
	{
		int option;
		
		
		System.out.println("*****************************************************************************************************************\n");
		System.out.println("					Hi! Admin, WELCOME TO POINT OF SALE SYSTEM..");
		System.out.println("*****************************************************************************************************************\n");
		System.out.println("1. Show Daily Summary \n 2. Add / Remove User \n Select activity : ");
		option=scan.nextInt();
		System.out.println();
		if(option==1)
			show_DailySummary();
		else if(option==2)
			Add_RemoveUser(cun,pswd);
		else
		{
			System.out.println("Error..Please Select 1 / 2...");
			System.out.print("1. Show Daily Summary \n 2. Add / Remove User \n Select activity : ");
			option=scan.nextInt();
			System.out.println();
		}
	}
	
	public static void Add_RemoveUser(ArrayList cun,ArrayList pswd){
		int option;
		String new_user,password,con_pas,delete_user;
		System.out.print("1. Add User\n 2.Remove User \n Select activity : ");
		option=scan.nextInt();
		if(option==1)
		{
			System.out.println();
			System.out.print("Enter New UserName :  ");
			new_user=scan.next();
			System.out.print("Enter Password : ");
			password=scan.next();
			System.out.print("Confirm Password : ");
			con_pas=scan.next();
			System.out.println();
			
			if(password.equals(con_pas))
			{
				cun.add(new_user);
				pswd.add(password);
				System.out.println(" you have created New User "+ new_user +" SuccessFully !");
			
			}
				
			else
				System.out.println(" Password and confirm Password are not matched !");
		}
		
		else if(option==2)
		{
			System.out.println();
			System.out.print("Enter  UserName to Delete :  ");
			delete_user=scan.next();
			cun.remove(delete_user);
		}
		
	}
	
	public static void show_DailySummary(){
		System.out.println("*******************************************		Daily Summary		******************************************************");
		System.out.println("Cashier Name : " + detail[0][0] +"\t\t\t\tDate : "+ detail[0][5]);
		System.out.println(" Product Detail: "+ detail[0][1]);
		System.out.println("Total_Price : "+ detail[0][2]);
		System.out.println("Amount_Pay : "+detail[0][3]);
		System.out.println("Balance : "+detail[0][4]);
		System.out.println();
		
	}
	

	public static void main(String[] args) 
	{
		System.out.println("/////////////////////////////////////////////////////////######//////////////////////////////////////////////////");
		System.out.println("-------------------------------------------###    POINT OF SALES SYSTEM    ###-----------------------------------");
		System.out.println("/////////////////////////////////////////////////////////######//////////////////////////////////////////////////");
		login();
    }
	
}
		