package org.deloitte.telecom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.deloitte.telecom.dao.*;
import org.deloitte.telecom.exceptions.*;
import org.springframework.stereotype.Service;
import org.deloitte.telecom.entities.*;

@Service
@Transactional
public class AccountserviceImpl implements IAccountService {
	
	private IAccountDao dao;
	
	

	public IAccountDao getDao() {
		return dao;
	}

	public AccountserviceImpl(IAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public Account accountBalanceEnquiry(String mobileNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rechargeAccount(Account a, double amount) {
		dao.rechargeAccount(a, amount);
	}

	@Override
	public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
		return dao.checkCredentialsByMobileNo(mobileNo, password);
	}

	@Override
	public boolean checkCredentialsById(int id, String password) {
		return dao.checkCredentialsById(id, password);
	}

	@Override
	public Account save(Account customer) {
		return dao.save(customer);
	}

	@Override
	public Account findAccountById(int id) {
		return dao.findAccountById(id);
	}

	@Override
	public Account findAccountByMobileNo(String mobileNo) {
		return dao.findAccountByMobileNo(mobileNo);
	}

	@Override
	public List<Account> fetchUsers(int blockSize) {
		List<Account> customers = dao.fetchUsers(blockSize);
		return customers;
	}

	@Override
	public Account transferAmount(Account a, Account b, double amount) {
		return dao.transferAmount(a, b, amount);
	}

	}
