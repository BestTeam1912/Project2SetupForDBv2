package hibernate_classreflection_test.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "p2_thread_tbl")
public class Thread {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "community_ref", nullable = true)
	private Community community;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
	private List<Comment> commentList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mythread")
	private List<ActiveUser> activeUserList;
	private Date dateCreated;
	
	public long getId() {
		return id;
	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
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
