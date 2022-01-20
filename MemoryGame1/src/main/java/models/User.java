package models;

public class User {

	private int ID;
	private int Points;
	private String UserName;
	private String Password;
	
	private int idCounter = 1;
	
	public int getID() {
		return ID;
	}
	public int getPoints() {
		return Points;
	}
	public String getUserName() {
		return UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setID() {
		ID = idCounter++;
	}
	public void setPoints(int points) {
		Points = points;
	}
	public void setUserName(String userName) {
		if((userName!=null) && (!userName.isEmpty())  && (userName.matches("[A-ZĀŽČĒĪŪĻĶĢŠŅa-zēūīļķščņ]+")))
        {
                UserName=userName;
        }
        else
        {
                UserName="Unknown";
        }
	}
	public void setPassword(String password) {
		if((password!=null) && (!password.isEmpty())  && (password.matches("[A-ZĀŽČĒĪŪĻĶĢŠŅa-zēūīļķščņ]+")))
        {
                Password=password;
        }
        else
        {
                Password="Unknown";
        }
	}
	public User() {
		setUserName("NaN");
		setPassword("NaN");
		setPoints(0);
		setID();
	}
	public User(String UserName, String Password, int Points) {
		setUserName(UserName);
		setPassword(Password);
		setPoints(0);
		setID();
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Points=" + Points + ", UserName=" + UserName + ", Password=" + Password + "]";
	}
}
