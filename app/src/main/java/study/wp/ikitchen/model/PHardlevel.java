package study.wp.ikitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * PHardlevel entity. @author MyEclipse Persistence Tools
 */

public class PHardlevel implements java.io.Serializable {

	// Fields

	private Integer hid;
	private String name;
	private Set<Menu> menus = new HashSet(0);

	// Constructors

	/** default constructor */
	public PHardlevel() {
	}

	/** minimal constructor */
	public PHardlevel(String name) {
		this.name = name;
	}

	/** full constructor */
	public PHardlevel(String name, Set menus) {
		this.name = name;
		this.menus = menus;
	}

	// Property accessors

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}

}