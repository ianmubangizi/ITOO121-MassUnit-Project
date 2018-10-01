package massunit;

import java.util.Scanner;

/**
 * This is a simple Mass convection class
 * that can take either a unit in kilograms 
 * or pounds a convects between the two
 * 
 * @author ian
 */
public class MassUnit {
    private final double con = 0.45359237;
    Scanner cin = new Scanner(System.in);
    private final int index;
    private double mass;
    private String unit;

    /** 
     * Default MassUnit Class Constructor
     */
    public MassUnit() {
        this.index = 0;
    }

    /** 
     * MassUnit Class Constructor that takes 
     * the mass only
     * 
     * @param mass
     */
    public MassUnit(double mass) {
        this.mass = mass;
        this.index = 1;
    }

    /** 
     * MassUnit Class Constructor that takes 
     * the unit only
     * 
     * @param unit
     */
    public MassUnit(String unit) {
        this.unit = unit;
        this.index = 3;
    }
    
    /** 
     * MassUnit Class Constructor that takes 
     * both the mass and unit
     * 
     * @param mass
     * @param unit
     */
    public MassUnit(double mass, String unit) {
        this.mass = mass;
        this.unit = unit;
        this.index = 4;
    }

    /** 
     * getMass() gets the mass and returns
     * it as a double
     * 
     * @return mass
     */
    public double getMass() {
            return mass;
    }

    /** 
     * setMass() sets the mass from passed
     * augment 
     * 
     * @param mass
     */
    public void setMass(double mass){
        this.mass = mass;
    }
    
    /** 
     * setMass() sets the mass with Scanner
     * input
     */
    public void setMass(){
        System.out.print("Enter Mass: ");
        this.mass = cin.nextDouble();
    }
    
    /** 
     * getUnit() gets the unit and returns
     * it as a String Object
     * 
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) throws Exception {
        if(!checkUnit(unit))
            throw new Exception("Invaild Unit Exception");
        else
            this.unit = unit;
    }
    public void setUnit() throws Exception {
        System.out.print("Enter Unit with (kg as kilos or lb as pounds): ");
        this.unit = cin.next();
        if(!checkUnit(this.unit))
            throw new Exception("Invaild Unit Exception");
    }

    public String MassConvertion(){
        if(unit.equalsIgnoreCase("kg"))
            return "["+ getMass() * con + "lb]";
                    
        if(unit.equalsIgnoreCase("lb"))
            return "["+ getMass() / con + "kg]";
        else
            return "[Error: No Unit found]";
    }
    
    public String setConvertion(String u){
            if(checkUnit(u)){
                return "["+ getMass() + u +"]";
            }
            return "[Error: Invaild Convertion Unit found]";
    }
    
    public void setMassAndUnit(){
        try{
            System.out.println("=============================================\n"
                    + "           |Class Constructor ["+ index +"]|"
            );
            setUnit();
            setMass();
        } catch(Exception e){
            System.out.println("=============================================\n"
                    +"The was a ["+ e +"]\n"
                    + "Enter the values again\n"
                    + "=============================================");
            cin.nextLine();
            setMassAndUnit();
        }
    }
    
    public boolean checkUnit(String u){
        return u.equalsIgnoreCase("kg")||u.equalsIgnoreCase("lb");
    }
    
    public void displayKilos(){
        System.out.println("Your Mass is "+ setConvertion("kg") +"");
    }
    
    public void displayPounds(){
        System.out.println("Your Mass is "+ setConvertion("lb") +"");
    }
    
    public void displayKilosAndPounds(){
        System.out.println("Your Mass is ["+ getMass() +""+ unit +"]\n"
                + "Which is equal to a Mass of "+ MassConvertion() +"");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MassUnit obj = new MassUnit();
        MassUnit obj1 = new MassUnit(0);
        MassUnit obj2 = new MassUnit("kg");
        MassUnit obj3 = new MassUnit(0,"kg");
        
        obj.setMassAndUnit();
        obj.displayKilos();
        obj.displayPounds();
        obj.displayKilosAndPounds();
        
        obj1.setMassAndUnit();
        obj1.displayKilos();
        obj1.displayPounds();
        obj1.displayKilosAndPounds();
        
        obj2.setMassAndUnit();
        obj2.displayKilos();
        obj2.displayPounds();
        obj2.displayKilosAndPounds();
    
        obj3.setMassAndUnit();
        obj3.displayKilos();
        obj3.displayPounds();
        obj3.displayKilosAndPounds();
    }
    
}
