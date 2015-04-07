package study.wp.ikitchen.model;

/**
 * Praise entity. @author MyEclipse Persistence Tools
 */

public class Praise implements java.io.Serializable {

	// Fields

	private Integer pid;
	private User user;
	private Menu menu;
	private Integer mid;

	// Constructors

	/** default constructor */
	public Praise() {
	}

	/** full constructor */
	public Praise(User user, Integer mid) {
		this.user = user;
		this.mid = mid;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	

}