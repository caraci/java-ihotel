import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.iHotel.model.MAlbergo;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;


public class MainEugenioInterfacce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbihotel");
		try {			
			List<MAlbergo> result = db.query(new Predicate<MAlbergo>() {
				public boolean match(MAlbergo candidate) {
					return true;
				}
			});
			MAlbergo albergo = new MAlbergo();
			albergo = result.get(0);
			Set<String> tipologie_camere = albergo.get_catalogoCamere().get_descrizioniCamere().keySet();
			VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = new VFrameCreaPrenotazioneStep_1(tipologie_camere);
			frameCreaPrenotazioneStep_1.setVisible(true);
		}
		finally{
			db.close();
		}
		
		
	}

}
