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
	String cat�gorie;
	
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
	public String getCat�gorie() {
		return cat�gorie;
	}
	public void setCat�gorie(String cat�gorie) {
		this.cat�gorie = cat�gorie;
	}
	public Livre(int id, String titre, String auteur, String cat�gorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.cat�gorie = cat�gorie;
	}
	public Livre(String titre, String auteur, String cat�gorie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.cat�gorie = cat�gorie;
	}
	
	
	

}
