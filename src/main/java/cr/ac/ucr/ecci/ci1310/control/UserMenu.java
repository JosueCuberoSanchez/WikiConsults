package cr.ac.ucr.ecci.ci1310.control;

import java.util.Scanner;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class UserMenu<K,V> {

    private String cacheId;
    private String cacheName;
    private String query;

    public UserMenu(){}

    public void displayUserMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the desired cache id");
        this.cacheId = scanner.next();
        System.out.println("Input the desired cache name");
        this.cacheName = scanner.next();
        System.out.println("Input the desired SQL query");
        this.query = scanner.next();
    }

    public String getCacheId() {
        return cacheId;
    }

    public String getCacheName() {
        return cacheName;
    }

    public String getQuery() {
        return query;
    }


}
