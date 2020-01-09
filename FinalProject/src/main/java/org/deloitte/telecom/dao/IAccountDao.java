package org.deloitte.telecom.dao;

import java.util.List;
import java.util.Map;

import org.deloitte.telecom.entities.*;

public interface IAccountDao {
	
	Account accountBalanceEnquiry(String mobileNo);
	
	void rechargeAccount(Account a,double amount);
	
	boolean checkCredentialsByMobileNo(String mobileNo, String password);
	
	boolean checkCredentialsById(int id,String password);
	
	Account save(Account customer);
	
	Account findAccountById(int id);
	
	Account findAccountByMobileNo(String mobileNo);
	
	List<Account> fetchUsers(int blockSize);
	
	Account transferAmount(Account a,Account b,double amount);

	
}
