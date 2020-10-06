package com.pratham.service;

import org.springframework.stereotype.Service;

import com.pratham.dao.ContactDao;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDao contactDao;
	
	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public String getNameById(Integer id) {
		
		//here for dao interface i have injected daoimpl so i will not npe but if we observer here name=null
		//mean actually daoimpl does't have any logic to give required name
		//so i need to provide logic to that dao interface
		String name = contactDao.findNameById(id);
		
		//logic
		String formattedName = name.toUpperCase();
		
		return formattedName;
	}

}
