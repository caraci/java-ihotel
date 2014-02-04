/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.iHotel.persistentModel;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AlbergoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public AlbergoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
	}
	
	public AlbergoCriteria(PersistentSession session) {
		this(session.createCriteria(Albergo.class));
	}
	
	public AlbergoCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public CatalogoCamereCriteria create_catalogoCamereCriteria() {
		return new CatalogoCamereCriteria(createCriteria("_catalogoCamere"));
	}
	
	public com.iHotel.persistentModel.PrenotazioneCriteria create_prenotazioniCriteria() {
		return new com.iHotel.persistentModel.PrenotazioneCriteria(createCriteria("_prenotazioni"));
	}
	
	public com.iHotel.persistentModel.CameraCriteria create_camereCriteria() {
		return new com.iHotel.persistentModel.CameraCriteria(createCriteria("_camere"));
	}
	
	public Albergo uniqueAlbergo() {
		return (Albergo) super.uniqueResult();
	}
	
	public Albergo[] listAlbergo() {
		java.util.List list = super.list();
		return (Albergo[]) list.toArray(new Albergo[list.size()]);
	}
}

