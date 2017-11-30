package dao;

import vo.User;
import java.util.List;

public interface IUserDAO {
	public boolean doInsert(User user) throws Exception;
	
	public boolean doDelete(int id) throws Exception;
	
	public boolean doUpdate(int id, User user) throws Exception;
	
	public User findById(int id) throws Exception;
	
	public List<User> findByKey(String keyword) throws Exception;
}
