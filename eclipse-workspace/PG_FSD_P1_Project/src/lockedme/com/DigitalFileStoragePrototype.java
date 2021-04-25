package lockedme.com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DigitalFileStoragePrototype {
	
	public static void main(String args[]) {
		
		int choice = 0;
		String Enterchoice = ("1. Display all files from directory\n"
								+ "2. Add a File to directory\n"
								+ "3. Search a File from directory\n"
								+ "4. Delete a File from directory\n"
								+ "5. Close the application\n\n"
								+ "Enter number from above selection:\n");

		
		Scanner input = new Scanner(System.in);
		System.out.println("***************************");
		System.out.println("*******Lockedme.com********");
		System.out.println("***************************");
		System.out.println();
		System.out.println(Enterchoice);
		choice=input.nextInt();
		
		while (choice < 1 || choice > 5) {  //checking if number entered is out to selection choice and show error
			System.out.println("\nERROR: Invalid option selected\n");
			System.out.println("------------------------------------");
			System.out.println(Enterchoice);
			choice=input.nextInt();
		}
		
		while (choice >= 1 || choice <= 5) {
		switch (choice) {
		case 1: {
			display();   //calls display method to display all files from directory
		}
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println(Enterchoice);
		choice=input.nextInt();
		break;
		
		case 2: {
			add();   	//calls add method to add a file to directory
		}
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println(Enterchoice);
		choice=input.nextInt();
		break;
		
		case 3: {
			search(); 	//calls search method to search a file from directory
		}
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println(Enterchoice);
		choice=input.nextInt();
		break;
		
		case 4: {
			delete();  	//calls delete method to delete a file from directory
		}
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println(Enterchoice);
		choice=input.nextInt();
		break;
		
		case 5: { 
			close(); 	//calls close method to close application
		}
		break;
			}
		
		}
	
	}
	
	static void display() {   	//Method to display all files from directory
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory to get list of files from:\n" );
        String directoryname = scan.next();
        String [] filenames; 
        File file = new File(directoryname);
        if (file.exists()) {
        filenames = file.list();
        
      /*
        //Arrays.sort(filenames);
      //prints the sorted string array in ascending order  
        //System.out.println(Arrays.toString(filenames));	
        */
        for (String filename : filenames) {
        	System.out.println(filename);
        }
        }else
        {
        	System.out.println("***Directory does not exist***");
        }
	}
	
	static void add() {			//Method to add all file to directory
		try {
			Scanner scan = new Scanner(System.in);
	        System.out.println("Enter directory along with file name to be created:\n" );
	        String filename = scan.next();
			File file = new File(filename);    //C://Pavani//Myfile.txt
			if (file.exists()) {
				System.out.println("***File already exists***");
			}else
			{
				file.createNewFile();
				System.out.println("***New file "+file.getName() +" created successfully***");
			}
							
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("***File cannot be created***");
				}
	
	}
	
	static void search() {		//Method to search files from directory
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory along with file name to be searched:\n" );    //C:\Pavani\Myfile.txt
        String filename = scan.next();
        //System.out.println("Enter the directory where to search:\n");
        //String directory = scan.next();
        File file = new File(filename);
        
        try {
			if (file.exists() && file.getCanonicalPath().equals(filename)) {    
				System.out.println("***File exist***");
				
			}else
			{
				System.out.println("***File not found***");
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}
	
	static void delete()  {			//Method to delete files from directory
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory along with file name to be deleted:\n" );
        String filename = scan.next();
        //System.out.println("Enter the directory where to search:\n");
        //String directory = scan.next();
        
        File file = new File(filename);
        try {
			if (file.exists() && file.getCanonicalPath().equals(filename)) {
				file.delete();
				System.out.println("***File successfully deleted***");
			}else
			{
				System.out.println("***File not found***");
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
        
	}
	
	static void close() {			//Method to close files from directory
		System.out.println("***Application closed***");
		System.exit(0);
	        
	}
	
}
	

	



