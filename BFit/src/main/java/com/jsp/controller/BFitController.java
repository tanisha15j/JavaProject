package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Admin;
import com.jsp.dto.Branch;
import com.jsp.dto.Event;
import com.jsp.dto.Manager;
import com.jsp.dto.Subscription;
import com.jsp.dto.Timeslot;
import com.jsp.dto.User;
import com.jsp.service.AdminService;
import com.jsp.service.BranchService;
import com.jsp.service.EventService;
import com.jsp.service.ManagerService;
import com.jsp.service.SubService;
import com.jsp.service.TimeslotService;
import com.jsp.service.UserService;

@Controller
public class BFitController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ManagerService managerService;	

	@Autowired
	private UserService userService;
	
	@Autowired
	private BranchService branchService;
		
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SubService subService;
	
	@Autowired
	private TimeslotService timeslotService;

	
//==================================================================================================

	//ADMIN	

	@RequestMapping("/adminH")
	public ModelAndView start(Admin admin) {
		ModelAndView modelAndView = new ModelAndView("adminHome.jsp");
		modelAndView.addObject(admin);
		return modelAndView;		
	}
	
	@RequestMapping("/addS")
	public ModelAndView createhome(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("adminSignUp.jsp");
		modelAndView.addObject("admins1", new Admin());
		return modelAndView;
	}
	
	@RequestMapping("/adminsignup")
	public ModelAndView adminSignUp(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("adminLogin.jsp");
		adminService.saveAdmin(admin);
		modelAndView.addObject("admin1", new Admin());
		return modelAndView;
	}
	
	@RequestMapping("/addL")
	public ModelAndView adminLogin(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("adminLogin.jsp");
		modelAndView.addObject("admin1", new Admin());
		return modelAndView;
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminFinalLogin(@ModelAttribute Admin admin) {
	boolean admin2 =adminService.adminLogin(admin.getId(), admin);
		if(admin2==true) {
			ModelAndView modelAndView = new ModelAndView("adminDashBoard.jsp");
			modelAndView.addObject(admin2);
			return modelAndView;			
		}
		else {
			ModelAndView modelAndView = new ModelAndView("adminLogin.jsp");
			modelAndView.addObject("saved", "Invlaid Login Credentials");
			return modelAndView;	
		}		
	}
	
	@RequestMapping("/addB")
	public ModelAndView adminAddBranch(Admin admin, Branch branch) {
		ModelAndView modelAndView = new ModelAndView("addBranch.jsp");
		modelAndView.addObject("addbranch1", new Branch());
		return modelAndView;
	}
	
	@RequestMapping("/addbranch")
	public ModelAndView adminFinalAddBranch(@ModelAttribute Branch branch, 
											 @RequestParam(name="adminid") int aid) {
		ModelAndView modelAndView = new ModelAndView("branchSuccess.jsp");
		branchService.saveBranch(branch, aid);
		modelAndView.addObject(branch);
		return modelAndView;
	}
	
	@RequestMapping("/deleteB")
	public ModelAndView deleteBranchById(@RequestParam(name="id") int id) {
		boolean res = branchService.deleteBranchById(id);
		System.out.println(res);
		if(res==true) {
			ModelAndView modelAndView=new ModelAndView("viewAllBranchs.jsp");
			List<Branch>branchs = branchService.getAllBranchs();
			modelAndView.addObject("branches", branchs);
			modelAndView.addObject("saved", "Branch with id " +id+ " is deleted" );
			return modelAndView;			
		}
		else {
			ModelAndView modelAndView=new ModelAndView("viewAllBranchs.jsp");
			return modelAndView;				
		}			
	}
		
	@RequestMapping("/updateB")
	public ModelAndView updateBranchById() {
		ModelAndView modelAndView=new ModelAndView("updateBranch.jsp");
		modelAndView.addObject("updateB1",new Branch());
		return modelAndView;		
	}
	
	@RequestMapping("/updateBranch")
	public ModelAndView finalUpdate(@ModelAttribute Branch branch, 
									 @RequestParam(name = "bid") int bid) {
		Branch b = branchService.updateBranchById(bid, branch);
		
		if(b!=null) {
			ModelAndView modelAndView=new ModelAndView("viewAllBranchs.jsp");	
			List<Branch>branchs = branchService.getAllBranchs();
			modelAndView.addObject("branches", branchs);
			modelAndView.addObject("saved", "Branch with id " + bid + " has been updated");
			return modelAndView;	
		}
		else {
			ModelAndView modelAndView=new ModelAndView("updateBranch.jsp");
			return modelAndView;		
		}		
	}
	
	@RequestMapping("/viewAllB")
	public ModelAndView getAllBranchs() {
		ModelAndView modelAndView=new ModelAndView("viewAllBranchs.jsp");
		List<Branch>branchs = branchService.getAllBranchs();
		modelAndView.addObject("branches", branchs);
		return modelAndView;
	}
	
	@RequestMapping("/appM")
	public ModelAndView approveManager() {
		ModelAndView modelAndView = new ModelAndView("approveManager.jsp");
		modelAndView.addObject("appM1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/approveM")
	public ModelAndView approveFinalManager(@RequestParam(name="managerid") int mid, 
											 @RequestParam(name="adminid") int aid) {
		ModelAndView modelAndView = new ModelAndView("adminDashBoard.jsp");
		adminService.approveManagerById(mid,aid);
		return modelAndView;
	}
	
	@RequestMapping("/rejM")
	public ModelAndView rejectManager() {
		ModelAndView modelAndView = new ModelAndView("rejectManager.jsp");
		modelAndView.addObject("rejM1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/rejectM")
	public ModelAndView rejectFinalManager(@RequestParam(name="managerid") int mid, 
											 @RequestParam(name="adminid") int aid) {
		ModelAndView modelAndView = new ModelAndView("adminDashBoard.jsp");
		adminService.rejectManagerById(mid,aid);
		return modelAndView;
	}
	
	@RequestMapping("/viewAllM")
	public ModelAndView getAllManagers() {
		ModelAndView modelAndView=new ModelAndView("viewAllManagers.jsp");
		List<Manager> managers = managerService.getAllManagers();
		modelAndView.addObject("managers", managers);
		return modelAndView;
	}
	
	@RequestMapping("/appE")
	public ModelAndView approveEvent() {
		ModelAndView modelAndView = new ModelAndView("approveEvent.jsp");
		modelAndView.addObject("appE1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/approveE")
	public ModelAndView approveFinalEvent(@RequestParam(name="eventid") int eid, 
										    @RequestParam(name="adminid") int aid) {
		ModelAndView modelAndView = new ModelAndView("adminDashBoard.jsp");
		adminService.approveEventById(eid, aid);
		return modelAndView;
	}
	
	@RequestMapping("/logoutA")
	public ModelAndView logoutAdmin() {
		ModelAndView modelAndView = new ModelAndView("logoutAdmin.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/logA")
	public ModelAndView logoutA() {
		ModelAndView modelAndView = new ModelAndView("bFitDashBoard.jsp");
		return modelAndView;
	}
	
//==================================================================================================

	//MANAGER

	@RequestMapping("/managerH")
	public ModelAndView start() {
		ModelAndView modelAndView = new ModelAndView("managerHome.jsp");
		List<Branch>branchs = branchService.getAllBranchs();
		modelAndView.addObject("branches", branchs);
		return modelAndView;		
	}
	
	@RequestMapping("/mgmS")
	public ModelAndView createhome(@ModelAttribute Manager manager) {
		ModelAndView modelAndView = new ModelAndView("managerSignUp.jsp");
		modelAndView.addObject("mgms1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/mgmsignup")
	public ModelAndView managerSignUp(@ModelAttribute Manager manager, 
									   @RequestParam(name="bid") int bid) {
		ModelAndView modelAndView = new ModelAndView("managerLogin.jsp");
		managerService.saveManager(manager, bid);
		modelAndView.addObject("manager1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/mgmL")
	public ModelAndView managerLogin(@ModelAttribute Manager manager) {
		ModelAndView modelAndView = new ModelAndView("managerLogin.jsp");
		modelAndView.addObject("manager1", new Manager());
		return modelAndView;
	}
	
	@RequestMapping("/managerlogin")
	public ModelAndView managerFinalLogin(@ModelAttribute Manager manager) {
		boolean manager2 = managerService.managerLogin(manager.getId(), manager);

		if(manager2==true) {
			ModelAndView modelAndView = new ModelAndView("managerDashBoard.jsp");
			modelAndView.addObject(manager2);
			return modelAndView;			
		}
		else {
			ModelAndView modelAndView = new ModelAndView("managerLogin.jsp");
			modelAndView.addObject("saved", "Invalid Login Credentials");
			return modelAndView;	
		}

	}
			
	@RequestMapping("/addE")
	public ModelAndView managerAddEvent(Manager manager, Event event) {
		ModelAndView modelAndView = new ModelAndView("addEvent.jsp");
		modelAndView.addObject("addevent1", new Event());
		return modelAndView;
	}
	
	@RequestMapping("/addevent")
	public ModelAndView managerFinalAddEvent(@ModelAttribute Event event,
											  @RequestParam(name = "mgmid") int mid,
											   @RequestParam(name = "bid") int bid,
											   @RequestParam(name = "sid") int sid) {
		ModelAndView modelAndView = new ModelAndView("eventSuccess.jsp");
		eventService.saveEvent(event, mid, bid, sid);
		modelAndView.addObject(event);
		return modelAndView;
	}
		
	@RequestMapping("/updateE")
	public ModelAndView updateEventById() {
		ModelAndView modelAndView=new ModelAndView("updateEvent.jsp");
		modelAndView.addObject("updateE1",new Event());
		return modelAndView;		
	}
	
	@RequestMapping("/updateEvent")
	public ModelAndView finalUpdate(@ModelAttribute Event event,
									 @RequestParam(name = "eid") int eid,
									 @RequestParam(name = "sid") int sid ) {
		Event e = eventService.updateEventById(eid, event, sid);
		
		if(e!=null) {
			ModelAndView modelAndView=new ModelAndView("viewAllEvents.jsp");	
			List<Event> events = eventService.getAllEvents();
			modelAndView.addObject("events", events);
			modelAndView.addObject("saved", "Event with id " + eid + " has been updated");
			return modelAndView;	
		}
		else {
			ModelAndView modelAndView=new ModelAndView("updateEvent.jsp");
			return modelAndView;		
		}		
	}
	
	@RequestMapping("/viewAllE")
	public ModelAndView getAllEvents() {
		ModelAndView modelAndView=new ModelAndView("viewAllEvents.jsp");
		List<Event> events = eventService.getAllEvents();
		modelAndView.addObject("events", events);
		return modelAndView;
	}
	
	@RequestMapping("/addT")
	public ModelAndView managerAddTimeSlot(Manager manager, Event event) {
		ModelAndView modelAndView = new ModelAndView("addTimeSlot.jsp");
		modelAndView.addObject("addts1", new Timeslot());
		return modelAndView;
	}
	
	@RequestMapping("/addts")
	public ModelAndView managerFinalTimeSlot(@ModelAttribute Timeslot timeslot,
											  @RequestParam(name = "eid") int eid) {
		ModelAndView modelAndView = new ModelAndView("tsSuccess.jsp");
		timeslotService.saveTimeslot(timeslot, eid);
		modelAndView.addObject(timeslot);
		return modelAndView;
	}
	
	@RequestMapping("/addSb")
	public ModelAndView managerAddSub(Manager manager, Subscription sub) {
		ModelAndView modelAndView = new ModelAndView("addSub.jsp");
		modelAndView.addObject("addsub1", new Subscription());
		return modelAndView;
	}
	
	@RequestMapping("/addsub")
	public ModelAndView managerFinalAddSub(@ModelAttribute Subscription sub, 
											@RequestParam(name = "mgmid") int mid) {
		ModelAndView modelAndView = new ModelAndView("subSuccess.jsp");
		subService.saveSubscription(sub, mid);
		modelAndView.addObject(sub);
		return modelAndView;
	}
	
	@RequestMapping("/viewAllU")
	public ModelAndView getAllUsers() {
		ModelAndView modelAndView=new ModelAndView("viewAllUsers.jsp");
		List<User> users = userService.getAllUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping("/logoutM")
	public ModelAndView logoutManager() {
		ModelAndView modelAndView = new ModelAndView("logoutManager.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/logM")
	public ModelAndView logoutM() {
		ModelAndView modelAndView = new ModelAndView("bFitDashBoard.jsp");
		return modelAndView;
	}
	
	
//==================================================================================================

	//USER
	
	@RequestMapping("/userH")
	public ModelAndView start(User user) {
		ModelAndView modelAndView = new ModelAndView("userHome.jsp");
		modelAndView.addObject(user);
		return modelAndView;		
	}
	
	@RequestMapping("/userS")
	public ModelAndView createhome(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("userSignUp.jsp");
		modelAndView.addObject("users1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/usersignup")
	public ModelAndView userSignUp(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("userLogin.jsp");
		userService.saveUser(user);
		modelAndView.addObject("user1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/userL")
	public ModelAndView userLogin(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("userLogin.jsp");
		modelAndView.addObject("user1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/userlogin")
	public ModelAndView userFinalLogin(@ModelAttribute User user) {
		boolean user2 = userService.userLogin(user.getId(), user);
	
		if(user2==true) {
			ModelAndView modelAndView = new ModelAndView("userDashBoard.jsp");
			List<Branch>branchs = branchService.getAllBranchs();
			List<Event> events = eventService.getAllEvents();
			List<Subscription>subscriptions = subService.getAllSubscriptions();
			modelAndView.addObject("branchs", branchs);
			modelAndView.addObject("events", events);
			modelAndView.addObject("subs", subscriptions);
			modelAndView.addObject(user2);
			return modelAndView;			
		}
		else {
			ModelAndView modelAndView = new ModelAndView("userLogin.jsp");
			modelAndView.addObject("saved", "Invalid Login Credentials");
			return modelAndView;	
		}
	}
	
	@RequestMapping("/bookE")
	public ModelAndView bookEvent() {
		ModelAndView modelAndView = new ModelAndView("bookEvent.jsp");
		modelAndView.addObject("bookEvent1", new User());
		return modelAndView;
	}
		
	
	@RequestMapping("/bookevent")
	public ModelAndView bookFinalEvent(@ModelAttribute User user, 
										@RequestParam(name = "uid") int uid) {
		boolean user2 = userService.bookEvent(uid, user);		
		if(user2==true) {
			ModelAndView modelAndView = new ModelAndView("viewAllTimeslot.jsp");
			List<Timeslot>timeslots = timeslotService.getAllTimeslots();
			modelAndView.addObject("timeslot", timeslots);
			return modelAndView;			
		}
		else {
			ModelAndView modelAndView = new ModelAndView("viewSubs.jsp");
			modelAndView.addObject(user);
			return modelAndView;	
		}
	}
	
	@RequestMapping("/bookT")
	public ModelAndView bookTimeslot() {
		ModelAndView modelAndView = new ModelAndView("bookTimeslot.jsp");
		modelAndView.addObject("bookTS1", new Timeslot());
		return modelAndView;
	}
	
	
	
	@RequestMapping("/bookTS")
	public ModelAndView bookFinalTimeSlot(@RequestParam(name = "tid") int tid, 
									  @RequestParam(name = "uid") int uid) {
		boolean b = userService.bookTimeslot(tid, uid);
		if(b==true) {
			ModelAndView modelAndView = new ModelAndView("viewBookedT.jsp");
			List<Timeslot>timeslots = timeslotService.getAllTimeslots();
			modelAndView.addObject("timeslot", timeslots);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("viewAllTimeslot.jsp");
			List<Timeslot>timeslots = timeslotService.getAllTimeslots();
			modelAndView.addObject("timeslot", timeslots);
			return modelAndView;
		}		
	}	
	
	@RequestMapping("/cancelT")
	public ModelAndView cancelTimeslot() {
		ModelAndView modelAndView = new ModelAndView("cancelTimeslot.jsp");
		modelAndView.addObject("cancelTS1", new Timeslot());
		return modelAndView;
	}
	
	@RequestMapping("/cancelTS")
	public ModelAndView cancelFinalTimeSlot(@RequestParam(name = "tid") int tid, 
									  @RequestParam(name = "uid") int uid) {
		boolean b = userService.cancelTimeslot(tid, uid);
		if(b==true) {
			ModelAndView modelAndView = new ModelAndView("viewAllTimeslot.jsp");
			List<Timeslot>timeslots = timeslotService.getAllTimeslots();
			modelAndView.addObject("timeslot", timeslots);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("viewBookedT.jsp");
			List<Timeslot>timeslots = timeslotService.getAllTimeslots();
			modelAndView.addObject("timeslot", timeslots);
			return modelAndView;
		}		
	}
	
	
	
	@RequestMapping("/buy1")
	public ModelAndView homePass() {
		ModelAndView modelAndView = new ModelAndView("bfitHomePass.jsp");
		List<Event> events = eventService.getAllEvents();
		List<Event> filteredEvents = new ArrayList<>();
		    
		   for (Event e : events) {
		        Subscription subscription = e.getSubscription(); 
		        if (subscription != null && subscription.getId() == 1) {
		            filteredEvents.add(e);
		        }
		    }	    
		    
		    modelAndView.addObject("events", filteredEvents);
		return modelAndView;
	}
		
	@RequestMapping("/buy2")
	public ModelAndView proPass() {
		ModelAndView modelAndView = new ModelAndView("bfitProPass.jsp");
		List<Event> events = eventService.getAllEvents();
		List<Event> filteredEvents = new ArrayList<>();
		    
		   for (Event e : events) {
		      Subscription subscription = e.getSubscription(); 
		        if (subscription != null && subscription.getId() == 2) {
		            filteredEvents.add(e);
		        }
		    }	    
		    
		    modelAndView.addObject("events", filteredEvents);
		return modelAndView;
	}
	
	@RequestMapping("/buy3")
	public ModelAndView elitePass() {
		ModelAndView modelAndView = new ModelAndView("bfitElitePass.jsp");
		List<Event> events = eventService.getAllEvents();
		List<Event> filteredEvents = new ArrayList<>();
		    
		   for (Event e : events) {
		        Subscription subscription = e.getSubscription(); 
		        if (subscription != null && subscription.getId() == 3) {
		            filteredEvents.add(e);
		        }
		    }	    
		    
		    modelAndView.addObject("events", filteredEvents);
		return modelAndView;
	}
	
	@RequestMapping("/buyH")
	public ModelAndView buyHomePass() {
		ModelAndView modelAndView = new ModelAndView("buyHomePass.jsp");
		modelAndView.addObject("buyHome1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/buyhome")
	public ModelAndView buyFinalHomePass(@ModelAttribute User user, 
										  @RequestParam(name = "uid") int uid) {
		boolean user2 = userService.buySubscription(user, uid);
		if(user2==true) {
			ModelAndView modelAndView = new ModelAndView("subHome.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("buyHomePass.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
	}
	
	@RequestMapping("/buyP")
	public ModelAndView buyProPass() {
		ModelAndView modelAndView = new ModelAndView("buyProPass.jsp");
		modelAndView.addObject("buyPro1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/buypro")
	public ModelAndView buyFinalProPass(@ModelAttribute User user,
			 							 @RequestParam(name = "uid") int uid) {
		boolean user2 = userService.buySubscription(user, uid);
		if(user2==true) {
			ModelAndView modelAndView = new ModelAndView("subPro.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("buyProPass.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
	}
		
	@RequestMapping("/buyE")
	public ModelAndView buyElitePass() {
		ModelAndView modelAndView = new ModelAndView("buyElitePass.jsp");
		modelAndView.addObject("buyElite1", new User());
		return modelAndView;
	}
	
	@RequestMapping("/buyelite")
	public ModelAndView buyFinalElitePass(@ModelAttribute User user,
			 							   @RequestParam(name = "uid") int uid) {
		boolean user2 = userService.buySubscription(user, uid);
		if(user2==true) {
			ModelAndView modelAndView = new ModelAndView("subElite.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("buyElitePass.jsp");
			modelAndView.addObject(user);
			return modelAndView;
		}
	}
	
	@RequestMapping("/logoutU")
	public ModelAndView logoutUser() {
		ModelAndView modelAndView = new ModelAndView("logoutUser.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/logU")
	public ModelAndView logoutU() {
		ModelAndView modelAndView = new ModelAndView("bFitDashBoard.jsp");
		return modelAndView;
	}
	
	
}
