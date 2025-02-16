import java.util.HashMap;
import java.util.Map;

public class ApplicationCible {
    private String id;
    private String adresseIp;
    private int port;
    private String typeContenu;
    private Map<String, Integer> metriques;
    private Map<String, ApplicationCible> connexions;

    public ApplicationCible(String id, String adresseIp, int port, String typeContenu) {
        this.id = id;
        this.adresseIp = adresseIp;
        this.port = port;
        this.typeContenu = typeContenu;
        this.metriques = new HashMap<>();
        this.connexions = new HashMap<>();
    }

    public void ajouterConnexion(ApplicationCible voisin, int metrique) {
        connexions.put(voisin.getId(), voisin);
        metriques.put(voisin.getId(), metrique);
    }

    public String getId() { return id; }
    public String getAdresseIp() { return adresseIp; }
    public int getPort() { return port; }
    public String getTypeContenu() { return typeContenu; }
    public Map<String, Integer> getMetriques() { return metriques; }
    public Map<String, ApplicationCible> getConnexions() { return connexions; }

    public void afficherConnexions() {
        System.out.println("Connexions de " + id + " (" + typeContenu + ") :");
        for (String voisinId : connexions.keySet()) {
            System.out.println(" - " + voisinId + " (IP: " + connexions.get(voisinId).getAdresseIp() +
                               ", Port: " + connexions.get(voisinId).getPort() +
                               ", Mét. : " + metriques.get(voisinId) + ")");
        }
    }
}
