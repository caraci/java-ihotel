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

public class CameraCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _numero;
	public final StringExpression _tipologia;
	
	public CameraCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_numero = new StringExpression("_numero", this);
		_tipologia = new StringExpression("_tipologia", this);
	}
	
	public CameraCriteria(PersistentSession session) {
		this(session.createCriteria(Camera.class));
	}
	
	public CameraCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public AlbergoCriteria create_albergoCriteria() {
		return new AlbergoCriteria(createCriteria("_albergo"));
	}
	
	public com.iHotel.persistentModel.StatoCameraCriteria create_statiCameraCriteria() {
		return new com.iHotel.persistentModel.StatoCameraCriteria(createCriteria("_statiCamera"));
	}
	
	public Camera uniqueCamera() {
		return (Camera) super.uniqueResult();
	}
	
	public Camera[] listCamera() {
		java.util.List list = super.list();
		return (Camera[]) list.toArray(new Camera[list.size()]);
	}
}

