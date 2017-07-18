package cr.ac.ucr.ecci.ci1310.control;

import java.util.Scanner;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class UserMenu<K,V> {

    private Boolean typeOfQuery;
    private String query;
    private Scanner scan;

    public UserMenu(){
        scan = new Scanner(System.in);
    }

    public void displayUserMenu(){
        System.out.println("Do you want to query Wikipedia by name o by id?\nType true for id, or false for name");
        this.typeOfQuery = this.scan.nextBoolean();
        System.out.println("Input the query data");
        this.query = scan.next();
    }

    public String getQuery() {
        return this.query;
    }

    public Boolean getTypeOfQuery(){
        return this.typeOfQuery;
    }


}
