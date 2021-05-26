
package DAO;

import java.util.List;

import mode.Livre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mode.Livre;
import toto.DbInteraction;
public class LivreDAO implements ILivre {

	@Override
	public int addLivre(Livre l) {
		// TODO Auto-generated method stub
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("insert into Livre values(null,'"+l.getId()+"',"+l.getTitre()+","+l.getAuteur()+",'"+l.getCatégorie()+"')");
		DbInteraction.disconnect();
		return nb;
	}

	@Override
	public int addLivre( String titre, String auteur, String catégorie) {
		// TODO Auto-generated method stub
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("insert into Livre values(null,'"+titre+"',"+auteur+",'"+catégorie+"')");
		DbInteraction.disconnect();
		return nb;
	}
	

	@Override
	public Livre findLivreById(int id) {
		// TODO Auto-generated method stub
		Livre l=null;
		DbInteraction.connect();
		ResultSet rs = DbInteraction.select("select * from produit where id="+id);
		try {
			if(rs.next())
			{
				l=new Livre(rs.getInt(1),rs.getString(2), rs.getString(3),  rs.getString(4));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public int deleteLivre(int id) {
		// TODO Auto-generated method stub
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("delete from Livre where id="+id);
		DbInteraction.disconnect();
		return nb;
	}

	@Override
	public List<Livre> allLivre() {
		List<Livre>  livres=new ArrayList<Livre>();
		DbInteraction.connect();
		ResultSet rs = DbInteraction.select("select * from livre ");
		try {
			while(rs.next())
			{
				Livre l=new Livre(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				livres.add(l);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livres;
	}

	@Override
	public int updateLivre(int id, Livre l) {
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("update livre set desg='"+l.getTitre()+"', prix="+l.getAuteur()+", qte="+l.getCatégorie() +"' where id="+id);
		DbInteraction.disconnect();
		return nb;
	}
}
