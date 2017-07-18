package cr.ac.ucr.ecci.ci1310.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Josue Cubero on 17/07/2017.
 */
public class Page {
    private String title;
    private String id;
    private Date date;

    public Page(String title, String id, String date){
        this.title = title;
        this.id = id;
        this.date = this.convertLastTouchedToDate(date);
    }

    public String getTitle() {
        return this.title;
    }

    public String getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public Date convertLastTouchedToDate(String stringDate){ //format: 20170714153735, YYYY,MM,DD
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date dateFromString = null;
        try {
            dateFromString = formatter.parse(stringDate.substring(0,4)+"."+stringDate.substring(4,6)+
                    "."+stringDate.substring(6,8));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFromString;
    }

    public void printData(){
        System.out.println("Title: "+this.getTitle()+" Id: "+this.getId()+" Last seen: "+this.getDate());
    }
}
