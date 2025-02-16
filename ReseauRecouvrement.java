import java.util.HashMap;
import java.util.Map;

public class ReseauRecouvrement {
    private Map<String, ApplicationCible> applications;

    public ReseauRecouvrement() {
        applications = new HashMap<>();
    }

    public void ajouterApplication(ApplicationCible app) {
        applications.put(app.getId(), app);
    }

    public void connecter(String id1, String id2, int metrique) {
        if (applications.containsKey(id1) && applications.containsKey(id2)) {
            applications.get(id1).ajouterConnexion(applications.get(id2), metrique);
            applications.get(id2).ajouterConnexion(applications.get(id1), metrique);
        } else {
            System.out.println("Erreur : Une des applications n'existe pas !");
        }
    }

    public void afficherReseau() {
        for (ApplicationCible app : applications.values()) {
            app.afficherConnexions();
        }
    }
}
