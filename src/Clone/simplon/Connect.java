package Clone.simplon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Connect extends DB{

    public Connect() {
        connectDB();
    }

    public void loginApprenant(String password, String mail){
        try{
            String sql = "SELECT * FROM apprenant WHERE mail = '"+mail+"' AND password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("Login Success");
            }else{
                System.out.println("Login Failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void loginFormateur(String mail,String password){
        try{
            String sql = "SELECT * FROM formateur WHERE mail = '"+mail+"' AND password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("Login Success");
            }else{
                System.out.println("Login Failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public void loginAdmin(String mail,String password){
        try{
            String sql = "SELECT * FROM admin WHERE mail = '"+mail+"' AND password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("Login Success");
            }else{
                System.out.println("Login Failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //insert data
    public void insertApprenant(String nom, String prenom, String mail ,String password,int promoid){
        try{
            String sql = "INSERT INTO apprenant (nom,prenom,mail,password,promoid) VALUES ('"+nom+"','"+prenom+"','"+mail+"','"+password+"','"+promoid+"')";
            stmt.executeUpdate(sql);
            System.out.println("Insert Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //afficher data apprenant by his id
    public void afficherApprenant(int id){
        try{
            String sql = "SELECT * FROM apprenant WHERE id = '"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("prenom: " + rs.getString("prenom"));
                System.out.println("mail: " + rs.getString("mail"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("promoid: " + rs.getInt("promoid"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void insertFormateur(String nom, String prenom, String mail ,String password ,int promoid){
        try{
            String sql = "INSERT INTO formateur (nom, prenom, mail,password, promoID) VALUES ('"+nom+"','"+prenom+"','"+mail+"','"+password+"','"+promoid+"')";
            stmt.executeUpdate(sql);
            System.out.println("Insert Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher data formateur by his id
    public void afficherFormateur(int id){
        try{
            String sql = "SELECT * FROM formateur WHERE id = '"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("prenom: " + rs.getString("prenom"));
                System.out.println("mail: " + rs.getString("mail"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("promoid: " + rs.getInt("promoid"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void insertPromo(String nom){
        try{
            String sql = "INSERT INTO promo (nom) VALUES ('"+nom+"')";
            stmt.executeUpdate(sql);
            System.out.println("Insert Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher promo by his name
    public void afficherPromo(String nom){
        try{
            String sql = "SELECT * FROM promo WHERE nom = '"+nom+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void insertBrief(String nom,String description,int formateurID,int promoID){
        try{
            String sql = "INSERT INTO brief (nom,description,formateurID,promoID) VALUES ('"+nom+"','"+description+"','"+formateurID+"','"+promoID+"')";
            stmt.executeUpdate(sql);
            System.out.println("Insert Success");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    //afficher brief by his name
    public void afficherBrief(String nom){
        try{
            String sql = "SELECT * FROM brief WHERE nom = '"+nom+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("formateurID: " + rs.getInt("formateurID"));
                System.out.println("promoID: " + rs.getInt("promoID"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //add apprenant to promo
    public void addApprenantToPromo(int apprenantID,int promoID){
        try{
            String sql = "UPDATE apprenant SET promoid = '"+promoID+"' WHERE id = '"+apprenantID+"'";
            stmt.executeUpdate(sql);
            System.out.println("Update Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher les apprenants d'une promo
    public void afficherApprenantByPromo(int promoID) {
        try {
            String sql = "SELECT * FROM apprenant WHERE promoid = '" + promoID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("prenom: " + rs.getString("prenom"));
                System.out.println("mail: " + rs.getString("mail"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("promoid: " + rs.getInt("promoid"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //afficher les apprenants d'une promo et les stocker dans une liste
    public List<Apprenant> afficherApprenantByPromo2(int promoID) {
        List<Apprenant> apprenants = new ArrayList<>();
        try {
            String sql = "SELECT * FROM apprenant WHERE promoid = '" + promoID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Apprenant apprenant = new Apprenant();
                apprenant.setId(rs.getInt("id"));
                apprenant.setNom(rs.getString("nom"));
                apprenant.setPrenom(rs.getString("prenom"));
                apprenant.setMail(rs.getString("mail"));
                apprenant.setPassword(rs.getString("password"));
                apprenant.setPromoID(rs.getInt("promoid"));
                apprenants.add(apprenant);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return apprenants;
    }
    public List<Brief> afficherBriefByPromo(int promoID) {
        List<Brief> briefs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM brief WHERE promoID = '" + promoID + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Brief brief = new Brief();
                brief.setId(rs.getInt("id"));
                brief.setNom(rs.getString("nom"));
                brief.setDescription(rs.getString("description"));;
                brief.setPromoID(rs.getInt("promoID"));
                briefs.add(brief);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return briefs;
    }

    // assigner une promo a un formateur
    public void assignerPromoToFormateur(int formateurID,int promoID){
        try{
            String sql = "UPDATE formateur SET promoID = '"+promoID+"' WHERE id = '"+formateurID+"'";
            stmt.executeUpdate(sql);
            System.out.println("Update Success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher le formateur d'une promo
    public void afficherFormateurPromo(int promoID){
        try{
            String sql = "SELECT * FROM formateur WHERE promoID = '"+promoID+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("prenom: " + rs.getString("prenom"));
                System.out.println("mail: " + rs.getString("mail"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("promoid: " + rs.getInt("promoid"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



       public void assignerBrief(int briefID,int promoID){
            try{
                String sql = "UPDATE brief SET promoID = '"+promoID+"' WHERE id = '"+briefID+"'";
                stmt.executeUpdate(sql);
                System.out.println("Update Success");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    //afficher brief by id
    public void afficherBriefByID(int id){
        try{
            String sql = "SELECT * FROM brief WHERE id = '"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("formateurID: " + rs.getInt("formateurID"));
                System.out.println("promoID: " + rs.getInt("promoID"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher promo by id
    public void afficherPromoByID(int id){
        try{
            String sql = "SELECT * FROM promo WHERE id = '"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("formateurID: " + rs.getInt("formateurID"));
                System.out.println("briefID: " + rs.getInt("briefID"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //afficher formateur by promo
    public void afficherFormateurByPromo(int promoID){
        try{
            String sql = "SELECT * FROM formateur WHERE promoID = '"+promoID+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nom: " + rs.getString("nom"));
                System.out.println("prenom: " + rs.getString("prenom"));
                System.out.println("mail: " + rs.getString("mail"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("promoid: " + rs.getInt("promoid"));
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }


}
