package dao;
import java.util.List;

import model.User;
public interface UserDao
{
	public void addUser(User user);
	public User getUserById(int userId);
	//public int  getUserId();
	public List<User> getAllUser();
	public void updateUser(User user);
	public void deleteUser(int userId);

}
