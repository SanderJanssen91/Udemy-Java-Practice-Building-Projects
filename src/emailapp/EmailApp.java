package emailapp;

public class EmailApp {

    public static void main(String[] args){
        Email em1 = new Email("Sander", "Janssen");
        em1.setAlternateEmail("janssen.sander@live.nl");
        System.out.println(em1.showInfo());
    }
}
