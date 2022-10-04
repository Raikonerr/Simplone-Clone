package Clone.simplon;
import java.util.*;


public class Brief {

    private int briefID;
    private String briefName;
    private int PromoID;
    private String briefDescription;

    private int formateurID;

  ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();

    public Brief(int BriefID, String BriefName, String BriefDescription,int formateurID) {
        this.briefID = BriefID;
        this.briefName = BriefName;
        this.briefDescription = BriefDescription;
        this.formateurID = formateurID;
    }

    /**
     * @return the briefID
     *
     */
    public int getBriefID() {
        return briefID;
    }

    public int getPromoID() {
        return PromoID;
    }

    public void setPromoID(int promoID) {
        PromoID = promoID;
    }

    /**
     * @param briefID the briefID to set
     *
     */
    public void setBriefID(int briefID) {
        this.briefID = briefID;
    }

    /**
     * @return the briefName
     *
     */
    public String getBriefName() {
        return briefName;
    }

    /**
     * @param briefName the briefName to set
     *
     */
    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    /**
     * @return the briefDescription
     *
     */
    public String getBriefDescription() {
        return briefDescription;
    }

    /**
     * @param briefDescription the briefDescription to set
     *
     */
    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }










    //toString
    public String toString(){
        return "Le brief est : " + briefName;
    }



}



