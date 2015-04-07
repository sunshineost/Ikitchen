package study.wp.ikitchen.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mobile;
	private String password;
	private String sid;
	private String nickname;
	private String headicon;
	private String qrcode;
	private Integer statu;
	private Integer sex;
	private Timestamp birth;
	private String state1;
	private String state2;
	private Set<Concern> concernsForUid = new HashSet(0);
	private Set<Collect> collects = new HashSet(0);
	private Set<Commit> commits = new HashSet(0);
	private Set<Concern> concernsForConcernuid = new HashSet(0);
	private Set<Praise> praises = new HashSet(0);
	private Set<Menu> menus = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String mobile, String password) {
		this.mobile = mobile;
		this.password = password;
	}

	/** full constructor */
	public User(String mobile, String password, String sid, String nickname,
			String headicon, String qrcode, Integer statu, Integer sex,
			Timestamp birth, String state1, String state2, Set concernsForUid,
			Set collects, Set commits, Set concernsForConcernuid, Set praises,
			Set menus) {
		this.mobile = mobile;
		this.password = password;
		this.sid = sid;
		this.nickname = nickname;
		this.headicon = headicon;
		this.qrcode = qrcode;
		this.statu = statu;
		this.sex = sex;
		this.birth = birth;
		this.state1 = state1;
		this.state2 = state2;
		this.concernsForUid = concernsForUid;
		this.collects = collects;
		this.commits = commits;
		this.concernsForConcernuid = concernsForConcernuid;
		this.praises = praises;
		this.menus = menus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadicon() {
		return this.headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getStatu() {
		return this.statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Timestamp getBirth() {
		return this.birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	public String getState1() {
		return this.state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getState2() {
		return this.state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public Set getConcernsForUid() {
		return this.concernsForUid;
	}

	public void setConcernsForUid(Set concernsForUid) {
		this.concernsForUid = concernsForUid;
	}

	public Set getCollects() {
		return this.collects;
	}

	public void setCollects(Set collects) {
		this.collects = collects;
	}

	public Set getCommits() {
		return this.commits;
	}

	public void setCommits(Set commits) {
		this.commits = commits;
	}

	public Set getConcernsForConcernuid() {
		return this.concernsForConcernuid;
	}

	public void setConcernsForConcernuid(Set concernsForConcernuid) {
		this.concernsForConcernuid = concernsForConcernuid;
	}

	public Set getPraises() {
		return this.praises;
	}

	public void setPraises(Set praises) {
		this.praises = praises;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}

}