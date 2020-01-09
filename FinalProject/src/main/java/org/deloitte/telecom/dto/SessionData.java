package org.deloitte.telecom.dto;

import org.deloitte.telecom.entities.*;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    private Account customer;

	public Account getCustomer() {
		return customer;
	}

	public void setCustomer(Account customer) {
		this.customer = customer;
	}

    

}
