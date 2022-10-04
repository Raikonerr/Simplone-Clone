package Clone.simplon;


public class Apprenant extends Compte{
    private int ApprenantNumber;
    private int promoID;

    public static String mail;

    private Brief brief;

    public Apprenant(int id , String nom , String prenom , String email , int role ) {
        super(id, nom, prenom, mail, role);
        mail = email;
    }

    public Apprenant(){
        super();
    }

    public String toString() {
        return "Apprenant Name : " + this.nom + " " + this.prenom + " " + "Apprenant ID : " + this.id + " " + "Apprenant Email : " + this.email ;
    }

    //getid
    public int getId(){
        return this.id;
    }

    public int getPromoID() {
        return promoID;
    }

    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }

    public static String getEmail(){

        return mail;
    }

    /**
     * @return the apprenantNumber
     *
     */
    public int getApprenantNumber() {
        return ApprenantNumber;
    }

    //afficher l'apprenant

    public void afficherInfo(){
        System.out.println("L'apprenant est : " + this.nom + " " + this.prenom);
    }

    public String getNom(){
        return this.nom;
    }

    //setBrief
    public void setBrief(Brief brief){
        this.brief = brief;
    }
}



