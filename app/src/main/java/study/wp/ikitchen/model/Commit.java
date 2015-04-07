package study.wp.ikitchen.model;

import java.sql.Timestamp;

/**
 * Commit entity. @author MyEclipse Persistence Tools
 */

public class Commit implements java.io.Serializable {

	// Fields

	private Integer cid;
	private User user;
	private Integer mid;
	private Menu menu;
	private Integer type;
	private String description;
	private String pic;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public Commit() {
	}

	/** minimal constructor */
	public Commit(User user, Integer mid) {
		this.user = user;
		this.mid = mid;
	}

	/** full constructor */
	public Commit(User user, Integer mid, Integer type, String description,
			String pic, Timestamp ctime) {
		this.user = user;
		this.mid = mid;
		this.type = type;
		this.description = description;
		this.pic = pic;
		this.ctime = ctime;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	

}