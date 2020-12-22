
package contractmanager;

import java.util.*;//importing library
import java.util.Calendar ;//importing the calendar
import java.text.SimpleDateFormat; //importing date format
import java.io.*;// importing the file format
import java.lang.*;

public class ContractManager {
public static Scanner sc = new Scanner(System.in);
public static Contract single = new Contract();// link to my contract class
 

    public static void main(String[] args) {
        
        
        //calling modules
        
        menu();//A greeting and the menu
        
        
        
        
    }
    //creation of modules
    public static  void menu(){
        System.out.println("TelCas Communications v5.");
        System.out.println("Hello and Welcome to Telcas Communications.\n ");
        
        System.out.println("Please choose from the following options. ");
        System.out.println("1: Enter new Contract. ");
        System.out.println("2: Display Summary of Contracts. ");
        System.out.println("3: Display Summary of Contracts for Selected Month. ");
        System.out.println("4: Find and Display Contracts. ");
        System.out.println("5: Exit. ");
        
        int iOption = sc.nextInt(); 
        
        switch (iOption){
            case 1: //enter new contract
                newContract(); 
                break; 
            case 2: //display summary of contracts
                summaryOfContracts();
                break; 
            case 3: //display summary of contracts for selected month
                sumConSelMon();
                break;
            case 4:// Find and display contracts
                findContract();
                break;
            case 5:// exit
                exit();
                break;
                
            }// end of switch
        
    }//////////////////////////////////////////////////////////////////////
    // new contract option 1 selected
    public static void newContract(){
        //step 1: get Name 
        clientName();
        //step 2: get bundle options (speeds of low, medium, high and unlimited : line 87
        bundleOptions();
        //step 3: select package options (small, medium, large) : line 105
        packageOptions(); 
        //step 4: business or non-business contract : line 123
        businessContract();
        //step 5: desired period of contract
        contractPeriod();
        //step 6: reference number
        referenceNumber();
        //step 7: international calls
        intCalls();
        //step 8: get date
        System.out.println("Contract created on "+ getDate());
        discount();
        // step 9 summarize and display charge befor discounts and any additional charges
        MonthlyCharge();
        // step 10 display discounted charge
        totalCharge();
        // step 11 display final charge after whole calculation after charges done
        finalCharge();
        // step 12 display summary box
        summaryBox();
        // step 13 save to contracts.txt file
        contracts();
        //addRecords();
        //closeFile();
        // step 14 return to main menu
        returnToMenu();
    }//end of new contract module 
    /////////////////////////////////////////////////////////////////////////////
    
    
    
