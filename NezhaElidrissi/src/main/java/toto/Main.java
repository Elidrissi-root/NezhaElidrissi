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
		int nb=lv.addLivre("Le th�or�me du parapluie" , "Micka�l Launay","Math�matiques");
		System.out.println(nb +"linges ajout�es");
	}

}
