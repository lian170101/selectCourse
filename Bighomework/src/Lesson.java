import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Lesson {
	
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	// ����MySQL���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	// MySQL���ݿ�������û���
	public static final String DBUSER = "root" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "root" ;
	
	
	private String LessonName;
	private String time;
	private String require;
	private String content;
	private String exam;
	private String TeaName;
	private String flag;
	
	public Lesson(String ILessonName,String ITime,String IRequire,String IContent,String IExam,String ITeaName,String Iflag)
	{
		LessonName = ILessonName;
		time = ITime;
		require = IRequire;
		content = IContent;
		exam = IExam;
		TeaName = ITeaName;
		flag = Iflag;
		
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTeaName() {
		return TeaName;
	}
	public void setTeaName(String teaName) {
		TeaName = teaName;
	}
	public void publish(String InLessonName,String InTime,String InRequire,String InContent,String InExam,String InTeaName,String InFlag)throws Exception
	{
		Connection conn = null ;				// ���ݿ�����
		Statement stmt = null ;				// ���ݿ����
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO lesson(lessonname,time,`require`,content,exam,teachername,flag)  "
				+ " VALUES ('"+InLessonName+"','"+InTime+"','"+InRequire+"','"+InContent+"','"+InExam+"','"+InTeaName+"','"+InFlag+"')";
		Class.forName(DBDRIVER) ;				// ������������
		// ����MySQL���ݿ�ʱ��Ҫд�����ӵ��û���������
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement() ;			// ʵ����Statement����
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
	
	
	
	
	
	public Lesson(String InLessonName)
	{
		this.LessonName = InLessonName;
	}
	public String getLessonName() {
		return LessonName;
	}
	public void setLessonName(String lessonName) {
		LessonName = lessonName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	
}