    // summary of contracts option 2 selected
    public static void summaryOfContracts(){
        // step 1 ask user which file to access
        fileAccess();
        // step 2 return to main menu
        returnToMenu();
        
        
        
    }// end of summary of contracts for selected month
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    // summary of contracts for selected month option 3 selected
    public static void sumConSelMon(){
        // step 1 ask user which file to access
        readFilePerMonth();
        // step 2 exit to main menu
        returnToMenu();
        
    }

    
    // Start of clientName module
    public static void clientName(){
        
        System.out.println ("Please provide your First Name.");
        String first_name = sc.next();// user input for first name
        
        System.out.println("please provide your last name.");
        String last_name = sc.next();// user input for last name
        int iLength=first_name.length()+last_name.length();// getting the length of the client name.
        if (iLength > 0 && iLength <26){// name must be between 1 and 25 characters.
            single.setName(first_name, last_name);
        System.out.println("Hello " + single.getName()+".\n");// Hello "Your name".
        }
            else{
            System.out.println("Please provide a name between 1 and 25 characters.");
            clientName();
        }
        
    }// end of Client name module
   /* int iPOption = sc.nextInt(); 
        single.isValidDataB(iPOption); 
        if(single.isValidDataB(iPOption) == true){
            single.setDataB(iPOption);
            
            System.out.println("You have chosen " + single.getDataB()+".\n");
        
            
        }else {
            bundleOptions();
      */  //}
    //Start of data bundle module
    public static void bundleOptions(){
        
        // all the below simply lists all the options available for bundle selection.
        System.out.println("Data bundles come in speeds of:" );
        System.out.println("1: 1Gb-Low. ");
        System.out.println("2: 4Gb-Medium. ");
        System.out.println("3: 8Gb-High. ");
        System.out.println("4: Unlimited. Please be aware that Unlimted is only available with our large package(1200 mins). ");
        System.out.println("Please select which Data Bundle you would like? ");
        int iPOption = sc.nextInt(); // user input select.
        //single.isValidDataB(iPOption); // checks if input is valid 
        if(single.isValidDataB(iPOption) == true){
            //single.setDataB(iPOption);// if valid. This sets input to dataB 
           
            // this switch statement will validate the user input with the correct response 
            switch (iPOption){
                case 1:
                    System.out.println("1: 1Gb-Low.\n ");
                    break;
                case 2:    
                    System.out.println("2: 4Gb-Medium.\n ");
                    break;
                case 3:
                    System.out.println("3: 8Gb-High.\n ");
                    break;    
                case 4:
                    System.out.println("4: Unlimited.\n ");
                    break;
                default:// left the default in with no consequence. Good for error checking.
                    System.out.println("Please try again.\n ");
                    break;
            }// end of switch case
            single.setDataB(iPOption);// setting 1, 2, 3 or 4 to set pack
            //System.out.println ("Test: "+ single.getDataB()); //testing set data bundles works
            }else{
            // an invalid input will loop the user back round to the start of the method.
            bundleOptions();
        }// if ok it can then continue onto package options
    }// end of bundle options module
    ////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    // start of packageOptions module
    public static void packageOptions(){
       
        // all the below simply lists all the options available for package selection.
        System.out.println ("Our Packages come in sizes of:"); 
        System.out.println("1: Small(300 mins).");
        System.out.println("2: Medium(600 mins).");
        System.out.println("3: Large(1200 mins).");
        System.out.println("Please select which Package you would like? ");
        int iPOption = sc.nextInt(); //user input select
        //single.isValidPack(iPOption);// checks if input is valid 
        if(single.isValidPack(iPOption) == true){
            //single.setPack(iPOption);// if valid. This sets input to setPack
            
            // this switch statement will validate the user input with the correct response 
            switch (iPOption){
                case 1: //small 300 mins 
                    System.out.println("1: Small(300 mins).\n ");
                     
                    break;
                case 2:    
                    System.out.println("2: Medium(600 mins).\n ");
                    
                    break;
                case 3:
                    System.out.println("3: Large(1200 mins).\n ");
                     
                    break;    
                default:// left the default in with no consequence. Good for error checking.
                    System.out.println("Please try again.\n ");
                    break;
                
            }//end of switch case
            single.setPack(iPOption);// setting 300 ,600 or 1200 mins to set pack
            //System.out.println ("Test: "+ single.getPack()); //testing setPack works 
        }else {
             // an invalid input will loop the user back round to the start of the method.
            packageOptions(); 
            
        }// if ok it can then continue onto business contract
     }// end of packageOptions module
    /////////////////////////////////////////////////////////////////////////////////
    
    
    
