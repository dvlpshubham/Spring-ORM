package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
       
//       Student student= new Student(287,"Chauhan","Rajasthan");
//       
//       int r = studentDao.insert(student);
//       
//       System.out.println("done......" + r);
       
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       
       
       boolean go= true;
       while (go) {
       System.out.println("Press 1 for add new student");
       System.out.println("Press 2 for display all students");
       System.out.println("Press 3 for get detail of single student");
       System.out.println("Press 4 for delete student");
       System.out.println("Press 5 for update student");
       System.out.println("Press 6 for EXIT");
       
       try {
    	   
    	   int input=Integer.parseInt(br.readLine());
    	   switch (input) {
		case 1:
			System.out.println("Enter user Id : ");
			int uid=Integer.parseInt(br.readLine());
			
			System.out.println("Enter User Name : ");
			String uName=br.readLine();
			
			System.out.println("Enter User City : ");
			String uCity=br.readLine();
			
			Student s=new Student();
			s.setStudentId(uid);
			s.setStudentName(uName);
			s.setStudentCity(uCity);
			
			int r=studentDao.insert(s);
			System.out.println(r + "Student Added");
			System.out.println("******************");
			System.out.println();
			
			break;
		case 2:
			System.out.println("*********************************");
			List<Student> allStudents = studentDao.getAllStudents();
			for (Student st:allStudents)
			{
				System.out.println("Id : " + st.getStudentId());
				System.out.println("Name : " + st.getStudentName());
				System.out.println("City : " + st.getStudentCity());
				System.out.println("_________________________________");
			}
			System.out.println("*********************************");
			break;
		case 3:
			System.out.println("Enter user Id : ");
			int userId=Integer.parseInt(br.readLine());
			
			Student student= studentDao.getStudent(userId);
			System.out.println("Id : " + student.getStudentId());
			System.out.println("Name : " + student.getStudentName());
			System.out.println("City : " + student.getStudentCity());
			System.out.println("_________________________________");
			
			break;
		case 4:
			System.out.println("Enter user Id : ");
			int id=Integer.parseInt(br.readLine());
			
			studentDao.deleteStudent(id);
			System.out.println("Student deleted Successfully.....!!!!");
			
			break;      
		case 5:
			System.out.println("Enter user Id to update : ");
			int updateId=Integer.parseInt(br.readLine());
			
			System.out.println("Enter student name ");
			String sName=br.readLine();
			
			System.out.println("Enter student city ");
			String sCity=br.readLine();
			
			Student st1= new Student();
			st1.setStudentName(sName);
			st1.setStudentCity(sCity);
			st1.setStudentId(updateId);
			
			studentDao.updateStudent(st1);
			System.out.println("Updated Successfully.....!!!!");
		
			break;
		case 6:
			go=false;
			break;
		}
		
	} catch (Exception e) {

		System.out.println("Invalid Input");
		System.out.println(e.getMessage());
		
	}
       
       } 
       
       System.out.println("Thankyou for using my application......");
       System.out.println("See You Soon....!!!!!!");
       
      
    }
}
