package study.wp.ikitchen.model;

/**
 * Arrangemenucookbook entity. @author MyEclipse Persistence Tools
 */

public class Arrangemenucookbook implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Cookbook cookbook;
	private Integer cid;
	private Menu menu;

	// Constructors

	/** default constructor */
	public Arrangemenucookbook() {
	}

	/** full constructor */
	public Arrangemenucookbook(Integer cid, Menu menu) {
		this.cid = cid;
		this.menu = menu;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Cookbook getCookbook() {
		return this.cookbook;
	}

	public void setCookbook(Cookbook cookbook) {
		this.cookbook = cookbook;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	

}