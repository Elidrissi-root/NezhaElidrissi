/**
 * 
 */
package DAO;

import mode.User;

/**
 * @author toshiba
 *
 */
public interface IUser {
	public int adduser(User u);
	public int adduser(String nom, String log, String pass);
	public User authentification(String log,String pass);

}
