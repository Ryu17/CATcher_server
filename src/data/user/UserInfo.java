package data.user;

//UserInfo 클래스입니다.
public class UserInfo {
	private String pub_id;
	private int account_type;
	private int device_type;
	private String login_id;
	private String login_pw;
	private int user_key;
	private String user_name;
	private int max_stamina;
	private int stamina;
	private String free_day1;
	private int free_day2;
	private String free_day3;
	private int free_day4;
	private String profile_info;
	private int wait_time;

	public UserInfo (String pub_id, int account_type, int device_type, String login_id, String login_pw,
			int user_key, String user_name, int max_stamina, int stamina, 
			String free_day1, int free_day2, String free_day3, int free_day4, String profile_info, int wait_time)
	{
		this.setPub_id(pub_id);
		this.setAccount_type(account_type);
		this.setDevice_type(device_type);
		this.setLogin_id(login_id);
		this.setLogin_pw(login_pw);
		this.setUser_key(user_key);
		this.setUser_name(user_name);
		this.setMax_stamina(max_stamina);
		this.setStamina(stamina);
		this.setFree_day1(free_day1);
		this.setFree_day2(free_day2);
		this.setFree_day3(free_day3);
		this.setFree_day4(free_day4);
		this.setProfile_info(profile_info);
		this.setWait_time(wait_time);
	}

	public String getPub_id() {
		return pub_id;
	}

	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public int getDevice_type() {
		return device_type;
	}

	public void setDevice_type(int device_type) {
		this.device_type = device_type;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pw() {
		return login_pw;
	}

	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}

	public int getUser_key() {
		return user_key;
	}

	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getMax_stamina() {
		return max_stamina;
	}

	public void setMax_stamina(int max_stamina) {
		this.max_stamina = max_stamina;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public String getFree_day1() {
		return free_day1;
	}

	public void setFree_day1(String free_day1) {
		this.free_day1 = free_day1;
	}

	public int getFree_day2() {
		return free_day2;
	}

	public void setFree_day2(int free_day2) {
		this.free_day2 = free_day2;
	}

	public String getFree_day3() {
		return free_day3;
	}

	public void setFree_day3(String free_day3) {
		this.free_day3 = free_day3;
	}

	public int getFree_day4() {
		return free_day4;
	}

	public void setFree_day4(int free_day4) {
		this.free_day4 = free_day4;
	}
	
	public String getProfile_info() {
		return profile_info;
	}

	public void setProfile_info(String profile_info) {
		this.profile_info = profile_info;
	}
	
	public int getWait_time() {
		return wait_time;
	}

	public void setWait_time(int wait_time) {
		this.wait_time = wait_time;
	}
			
}
