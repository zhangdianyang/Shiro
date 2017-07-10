package test.dao;

import org.springframework.stereotype.Repository;

import test.pojo.User;

@Repository
public interface UserDao {
	User getUser(String id);
}
