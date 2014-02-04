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

public class PrezzoCameraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _prezzo;
	
	public PrezzoCameraDetachedCriteria() {
		super(com.iHotel.persistentModel.PrezzoCamera.class, com.iHotel.persistentModel.PrezzoCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_prezzo = new IntegerExpression("_prezzo", this.getDetachedCriteria());
	}
	
	public PrezzoCameraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.PrezzoCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_prezzo = new IntegerExpression("_prezzo", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.PeriodoDetachedCriteria create_periodoCriteria() {
		return new com.iHotel.persistentModel.PeriodoDetachedCriteria(createCriteria("_periodo"));
	}
	
	public com.iHotel.persistentModel.DescrizioneCameraDetachedCriteria create_descrizioneCameraCriteria() {
		return new com.iHotel.persistentModel.DescrizioneCameraDetachedCriteria(createCriteria("_descrizioneCamera"));
	}
	
	public PrezzoCamera uniquePrezzoCamera(PersistentSession session) {
		return (PrezzoCamera) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PrezzoCamera[] listPrezzoCamera(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PrezzoCamera[]) list.toArray(new PrezzoCamera[list.size()]);
	}
}

