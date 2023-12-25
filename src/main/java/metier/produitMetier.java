package metier;
import DAO.produitDAO;
import java.util.List;
import modele.produit;

public class produitMetier {
    private produitDAO produitDAO;

    public produitMetier() {
    	produitDAO = new produitDAO();
    }

    public void createProduit(produit produit) {
    	produitDAO.createProduit(produit);
    }

    public List<produit> getAllProduits() {
        return produitDAO.getAllProduits();
    }

    public produit getProduitById(int id) {
        return produitDAO.getProduitById(id);
    }

    public void updateProduit(produit produit) {
    	produitDAO.updateProduit(produit);
    }

    public void deleteProduit(int id) {
    	produitDAO.deleteProduit(id);
    }
}
