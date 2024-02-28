
public class Teacher{
    
    private static int idCounter;
    private int id;
    private String name;
    private String specialisations;

    public String getName() {return name;}
    public int getId() {return id;}
    public String getSpecialisations() {return specialisations;}

    public void addSpecialisation(String special){
        if(specialisations == ""){
            specialisations = special;
            return;
        }
        specialisations += ", " + special;
    }

    public Teacher(String name, String specialisation)
    {   this.name = name;    
        this.specialisations = specialisation;
        id = idCounter++;

    }

    public Teacher(int id, String name, String specialisation){
        this.name = name;    
        this.specialisations = specialisation;
        this.id = id;
    }

}