    // start of business contract or not confirmation
    public static void businessContract(){
        System.out.println("Business contracts offer extra discount.");
        System.out.println("For a Business contract you will recieve 10% discount on a 12 month contract or longer.");
        System.out.println("A Non-Business contract will give you a 5% discount on a 12 and 18 month contract or 10% on a 24 month contract.");
        System.out.println("Please select from the following 2 options:" );
        System.out.println("1: Business Contract");
        System.out.println("2: Non-Business Contract");
        int iPOption = sc.nextInt();// wants user input 1 or 2
        //single.isValidContract(iPOption);
        if(single.isValidContract(iPOption) == true){// if returns true then the switch case will print out approprite validation
            //single.setContract(iPOption);
            
             switch (iPOption){
                case 1:
                    System.out.println("1: Business Contract.\n ");
                    break;
                case 2:    
                    System.out.println("2: Non-Business Contract.\n ");
                    break;
                default:// left the default in with no consequence. Good for error checking.
                    System.out.println("Please try again.\n ");
                    break;    
            }//end of switch case 
            single.setContract(iPOption);// setting 1 or 2 to set Business Contract
            //System.out.println ("Test: "+ single.getContract()); //testing getContract works     
        }else{
            businessContract();// if no good. It will loop back round to the start of the method
        }
    }// end of business contract module
    /////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    // contract period
    public static void contractPeriod(){
        System.out.println("Contract durations are available in:");
        System.out.println("1 Month.");
        System.out.println("12 Months.");
        System.out.println("18 Months.");
        System.out.println("24 Months");
        System.out.println("Please select the number of months you want." );
        int iPOption = sc.nextInt();// user input. Select 1, 12, 18 or 24 months.
        single.isValidMonth(iPOption);// checks if valid
        if(single.isValidMonth(iPOption) == true){
            single.setMonths(iPOption);// if option selected is 1 or 2. Then it is set.
            
            System.out.println("You have opted for " + single.getMonths()+" Months.\n");// Just a return message
            //System.out.println ("Test: "+ single.getMonths()); //testing getContract works
        }else{
            contractPeriod();// loops back through if no good.
        }
    
    }// end of contract period
    ////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    // reference number
    public static void referenceNumber(){
        
        String rfNum;
        
        System.out.println("Please enter a Valid 6 Digit Reference Number");
        System.out.println("Your unique Reference number Must be 2 letters followed by 3 numbers and 1 letter at the end of your Reference Number.  ");
        System.out.println("A letter at the end with either "); 
        System.out.println(":B for a Business Contract.  ");
        System.out.println(":N for a Non-Business Contract. ");
        
        rfNum = sc.nextLine();
        single.isValidRef(rfNum);
        if(single.isValidRef(rfNum) == true){
            single.setRefNumber(rfNum);
            // had a problem with that been with the 6th character it could have been any letter.
            System.out.println("Your unique Reference Code is: "+ single.getRefNumber()+".\n");// Return message
        }else{
            System.out.println("please enter a valid reference number.\n");
            referenceNumber();
        }
        
    }// end of reference number
    ////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    // international calls Y or N
    public static void intCalls(){
        char YorN; 
        System.out.println("International calls are charged seperately to your package but can be ");
        System.out.println("inluded for an additional 15% charge on the price. ");
        System.out.println("Would you like to add International Calls to your package? Y/N ");
        YorN = sc.next().charAt(0);// user input for a Y or N
        
        single.isValidCalls(YorN);
        if (single.isValidCalls(YorN) == true){// checking for valid input
            single.setCalls(YorN);// if all ok then it is set.
        
            System.out.println("You have selected " + single.getCalls()+".\n");// Just a return message
            //System.out.println ("Test: "+ single.getCalls()); //testing getContract works
        }else{
            intCalls();// loops back through if unsucessfull
        }
        
    }// end of international calls
    /////////////////////////////////////////////////////////////////////////////
    
    
    
    // displaying the monthly charge befor discounts 
    public static double MonthlyCharge()
    {
        double monthCharge = 0;// stored in pence
        
        if (single.getPack() == 1)
{
		    switch(single.getDataB())
		    {
			    case 1 : 	monthCharge = 500;
			    			break;
			    case 2 :	monthCharge = 700;
			    			break;
			    case 3 :	monthCharge = 900;
			    			break;
                                
		    }
	    }
		else if (single.getPack() == 2)
		{
		    switch(single.getDataB())
		    {
			    case 1 : 	monthCharge = 650;
			    			break;
			    case 2 :	monthCharge = 850;
			    			break;
			    case 3 :	monthCharge = 1050;
			    			break;
		    }
	    }
	    else
		{
		    switch(single.getDataB())
		    {
			    case 1 : 	monthCharge = 850;
			    			break;
			    case 2 :	monthCharge = 1050;
			    			break;
			    case 3 :	monthCharge = 1250;
			    			break;
                            case 4 :    monthCharge = 2000;
                                                break;
		    }
	    }
            
        single.setMonthlyCharge(monthCharge);
        //System.out.println("Test:"+ single.getMonthlyCharge());
        System.out.printf("The monthly price of your package is: £%.2f\n", single.getMonthlyCharge() / 100);
	    return monthCharge;
            
         
    }// end of monthly charge
    //////////////////////////////////////////////////////////////////////////
    //DISCOUNT INFO
    //•	Business customer receive a 10% discount and must take at least a 12-month contract.
    //Non-business customers taking a 12 or 18-month contract receive a 5% discount and 10% for a 24-month contract
    //•International calls are normally charged separately, but customers can choose to use the minutes 
    //included with package to make these calls.  If this option is selected, 
    //the charges above are increased by 15%.
    
    
    
    //price after discount((with or without business for the number of months.)
    public static int discount(){
        int discount=0;
        if (single.getContract()==1 && single.getMonths()>=12){ //business contract with 12 month contract
            discount = 10; 
            
        }else if (single.getContract()==2 && single.getMonths()>=12 && single.getMonths() <=18){//non business contract with 12 -18 months contract
            discount = 5; 
        }else if (single.getContract() ==2 && single.getMonths() ==24){// non business contract with a 24 month contract
            discount = 10; 
        }
            single.setDiscount(discount);
            System.out.println("Discount:"+ single.getDiscount()+"%");
            return discount; 
    }//end of discount method
    //////////////////////////////////////////////////////////////////////////////////
    
    
    
