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

public class CameraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public CameraDetachedCriteria() {
		super(com.iHotel.persistentModel.Camera.class, com.iHotel.persistentModel.CameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public CameraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.CameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.AlbergoDetachedCriteria create_albergoCriteria() {
		return new com.iHotel.persistentModel.AlbergoDetachedCriteria(createCriteria("_albergo"));
	}
	
	public com.iHotel.persistentModel.StatoCameraDetachedCriteria create_statiCameraCriteria() {
		return new com.iHotel.persistentModel.StatoCameraDetachedCriteria(createCriteria("_statiCamera"));
	}
	
	public Camera uniqueCamera(PersistentSession session) {
		return (Camera) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Camera[] listCamera(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Camera[]) list.toArray(new Camera[list.size()]);
	}
}

