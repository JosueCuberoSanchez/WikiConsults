package cr.ac.ucr.ecci.ci1310.control;

import cr.ac.ucr.ecci.ci1310.cache.CacheTypes.Cache;
import cr.ac.ucr.ecci.ci1310.cache.CacheTypes.FIFOCache;
import cr.ac.ucr.ecci.ci1310.core.service.WikiService;
import cr.ac.ucr.ecci.ci1310.core.service.impl.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.model.Page;
import cr.ac.ucr.ecci.ci1310.statistics.Statistics;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class Controller<K,V> {
    private UserMenu userMenu;
    private WikiService wikiService;
    private Statistics statistics;
    private Boolean cont;
    private Cache cacheIds;
    private Cache cacheNames;
    private Page page;
    private List<Page> pages;

    public Controller(){
        this.userMenu = new UserMenu();
        this.wikiService = new WikiServiceImpl();
        this.statistics = new Statistics();
        this.cont = true;
        this.cacheIds = new FIFOCache<>();
        this.cacheNames = new FIFOCache<>();
    }

    @SuppressWarnings("unchecked")
    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(this.cont){
            this.userMenu.displayUserMenu();
            if(this.userMenu.getTypeOfQuery()){
                this.page = (Page) this.cacheIds.get(this.userMenu.getQuery());
                if(this.page==null){
                    this.cacheIds.put(this.userMenu.getQuery(), this.wikiService.getDataWithId(this.userMenu.getQuery()));
                } else {
                    //System.out.println("found in cache");
                    this.page.printData();
                }
            } else {
                this.pages = (List<Page>) this.cacheNames.get(this.userMenu.getQuery());
                if(this.pages==null){
                    this.cacheNames.put(this.userMenu.getQuery(), this.wikiService.getDataWithName(this.userMenu.getQuery()));
                } else {
                    //System.out.println("found in cache");
                    for(Page temporalPage: pages) {
                        temporalPage.printData();
                    }
                }
            }
            System.out.println("Do you want to do another query?\nType true to continue or false to quit");
            this.cont = scanner.nextBoolean();
        }
    }
}
