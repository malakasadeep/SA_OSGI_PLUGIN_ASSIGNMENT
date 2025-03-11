package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class filghtServiceActivator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("publisher start");
		filghtServicePublish publisherservice = new flightServicePublishIMPL();
		publishServiceRegistration=context.registerService(filghtServicePublish.class.getName(), publisherservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("publisher stop");
		publishServiceRegistration.unregister();
		
	}

}
