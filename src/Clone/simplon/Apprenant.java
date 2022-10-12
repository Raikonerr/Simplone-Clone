package Clone.simplon;


public class Apprenant extends Compte{
    private int ApprenantNumber;
    private int promoID;

    public static String mail;

    private Brief brief;

    public Apprenant(int id , String nom , String prenom , String email , String password ) {
        super(id, nom, prenom, mail, password);
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

    public Apprenant get(int i) {
        return null;

    }

    public int size() {
        return 0;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



