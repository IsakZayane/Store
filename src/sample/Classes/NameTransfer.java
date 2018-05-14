package sample.Classes;

public class NameTransfer {
    private String email;
    private String name;
    private double totalsum;
    private static NameTransfer ourInstance = new NameTransfer();

    public static NameTransfer getInstance() {
        return ourInstance;
    }
    // Här Sparas namnet på den som loggar in oavsett guest eller member

    public void setName(String name){
        this.name=name;


    }

    public String getName() {
        return name;

    }public void setEmail(String email){
        this.email = email;

    }public String getEmail(){
        return email;
    }

    public void setTotalsum(double setsum){

        this.totalsum += setsum;
    }
   public double getTotalsum(){return totalsum;}

    private NameTransfer() {
    }
}
