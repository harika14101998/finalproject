package org.deloitte.telecom.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.deloitte.telecom.entities.*;
import org.deloitte.telecom.exceptions.*;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {
	
	  private EntityManager entityManager;

	    public EntityManager getEntityManager() {
	        return entityManager;
	    }

	    @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	@Override
	public Account accountBalanceEnquiry(String mobileNo) {
		return null;
	}

	@Override
	public void rechargeAccount(Account a, double amount) {
		a.addAmount(amount);
		getEntityManager().merge(a);
	}
	
	
	
	@Override
	public Account findAccountById(int id) {
		Account customer = entityManager.find(Account.class,id);
		return customer;
}
	 @Override
	    public Account save(Account customer) {
		 System.out.println("inside save , customer="+customer);
		 String mobileNo = customer.getMobileNo();
		 boolean exists= mobileNoExists(mobileNo);
		 if(exists) {
			 throw new MobileNoAlreadyExistsException(" Mobile No Exists");
		 }
	        customer = getEntityManager().merge(customer);
	        return customer;
	    }
	 
	 public boolean mobileNoExists(String mobileNo) {
		 Account customer = findAccountByMobileNo(mobileNo);
		 return customer!=null;
	 }
	 
	 @Override
	 public Account findAccountByMobileNo(String mobileNo) {
		 try {
		 String jql = "from Account where mobileNo=:mob";
		 TypedQuery<Account> query = entityManager.createQuery(jql, Account.class);
		 query.setParameter("mob", mobileNo);
		 Account result = query.getSingleResult();
		 return result;
		 }catch(NoResultException e) {
			 return  null;
		 }
	 }

	@Override
	public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
		Account customer = findAccountByMobileNo(mobileNo);
		if(customer == null) {
			return false;
		}
		return customer.getPassword().equals(password);
	}

	@Override
	public boolean checkCredentialsById(int id, String password) {
		Account customer = entityManager.find(Account.class, id);
		if(customer == null) {
			return false;
		}
		return customer.getPassword().equals(password);
	}

	@Override
	public List<Account> fetchUsers(int blockSize) {
		String jql = "from Account";
		TypedQuery<Account> query = entityManager.createQuery(jql,Account.class);
		query.setMaxResults(blockSize);
		List<Account> list = query.getResultList();
		return list;
	}

	@Override
	public Account transferAmount(Account a,Account b ,double amount) {
		
		a.setBalance(a.getBalance()-amount);
		b.setBalance(b.getBalance()+amount);
		return a;
	}
	 
}
	
	
