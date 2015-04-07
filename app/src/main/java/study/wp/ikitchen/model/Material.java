package study.wp.ikitchen.model;

/**
 * Material entity. @author MyEclipse Persistence Tools
 */

public class Material implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Integer menuid;
	private Menu menu;
	private String mdescription;
	private String weight;

	// Constructors

	/** default constructor */
	public Material() {
	}

	/** full constructor */
	public Material(Integer menuid, String mdescription, String weight) {
		this.menuid = menuid;
		this.mdescription = mdescription;
		this.weight = weight;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getMdescription() {
		return this.mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	
	

}