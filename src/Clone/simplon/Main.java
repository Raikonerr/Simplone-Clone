package Clone.simplon;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Administrator admin = new Administrator(1, "admin", "admin", "admin@gmail.com", 0);
        Formateur formateur = new Formateur();
        Apprenant apprenant = new Apprenant();
while (true) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Entrer votre Role");
        String role = sn.next();
        boolean menu = true ;

        //check role of the user and display the menu
        if (role.equals("admin")){



            while (menu) {
                System.out.println("1- Ajouter un apprenant");
                System.out.println("2- Afficher les apprenants");
                System.out.println("3- Ajouter un formateur");
                System.out.println("4- Afficher les formateurs");
                System.out.println("5- Ajouter une promo");
                System.out.println("6- Afficher les promos");
                System.out.println("7- Assigner une promo à un formateur");
                System.out.println("8- afficher le formateur d'une promo");
                System.out.println("9- retourner au menu principal");
                System.out.println("0- Quitter");

                Scanner sc = new Scanner(System.in);
                int choix = sc.nextInt();


                switch (choix) {
                    case 1:

                        admin.addApprenant();
                        break;
                    case 2:

                        admin.afficherApprenant();
                        break;
                    case 3:

                        admin.addFormateur();
                        break;
                    case 4:
                        admin.afficherFormateur();
                        break;
                    case 5:
                        admin.addPromo();
                        break;
                    case 6:
                        admin.afficherPromo();
                        break;
                    case 7:
                        admin.assignerFormateur();
                        System.out.println("Promo assignée");
                        break;
                    case 8:
                        admin.afficherFormateurPromo();
                        break;
                    case 9:
                        menu = false;
                        break;
                    case 0:
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            }

        }else if(role.equals("apprenant")){
            System.out.println("Bienvenue apprenant");
            admin.loginApprenant();

            while(menu){
                System.out.println("1- Afficher les briefs");
                System.out.println("2- Afficher les promos");
                System.out.println("3- Afficher les formateurs");
                System.out.println("4- afficher les apprenants");
                System.out.println("5- retourner au menu principal");
                System.out.println("6- Quitter");


                Scanner sc = new Scanner(System.in);
                int choix = sc.nextInt();

                switch (choix) {
                    case 1:
                        formateur.afficherBriefs();
                        break;
                    case 2:
                        admin.afficherPromo();
                        break;
                    case 3:
                        admin.afficherFormateur();
                        break;
                    case 4:
                        admin.afficherApprenant();
                        break;
                    case 5:
                        menu = false;
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }


        }else if(role.equals("formateur")){
            System.out.println("Bienvenue formateur");
            admin.loginFormateur();


            while(menu){
                System.out.println(admin.userId);
                System.out.println("1- Creer un brief");
                System.out.println("2- Afficher les briefs");
                System.out.println("3- Assigner un brief a une promo");
                System.out.println("4- Afficher les promos");
                System.out.println("5- Ajouter un apprenant a une promo");
                System.out.println("6- afficher les apprenants d'une promo");
                System.out.println("7- retourner au menu principal");
                System.out.println("0- Quitter");

                Scanner sc = new Scanner(System.in);
                int choix = sc.nextInt();

switch (choix) {
                    case 1:
                        admin.createBrief();
                        break;
                    case 2:
                        admin.afficherBriefs();
                        break;
                    case 3:
                        admin.assignerBrieff();
                        break;
                    case 4:
                        admin.afficherPromo();
                        break;
                    case 5:
                        admin.assignerApprenant();
                        break;
                    case 6:
                        admin.afficherApprenantPromo();
                        break;
                    case 7:
                        menu = false;
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        break;
                }

            }
        }
    }}
    }
