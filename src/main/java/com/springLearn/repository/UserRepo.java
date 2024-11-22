package com.springLearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springLearn.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
}

//public class UserRepo {
//
//	User user;
//
//	public UserRepo(User user) {
//		this.user = user;
//	}
//
//	public void createUser() {
//		String query = "insert into user(id,model,name) values(?,?,?)";
//		try {
//
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sujithaDb", "root",
//					"root");
//			PreparedStatement ps = connection.prepareStatement(query);
//			System.out.println("from user repo " + this.user.toString());
//			ps.setInt(1, this.user.getId());
//			ps.setInt(2, this.user.getModel());
//			ps.setString(3, this.user.getName());
//			int rows = ps.executeUpdate();
//
//			if (rows > 0) {
//				System.out.println("inserted successfully");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}