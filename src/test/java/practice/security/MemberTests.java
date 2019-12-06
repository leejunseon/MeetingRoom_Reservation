package practice.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberTests {

	@Autowired
	private PasswordEncoder pwencoder;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testInsertMember() throws SQLException {
		String sql="insert into tbl_member(userid,userpw,username) values (?,?,?)";
		Connection con=ds.getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,"ljs921026");
		pstmt.setString(2,pwencoder.encode("dkxltmxm135"));
		pstmt.setString(3,"이준선");
		pstmt.executeUpdate();
	}
}
