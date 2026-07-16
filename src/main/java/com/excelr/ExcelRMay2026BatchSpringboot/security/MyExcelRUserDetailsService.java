package com.excelr.ExcelRMay2026BatchSpringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.DBUser;
import com.excelr.ExcelRMay2026BatchSpringboot.repository.DBUserRepository;

@Service
public class MyExcelRUserDetailsService implements UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DBUser user=dbUserRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("user does not exist");
		return new MyExclerSetAuthorities(user);
	}

}
