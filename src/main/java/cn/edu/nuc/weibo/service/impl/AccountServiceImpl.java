package cn.edu.nuc.weibo.service.impl;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.weibo.dao.interfaces.AccountMapper;
import cn.edu.nuc.weibo.entity.Account;
import cn.edu.nuc.weibo.exception.LoginException;
import cn.edu.nuc.weibo.service.interfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private transient Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountMapper accountMapper;
	
	public Account login(String email, String password) {
		log.debug("帐号{}偿试登录,密码{}", email, password);
		Account account = accountMapper.findByEmail(email);
		if( account == null 
				|| (! password.equals(account.getPassword())) ){
			log.error("{} 帐号登录错误", email);
			throw new LoginException("用户名或密码错误");
		}
		log.info("{}帐号登录成功!", email);
		return account;
	}

	/**
	 * 用户增加
	 */
	public String insertAccount(Account account) {
		
		int count = accountMapper.insert(account);
		if(count > 0){
			return "seccess";
		}else {
			return "login";
		}
		

	}

}
