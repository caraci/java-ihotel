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

public class StatoCameraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression _libera;
	
	public StatoCameraDetachedCriteria() {
		super(com.iHotel.persistentModel.StatoCamera.class, com.iHotel.persistentModel.StatoCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_libera = new BooleanExpression("_libera", this.getDetachedCriteria());
	}
	
	public StatoCameraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.StatoCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_libera = new BooleanExpression("_libera", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.PeriodoDetachedCriteria create_periodoCriteria() {
		return new com.iHotel.persistentModel.PeriodoDetachedCriteria(createCriteria("_periodo"));
	}
	
	public com.iHotel.persistentModel.CameraDetachedCriteria create_cameraCriteria() {
		return new com.iHotel.persistentModel.CameraDetachedCriteria(createCriteria("_camera"));
	}
	
	public StatoCamera uniqueStatoCamera(PersistentSession session) {
		return (StatoCamera) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public StatoCamera[] listStatoCamera(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (StatoCamera[]) list.toArray(new StatoCamera[list.size()]);
	}
}

