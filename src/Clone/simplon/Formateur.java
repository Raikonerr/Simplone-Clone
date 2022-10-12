package Clone.simplon;
import java.util.*;


public class Formateur extends Compte {

    private int promoID;

    private Apprenant[] apprenants;
    private Promo[] promos;
    public static String mail;

    ArrayList<Brief> briefs = new ArrayList<Brief>();
    public Formateur(int id , String nom , String prenom , String email , String password ) {
        super(id, nom, prenom, email, password);
        this.email = mail;
    }
    public Formateur(){
        super();
    }
    public String toString() {
        return "Formateur Name : " + this.nom + " " + this.prenom + " " + "Formateur ID : " + this.id + " " + "Formateur Email : " + this.email ;
    }

    public int getPromoID() {
        return promoID;
    }

    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }

    //creer un brief



    //afficher les briefs
    public void afficherBriefs(){
        for (Brief brief : briefs) {
            System.out.println(brief.toString());
        }
    }

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public static String getEmail(){
        return mail;
    }




         //assigner brief à une promo














}
