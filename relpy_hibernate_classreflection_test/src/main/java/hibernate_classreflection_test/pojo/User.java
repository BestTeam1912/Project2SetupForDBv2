package hibernate_classreflection_test.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "p2_user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String username;
	private String password;
	private Enum userType;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ActiveUser> activeUserList;
	private Date dateCreated;
	public long getId() {
		return id;
	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Enum getUserType() {
		return userType;
	}
	public void setUserType(Enum userType) {
		this.userType = userType;
	}
	public List<ActiveUser> getActiveUserList() {
		return activeUserList;
	}
	public void setActiveUserList(List<ActiveUser> activeUserList) {
		this.activeUserList = activeUserList;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
//	public void setDateCreated(Date dateCreated) {
//		this.dateCreated = dateCreated;
//	}
	
	
}
