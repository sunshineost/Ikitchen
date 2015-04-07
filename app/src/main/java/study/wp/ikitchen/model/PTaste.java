package study.wp.ikitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * PTaste entity. @author MyEclipse Persistence Tools
 */

public class PTaste implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String name;
	private Set<Menu> menus = new HashSet(0);

	// Constructors

	/** default constructor */
	public PTaste() {
	}

	/** minimal constructor */
	public PTaste(String name) {
		this.name = name;
	}

	/** full constructor */
	public PTaste(String name, Set menus) {
		this.name = name;
		this.menus = menus;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
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