package Clone.simplon;

import services.Courier;
import services.SendService;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import models.SendRequestMessageRouting;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.*;
public class Administrator  extends  Compte {
    ArrayList<Apprenant> apprenants = new ArrayList<Apprenant>();
    ArrayList<Formateur> formateurs = new ArrayList<Formateur>();
    ArrayList<Brief> briefs = new ArrayList<Brief>();
    int userId = 0 ;

    ArrayList<Promo> promos = new ArrayList<Promo>();

    public Administrator(int id, String nom, String prenom, String email, int role) {
        super(id, nom, prenom, email, role);
    }

    //login with id
   public void loginFormateur(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Entrer votre id : ");
         int id = sc.nextInt();
         for (Formateur formateur : formateurs) {
              if (formateur.getId() == id) {
                System.out.println("Bienvenue " + formateur.getNom());
                userId = id;
              }
         }
   }

   public void loginApprenant() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Entrer votre id : ");
       int id = sc.nextInt();
       for (Apprenant apprenant : apprenants) {
           if (apprenant.getId() == id) {
               System.out.println("Bienvenue " + apprenant.getNom());
           }
       }
   }




    public void afficherMenu(){
        System.out.println("1. Gestion des comptes");
        System.out.println("2. Gestion des promos");
        System.out.println("3. Gestion des briefs");
        System.out.println("4. Quitter");
    }
    public void addApprenant(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer l'id du apprenant");
        int id = sc.nextInt();
        System.out.println("Entrer le nom du apprenant");
        String nom = sc.next();
        System.out.println("Entrer le prenom du apprenant");
        String prenom = sc.next();
        System.out.println("Entrer l'email du apprenant");
        String email = sc.next();

        Apprenant apprenant = new Apprenant(id, nom, prenom, email, 1);
        apprenants.add(apprenant);
    }
    //afficher un apprenant
    public void afficherApprenant(){
        for (Apprenant apprenant : apprenants) {
            System.out.println(apprenant.toString());
        }
    }
    //ajouter un formateur
    public void addFormateur(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer l'id du formateur");
        int id = sc.nextInt();
        System.out.println("Entrer le nom du formateur");
        String nom = sc.next();
        System.out.println("Entrer le prenom du formateur");
        String prenom = sc.next();
        System.out.println("Entrer l'email du formateur");
        String email = sc.next();


        Formateur formateur = new Formateur(id, nom, prenom, email, 2);
        formateurs.add(formateur);

    }
    public void afficherFormateur(){
        for (Formateur formateur : formateurs) {
            System.out.println(formateur.toString());
        }
    }
    //Ajouter une promo
    public void addPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        System.out.println("Entrer le nom de la promo");
        String promoName = sc.next();

        Promo promo = new Promo(promoID, promoName);
        promos.add(promo);

    }
 // afficher les promos
    public void afficherPromo(){
        for (Promo promo : promos) {
            System.out.println(promo.toString());
        }
    }



    //assign promo to formateur
    public void assignerFormateur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id du formateur");
        int formateurID = sc.nextInt();
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();

        for (Formateur formateur : formateurs) {
            if(formateur.getId() == formateurID){
                for (Promo promo : promos) {
                    if(promo.getPromoID() == promoID){
                        formateur.setPromoID(promoID);
                    }
                }
            }
        }
    }
    //assign briefs to a promo
    public void assignerBrieff(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        System.out.println("Entrer l'id du brief");
        int briefID = sc.nextInt();

        for (Promo promo : promos) {
            if(promo.getPromoID() == promoID){

                for (Brief brief : briefs) {
                    if(brief.getPromoID() == briefID){
                        brief.setPromoID(promoID);

                        for (Apprenant apprenant : apprenants) {
                            if(apprenant.getPromoID() == promoID){
                                sendMail(apprenant.getEmail(), apprenant.nom, apprenant.prenom, brief.getBriefDescription());
                            }
                        }
                    }
                }
            }
        }

    }

    //afficher le formateur d'une promo
    public void afficherFormateurPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();

        for (Promo promo : promos) {
            if(promo.getPromoID() == promoID){
                for (Formateur formateur : formateurs) {
                    if(formateur.getPromoID() == promoID){
                        System.out.println(formateur);
                    }
                }
            }
        }
    }
    public void createBrief(){
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l id du brief");
        int id = sc.nextInt();
        System.out.println("Entrer le nom du brief : ");
        String nom = sc.next();
        System.out.println("Entrer le contenu du brief : ");
        String description = sc.next();

        Brief brief = new Brief(id,nom,description,userId);
        briefs.add(brief);
    }
    public void afficherBriefs(){
        for (Brief brief : briefs) {
            System.out.println(brief.toString());
        }
    }

    //ajouter les apprenants a une promo
    public void addApprenantToPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        System.out.println("Entrer l'id de l'apprenant");
        int apprenantID = sc.nextInt();

        for (Promo promo : promos) {
            if(promo.getPromoID() == promoID){
                for (Apprenant apprenant : apprenants) {
                    if(apprenant.getPromoID() == apprenantID){
                        apprenant.setPromoID(promoID);
                    }
                }
            }
        }
    }






    public void assignerBriefPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        System.out.println("Entrer l'id du brief");
        int briefID = sc.nextInt();

        for (Promo promo : promos) {
            System.out.println(promo.getPromoID());
            if(promo.getPromoID() == promoID){
                for (Brief brief : briefs) {
                    if(brief.getBriefID() == briefID){
                       brief.setPromoID(promoID);
                    }
                }
            }
        }
    }
    //assigner l'apprenant a une promo
    public void assignerApprenant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de l'apprenant");
        int apprenantID = sc.nextInt();
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();

        for (Apprenant apprenant : apprenants) {
            if(apprenant.getId() == apprenantID){
                for (Promo promo : promos) {
                    if(promo.getPromoID() == promoID){
                        apprenant.setPromoID(promoID);
                    }
                }
            }
        }
    }

    //afficher l'apprenant avec l'id du sa promo
    public void afficherApprenantPromo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();

        for (Promo promo : promos) {
            System.out.println("promo id " + promo.getPromoID());
            if(promo.getPromoID() == promoID){
                for (Apprenant apprenant : apprenants) {
                    System.out.println("appartenant id "+apprenant.getPromoID());
                    if(apprenant.getPromoID() == promoID){
                        System.out.println(apprenant + " " + promo);
                    }
                }
            }
        }
    }

    public void sendMail(String email,String nom,String prenom,String title){
        Courier.init("pk_prod_9JDC3R4J164P25M1TX88JQ3SC0Q8");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", email);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Welcome to Courier");
        content.put("body", "Bonjour "+nom+" "+prenom+" vous avez un nouveau brief "+title);
        sendRequestMessage.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("joke", "Why do Java programmers have to wear glasses? Because they don't C#");
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
