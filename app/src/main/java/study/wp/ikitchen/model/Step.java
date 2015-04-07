package study.wp.ikitchen.model;

/**
 * Step entity. @author MyEclipse Persistence Tools
 */

public class Step implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Menu menu;
	private Integer mid;
	private String description;
	private Integer inmenuid;
	private String spic;
	private Integer stime;

	// Constructors

	/** default constructor */
	public Step() {
	}

	/** minimal constructor */
	public Step(Integer mid, String description, Integer inmenuid) {
		this.mid = mid;
		this.description = description;
		this.inmenuid = inmenuid;
	}

	/** full constructor */
	public Step(Integer mid, String description, Integer inmenuid, String spic,
			Integer stime) {
		this.mid = mid;
		this.description = description;
		this.inmenuid = inmenuid;
		this.spic = spic;
		this.stime = stime;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInmenuid() {
		return this.inmenuid;
	}

	public void setInmenuid(Integer inmenuid) {
		this.inmenuid = inmenuid;
	}

	public String getSpic() {
		return this.spic;
	}

	public void setSpic(String spic) {
		this.spic = spic;
	}

	public Integer getStime() {
		return this.stime;
	}

	public void setStime(Integer stime) {
		this.stime = stime;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	

}