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

public class CatalogoCamereCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public CatalogoCamereCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public CatalogoCamereCriteria(PersistentSession session) {
		this(session.createCriteria(CatalogoCamere.class));
	}
	
	public CatalogoCamereCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public com.iHotel.persistentModel.DescrizioneCameraCriteria create_descrizioniCamereCriteria() {
		return new com.iHotel.persistentModel.DescrizioneCameraCriteria(createCriteria("_descrizioniCamere"));
	}
	
	public CatalogoCamere uniqueCatalogoCamere() {
		return (CatalogoCamere) super.uniqueResult();
	}
	
	public CatalogoCamere[] listCatalogoCamere() {
		java.util.List list = super.list();
		return (CatalogoCamere[]) list.toArray(new CatalogoCamere[list.size()]);
	}
}

