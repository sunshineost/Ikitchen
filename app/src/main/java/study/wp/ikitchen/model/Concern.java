package study.wp.ikitchen.model;

/**
 * Concern entity. @author MyEclipse Persistence Tools
 */

public class Concern implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer uid;
	private Integer concernuid;
	private User userByConcernuid;
	private User userByUid;

	// Constructors

	/** default constructor */
	public Concern() {
	}

	/** full constructor */
	public Concern(Integer concernuid, Integer uid) {
		this.concernuid = concernuid;
		this.uid = uid;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public User getUserByConcernuid() {
		return this.userByConcernuid;
	}

	public void setUserByConcernuid(User userByConcernuid) {
		this.userByConcernuid = userByConcernuid;
	}

	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getConcernuid() {
		return concernuid;
	}

	public void setConcernuid(Integer concernuid) {
		this.concernuid = concernuid;
	}
	

}