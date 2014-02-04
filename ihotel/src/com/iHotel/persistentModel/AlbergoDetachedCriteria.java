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

public class AlbergoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	
	public AlbergoDetachedCriteria() {
		super(com.iHotel.persistentModel.Albergo.class, com.iHotel.persistentModel.AlbergoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public AlbergoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.AlbergoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.CatalogoCamereDetachedCriteria create_catalogoCamereCriteria() {
		return new com.iHotel.persistentModel.CatalogoCamereDetachedCriteria(createCriteria("_catalogoCamere"));
	}
	
	public com.iHotel.persistentModel.PrenotazioneDetachedCriteria create_prenotazioniCriteria() {
		return new com.iHotel.persistentModel.PrenotazioneDetachedCriteria(createCriteria("_prenotazioni"));
	}
	
	public com.iHotel.persistentModel.CameraDetachedCriteria create_camereCriteria() {
		return new com.iHotel.persistentModel.CameraDetachedCriteria(createCriteria("_camere"));
	}
	
	public Albergo uniqueAlbergo(PersistentSession session) {
		return (Albergo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Albergo[] listAlbergo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Albergo[]) list.toArray(new Albergo[list.size()]);
	}
}

