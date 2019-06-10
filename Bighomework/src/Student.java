import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Student /*extends Person*/ {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	// ����MySQL���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	// MySQL���ݿ�������û���
	public static final String DBUSER = "root" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "root" ;
	
	private String myclass;
	private String num;
	private String tel;
	private String username;
	private String password;
	private String name;
	private String age;
	private String sex;
	private String major;
	public Student(){};
	public Student(String Iusername, String Ipassword, String Iname, String Iage, String Isex, String Imajor,String IClass,String Inum,String Itel) {
		username = Iusername;
		password = Ipassword;
		name = Iname;
		age = Iage;
		sex = Isex;
		major = Imajor;
		myclass = IClass;
		num = Inum;
		tel = Itel;
		// TODO Auto-generated constructor stub
	}

	public int Login(String InUsername, String InPassword) {
		
		if(this.getUsername().equals(InUsername)&& this.getPassword().equals(InPassword))		
		{
			return 1;
			
		}
		else
		{
			
			return 0;
		}
	}

		
	

	public void register(String InUsername, String InPassword, String InName, String InAge, String InSex, String InMajor,String InClass,String InNum,String InTel ) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null ;				// ���ݿ�����
		Statement stmt = null ;				// ���ݿ����
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO student(username,password,name,age,sex,major,class,number,tel)  "
				+ " VALUES ('"+InUsername+"','"+InPassword+"','"+InName+"','"+InAge+"','"+InSex+"','"+InMajor+"','"+InClass+"','"+InNum+"','"+InTel+"')";
		Class.forName(DBDRIVER) ;				// ������������
		// ����MySQL���ݿ�ʱ��Ҫд�����ӵ��û���������
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement() ;			// ʵ����Statement����
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}

	public void change(String InUsername, String InPassword, String InName, String InAge, String InSex, String InMajor,String InClass,String InNum,String InTel )throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		String username = InUsername;
		String password = InPassword;
		String name = InName;
		String age = InAge;
		String sex = InSex;
		String major = InMajor;
		String banji = InClass;
		String num = InNum;
		String tel = InTel;
		String sql = "UPDATE student SET username = '"+username+"',password = '"+password+"',name = '"+name+"',age = '"+age+"',sex = '"+sex+"',major = '"+major+"',class = '"+banji+"',number = '"+num+"',tel = '"+tel+"'WHERE number = " + num;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}

	public String getMyclass() {
		return myclass;
	}

	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}


	
	
	
}
