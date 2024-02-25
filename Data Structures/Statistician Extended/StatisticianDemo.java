public class StatisticianDemo {
    public static void main(String[] args) { 

        // Creating Statistician objects for testing. 
        Statistician a = new Statistician(); 
        a.nextNumber(2.0);
        a.nextNumber(-10.0); 
        a.nextNumber(5.0); 

        Statistician b = new Statistician(); 
        b.nextNumber(1.0); 
        b.nextNumber(2.0); 
        b.nextNumber(3.0); 

        Statistician c = new Statistician(); 
        c.nextNumber(-10.0); 
        c.nextNumber(-10.0); 
        c.nextNumber(-100.0); 
    }
}