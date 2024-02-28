
package Application;
public class Teacher{
    
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


    public Teacher(int id, String name, String specialisation)
    {   this.name = name;
        this.id = id;
        this.specialisations = specialisation;

    }


}