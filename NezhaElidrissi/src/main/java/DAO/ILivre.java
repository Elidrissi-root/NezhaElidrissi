
package DAO;
import java.util.List;
import mode.Livre;
public interface ILivre {
	public int addLivre(Livre l);
	public int addLivre(String titre, String auteur, String catégorie );
	public Livre findLivreById(int id);
	public int deleteLivre(int id);
	public List<Livre> allLivre();
	public int updateLivre(int id, Livre l);
	
}
