package Clone.simplon;

import java.util.*;

public class Compte {
   protected int id;
   protected String nom;
   protected String prenom;
   protected String email;
   protected String password;
   protected int role;




    public Compte(int id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;

    }

    public Compte(){

    }





    public void afficherCompte() {
        System.out.println("id: " + this.id);
        System.out.println("nom: " + this.nom);
        System.out.println("prenom: " + this.prenom);
        System.out.println("email: " + this.email);
        System.out.println("role: " + this.role);
    }








}
