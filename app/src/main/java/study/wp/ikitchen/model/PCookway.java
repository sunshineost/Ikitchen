package study.wp.ikitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * PCookway entity. @author MyEclipse Persistence Tools
 */

public class PCookway implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String name;
	private Set<Menu> menus = new HashSet(0);

	// Constructors

	/** default constructor */
	public PCookway() {
	}

	/** minimal constructor */
	public PCookway(String name) {
		this.name = name;
	}

	/** full constructor */
	public PCookway(String name, Set menus) {
		this.name = name;
		this.menus = menus;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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