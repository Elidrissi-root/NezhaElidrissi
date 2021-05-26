/**
 * 
 */
package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import mode.User;
import toto.DbInteraction;

/**
 * @author toshiba
 *
 */
public class UserDAO implements IUser {
	@Override
	public int adduser(User u) {
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("insert into user values(null,'"+u.getNom()+"','"+u.getLog()+"','"+u.getPass()+"','"+u.getRole()+"')");
		DbInteraction.disconnect();
		return nb;
	}

	@Override
	public int adduser(String nom, String log, String pass) {
		DbInteraction.connect();
		int nb=DbInteraction.MAJ("insert into user values(null,'"+nom+"','"+log+"','"+pass+"')");
		DbInteraction.disconnect();
		return nb;
	}
	@Override
	public User authentification(String log, String pass) {
		User u=null;
		DbInteraction.connect();
		ResultSet rs = DbInteraction.select("select * from user where log='"+log+"' and pass='"+pass+"'");
		try {
			if(rs.next())
			{
				u=new User(rs.getInt(1),rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
