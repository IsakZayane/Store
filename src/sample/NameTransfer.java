package sample;

public class NameTransfer {
    private String name;
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
    }

    private NameTransfer() {
    }
}
