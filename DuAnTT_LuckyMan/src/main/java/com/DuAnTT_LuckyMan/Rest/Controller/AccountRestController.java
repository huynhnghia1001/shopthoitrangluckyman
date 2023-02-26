package com.DuAnTT_LuckyMan.Rest.Controller;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DuAnTT_LuckyMan.entity.Account;
import com.DuAnTT_LuckyMan.service.AccountService;
import com.DuAnTT_LuckyMan.service.MailService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService accService;
    
    @GetMapping
    public List<Account> getAccounts(@RequestParam("admin")Optional<Boolean> admin){
    	if(admin.orElse(false)) {
    		return accService.getAdministrators();
    	}
    	return accService.findAll();
    }
    
    @GetMapping("load")
	public List<Account> getAll() {
		return accService.findAll();
	}
    
    @GetMapping("{username}")
	public Account getOne(@PathVariable("username") String username) {
		return accService.findById(username);
	}
	@PostMapping
	public Account create(@RequestBody  Account account) {
		return accService.create(account);
	}
	@PutMapping("{username}")
	public Account update(@PathVariable("username") String username,@RequestBody Account account) {
		return accService.update(account);
	}
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accService.delete(username);
	}
	
	@PostMapping("/dky")
	public Account dangky(@RequestBody  Account account) {
		return accService.create(account);
	}
	
	@GetMapping("/findname/{fullname}")
	public List<Account> getName(@PathVariable("fullname")String fullname) {
		return accService.findByName("%" + fullname + "%");
	}
	
	@Autowired
	MailService mailService;
	
	@RequestMapping("/quen/{username}")
	public String quenk1(Model model,@PathVariable("username")String username) throws MessagingException{
			Account user = accService.findById(username);
			int pass = ThreadLocalRandom.current().nextInt(1000,9999);
			String abc = String.valueOf(pass);
			
			String mess = "Mã xác nhận của bạn là:" +  pass + "\n" + 
			"Vui lòng nhập vào để đổi mật khẩu mới."
					;
			
			mailService.sendEmailqmk(user.getEmail(),mess);
			return abc;
	}
}
