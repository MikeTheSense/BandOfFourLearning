package learnpatterns;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var pr = PropertiesService.getInstance();
        pr.getProperties();
        var vr = PropertiesService.getInstance();
        vr.getProperties();


        System.out.println(pr.equals(vr));

        System.out.println(pr.getProperties().getProperty("projectName"));
        System.out.println(vr.getProperties().getProperty("projectName"));



    }
}
