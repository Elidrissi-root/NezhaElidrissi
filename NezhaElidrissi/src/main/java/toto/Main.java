/**
 * 
 */
package toto;
import DAO.LivreDAO ;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LivreDAO lv=new LivreDAO();
		int nb=lv.addLivre("Le théorème du parapluie" , "Mickaël Launay","Mathématiques");
		System.out.println(nb +"linges ajoutées");
	}

}
