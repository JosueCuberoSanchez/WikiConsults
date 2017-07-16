package cr.ac.ucr.ecci.ci1310.control;

import cr.ac.ucr.ecci.ci1310.core.service.WikiService;
import cr.ac.ucr.ecci.ci1310.core.service.impl.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.statistics.Statistics;

import java.util.Scanner;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class Controller<K,V> {
    private UserMenu userMenu;
    private WikiService wikiService;
    private Statistics statistics;
    private Boolean cont;

    public Controller(){
        this.userMenu = new UserMenu();
        this.wikiService = new WikiServiceImpl();
        this.statistics = new Statistics();
        this.cont = true;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(this.cont){
            this.userMenu.displayUserMenu();
            this.wikiService.getDataWithId("Metallica");
            System.out.println("Do you want to do another query?");
            this.cont = scanner.nextBoolean();
        }
    }
}
