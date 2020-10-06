package com.pratham.service;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.pratham.dao.ContactDao;

public class ContactServiceTest {
	
	@Test
	public void testGetNameById_01() {
		
		//1. just i have created mock obj. so we need to inject it to service layer
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
		
		//2.setting behaviour for proxyobj i.e daoimpl
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Shiva Rena");
		
		EasyMock.expect(daoProxy.findNameById(102)).andReturn("Ashok");
		
		EasyMock.replay(daoProxy);
		
		ContactServiceImpl service = (ContactServiceImpl) new ContactServiceImpl();
		
		// mock daoimpl is inejcting to service 
		service.setContactDao(daoProxy);
		
		//here i need to inject daoimpl but i dont have it.so
		//i need to mack the DaoImpl class
		String name = service.getNameById(101);
		
		assertNotNull(name);
	}

}
