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
public class Administrator  extends  Connect  {

    Apprenant apprenants = new Apprenant();
    Formateur formateurs = new Formateur();

    Brief briefs = new Brief();








    int userId = 0 ;



    public Administrator() {

    }

    //login with id
   public void loginFormateur(){
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter your mail : ");
        String mail = sc.nextLine();
        System.out.println("Enter your password : ");
        String password = sc.nextLine();
        try{
            loginFormateur(mail,password);
        }catch (Exception e){
            System.out.println(e);
        }

   }

   public void loginApprenant() {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter your mail : ");
        String mail = sc.nextLine();
        System.out.println("Enter your password : ");
        String password = sc.nextLine();
        try{
            loginApprenant(password,mail);
        }catch (Exception e){
            System.out.println(e);
        }
   }

   public void loginAdmin() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your mail : ");
       String mail = sc.nextLine();
       System.out.println("Enter your password : ");
       String password = sc.nextLine();
       try {
           loginAdmin(mail, password);
       } catch (Exception e) {
           System.out.println(e);
       }
   }





    public void addApprenant(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Entrer le nom du apprenant");
        String nom = sc.next();
        System.out.println("Entrer le prenom du apprenant");
        String prenom = sc.next();
        System.out.println("Entrer l'email du apprenant");
        String email = sc.next();
        System.out.println("Entrer le mot de passe du apprenant");
        String password = sc.next();
        System.out.println("Entrer l'id de la promotion");
        int promoid = sc.nextInt();
        try{
            insertApprenant(nom,prenom,email,password,promoid);
        }catch (Exception e){
            System.out.println(e);
        }


    }
    //afficher un apprenant
    public void afficherApprenant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id du apprenant");
        int id = sc.nextInt();
        try{
            afficherApprenant(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //ajouter un formateur
    public void addFormateur(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Entrer le nom du formateur");
        String nom = sc.next();
        System.out.println("Entrer le prenom du formateur");
        String prenom = sc.next();
        System.out.println("Entrer l'email du formateur");
        String email = sc.next();
        System.out.println("Entrer le mot de passe du formateur");
        String password = sc.next();
        System.out.println("Entrer l'id de la promotion");
        int promoid = sc.nextInt();
        try{
            insertFormateur(nom,prenom,email,password,promoid);
        }catch (Exception e){
            System.out.println(e);
        }




    }
    public void afficherFormateur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id du formateur");
        int id = sc.nextInt();
        try{
            afficherFormateur(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Ajouter une promo
    public void addPromo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer le nom de la promo");
        String promoName = sc.nextLine();

        try{
            insertPromo(promoName);
        }catch (Exception e){
            System.out.println(e);
        }



    }
 // afficher les promos
    public void afficherPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer nom de la promo");
        String nom = sc.next();
        try{
            afficherPromo(nom);
        }catch (Exception e){
            System.out.println(e);
        }

    }



    //assign promo to formateur
    public void assignerFormateur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id du formateur");
        int id = sc.nextInt();
        System.out.println("Entrer l'id de la promo");
        int promoId = sc.nextInt();
        try{
            assignerPromoToFormateur(id,promoId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //afficher le formateur d'une promo
    public void afficherFormateurPromo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        afficherFormateurPromo(promoID);
    }

    public void createBrief(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer le nom du brief : ");
        String nom = sc.next();
        System.out.println("Entrer le contenu du brief : ");
        String description = sc.next();
        System.out.println("Entrer l'id de la promo : ");
        int promoID = sc.nextInt();
        System.out.println("Entrer l'id du formateur : ");
        int formateurID = sc.nextInt();
        try{
            insertBrief(nom,description,promoID,formateurID);
        }catch (Exception e){
            System.out.println(e);
        }



    }
    public void afficherBriefs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du brief : ");
        String nom = sc.next();
        try{
            afficherBrief(nom);
        }catch (Exception e){
            System.out.println(e);
        }
    }











    //assigner l'apprenant a une promo
    public void assignerApprenant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        System.out.println("Entrer l'id de l'apprenant");
        int apprenantID = sc.nextInt();
        try{
            addApprenantToPromo(promoID,apprenantID);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //afficher l'apprenant avec l'id du sa promo
    public void afficherApprenantPromo(){
        Scanner sc = new Scanner(System.in);

       System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        try{
            afficherApprenantByPromo(promoID);
        }catch (Exception e){
            System.out.println(e);
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

    //assigner un breif a une promo et envoyer un mail a tous les apprenants de la promo
    public void assignerBrief() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id du brief");
        int briefID = sc.nextInt();
        System.out.println("Entrer l'id de la promo");
        int promoID = sc.nextInt();
        try {
            assignerBrief(briefID, promoID);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            List<Brief> briefs = afficherBriefByPromo(promoID);
            List<Apprenant> apprenants = afficherApprenantByPromo2(promoID);
            for (Apprenant apprenant : apprenants) {
                sendMail(apprenant.getEmail(), apprenant.getNom(), apprenant.getPrenom(), briefs.get(0).getNom());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    //envoyer un mail a tous les apprenants de la promo













}