    //•International calls are normally charged separately, but customers can choose to use the minutes included with package 
    //to make these calls.  If this option is selected, the charges above are increased by 15%.
    public static double addCharge(){
        double charge =0;
        if (single.getCalls()=='Y'|| single.getCalls()=='y'){
            charge = 15;
        }
        
        single.setAddCharge(charge);
        //System.out.println("Test:"+ single.getAddCharge());
        return charge;
        
    }// end of charge for international calls
    //////////////////////////////////////////////////////////////////////////////
    
   
    
    
    
    
    //Calculating final charge after discounts and charges
    public static double totalCharge(){
         //int dCharge = (int) (totCharge - totCharge * (discount/100.0));
        double discCharge=(single.getMonthlyCharge()/100);// get 1%
        
        double disc2Charge=discCharge * discount();//Discount percentage
        //System.out.println("Discount to be taken off: "+disc2Charge);// total amount to be taken off
        double totCharge=single.getMonthlyCharge()-disc2Charge;// total amount after discount
        
        single.setTotalCharge(totCharge);
        System.out.printf("Price after discount: £%.2f\n", totCharge / 100.0);
        
        return totCharge;
        
        
    }// end of total charge
    
    public static void finalCharge(){
    
        double intCharge=totalCharge()/100;
        double finalCharge=intCharge * single.getAddCharge();
        double finalCharge2= finalCharge + single.getTotalCharge();
        
        single.setFinalCharge(finalCharge);
        
        //System.out.println("Charges: "+intCharge);
        //System.out.println("Charges: "+finalCharge);
        //System.out.println("Charges: "+finalCharge2);
    }
    /////////////////////////////////////////////////////////////////////////////
    
    // getting the date format for todays date
    public static String getDate(){

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    return sdf.format(cal.getTime());
    
    }// end of get date method
    //////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    // Displaying all info in a summary box. Struggled to match input from user
    // to match info required for the box. So had to mess about with some extra variables
    public static void summaryBox(){
        String packDesc = null;// making a variable for the package to enable instead of just 1, 2, or 3 
        if (single.getPack() == 1){// it will display the actual description. My user input 
            packDesc = "Small(300)";// is not suited to this
        }else if(single.getPack() == 2){
            packDesc = "Medium(600)";
        }else if(single.getPack() == 3){
        packDesc = "Large(1200)";
    }
        
        String dataBdesc = null;// Data bundle variable
        if (single.getDataB() == 1){
            dataBdesc = "Low (1Gb)";
        }else if(single.getDataB() == 2){
            dataBdesc = "Medium (4Gb)";
        }else if(single.getDataB() == 3){
            dataBdesc = "High (8Gb)";
        }else if(single.getDataB() == 4){
            dataBdesc = "Unlimited";
        }
        
        String bussDesc = null;// Business or non-business account variable
        if (single.getContract() == 1){
            bussDesc = "Business";
        }else if (single.getContract() == 2){
            bussDesc = "Non-Business";
        }
        
        System.out.println("+-----------------------------------------------+");
        System.out.println("| Customer: "+ single.getName()+"\t\t|");
        System.out.println("|                                               |");
        System.out.println("|      Ref: "+ single.getRefNumber()+"\tDate: "+getDate()+"\t|");
        System.out.println("|  Package: "+ packDesc +"\tData: "+dataBdesc+"\t|");
        System.out.println("|   Period: "+ single.getMonths()+ " Months"+"\tType: "+bussDesc+"\t|");
        System.out.println("|                                               |");
        System.out.println("| Discount: "+ single.getDiscount()+"%"+"\tInt. Calls:"+single.getCalls()+"\t\t\t|");
        System.out.println("|                                               |");
        System.out.println("|      Discounted Monthly Charge: £"+ single.getTotalCharge() / 100+"\t\t|");
        System.out.println("|                                               |");
        System.out.println("+-----------------------------------------------+");
        
        }
    //////////////////////////////////////////////////////////////////////////////
    
    
    // writing to the archive file
    public static void contracts(){
        File contract = new File("contracts.txt");// link to the contract external file
        PrintWriter output = null;// formatter to print to file
        
        if (!contract.exists())// check doesnt exist
        {
        try{
            output = new PrintWriter(contract);// creating a link to the text file
            }
        catch(Exception e)// check everything went ok
            {
                System.out.println("Error creating the file");
                System.exit(0);// terminates the programme
                
            }
        if (contract.exists())
            {
                output.println(getDate()+"\t"+single.getPack()+"\t"+single.getDataB()+"\t"+single.getMonths()+"\t"+single.getCalls()+"\t"+single.getRefNumber()+"\t"+single.getTotalCharge()+"\t"+single.getName());
                System.out.println(contract.getName() + " Exists");
            }
            else
                System.out.println("Error. Cant find file.");
        output.close();
        }
        
        
    }// end of write to file
    ///////////////////////////////////////////////////////////////////////////
    
    
    
    
    //Summary of contracts option 2 selected. Asking which file you want to access
    public static void fileAccess(){
        
        
        System.out.println("Which File do you want to access: ");// asking the user which file they want to access
        System.out.println("1: Main");
        System.out.println("2: Archive");
        int iPOption = sc.nextInt();
        if (iPOption == 1 ){
             readFile("contracts.txt");
        }else if(iPOption == 2){
            readFile("Archive.txt");
        }
        
    }//end of file Access
    
