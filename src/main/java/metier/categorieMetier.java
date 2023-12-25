package metier;

import DAO.categorieDAO;
import java.util.List;
import modele.categorie;

public class categorieMetier {
    private categorieDAO categorieDAO;

    public categorieMetier() {
        categorieDAO = new categorieDAO();
    }

    public void createCategorie(categorie categorie) {
        categorieDAO.createCategorie(categorie);
    }
    public List<categorie> getAllCategories() {
        return categorieDAO.getAllCategories();
    }

    public categorie getCategorieById(int id) {
        return categorieDAO.getCategorieById(id);
    }

    public void updateCategorie(categorie categorie) {
        categorieDAO.updateCategorie(categorie);
    }

    public void deleteCategorie(int id) {
        categorieDAO.deleteCategorie(id);
    }
}
