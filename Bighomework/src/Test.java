import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


import java.util.Scanner;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Test {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	// 锟斤拷锟斤拷MySQL锟斤拷锟捷匡拷锟斤拷锟斤拷拥锟街�
	public static final String DBURL = "jdbc:mysql://localhost:3306/test" ;
	// MySQL锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷没锟斤拷锟�
	public static final String DBUSER = "root" ;
	// MySQL锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	public static final String DBPASS = "root" ;
	public static void main(String[] args) throws Exception {
				
		System.out.println("请选择1.登录/2.注册");
		int i;
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		
		switch(i)
		{
		case 1:
		{
			while(true)
			{
			System.out.println("1.学生入口 ");
			System.out.println("2.教师入口");
			System.out.println("3.管理员入口");
			int q;
			Scanner sc1 = new Scanner(System.in);
			q = sc1.nextInt();
			switch(q)
			{
			case 1:
			{	
				String username,password;
				System.out.println("用户名");
				
				System.out.println("密码");
				Scanner sc4 = new Scanner(System.in);
				username = sc4.nextLine();
				
				password = sc4.nextLine();
				Connection conn = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
				Statement stmt = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String sql = "SELECT username,password FROM student";
				Class.forName(DBDRIVER);
				conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					Student stu = new Student();
					stu.setUsername(rs.getString("username"));
					stu.setPassword(rs.getString("password"));
					if(stu.Login(username, password) == 1)
					{
						System.out.println("欢迎使用选课系统");
						break;
					}
					else
					{
						System.out.println("用户名或密码错误");
						System.exit(0);
						break;
					}
				}
				rs.close();
				stmt.close();
				conn.close();
				while(true)
				{
				System.out.println("1.修改个人信息");
			    System.out.println("2.查看可选课程");
			    System.out.println("3.选课");
			    System.out.println("0.退出");
			    int a;
			    Scanner sc5 = new Scanner(System.in);
			    a = sc5.nextInt();
			    switch(a)
			    {
			    case 1:
			    {
			    	System.out.println("输入个人信息：用户名 + 密码 + 姓名 + 年龄 + 性别 + 专业 + 班级 + 学号 + 联系方式");
			    	Scanner sc6 = new Scanner(System.in);
			    	String ChangeUsername = sc6.nextLine();
			    	String ChangePassword = sc6.nextLine();
			    	String ChangeName = sc6.nextLine();
			    	String ChangeAge = sc6.nextLine();
			    	String ChangeSex = sc6.nextLine();
			    	String ChangeMajor = sc6.nextLine();
			    	String ChangeClass = sc6.nextLine();
			    	String ChangeNum = sc6.nextLine();
			    	String ChangeTel = sc6.nextLine();
			    	Student stu = new Student(ChangeUsername,ChangePassword,ChangeName,ChangeAge,ChangeSex,ChangeMajor,ChangeClass,ChangeNum,ChangeTel);
			    	stu.change(ChangeUsername, ChangePassword, ChangeName, ChangeAge, ChangeSex, ChangeMajor, ChangeClass, ChangeNum, ChangeTel);
			    	break;
			    }
			    case 2:
			    {
			    	System.out.println("选择教师");
			    	Connection conn1 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
					Statement stmt1 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
					ResultSet rs1 = null;
					PreparedStatement pstmt1 = null;
					String sql1 = "SELECT name FROM teacher ";
					Class.forName(DBDRIVER);
					conn1 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
					stmt1 = conn1.createStatement();
					rs1 = stmt1.executeQuery(sql1);
					while(rs1.next())
					{
						String teacher = rs1.getString("name");
						int j = 1;
						System.out.println(""+j+"."+teacher+"");
						j++;
					}
					Scanner sc7 = new Scanner(System.in);
					String teachername = sc7.nextLine();
					rs1.close();
					stmt1.close();
					conn1.close();
					Connection conn2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
					Statement stmt2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
					ResultSet rs2 = null;
					PreparedStatement pstmt2 = null;
					String sql2 = "SELECT lessonname FROM lesson WHERE teachername = "+ "teachername";
					Class.forName(DBDRIVER);
					conn2 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
					stmt2 = conn2.createStatement();
					rs2 = stmt2.executeQuery(sql2);
					while(rs2.next())
					{
						String lesson = rs2.getString("lessonname");
						int j = 1;
						System.out.println(""+j+"."+lesson+"");
						j++;
					}
					rs2.close();
					stmt2.close();
					conn2.close();
			    	break;
			    }
			    case 3:
			    {
			    	System.out.println("输入所选课程以及个人姓名：");
			    	Scanner sc8 = new Scanner(System.in);
			    	String lesname = sc8.nextLine();
			    	String stuname = sc8.nextLine();
			    	Connection conn3 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
					Statement stmt3 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
					PreparedStatement pstmt3 = null;
					
					String sql3 = "INSERT INTO choose(lessonname,studentname)  "
							+ " VALUES ('"+lesname+"','"+stuname+"')";
					Class.forName(DBDRIVER) ;				// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
					// 锟斤拷锟斤拷MySQL锟斤拷锟捷匡拷时锟斤拷要写锟斤拷锟斤拷锟接碉拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷
					conn3 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
					stmt3 = conn3.createStatement() ;			// 实锟斤拷锟斤拷Statement锟斤拷锟斤拷
					stmt3.executeUpdate(sql3);
					stmt3.close();
					conn3.close();
			    	
			    	break;
			    }
			    case 0:
			    	break;
			    }
				}
			    //System.exit(0);
			   // break;
			}
			
			case 2:
			{
				System.out.println("用户名：");
				System.out.println("密码：");
				String username,password;
				Scanner sc9 = new Scanner(System.in);
				username = sc9.nextLine();
				password = sc9.nextLine();
				Connection conn = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
				Statement stmt = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String sql = "SELECT username,password FROM teacher";
				Class.forName(DBDRIVER);
				conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					Teacher tea = new Teacher();
					tea.setUsername(rs.getString("username"));
					tea.setPassword(rs.getString("password"));
					if(tea.Login(username, password) == 1)
					{
						System.out.println("教师登录成功！");
						break;
					}
					else
					{
						System.out.println("用户名或密码错误！");
						System.exit(0);
						break;
					}
				}
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("1.修改信息");
				System.out.println("2.发布课程");
				System.out.println("3.查看选课名单");
				System.out.println("4.导出名单");
				System.out.println("0.退出");
				int b;
				Scanner sc10 = new Scanner(System.in);
				b = sc10.nextInt();
				switch(b)
				{
				case 1:
				{
			    	System.out.println("输入个人信息：用户名 + 密码 + 姓名 + 年龄 + 性别 + 专业 + 职务");
			    	Scanner sc11 = new Scanner(System.in);
			    	String ChangeUsername = sc11.nextLine();
			    	String ChangePassword = sc11.nextLine();
			    	String ChangeName = sc11.nextLine();
			    	String ChangeAge = sc11.nextLine();
			    	String ChangeSex = sc11.nextLine();
			    	String ChangeMajor = sc11.nextLine();
			    	String ChangeJob= sc11.nextLine();
			    	Teacher tea = new Teacher(ChangeUsername,ChangePassword,ChangeName,ChangeAge,ChangeSex,ChangeMajor,ChangeJob);
			    	tea.change(ChangeUsername, ChangePassword, ChangeName, ChangeAge, ChangeSex, ChangeMajor,ChangeJob);
					break;
				}
				case 2:
				{
					System.out.println("输入课程信息：课程名称 + 学时  + 要求 + 内容 + 考核 + 教师名称 + 课程状态");
					String lessonname,require,content,exam,teaname;
					String time,flag;
					Scanner sc12 = new Scanner(System.in);
					lessonname = sc12.nextLine();
					time = sc12.nextLine();
					require = sc12.nextLine();
					content = sc12.nextLine();
					exam = sc12.nextLine();
					teaname = sc12.nextLine();
					flag = sc12.nextLine();
					Lesson les = new Lesson(lessonname,time,require,content,exam,teaname,flag);
					les.publish(lessonname, time, require, content, exam,teaname,flag);
					break;
				}
				case 3:
				{
					//杈撳嚭鏌愯瀛︾敓琛ㄦ牸鍚嶅崟
					System.out.println("选择课程");
					Scanner sc13 = new Scanner(System.in);
					String lesname = sc13.nextLine();
					Connection conn2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
					Statement stmt2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
					ResultSet rs2 = null;
					PreparedStatement pstmt2 = null;
					String sql2 = "SELECT studentname FROM choose WHERE lessonname = "+ "lesname";
					Class.forName(DBDRIVER);
					conn2 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
					stmt2 = conn2.createStatement();
					rs2 = stmt2.executeQuery(sql2);
					while(rs2.next())
					{
						String stuname = rs2.getString("studentname");
						int j = 1;
						System.out.println(""+j+"."+stuname+"");
						j++;
					}
					rs2.close();
					stmt2.close();
					conn2.close();
					break;
				}
				case 4:
				{
					//瀵煎嚭鏂囦欢
					System.out.println("输入课程名称");
					Scanner sc14 = new Scanner(System.in);
					String lessonname = sc14.nextLine();
				       try {
				            // 鎵撳紑鏂囦欢
				            WritableWorkbook book = Workbook.createWorkbook(new File(""+lessonname+".xls"));
				            // 鐢熸垚鍚嶄负鈥滅涓�椤碘�濈殑宸ヤ綔琛紝鍙傛暟0琛ㄧず杩欐槸绗竴椤�
				            WritableSheet sheet = book.createSheet("第一页", 0);
				            // 鍦↙abel瀵硅薄鐨勬瀯閫犲瓙涓寚鍚嶅崟鍏冩牸浣嶇疆鏄涓�鍒楃涓�琛�(0,0)
				            // 浠ュ強鍗曞厓鏍煎唴瀹逛负test
				            Label label = new Label(0, 0, "序号");
				            Label label1 = new Label(1, 0, "姓名");
				            Connection conn2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
							Statement stmt2 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
							ResultSet rs2 = null;
							PreparedStatement pstmt2 = null;
							String sql2 = "SELECT studentname FROM choose WHERE lessonname = "+ lessonname;
							Class.forName(DBDRIVER);
							conn2 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
							stmt2 = conn2.createStatement();
							rs2 = stmt2.executeQuery(sql2);
							while(rs2.next())
							{
								String stuname = rs.getString("studentname");
								int j = 1;
								Label label2 = new Label(1, j, "+stuname+");
								Label label3 = new Label(0, j, "+j+");
								j++;
							}
							rs2.close();
							stmt2.close();
							conn2.close();
				            // 灏嗗畾涔夊ソ鐨勫崟鍏冩牸娣诲姞鍒板伐浣滆〃涓�
				            sheet.addCell(label);


				            // 鍐欏叆鏁版嵁骞跺叧闂枃浠�
				            book.write();
				            book.close();

				        } catch (Exception e) {
				            System.out.println(e);
				        }
					break;
				}
				case 0:
					break;
				}
				break;
			}
			case 3:
			{
				System.out.println("用户名");
				System.out.println("密码");
				String username,password;
				Scanner sc15 = new Scanner(System.in);
				username = sc15.nextLine();
				password = sc15.nextLine();
				Connection conn = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
				Statement stmt = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String sql = "SELECT username,password FROM admin";
				Class.forName(DBDRIVER);
				conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					Adminaaa adm = new Adminaaa();
					adm.setUsername(rs.getString("username"));
					adm.setPassword(rs.getString("password"));
					if(adm.Login(username, password) == 1)
					{
						System.out.println("管理员登录成功");
						break;
					}
					else
					{
						System.out.println("用户名或密码错误");
						System.exit(0);
						break;
					}
				}
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("待审核课程：");
				Connection conn1 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟斤拷
				Statement stmt1 = null ;				// 锟斤拷锟捷匡拷锟斤拷锟�
				ResultSet rs1 = null;
				PreparedStatement pstmt1 = null;
				String sql1 = "SELECT lessonname,time,require,content,exam,teachername,flag FROM lesson WHERE flag = " + "CanNotChoose";
				Class.forName(DBDRIVER);
				conn1 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt1 = conn1.createStatement();
				rs1 = stmt1.executeQuery(sql1);
				while(rs1.next())
				{
					String lessonname = rs.getString("Lessonname");
					int time = rs.getInt("time");
					String require = rs.getString("require");
					String content = rs.getString("content");
					String exam = rs.getString("exam");
					String teaname = rs.getString("teaname");
					String flag = rs.getString("flag");
					System.out.println("课程名称："+lessonname+"");
					System.out.println("学时："+time+"");
					System.out.println("要求:"+require+"");
					System.out.println("内容："+content+"");
					System.out.println("考核："+exam+"");
					System.out.println("教师名称："+teaname+"");
					System.out.println("状态："+flag+"");
				}
				rs1.close();
				stmt1.close();
				conn1.close();
				//String Flag= sc.nextLine();
				Connection conn2 = null;
				Statement stmt2 = null;	
				String sql2 = "UPDATE lesson SET flag = 'CanChoose' WHERE flag = " + "CanNotChoose";
				Class.forName(DBDRIVER);
				conn2 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt2 = conn2.createStatement();
				stmt2.executeUpdate(sql);
				stmt2.close();
				conn2.close();
				break;
			}
			}
		}
		}
		case 2:
		{
			System.out.println("1.学生注册");
			System.out.println("2.教师注册");
			System.out.println("3.管理员注册");
			System.out.println("0.退出");
			Scanner sc16 = new Scanner(System.in);
			int c = sc16.nextInt();
			switch(c)
			{
			case 1:
			{
				
				
				
				System.out.println("输入用户名");
				System.out.println("输入密码");
				System.out.println("输入姓名");
				System.out.println("输入年龄");
				System.out.println("输入性别");
				System.out.println("输入专业");
				System.out.println("输入班级");
				System.out.println("输入学号");
				System.out.println("输入联系方式");
				
				String password,username1,name,age,sex,major,banji,number,tel;
				Scanner sc50 = new Scanner(System.in);
				
				username1 = sc50.nextLine();	
				password = sc50.nextLine();
				name = sc50.nextLine();
				age = sc50.nextLine();
				sex = sc50.nextLine();
				major = sc50.nextLine();
				banji = sc50.nextLine();
				number = sc50.nextLine();
				tel = sc50.nextLine();
				Student stu = new Student(username1,password,name,age,sex,major,banji,number,tel);
				stu.register(username1,password,name,age,sex,major,banji,number,tel);
				System.out.println("注册成功");
				
				break;
			}
			case 2:
			{
				System.out.println("输入用户名");
				System.out.println("输入密码");
				System.out.println("输入姓名");
				System.out.println("输入年龄");
				System.out.println("输入性别");
				System.out.println("输入专业");
				System.out.println("输入职务");
				String username,password,name,sex,major,job;
				String age;
				Scanner sc20 = new Scanner(System.in);
				username = sc20.nextLine();
				password = sc20.nextLine();
				name = sc20.nextLine();
				age = sc20.nextLine();
				sex = sc20.nextLine();
				major = sc20.nextLine();
				job = sc20.nextLine();
				Teacher tea= new Teacher(username,password,name,age,sex,major,job);
				tea.register(username,password,name,age,sex,major,job);
				System.out.println("注册成功");
				break;
			}
			case 3:
			{
				System.out.println("输入用户名");
				System.out.println("输入密码");
				System.out.println("输入姓名");
				System.out.println("输入年龄");
				System.out.println("输入性别");
				System.out.println("输入专业");
				String username,password,name,sex,major;
				String age;
				Scanner sc21 = new Scanner(System.in);
				username = sc21.nextLine();
				password = sc21.nextLine();
				name = sc21.nextLine();
				age = sc21.nextLine();
				sex = sc21.nextLine();
				major = sc21.nextLine();
				Adminaaa adm= new Adminaaa(username,password,name,age,sex,major);
				adm.register(username,password,name,age,sex,major);
				System.out.println("注册成功");				
				break;
			}
			case 0:
				break;
			}
			break;
		}
		}
		
}
}		