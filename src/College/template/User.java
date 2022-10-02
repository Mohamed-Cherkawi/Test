package College.template;

public abstract class User {

    // Attributes
    private short id ;
    private  String nom ;
    private String prenom ;
    private String telephone ;
    private String email ;
    private String password ;
    // private  role ;

    //Methods
    public abstract void insert();
    public abstract void update();
    public abstract String search();

    public  void delete(){};
}
