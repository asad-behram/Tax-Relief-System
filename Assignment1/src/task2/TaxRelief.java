package task2;


import java.util.Scanner;

public class TaxRelief {
	//attributes
	int gross_salary ;
	String name;
	int NRIC;
	int net_salary ;
	int individual;
	int medicalparent;
	int medicalexpense;
	int disabilitysupport;
	int lifestyle;
	int child;
	int medicalinsurrance;
	int socialsecurity;
	
	//constructor
	public TaxRelief( ) {
		setname("");
		setNRIC(00000000);
		setsalary(0);
		setNetSalary(0);
		setsocialsecurity(0);
		setmedicalinsurrance(0);
		setchild(0);
		setlifestyle(0);
		setdisabilitysupport(0);
		setmedicalexpense(0);
		setmedicalparent(0);
		setindividual(0);
	}
	//setters
	public void setsocialsecurity(int s) {
		socialsecurity= s;
	}
	
	public void setmedicalinsurrance(int m) {
		medicalinsurrance=m;
	}
	
	public void setchild(int c) {
		child=c;
	}
	
	public void setlifestyle(int l) {
		lifestyle=l;
	}
	
	public void setdisabilitysupport(int s) {
		disabilitysupport=s;
	}
	
	public void setmedicalexpense(int e) {
		medicalexpense=e;
	}
	
	public void setmedicalparent(int p) {
		medicalparent=p;
	}
	
	public void setindividual(int i) {
		individual=i;
	}
	
	public void setsalary(int salary) {
		gross_salary= salary;
	}
	public void setNetSalary(int salary) {
		net_salary= salary;
	}
	public void setname(String n) {
		name=n;
	}
	public void setNRIC(int nric) {
		NRIC = nric;
	}
	
	//getter
	public int getsocialsecurity() {
		return socialsecurity;
	}
	
	public int getmedicalinsurrance() {
		return medicalinsurrance;
	}
	
	public int getchild() {
		return child;
	}
	
	public int getlifestyle() {
		return lifestyle;
	}
	
	public int getdisabilitysupport() {
		return disabilitysupport;
	}
	
	public int getmedicalexpense() {
		return medicalexpense;
	}
	
	public int getmedicalparent() {
		return medicalparent;
	}
	
	public int getindividual() {
		return individual;
	}
	
	public int getsalary() {
		return gross_salary;
	}
	public int getNetSalary() {
		return net_salary;
	}
	public String getname() {
		return name;
	}
	public int getnric() {
		return NRIC;
	}
	
	//input data
	public void inputdata() {
		Scanner input = new Scanner(System.in);
		int s=0;
		String n;
		int nric=0;
		char choice;
		int child=0;
		int net_sal;
		
		//user data
		System.out.println("Enter your gross salary: ");
		s=input.nextInt();
		System.out.println("Enter your name: ");
		input.nextLine();
		n =input.nextLine();
		System.out.println("Enter your NRIC: ");
		nric=input.nextInt();
		
		setsalary(s);
		setname(n);
		setNRIC(nric);
		
		if(s<50000) {
			System.out.println("The person is exempted from tax");
		}
		else {
			//TR information:
			System.out.println("Individual?(Y/N)");
			//input.nextLine();
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {	
				s=s-10000;
				setNetSalary(s);
				setindividual(10000);
			}
			System.out.println("Medical Treatment for Parents?(Y/N)");
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-5000;
				setNetSalary(s);
				setmedicalparent(5000);
			}
			System.out.println("Medical Expense?(Y/N)");
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-3000;
				setNetSalary(s);
				setmedicalexpense(3000);
			}
				
			System.out.println("Disability Support?(Y/N)");
			//input.nextLine();
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-3000;
				setNetSalary(s);
				setdisabilitysupport(3000);
			} 
			System.out.println("Lifestyle?(Y/N)");
			//input.nextLine();
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-2000;
				setNetSalary(s);
				setlifestyle(2000);
			} 
			System.out.println("Number of Unmarried Children?");
			child=input.nextInt();
			child= child*1000;
			s=s-child;
			setNetSalary(s);
			setchild(child);
			
			System.out.println("Medical Insurance?(Y/N)");
			//input.nextLine();
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-5000;
				setNetSalary(s);
				setmedicalinsurrance(5000);
			}
			System.out.println("Contribution in Social Security Organization?(Y/N)");
			//input.nextLine();
			choice =input.next().charAt(0);
			if(choice=='Y'|| choice=='y') {
				s=s-1000;
				setNetSalary(s);
				setsocialsecurity(1000);
			}
			System.out.println("calculating Tax.........");
			System.out.println("**********YOUR TAX PROFILE**********");
			System.out.println("INDIVIDUAL TAX: RM" + getindividual());
			System.out.println("MEDICAL TREATMENT FOR PARENTS: RM" + getmedicalparent());
			System.out.println("MEDICAL EXPENSE: RM" + getmedicalexpense());
			System.out.println("DISABLITY SUPPORT: RM" + getdisabilitysupport());
			System.out.println("LIFESTYLE: RM" + getlifestyle());
			System.out.println("UNMARRIED CHILDREN: RM" + getchild());
			System.out.println("MEDICAL INSURRANCE: RM" + getmedicalinsurrance());
			System.out.println("CONTRIBUTION IN SOCIAL SECURITY: RM" +getsocialsecurity());
			showinfo();
		}
		
		input.close();
	}
	//tax calculation
	public double taxcalculation() {
		double tax=0;
		int gSal = getsalary();
		int netSal = getNetSalary();
		if(gSal>=0 && gSal<=5000) {
			tax= netSal*0;
			System.out.println("Amount of tax you will pay is RM " + Math.round(tax));
		}
		else if (gSal>=5001 && gSal<=25000) {
			tax= netSal*(0.1);
			System.out.println("Amount of tax you will pay is RM" + Math.round(tax));
			}
		else if (gSal>=25001 && gSal<=50000) {
			tax= netSal*(0.2);
			System.out.println("Amount of tax you will pay is RM" + Math.round(tax));
			}
		else if (gSal>50001) {
			tax= netSal*(0.3);
			System.out.println("Amount of tax you will pay is RM" + Math.round(tax));
			}
		return tax;
	}
	//show result
	public void showinfo() {
		System.out.println("NAME:" + getname());
		System.out.println("NRIC:" + getnric());
		System.out.println("GROSS SALARY: RM " + getsalary());
		
		System.out.println("NET SALARY: RM " + getNetSalary());
		taxcalculation();
	}
}
