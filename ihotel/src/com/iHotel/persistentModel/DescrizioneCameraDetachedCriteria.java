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

public class DescrizioneCameraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression _tipologia;
	
	public DescrizioneCameraDetachedCriteria() {
		super(com.iHotel.persistentModel.DescrizioneCamera.class, com.iHotel.persistentModel.DescrizioneCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_tipologia = new StringExpression("_tipologia", this.getDetachedCriteria());
	}
	
	public DescrizioneCameraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.DescrizioneCameraCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_tipologia = new StringExpression("_tipologia", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.CatalogoCamereDetachedCriteria create_catalogoCamereCriteria() {
		return new com.iHotel.persistentModel.CatalogoCamereDetachedCriteria(createCriteria("_catalogoCamere"));
	}
	
	public com.iHotel.persistentModel.PrezzoCameraDetachedCriteria create_prezziCameraCriteria() {
		return new com.iHotel.persistentModel.PrezzoCameraDetachedCriteria(createCriteria("_prezziCamera"));
	}
	
	public DescrizioneCamera uniqueDescrizioneCamera(PersistentSession session) {
		return (DescrizioneCamera) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public DescrizioneCamera[] listDescrizioneCamera(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (DescrizioneCamera[]) list.toArray(new DescrizioneCamera[list.size()]);
	}
}

