package study.wp.ikitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Type type;
	private PCookpeople PCookpeople;
	private PTaste PTaste;
	private PHardlevel PHardlevel;
	private PCookway PCookway;
	private PCooktime PCooktime;
	private User user;
	private String name;
	private String description;
	private Integer count;
	private Integer statu;
	private String qrcode;
	private String tag;
	private String endpic;
	private String uploadtime;
	private Integer hasVoice;
	private Integer hasTimer;
	private String state1;
	private String state2;
	private Set<Arrangemenucookbook> arrangemenucookbooks = new HashSet(0);
	private Set<Collect> collects = new HashSet(0);
	private Set<Praise> praises = new HashSet(0);
	private Set<Material> materials = new HashSet(0);
	private Set<Step> steps = new HashSet(0);
	private Set<Commit> commits = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(Integer mid, Type type, PCookpeople PCookpeople, PTaste PTaste,
			PHardlevel PHardlevel, PCookway PCookway, PCooktime PCooktime,
			User user, String name, Integer hasVoice, Integer hasTimer) {
		this.mid = mid;
		this.type = type;
		this.PCookpeople = PCookpeople;
		this.PTaste = PTaste;
		this.PHardlevel = PHardlevel;
		this.PCookway = PCookway;
		this.PCooktime = PCooktime;
		this.user = user;
		this.name = name;
		this.hasVoice = hasVoice;
		this.hasTimer = hasTimer;
	}

	/** full constructor */
	public Menu(Integer mid, Type type, PCookpeople PCookpeople, PTaste PTaste,
			PHardlevel PHardlevel, PCookway PCookway, PCooktime PCooktime,
			User user, String name, String description, Integer count,
			Integer statu, String qrcode, String tag, String endpic,
			String uploadtime, Integer hasVoice, Integer hasTimer,
			String state1, String state2, Set arrangemenucookbooks,
			Set collects, Set praises, Set materials, Set steps, Set commits) {
		this.mid = mid;
		this.type = type;
		this.PCookpeople = PCookpeople;
		this.PTaste = PTaste;
		this.PHardlevel = PHardlevel;
		this.PCookway = PCookway;
		this.PCooktime = PCooktime;
		this.user = user;
		this.name = name;
		this.description = description;
		this.count = count;
		this.statu = statu;
		this.qrcode = qrcode;
		this.tag = tag;
		this.endpic = endpic;
		this.uploadtime = uploadtime;
		this.hasVoice = hasVoice;
		this.hasTimer = hasTimer;
		this.state1 = state1;
		this.state2 = state2;
		this.arrangemenucookbooks = arrangemenucookbooks;
		this.collects = collects;
		this.praises = praises;
		this.materials = materials;
		this.steps = steps;
		this.commits = commits;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public PCookpeople getPCookpeople() {
		return this.PCookpeople;
	}

	public void setPCookpeople(PCookpeople PCookpeople) {
		this.PCookpeople = PCookpeople;
	}

	public PTaste getPTaste() {
		return this.PTaste;
	}

	public void setPTaste(PTaste PTaste) {
		this.PTaste = PTaste;
	}

	public PHardlevel getPHardlevel() {
		return this.PHardlevel;
	}

	public void setPHardlevel(PHardlevel PHardlevel) {
		this.PHardlevel = PHardlevel;
	}

	public PCookway getPCookway() {
		return this.PCookway;
	}

	public void setPCookway(PCookway PCookway) {
		this.PCookway = PCookway;
	}

	public PCooktime getPCooktime() {
		return this.PCooktime;
	}

	public void setPCooktime(PCooktime PCooktime) {
		this.PCooktime = PCooktime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getStatu() {
		return this.statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public String getQrcode() {
		return this.qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
	

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getEndpic() {
		return this.endpic;
	}

	public void setEndpic(String endpic) {
		this.endpic = endpic;
	}

	public String getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Integer getHasVoice() {
		return this.hasVoice;
	}

	public void setHasVoice(Integer hasVoice) {
		this.hasVoice = hasVoice;
	}

	public Integer getHasTimer() {
		return this.hasTimer;
	}

	public void setHasTimer(Integer hasTimer) {
		this.hasTimer = hasTimer;
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

	public Set getArrangemenucookbooks() {
		return this.arrangemenucookbooks;
	}

	public void setArrangemenucookbooks(Set arrangemenucookbooks) {
		this.arrangemenucookbooks = arrangemenucookbooks;
	}

	public Set getCollects() {
		return this.collects;
	}

	public void setCollects(Set collects) {
		this.collects = collects;
	}

	public Set getPraises() {
		return this.praises;
	}

	public void setPraises(Set praises) {
		this.praises = praises;
	}

	public Set getMaterials() {
		return this.materials;
	}

	public void setMaterials(Set materials) {
		this.materials = materials;
	}

	public Set getSteps() {
		return this.steps;
	}

	public void setSteps(Set steps) {
		this.steps = steps;
	}

	public Set getCommits() {
		return this.commits;
	}

	public void setCommits(Set commits) {
		this.commits = commits;
	}


}