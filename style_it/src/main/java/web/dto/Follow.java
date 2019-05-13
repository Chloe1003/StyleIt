package web.dto;

public class Follow {
	
	private int f_no;
	private int follower_no;
	private int followee_no;
	
	private int m_no;
	
	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public int getFollower_no() {
		return follower_no;
	}

	public void setFollower_no(int follower_no) {
		this.follower_no = follower_no;
	}

	public int getFollowee_no() {
		return followee_no;
	}

	public void setFollowee_no(int followee_no) {
		this.followee_no = followee_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	@Override
	public String toString() {
		return "Follow [f_no=" + f_no + ", follower_no=" + follower_no + ", followee_no=" + followee_no + ", m_no="
				+ m_no + "]";
	}
	
	
	

}
