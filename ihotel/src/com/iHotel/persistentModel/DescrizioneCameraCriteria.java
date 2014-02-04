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

public class DescrizioneCameraCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _tipologia;
	
	public DescrizioneCameraCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_tipologia = new StringExpression("_tipologia", this);
	}
	
	public DescrizioneCameraCriteria(PersistentSession session) {
		this(session.createCriteria(DescrizioneCamera.class));
	}
	
	public DescrizioneCameraCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public CatalogoCamereCriteria create_catalogoCamereCriteria() {
		return new CatalogoCamereCriteria(createCriteria("_catalogoCamere"));
	}
	
	public com.iHotel.persistentModel.PrezzoCameraCriteria create_prezziCameraCriteria() {
		return new com.iHotel.persistentModel.PrezzoCameraCriteria(createCriteria("_prezziCamera"));
	}
	
	public DescrizioneCamera uniqueDescrizioneCamera() {
		return (DescrizioneCamera) super.uniqueResult();
	}
	
	public DescrizioneCamera[] listDescrizioneCamera() {
		java.util.List list = super.list();
		return (DescrizioneCamera[]) list.toArray(new DescrizioneCamera[list.size()]);
	}
}

