/**
 * 
 */
package mode;


/**
 * @author toshiba
 *
 */
public class Livre {
	int id;
	String titre;
	String auteur;
	String catégorie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getCatégorie() {
		return catégorie;
	}
	public void setCatégorie(String catégorie) {
		this.catégorie = catégorie;
	}
	public Livre(int id, String titre, String auteur, String catégorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.catégorie = catégorie;
	}
	public Livre(String titre, String auteur, String catégorie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.catégorie = catégorie;
	}
	
	
	

}