    // (Option 2)reading and opening file to display contracts
    public static void readFile(String FileName){
            Scanner input = null;  // this is to keep the compiler happy
            
            int [] conMonth = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
            int totalCon = 0;// setting the contract total to zero
            int hiLaDB = 0;// setting the total of large data bundles and unlimited to zero
           
            int costLP = 0;// cost of large package
            double avLP = 0;// average of large package
            int totalLP = 0;// total number of large packages
            
	try
	{	
	 	input = new Scanner(new File(FileName));	
	}		 	


	catch(FileNotFoundException e)
	{
		System.out.println("File doesn't exist");
		System.exit(1);
	}
        
        

	while( input.hasNext())
	{   
            // creating variables for the columns in the archive or main
            
            
                String line = input.next();
                int pack = input.nextInt();
                String data = input.next();
                int months = input.nextInt();
                String interCalls = input.next();
                String rNum = input.next();
                int charge = input.nextInt();
                        
                String name = input.next();
                totalCon=totalCon + 1;
            
            input.nextLine();// for some reason this could only go here
             
            
                //String date = input.next();
             /*   int pack = input.nextInt();
                String data = input.next();
                int months = input.nextInt();
                String interCalls = input.next();
                String rNum = input.next();
                int charge = input.nextInt();
                String name = input.next();*/
                
            // getting the total for large and unlimited bundles.
            if (data.contains  ("3") || data.contains ("4")){
                    hiLaDB = hiLaDB + 1;
                }    
            
            // getting total number of large packages
            if (pack == 3){
                totalLP = totalLP + 1;
                costLP = costLP + charge;
                avLP=costLP/totalLP;
            }
           
         
                    
            // going to go through every month and tally up total for the year. 
                  if(line.contains("Jan")){
                conMonth[0]= conMonth[0]+1;
            }else if(line.contains("Feb")){
                conMonth[1]= conMonth[1]+1;
            }else if(line.contains("Mar")){
                conMonth[2]= conMonth[2]+1;
            }else if(line.contains("Apr")){
                conMonth[3]= conMonth[3]+1;
            }else if(line.contains("May")){
                conMonth[4]= conMonth[4]+1;
            }else if(line.contains("Jun")){
                conMonth[5]= conMonth[5]+1;
            }else if(line.contains("Jul")){
                conMonth[6]= conMonth[6]+1;
            }else if(line.contains("Aug")){
                conMonth[7]= conMonth[7]+1;
            }else if(line.contains("Sep")){
                conMonth[8]= conMonth[8]+1;
            }else if(line.contains("Oct")){
                conMonth[9]= conMonth[9]+1;
            }else if(line.contains("Nov")){
                conMonth[10]= conMonth[10]+1;
            }else if(line.contains("Dec")){
                conMonth[11]= conMonth[11]+1;
            }
                
            
        
        
        }//closes while loop
        
        
            System.out.println("Total Number of contracts: "+ totalCon);
            System.out.println("Contracts with High or Unlimited Data Bundles: "+ hiLaDB);
            System.out.println("Average charge for large packages: "+ avLP/100 +"\n");
            System.out.println("Number of contracts per Month: \n");
            System.out.println("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
            System.out.println(" "+conMonth[0]+"\t"+conMonth[1]+"\t"+conMonth[2]+"\t"+conMonth[3]+"\t"+conMonth[4]+"\t"+conMonth[5]+"\t"+conMonth[6]+"\t"+conMonth[7]+"\t"+conMonth[8]+"\t"+conMonth[9]+"\t"+conMonth[10]+"\t"+conMonth[11]);
                    
		
             
   	 input.close();
         
    }
    
    public static void readFilePerMonth(){
        String FileName = ""; 
        System.out.println("Which File do you want to access: ");// asking the user which file they want to access
        System.out.println("1: Main");
        System.out.println("2: Archive");
        int iPOption = sc.nextInt();
        if (iPOption == 1 ){
            //OPEN FILE CONTRACTS 
            FileName = "contracts.txt"; 
            
        }else if(iPOption == 2){
            //OPEN FILE ARCHIVE 
            FileName = "Archive.txt"; 
            
        }
        
        Scanner input = null;  // this is to keep the compiler happy
            
            int [] conMonth = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
            String line = ""; 
            
//ints to add up totals per month
            int janTot = 0, janBundleTot = 0, janLP = 0, janCost= 0;
            int febTot = 0, febBundleTot=0, febLP = 0, febCost =0; 
            int marTot = 0, marBundleTot=0, marLP = 0, marCost =0;
            int aprTot = 0, aprBundleTot=0, aprLP = 0, aprCost =0;
            int mayTot = 0, mayBundleTot=0, mayLP = 0, mayCost =0;
            int junTot = 0, junBundleTot=0, junLP = 0, junCost =0;
            int julTot = 0, julBundleTot=0, julLP = 0, julCost =0;
            int augTot = 0, augBundleTot=0, augLP = 0, augCost =0;
            int sepTot = 0, sepBundleTot=0, sepLP = 0, sepCost =0;
            int octTot = 0, octBundleTot=0, octLP = 0, octCost =0;
            int novTot = 0, novBundleTot=0, novLP = 0, novCost =0;
            int decTot = 0, decBundleTot=0, decLP = 0, decCost =0;
            // had to add these variables to get the correct format for the average output
            double janAvg = 0;
            double febAvg = 0;
            double marAvg = 0;
            double aprAvg = 0;
            double mayAvg = 0;
            double junAvg = 0;
            double julAvg = 0;
            double augAvg = 0;
            double sepAvg = 0;
            double octAvg = 0;
            double novAvg = 0;
            double decAvg = 0;
            
        System.out.println ("Which month would you like to see a summary of? [Type of the corresponding month number]");
        System.out.println("1: January.");
        System.out.println("2: February.");
        System.out.println("3: March.");
        System.out.println("4: April.");
        System.out.println("5: May.");
        System.out.println("6: June.");
        System.out.println("7: July.");
        System.out.println("8: August.");
        System.out.println("9: September.");
        System.out.println("10: October.");
        System.out.println("11: November.");
        System.out.println("12: December.");
        
        //set iMonthOption equal to user input 
        int iMonthOption = sc.nextInt(); 
        
        
             
	try
	{	
	 	input = new Scanner(new File(FileName));	
	}		 	


	catch(FileNotFoundException e)
	{
		System.out.println("File doesn't exist");
		System.exit(1);
	}
        
        

	while( input.hasNext())
	{   
            // creating variables for the columns in the archive or main
            
            
                line = input.next();
                int pack = input.nextInt();
                String data = input.next();
                int months = input.nextInt();
                String interCalls = input.next();
                String rNum = input.next();
                int charge = input.nextInt();
                        
                String name = input.next();
                
            
            
             input.nextLine();//goes for the next line
           
        //January Totals 
            if (line.contains("Jan")){
                conMonth[0]= conMonth[0]+1; 
                if(data.equals ("3") || data.equals("4")){
                    janBundleTot = janBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    janLP = janLP + 1;
                    janCost = janCost + charge;
                    janAvg=janCost/janLP;
                }//end pack if statement
            }//end if line contain January if statement 
            
            //Feb Totals 
            if (line.contains("Feb")){
                conMonth[1]= conMonth[1]+1; 
                if(data.equals ("3") || data.equals("4")){
                    febBundleTot = febBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    febLP = febLP + 1;
                    febCost = febCost + charge;
                    febAvg=febCost/febLP;
                }//end pack if statement
            }//end if line contain February if statement 
        
             //March Totals 
            if (line.contains("Mar")){
                conMonth[2]= conMonth[2]+1; 
                if(data.equals ("3") || data.equals("4")){
                    marBundleTot = marBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    marLP = marLP + 1;
                    marCost = marCost + charge;
                    marAvg=marCost/marLP;
                }//end pack if statement
            }//end if line contain March if statement
            
             //April Totals 
            if (line.contains("Apr")){
                conMonth[3]= conMonth[3]+1; 
                if(data.equals ("3") || data.equals("4")){
                    aprBundleTot = aprBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    aprLP = aprLP + 1;
                    aprCost = aprCost + charge;
                    aprAvg=aprCost/aprLP;
                }//end pack if statement
            }//end if line contain April if statement
            
             //May Totals 
            if (line.contains("May")){
                conMonth[4]= conMonth[4]+1; 
                if(data.equals ("3") || data.equals("4")){
                    mayBundleTot = mayBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    mayLP = mayLP + 1;
                    mayCost = mayCost + charge;
                    mayAvg=mayCost/mayLP;
                }//end pack if statement
            }//end if line contain May if statement
            
             //June Totals 
            if (line.contains("Jun")){
                conMonth[5]= conMonth[5]+1; 
                if(data.equals ("3") || data.equals("4")){
                    mayBundleTot = mayBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    mayLP = mayLP + 1;
                    mayCost = mayCost + charge;
                    mayAvg=mayCost/mayLP;
                }//end pack if statement
            }//end if line contain May if statement
            
             //July Totals 
            if (line.contains("Jul")){
                conMonth[6]= conMonth[6]+1; 
                if(data.equals ("3") || data.equals("4")){
                    julBundleTot = julBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    julLP = julLP + 1;
                    julCost = julCost + charge;
                    julAvg=julCost/julLP;
                }//end pack if statement
            }//end if line contain July if statement
            
             //August Totals 
            if (line.contains("Aug")){
                conMonth[7]= conMonth[7]+1; 
                if(data.equals ("3") || data.equals("4")){
                    augBundleTot = augBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    augLP = augLP + 1;
                    augCost = augCost + charge;
                    augAvg=augCost/augLP;
                }//end pack if statement
            }//end if line contain August if statement
            
             //September Totals 
            if (line.contains("Sep")){
                conMonth[8]= conMonth[8]+1; 
                if(data.equals ("3") || data.equals("4")){
                    sepBundleTot = sepBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    sepLP = sepLP + 1;
                    sepCost = sepCost + charge;
                    sepAvg=sepCost/sepLP;
                }//end pack if statement
            }//end if line contain September if statement
            
             //Feb Totals 
            if (line.contains("Oct")){
                conMonth[9]= conMonth[9]+1; 
                if(data.equals ("3") || data.equals("4")){
                    octBundleTot = octBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    octLP = octLP + 1;
                    octCost = octCost + charge;
                    octAvg=octCost/octLP;
                }//end pack if statement
            }//end if line contain October if statement
            
             //November Totals 
            if (line.contains("Nov")){
                conMonth[10]= conMonth[10]+1; 
                if(data.equals ("3") || data.equals("4")){
                    novBundleTot = novBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    novLP = novLP + 1;
                    novCost = novCost + charge;
                    novAvg=novCost/novLP;
                }//end pack if statement
            }//end if line contain November if statement
            
             //December Totals 
            if (line.contains("Dec")){
                conMonth[11]= conMonth[11]+1; 
                if(data.equals ("3") || data.equals("4")){
                    decBundleTot = decBundleTot +1; 
                }//end data bundles if statement 
                if (pack == 3){
                    decLP = decLP + 1;
                    decCost = decCost + charge;
                    decAvg=decCost/decLP;
                }//end pack if statement
            }//end if line contain December if statement
            
            
              
        
        
             
          }//while loop ends
        
        switch (iMonthOption){
            case 1: //January 
                System.out.println("\nJanuary ");
                System.out.println("Total Contracts in January: " + conMonth[0]);
                System.out.println ("Total high or unlimited data bundles: " + janBundleTot); 
                System.out.println ("Average charge for Large Packages in January: " +janAvg/100 );
                break;
            case 2: //February
                System.out.println("\nFebruary ");
                System.out.println("Total Contracts in February: " + conMonth[1]);
                System.out.println ("Total high or unlimited data bundles: " + febBundleTot); 
                System.out.println ("Average charge for Large Packages in February: " +febAvg/100 );
                break;
            case 3: //March
                System.out.println("\nMarch ");
                System.out.println("Total Contracts in March: " + conMonth[2]);
                System.out.println ("Total high or unlimited data bundles: " + marBundleTot); 
                System.out.println ("Average charge for Large Packages in March: " +marAvg/100 );
                break;
            case 4://April
                System.out.println("\nApril ");
                System.out.println("Total Contracts in April: " + conMonth[3]);
                System.out.println ("Total high or unlimited data bundles: " + aprBundleTot); 
                System.out.println ("Average charge for Large Packages in April: " +aprAvg/100 );
                break;
            case 5://May
                System.out.println("\nMay ");
                System.out.println("Total Contracts in May: " + conMonth[4]);
                System.out.println ("Total high or unlimited data bundles: " + mayBundleTot); 
                System.out.println ("Average charge for Large Packages in May: " +mayAvg/100 );
                break;
            case 6://June
                System.out.println("\nJune ");
                System.out.println("Total Contracts in June: " + conMonth[5]);
                System.out.println ("Total high or unlimited data bundles: " + junBundleTot); 
                System.out.println ("Average charge for Large Packages in June: " +junAvg/100 );
                break;
            case 7://July
                System.out.println("\nJuly ");
                System.out.println("Total Contracts in July: " + conMonth[6]);
                System.out.println ("Total high or unlimited data bundles: " + julBundleTot); 
                System.out.println ("Average charge for Large Packages in July: " +julAvg/100 );
                break;
            case 8://August
                System.out.println("\nAugust ");
                System.out.println("Total Contracts in August: " + conMonth[7]);
                System.out.println ("Total high or unlimited data bundles: " + augBundleTot); 
                System.out.println ("Average charge for Large Packages in August: " +augAvg/100 );
                break;
            case 9://September
                System.out.println("\nSeptember ");
                System.out.println("Total Contracts in September: " + conMonth[8]);
                System.out.println ("Total high or unlimited data bundles: " + sepBundleTot); 
                System.out.println ("Average charge for Large Packages in September: " +sepAvg/100 );
                break;
            case 10://October
                System.out.println("\nOctober ");
                System.out.println("Total Contracts in October: " + conMonth[9]);
                System.out.println ("Total high or unlimited data bundles: " + octBundleTot); 
                System.out.println ("Average charge for Large Packages in October: " +octAvg/100 );
                break;
            case 11://November
                System.out.println("\nNovember ");
                System.out.println("Total Contracts in November: " + conMonth[10]);
                System.out.println ("Total high or unlimited data bundles: " + novBundleTot); 
                System.out.println ("Average charge for Large Packages in November: " +novAvg/100 );
                break;
            case 12://December
                System.out.println("\nDecember ");
                System.out.println("Total Contracts in December: " + conMonth[11]);
                System.out.println ("Total high or unlimited data bundles: " + decBundleTot); 
                System.out.println ("Average charge for Large Packages in December: " +decAvg/100 );
                break;
        }
               
                        
        
            
        
        
           //System.out.println("Total Number of contracts in month: " + iMonthOption +" is " + conMonth[0]);
           //System.out.println("Contracts with High or Unlimited Data Bundles: "+ hiLaDB);
           //System.out.println("Average charge for large packages: "+ avLP/100 +"\n");
            //System.out.println("Number of contracts per Month: \n");
            //System.out.println("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
            //System.out.println(" "+conMonth[0]+"\t"+conMonth[1]+"\t"+conMonth[2]+"\t"+conMonth[3]+"\t"+conMonth[4]+"\t"+conMonth[5]+"\t"+conMonth[6]+"\t"+conMonth[7]+"\t"+conMonth[8]+"\t"+conMonth[9]+"\t"+conMonth[10]+"\t"+conMonth[11]);
                    
		
           
   	 input.close();
         
        }
    
        // setting a method for returning to main menu
        public static void returnToMenu(){
        System.out.println("\nPress any Number to Return to Main Menu.");
        int iPOption = sc.nextInt();
        if (iPOption == 1 ){
            menu();
        }else{
            menu();
        }
        }
    // end of open file
    ////////////////////////////////////////////////////////////////////
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////
    
    
    
    
    //(Option 4) Find and display contarct
    public static void findContract(){
        
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    
    
    
    //(Option 5) Exit
    public static void exit(){
        
        System.out.println("Thank You For Using TelCas Communications.");
    }

    
    
        
        
    
}
