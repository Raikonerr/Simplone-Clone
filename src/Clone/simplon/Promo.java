package Clone.simplon;

public class Promo {

    public int promoID;
    public String promoName;
    private int[] apprenantIDs;
    private Brief brief;



    public Promo(int PromoID, String PromoName) {
        this.promoID = PromoID;
        this.promoName = PromoName;

    }


    /**
     * @return the promoID
     *
     */
    public int getPromoID() {
        return promoID;
    }

    /**
     * @param promoID the promoID to set
     *
     */
    public void setPromoID(int promoID) {
        this.promoID = promoID ;
    }


    /**
     * @return the promoName
     *
     */




    public void afficherPromo(){
        System.out.println("La promo est : " + promoName);
    }

    public String toString(){
        return "La promo est : " + promoName;
    }
    //setFormateurID

    public void setBrief(Brief brief){
        this.brief = brief;
    }

}
