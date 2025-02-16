public class ApplicationRecouvrement extends ApplicationCible {
    private String role;

    public ApplicationRecouvrement(String id, String adresseIp, int port, String typeContenu) {
        super(id, adresseIp, port, typeContenu);
        this.role = "Recouvrement";
    }

    @Override
    public void afficherConnexions() {
        System.out.println("[REC] Connexions de " + getId() + " (Rôle: " + role + "):");
        for (String voisinId : getConnexions().keySet()) {
            System.out.println(" - " + voisinId + " (IP: " + getConnexions().get(voisinId).getAdresseIp() +
                               ", Port: " + getConnexions().get(voisinId).getPort() +
                               ", Mét. : " + getMetriques().get(voisinId) + ")");
        }
    }
}
