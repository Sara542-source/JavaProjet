import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class Main {
    static Set<Client> clients = new HashSet<>();
    static Set<Compte> comptes = new HashSet<>();

    public static void main(String[] args) {
        try {
            
            Banque banque1 = new Banque(1, "Italy");
            Client client1 = ajouterClient(1, "slim", "sara", "semlalia 12", "1234567890", "selimanisara2@gmail.com");
            Compte compte1 = creerCompte("345224", new Date(), "EUR", client1, banque1);

            Client rechercheClient = rechercherClient(1);
            if (rechercheClient != null) {
                System.out.println("Client " + rechercheClient.nom + " " + rechercheClient.prenom);
            }

            Compte rechercheCompte = rechercherCompte("345224");
            if (rechercheCompte != null) {
                System.out.println("Compte trouvé: " + rechercheCompte.numCompte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Client ajouterClient(int num, String nom, String prenom, String adresse, String phone, String email) {
        Client client = new Client(num, nom, prenom, adresse, phone, email);
        clients.add(client);
        return client;
    }

    public static Compte creerCompte(String numCompte, Date dateCreation, String devise, Client client, Banque banque) {
        Compte compte = new Compte(numCompte, dateCreation, devise, client, banque);
        client.addCompte(compte);
        banque.addCompte(compte);
        return compte;
    }

    public static Client rechercherClient(int num) {
        for (Client client : clients) {
            if (client.num == num) {
                return client;
            }
        }
        return null;
    }

    public static Compte rechercherCompte(String numCompte) {
        for (Compte compte : comptes) {
            if (compte.numCompte.equals(numCompte)) {
                return compte;
            }
        }
        return null;
    }
}
