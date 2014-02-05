
import java.util.*;
import java.text.SimpleDateFormat;

import com.db4o.*;
import com.db4o.query.Predicate;
import com.iHotel.model.*;

public class MainQuery {
	
	public static void listResult(List<?> result){
		
		System.out.println(result.size());
		for (Object o : result) {
			System.out.println(o);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Accedo al DB
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbihotel");
		
		try {
		List<MAlbergo> result = db.query(new Predicate<MAlbergo>() {
			public boolean match(MAlbergo candidate) {
				return true;
			}
		});	
		MAlbergo albergo = result.get(0);
		MCamera camera = albergo.get_camere().get(0);
		for (Iterator iterator = camera.get_statiCamera().iterator(); iterator.hasNext();) {
			MStatoCamera statoCamera = (MStatoCamera) iterator.next();
			if(statoCamera.get_periodo().get_dataFine()<=1393628399000L && statoCamera.get_libera()==true){
				System.out.print(camera.get_numero());
			}	
		}
	
		/*
		int anno = gc.get(Calendar.YEAR);
		int mese = gc.get(Calendar.MONTH) + 1;
		int giorno = gc.get(Calendar.DATE);
		int ore = gc.get(Calendar.HOUR);
		int min = gc.get(Calendar.MINUTE);
		int sec = gc.get(Calendar.SECOND);
		
		System.out.println(giorno + "/" + mese + "/" + anno + " " + ore + ":" + min + ":" + sec);
		*/
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy � HH:mm:ss");
		//System.out.println(sdf.format(gc.getTime()));
		
		} finally {
			db.close();
		}
	}

}
