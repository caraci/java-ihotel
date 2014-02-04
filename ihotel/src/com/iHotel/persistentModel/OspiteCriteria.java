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

public class OspiteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _email;
	public final StringExpression _telefono;
	
	public OspiteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_nome = new StringExpression("_nome", this);
		_cognome = new StringExpression("_cognome", this);
		_email = new StringExpression("_email", this);
		_telefono = new StringExpression("_telefono", this);
	}
	
	public OspiteCriteria(PersistentSession session) {
		this(session.createCriteria(Ospite.class));
	}
	
	public OspiteCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public Ospite uniqueOspite() {
		return (Ospite) super.uniqueResult();
	}
	
	public Ospite[] listOspite() {
		java.util.List list = super.list();
		return (Ospite[]) list.toArray(new Ospite[list.size()]);
	}
}

