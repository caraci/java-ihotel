/**
 * 
 */
package com.iHotel.persistence;

import java.util.Comparator;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import com.db4o.query.QueryComparator;

/**
 * @author Eugenio
 *
 */
public class Albergo implements com.db4o.ObjectContainer {

	@Override
	public void activate(Object arg0, int arg1) throws Db4oIOException,
			DatabaseClosedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean close() throws Db4oIOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void commit() throws Db4oIOException, DatabaseClosedException,
			DatabaseReadOnlyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivate(Object arg0, int arg1)
			throws DatabaseClosedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object arg0) throws Db4oIOException,
			DatabaseClosedException, DatabaseReadOnlyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExtObjectContainer ext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query query() throws DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Class<TargetType> arg0)
			throws Db4oIOException, DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0)
			throws Db4oIOException, DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0,
			QueryComparator<TargetType> arg1) throws Db4oIOException,
			DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0,
			Comparator<TargetType> arg1) throws Db4oIOException,
			DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ObjectSet<T> queryByExample(Object arg0) throws Db4oIOException,
			DatabaseClosedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rollback() throws Db4oIOException, DatabaseClosedException,
			DatabaseReadOnlyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(Object arg0) throws DatabaseClosedException,
			DatabaseReadOnlyException {
		// TODO Auto-generated method stub
		
	}
	

}
