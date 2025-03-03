import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class Main {
    public static void main(String[] args) {
        ReseauRecouvrement reseau = new ReseauRecouvrement();

        try {
            // Lire le fichier JSON
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader("reseau.json"), JsonObject.class);

            // Lire les applications
            JsonArray applications = jsonObject.getAsJsonArray("applications");
            Map<String, ApplicationCible> appMap = new HashMap<>();
            for (int i = 0; i < applications.size(); i++) {
                JsonObject app = applications.get(i).getAsJsonObject();
                String id = app.get("id").getAsString();
                String ip = app.get("ip").getAsString();
                int port = app.get("port").getAsInt();
                String type = app.get("type").getAsString();

                ApplicationCible application;
                if (type.equals("Multiprotocole")) {
                    application = new ApplicationRecouvrement(id, ip, port, type);
                } else {
                    application = new ApplicationCible(id, ip, port, type);
                }
                appMap.put(id, application);
                reseau.ajouterApplication(application);
            }

            // Lire les connexions
            JsonArray connexions = jsonObject.getAsJsonArray("connexions");
            for (int i = 0; i < connexions.size(); i++) {
                JsonObject connexion = connexions.get(i).getAsJsonObject();
                String source = connexion.get("source").getAsString();
                String destination = connexion.get("destination").getAsString();
                int metrique = connexion.get("metrique").getAsInt();

                reseau.connecter(source, destination, metrique);
            }

            // Affichage du réseau
            System.out.println("\n=== État du réseau ===");
            reseau.afficherReseau();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}