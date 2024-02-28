public class mainEntry {

    public static void main(String[] args) {
        Teacher t = new Teacher("HARRY", "Maths");
        AppDataWriter writer = new ReflectionWriter();
        writer.writeObject(t);
    }
    
}
