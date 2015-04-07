package study.wp.ikitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Tagdata entity. @author MyEclipse Persistence Tools
 */

public class Tagdata implements java.io.Serializable {

	// Fields

	private Integer tid;
	private Integer ptid;
	private Tagdata tagdata;
	private String name;
	private Set<Tagdata> tagdatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tagdata() {
	}

	/** minimal constructor */
	public Tagdata(Integer ptid, String name) {
		this.ptid = ptid;
		this.name = name;
	}

	/** full constructor */
	public Tagdata(Integer ptid, String name, Set tagdatas) {
		this.ptid = ptid;
		this.name = name;
		this.tagdatas = tagdatas;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Tagdata getTagdata() {
		return this.tagdata;
	}

	public void setTagdata(Tagdata tagdata) {
		this.tagdata = tagdata;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTagdatas() {
		return this.tagdatas;
	}

	public void setTagdatas(Set tagdatas) {
		this.tagdatas = tagdatas;
	}

	public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	

}