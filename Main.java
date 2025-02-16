public class Main {
    public static void main(String[] args) {
        ReseauRecouvrement reseau = new ReseauRecouvrement();

        /* Création des applications cibles */
        ApplicationCible app1 = new ApplicationCible("App1", "192.168.1.1", 5000, "Texte");
        ApplicationCible app2 = new ApplicationCible("App2", "192.168.1.2", 5001, "Image");
        ApplicationCible app3 = new ApplicationCible("App3", "192.168.1.3", 5002, "Vidéo");

        /*applications de recouvrement */
        ApplicationRecouvrement rec1 = new ApplicationRecouvrement("Rec1", "192.168.1.4", 5003, "Multiprotocole");
        ApplicationRecouvrement rec2 = new ApplicationRecouvrement("Rec2", "192.168.1.5", 5004, "Multiprotocole");

        /*ajout des applications au réseau */ 
        reseau.ajouterApplication(app1);
        reseau.ajouterApplication(app2);
        reseau.ajouterApplication(app3);
        reseau.ajouterApplication(rec1);
        reseau.ajouterApplication(rec2);

        /*Connexions statiques */ 
        reseau.connecter("App1", "Rec1", 5);
        reseau.connecter("App2", "Rec1", 7);
        reseau.connecter("Rec1", "Rec2", 3);
        reseau.connecter("Rec2", "App3", 6);

        /* Affichage du réseau */
        System.out.println("\n=== État du réseau ===");
        reseau.afficherReseau();
    }
}
