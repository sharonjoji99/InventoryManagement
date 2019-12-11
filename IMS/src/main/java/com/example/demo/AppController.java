package com.example.demo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;










@Controller
public class AppController {

	public String usr;
	@RequestMapping("/")
	 public String index() {
			System.out.println("You have reached landiNG page");
		   
			usr="TEST_NAME";
			return "index.html";
		    
		}
	 
	 @Controller
	 public class ownerLoginController {

	     @GetMapping("/ownerLogin")
	     public String ownerLoginForm() {

	    	 System.out.println("Owner Login page reached");
	        return "ownerLogin";
	     }
	     @PostMapping("/ownerLogin")
	     public String ownerFormPost(ownerLogin user, Model model) {
	         boolean check=false;
	         
	    	 model.addAttribute("user", user);
	         model.addAttribute("check",check);
	        
	        String name=user.getUsername();
	        String pwd=user.getPassword();
	        System.out.println("Entered detail: usr= " + name + "  pwd="+pwd);
	        
			try {
				
				checkLogin.verifyPwd(name, pwd,'o');
				if(checkLogin.flag==true) {
					System.out.println("ENTERED LOGIN IS CORRECT");
					usr=name;
					System.out.println(usr);
					
				}else {
					System.out.println("Wrong details");
					check=true;
				}
			} catch (ClassNotFoundException e) {
				System.out.println("CATCH 1");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("CATCH 2");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(checkLogin.flag==true) {
	        	return "redirect:/dashboard";
	     }else {
	    	 return "redirect:/ownerLogin";
	     }
	     }

	 }
	 @Controller
	 public class employeeLoginController{
		 
	 
	 @GetMapping("/employeeLogin")
	 public String employeeLogin(Model model) {
			System.out.println("You have reached Employee Login page");
		    return "employeeLogin.html";
		}
	 @PostMapping("/employeeLogin")
	 public String employeeFormPost(employeeLogin user,Model model) {
	 boolean check=true;
		 model.addAttribute("user", user);
		 model.addAttribute("check",check);
		 
		 
		 String name=user.getUsername();
	        String pwd=user.getPassword();
	        System.out.println("Entered detail: usr= " + name + "  pwd="+pwd);
	        
		 
		 try {
				checkLogin.verifyPwd(name, pwd,'e');
				if(checkLogin.flag==true) {
					System.out.println("ENTERED LOGIN IS CORRECT");
					usr=name;
				}else {
					System.out.println("Wrong details");
					check=false;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(checkLogin.flag==true) {
			 return "redirect:/dashboard";
		 }else {
			 return "redirect:/employeeLogin";
		 }
	 }
	 }
	 
	 
	 @Controller
	 public class signupController{
		 
		 
	 @GetMapping("/signupOwner")
	 public String signupForm(Model model) {
			System.out.println("You have reached Owner Sign up page");
		    return "signupOwner";
		}
	 
	 @PostMapping("/signupOwner")
	 public String signupFormPost(signupForm user,Model model){
		   model.addAttribute("user",user);
		   String usr=user.getUsername();
	       String pwd=user.getPassword();
	       int age=user.getAge();
	       String name=user.getName();
	    	String email=user.getEmail();
	    	String gender=user.getGender();
	    	long phone=user.getphno();
	    	boolean choice=false;
	       System.out.println("Entered detail: usr=" + usr + "  pwd="+pwd + "  age="+age+ "  name="+name+ "  email="+email+ "  gender="+gender+ "    phone="+phone );
	       try {
			insertToDb.signupDetails(usr,pwd,age,name,email,gender,choice,phone);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return "index";
	  }
	 }
	 
	 @Controller
	 public class signupController2{
		 
		 
	 @GetMapping("/signupEmployee")
	 public String signupForm(Model model) {
			System.out.println("You have reached Owner Sign up page");
		    return "signupEmployee";
		}
	 
	 @PostMapping("/signupEmployee")
	 public String signupFormPost(signupForm user,Model model){
		   model.addAttribute("user",user);
		   String usr=user.getUsername();
	       String pwd=user.getPassword();
	       int age=user.getAge();
	       String name=user.getName();
	    	String email=user.getEmail();
	    	String gender=user.getGender();
	    	long phone=user.getphno();
	    	boolean choice=true;
	       System.out.println("Entered detail: usr= " + usr + "  pwd="+pwd + "  age="+age+ "  name="+name+ "  email="+email+ "  gender="+gender);
	       try {
			insertToDb.signupDetails(usr,pwd,age,name,email,gender,choice,phone);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return "index";
	 }
	 }
	 
	 @Controller
	 public  class dashboardController {
		 
		 @RequestMapping("/dashboard")
		 String dashboard(Model model) {
			 

			 
			 model.addAttribute("test",usr);
			 return "dashboard";
		 }
	 }
	 
	 @Controller
	 public class selectShopController{
		   @GetMapping("/selectShop")
		   String selectShop(Model model){
			  
			   System.out.println("Entered select shop page ");
			   ArrayList <shopDetails> test= fetchShops.fetchAllShops();
			   shopDetails obj[]=new shopDetails[test.size()];
			   
			   for (int i = 0; i < test.size(); i++) 
		        { 
		          
		  
		            obj[i] = test.get(i); 
		  
		          
		  
		        }
			   model.addAttribute("shop", obj);
			   
			   return("selectShop.html");
		   }
		   
		   @PostMapping("/selectShop")
		   String selectShopPost(Model model,@RequestParam("s_name") String s_name,@RequestParam("s_manager") String s_manager,@RequestParam("s_loc") String s_loc,@RequestParam("s_id") int s_id,@RequestParam("s_phone") long s_phone) {
			   
			   
			   
			   System.out.println("Enetered Details : s_name:"+s_name);
			   try {
				insertToShop.shopDetails(s_name, s_id, s_loc, s_manager, s_phone);
				return "redirect:/selectShop";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   return "selectShop.html";
			   
		   }
		   
		   
		    }	
	 
	 
	 
	 @Controller
	 public class itemController{
		   @GetMapping("/inventory")
		   String selectItem(Model model){
			  int ch=1;
			  boolean b=false;
			   System.out.println("You have entered Items page ");
			   ArrayList <inventory> test= fetchItems.fetchAllItems(ch,b);
               inventory obj[]=new inventory[test.size()];
			   
			   for (int i = 0; i < test.size(); i++) 
		        { 
		          
		  
		            obj[i] = test.get(i); 
		  
		          
		  
		        }
			   model.addAttribute("item", obj);
			   
			   return("items.html");
		   }
		   
		   @PostMapping("/inventory")
		   String itemIncrease(Model model,@RequestParam("p_id") int p_id,@RequestParam("quantity") int quantity) {
			   System.out.println("Enetered Details : quantity:"+quantity+"  p_id:"+p_id); 
			   try {
				   
				
				    if(true) {
					increaseQuantity.addQuantity(p_id,quantity);
				    }else {
				    //	float dp=(float)(p_mrp-(discount/100 - p_mrp));
				    	//insertToItem.insertItem(p_name, p_id2,category,quantity2,p_mrp,discount,dp);
				    }
					return "redirect:/inventory";
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			  
			   return "items.html";
			   
		   }

		  
	 }
	 
	 
	 @Controller
	 public class itemController2{
        @PostMapping("/inventoryAdd")
	 String itemAdd(Model model,@RequestParam("p_id") int p_id,@RequestParam("quantity") int quantity,@RequestParam("p_name") String p_name,@RequestParam("p_mrp") int p_mrp,@RequestParam("s_id") int s_id,@RequestParam("discount") int discount,@RequestParam("category") String category) {
        	
			   System.out.println("Enetered Details : p_name:"+p_name+"  p_id:"+p_id);
			   float dp=(float)p_mrp-(((float)discount/(float)100)*(float)p_mrp);	   
			   
			   try {
				insertToItem.insertItem(p_name, p_id, category, quantity, p_mrp, discount,dp,s_id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	 
	 
	 return "redirect:/inventory";
	 }




	 }
	 
	 @Controller
	 public class employeeListController{
		   @GetMapping("/employeeList")
		   String selectItem(Model model){
			  
			   System.out.println("You have entered employee page ");
			   ArrayList <employeeDetails> test= fetchEmployee.fetchAllEmployees();
			   employeeDetails obj[]=new employeeDetails[test.size()];
			   
			   for (int i = 0; i < test.size(); i++) 
		        { 
		          
		  
		            obj[i] = test.get(i); 
		  
		          
		  
		        }
			   model.addAttribute("emp", obj);
			   
			   //return("items.html");
			   
			   return("employee.html");
		   }
	 
  }
	 
	 
	
	 @Controller
	 public class OwnerControlController{
		   @GetMapping("/ownerControl")
		   String selectItem(Model model){
			  
			   System.out.println("You have Owner Control page ");
			   ArrayList <ownerDetails> test= fetchOwner.fetchAllOwners();
			   ownerDetails obj[]=new ownerDetails[test.size()];
			   
			   for (int i = 0; i < test.size(); i++) 
		        { 
		          
		  
		            obj[i] = test.get(i); 
		  
		          
		  
		        }
			   model.addAttribute("own", obj);
			   
			 
			   
			   
	
			   
			   return("owner.html");
		   }
		  
		   
		   @PostMapping("/ownerControl")
		   String selectItem(Model model,@RequestParam("username") String username,@RequestParam("s_id") int s_id,@RequestParam("salary") int salary,@RequestParam("points") int points ){
			  
			   
			   System.out.println("You have Owner Control page ");
			   
			   insertToemp_shop.updateEmployee(username,s_id,salary,points);
			   
			   
			
			   
			   return("redirect:/ownerControl");
		   }
		   
		   
	 
  }
	 
	
	 
	 
	 
	 
	 
	 
	 @Controller
	 public class ShopChooseController{
	
     @PostMapping("/shopChoice")
	 String shopChoice(Model model,@RequestParam("choice") int ch) {
    	 System.out.println(ch);
    	 boolean b=true;
    	 
    	 System.out.println("You have entered Items page ");
		   ArrayList <inventory> test= fetchItems.fetchAllItems(ch, b);
         inventory obj[]=new inventory[test.size()];
		   
		   for (int i = 0; i < test.size(); i++) 
	        { 
	          
	  
	            obj[i] = test.get(i); 
	  
	          
	  
	        }
		   model.addAttribute("item",obj);
    	 return ("/shopChoice");
     }
}
	 
}

	 
	
		 
	 
	 


