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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CatalogoCamereDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public CatalogoCamereDetachedCriteria() {
		super(com.iHotel.persistentModel.CatalogoCamere.class, com.iHotel.persistentModel.CatalogoCamereCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public CatalogoCamereDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.CatalogoCamereCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.DescrizioneCameraDetachedCriteria create_descrizioniCamereCriteria() {
		return new com.iHotel.persistentModel.DescrizioneCameraDetachedCriteria(createCriteria("_descrizioniCamere"));
	}
	
	public CatalogoCamere uniqueCatalogoCamere(PersistentSession session) {
		return (CatalogoCamere) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CatalogoCamere[] listCatalogoCamere(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CatalogoCamere[]) list.toArray(new CatalogoCamere[list.size()]);
	}
}

