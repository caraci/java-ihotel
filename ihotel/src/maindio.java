import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


public class maindio {

	public static void main(String[] args) {
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbdio");
		try {
			pilot p = new pilot();
			db.store(p);
		}
		finally{
			db.close();
		}

	}

}
