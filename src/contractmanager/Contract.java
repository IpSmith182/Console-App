
package contractmanager;
// importing the date function from library
import java.io.*;
import java.lang.*;
import java.util.*;

public class Contract {
    
    // instance variables
    // details for the contract
    String _date;
    int _pack;
    int _dataB;
    int _months;
    char _calls;
    String _ref;
    double _charge;
    String _name;
    int _contract;
    int _discount;
    double _addCharge;
    double _totalCharge;
    double _finalCharge;
    
    // naming the data format so i can use it later to get the correct date when a contract is entered.
    ////////////////////////////////////////////////////////////////////////////////////
    
    // Start of methods
    //set full name
    public String setName (String f, String l){
        _name = f + " " + l;
        
        
        return _name; 
    }// end of setName
    
    // get name
    public String getName (){
        return _name; 
    }
    //////////////////////////////////////////////////////////////////////////////////
    
    // Get date
    public String getDate()
    {
        return _date;
    }
    ///////////////////////////////////////////////////////////////////////////////////
    
 

    
    // Get package
    public int getPack()
    {
        return _pack;
    }// end of get
    
    // Set package
    public boolean setPack(int p){
        
            //System.out.println ("Test 2"); //test 
            this._pack = p;
            return true;
        
        }
    // Check that numbers 1 - 3 are entered for desired package
    public static boolean isValidPack(int p){
        
        if (p >=1 && p <=3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// end of set package
    /////////////////////////////////////////////////////////////////////////////
    
    
    // get data bundle
    public int getDataB()
    {
        return _dataB;
    }// end of get
    
    // Set data bundle
    public boolean setDataB(int db){
        if (isValidDataB(db))
        {
            this._dataB = db;
            return true;
        }
        return false;
    }
    // checks that option 1,2,3,4 is selected for what bundle is required
    public static boolean isValidDataB(int db){
        
        if (db >=1 && db <=4)
        {
            return true;
        }
        else
        {
            return false;
        }
     
    }// end of set Data bundles.
    ///////////////////////////////////////////////////////////////////////////////
    
    
    
    // Get months
    public int getMonths()
    {
        return _months;
    }// end of get
    
    // set months
    public boolean setMonths(int m){
        if (isValidMonth(m))
        {
            this._months = m;
            return true;
        }
        return false;
    }
    // picking what contract period the user wants
    public static boolean isValidMonth(int m){
        
        if (m == 1 || m == 12 || m == 18 || m == 24)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// end of set months
    ///////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    // get international calls Y or N
    public char getCalls()
    {
        return _calls;
    }// end of get
    
    // set boolean for calls
    public boolean setCalls(char c){
        if (isValidCalls(c))
        {
            this._calls = c;
            return true;
        }
        return false;
    }
    public static boolean isValidCalls(char c){
        
        if (c == 'Y'  || c =='y' &&c == 'N' || c =='n' )// N for non international calls. Y for yes.
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }// end of set calls
    /////////////////////////////////////////////////////////////////////////////
    
    
    
    // set contract type
    public int getContract()
    {
        return _contract;
    }// end of get
    
    // Set package
    public boolean setContract(int ct){
        if (isValidContract(ct))
        {
            this._contract = ct;
            return true;
        }
        return false;
    }
    // Check that numbers 1 or 2 are entered
    public static boolean isValidContract(int ct){
        
        if (ct ==1 || ct ==2)// 1 for non business and 2 for business
        {
            return true;
        }
        else
        {
            return false;
        }
    }// end of set package
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    // get Reference number
    public String getRefNumber(){
        return _ref;
    }
    
    public boolean setRefNumber(String rf){
        if (isValidRef(rf))
        {
            this._ref=rf;
            return true;
        }
        return false;
    }
    
    public static boolean isValidRef(String rf)
    {
        boolean validFlag = true;
        
        if (rf.length() != 6)
        {
            validFlag = false;
        }
        else if (( !Character.isLetter(rf.charAt(0))) || (!Character.isLetter(rf.charAt(1))) ||
                (!Character.isDigit(rf.charAt(2))) || (!Character.isDigit(rf.charAt(3))) || (!Character.isDigit(rf.charAt(4))) &&
                ((rf.charAt(5))) == 'B' || ((rf.charAt(5)) =='N' ))
        {
            validFlag = false;
        }
        return validFlag;
    }// end of setting and verifying discount code
    ///////////////////////////////////////////////////////////////////////////////
    
    
    
    // get monthly charge
    public double getMonthlyCharge(){
        return _charge;
    }
    // end of get monthly charge
    // set monthly charge
    public void setMonthlyCharge(double mc){
         _charge = mc;
    }// end of set monthly charge
    //////////////////////////////////////////////////////////////////////////
    
    
   

    // get discount
    public int getDiscount(){
        return _discount;
    }// end of get discount
    
    // set discount
    public void setDiscount(int dc){
        _discount = dc;
    }// end of set discount
    /////////////////////////////////////////////////////////////////////////
    
    
    
    
    //get additional charge for international calls
    public double getAddCharge(){
        return _addCharge;
    }// end of get additional charge
    
    // set additional charge
    public void setAddCharge(double ac){
        _addCharge = ac;
    }// end of set additional charge
    /////////////////////////////////////////////////////////////////////////
    
    
    
    
    // charge after discounts but not charges
    public double getTotalCharge(){
        return _totalCharge;
    }// end of get total charge
    
    // set total charge
    public void setTotalCharge(double tt){
        _totalCharge = tt;
    }// end of set total charge
    //////////////////////////////////////////////////////////////////////////
    
    
    
    
    // final charge after everything
    public double getFinalCharge(){
        return _finalCharge;
    }// end of get total charge
    
    // set total charge
    public void setFinalCharge(double fc){
        _finalCharge = fc;
    }
    
    
}
    
        
        
        
    
           

