	 	package com.capg.sms.main;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capg.sms.beans.Student;
import com.capg.sms.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService services;
	AnnotationConfigApplicationContext studentctx= 
			new AnnotationConfigApplicationContext(Student.class);
	//user home page
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}

	@RequestMapping(value="/userHome",method=RequestMethod.GET)
	public String HomePage(){
		return "UserHomePage";
	}


	//user login
	@GetMapping("/login")
	public String loginPage(){
		return "userLogin";
	}

	@PostMapping("/userLogin")
	public ModelAndView login(HttpServletRequest req,
			ModelAndView mv){
		int regno = Integer.parseInt(req.getParameter("regno"));
		String password = req.getParameter("password");

		Student student = services.loginStudent(regno, password);
		System.out.println(regno+" "+password);
		System.out.println(student+"....................");
		if(student != null){
			HttpSession session = req.getSession();	
			session.setAttribute("student", student);
			mv.setViewName("redirect:./userHome");
		}else{
			mv.setViewName("redirect:./login");
		}
		return mv;
	}




	//user registration

	@GetMapping("/register")
	public String addUserPage(){
		return "userRegister";
	}

	@PostMapping("/userRegister")
	public ModelAndView addUser(HttpServletRequest req, 
			ModelAndView mv){
		Student student = studentctx.getBean(Student.class,"student");
		student.setRegno(Integer.parseInt(req.getParameter("regno")));
		student.setPassword(req.getParameter("password"));
		student.setFname(req.getParameter("fname"));
		student.setLname(req.getParameter("lname"));
		student.setEmail(req.getParameter("email"));

		System.out.println(student);

		Student loginStudent=services.registerStudent(student);
		String msg="Failed";
		if(loginStudent!=null) {
			msg="Successful";
		}

		mv.addObject("msg", msg); 
		mv.setViewName("userRegister");
		return mv;
	}
	//user update
	@GetMapping("/update")
	public String updateUserPage(){
		return "userUpdate";
	}

	@PostMapping("/userUpdate")
	public ModelAndView updateUser(HttpServletRequest req, 
			ModelAndView mv){
		Student student=(Student) req.getSession().getAttribute("student");	

		String email=req.getParameter("email");
		
		Student updateEmail=services.updateEmail(student.getRegno(), email);
		String msg="Failed";
		if(updateEmail!=null) {
			msg="Successful";
		}
		mv.addObject("msg", msg);  
		mv.setViewName("userUpdate");
		return mv;
	}


	//user delete
	@GetMapping("/delete")
	public String deletePage(){
		return "userDelete";
	}

	@PostMapping("/userDelete")
	public ModelAndView deleteUser(HttpServletRequest req,
			ModelAndView mv){
		//TO-Do
		Student student = studentctx.getBean(Student.class,"student");

		int regno = student.getRegno();
		String password=req.getParameter("password");
		String msg="Failed";
		if(services.removeStudent(regno,password)) {
				msg="Successful";
				mv.setViewName("redirect:./login");
			}
		mv.addObject("msg", msg);  
		mv.setViewName("userDelete");
		return mv;
		}
		
	//logout
	@GetMapping("/logout")
	public void logOut(HttpServletRequest req,HttpServletResponse resp)
	{
		HttpSession session=req.getSession();
		if(session!=null){
			session.invalidate();
			Cookie cookie [] = req.getCookies();
			if(cookie!=null){
				for(Cookie c: cookie){
					if(c.getName().equals("JSESSIONID")){
						c.setMaxAge(0);
						resp.addCookie(c);
						break;
					}
				}
			}
			try {
				resp.sendRedirect("./login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				resp.sendRedirect("./login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//get aggregate Marks
	@GetMapping("/result")
	public String resultPage(){
		return "userResult";
	}

	@PostMapping("/getResult")
	public ModelAndView getResult(HttpServletRequest req, 
			ModelAndView mv){
		Student student=(Student) req.getSession().getAttribute("student");		
		double monthlyMarks=Double.parseDouble(req.getParameter("monthly"));
		double quaterlyMarks=Double.parseDouble(req.getParameter("quatery"));
		student.setMonthlyMarks(monthlyMarks);
		student.setQuaterlyMarks(quaterlyMarks);



		Double aggregateMarks=services.getAggreagateMarks(student.getRegno());
		student.setAggregateMarks(aggregateMarks);
		Double marks= services.updateMarks(student);
		String msg="Failed";
		if(marks!=null) {
			msg="Successful";
		}
		String grade=services.getgrade(marks);
		mv.addObject("grade",grade);
		
		mv.addObject("msg", msg);  
		mv.setViewName("userResult");
		return mv;
	}
	


}
