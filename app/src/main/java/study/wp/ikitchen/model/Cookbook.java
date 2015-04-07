package study.wp.ikitchen.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Cookbook entity. @author MyEclipse Persistence Tools
 */

public class Cookbook implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String description;
	private String picture;
	private Timestamp createtime;
	private Set<Arrangemenucookbook> arrangemenucookbooks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cookbook() {
	}

	/** minimal constructor */
	public Cookbook(String description) {
		this.description = description;
	}

	/** full constructor */
	public Cookbook(String description, String picture, Timestamp createtime,
			Set arrangemenucookbooks) {
		this.description = description;
		this.picture = picture;
		this.createtime = createtime;
		this.arrangemenucookbooks = arrangemenucookbooks;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Set getArrangemenucookbooks() {
		return this.arrangemenucookbooks;
	}

	public void setArrangemenucookbooks(Set arrangemenucookbooks) {
		this.arrangemenucookbooks = arrangemenucookbooks;
	}

}