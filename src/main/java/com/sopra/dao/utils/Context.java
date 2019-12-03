package com.sopra.dao.utils;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.*;

public class Context {
	
	private static Logger LOGGER = LogManager.getLogger(Context.class.getName());
	
	private static Context instance;
	private EntityManagerFactory emf;

	private Context() {
		emf = Persistence.createEntityManagerFactory("contact");
		LOGGER.info("Creation d'un persistence context : contact");
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		LOGGER.info("Recuperation d'un singleton");
		return instance;
	}

}
