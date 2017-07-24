package jwd.Modul3.Test12.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.Modul3.Test12.app.model.Pivara;
import jwd.Modul3.Test12.app.model.Pivo;
import jwd.Modul3.Test12.app.model.VrstaPiva;
import jwd.Modul3.Test12.app.service.PivaraService;
import jwd.Modul3.Test12.app.service.PivoService;
import jwd.Modul3.Test12.app.service.VrstaPivaService;

@Component

public class TestData {
	@Autowired
	private PivaraService pivaraS;
	@Autowired
	private PivoService pivoS;
	@Autowired
	private VrstaPivaService vrstaS;

	@PostConstruct
	public void init() {

		Pivara pivara1 = new Pivara();
		pivara1.setDrzava("Srbija");
		pivara1.setNaziv("Apatinska");
		pivara1.setPib("12563");
		pivaraS.save(pivara1);

		Pivara pivara2 = new Pivara();
		pivara2.setDrzava("Srbija");
		pivara2.setNaziv("Zajecarska");
		pivara2.setPib("12553");
		pivaraS.save(pivara2);

		VrstaPiva vrsta1 = new VrstaPiva();
		vrsta1.setNaziv("Svetlo");
		vrstaS.save(vrsta1);

		VrstaPiva vrsta2 = new VrstaPiva();
		vrsta2.setNaziv("Tamno");
		vrstaS.save(vrsta2);

		Pivo pivo1 = new Pivo();
		pivo1.setIbu(1.5);
		pivo1.setNaStanju(5);
		pivo1.setNaziv("Jelen");
		pivo1.setProcenatAlkohola(2.0);
		pivo1.setPvara(pivara1);
		pivo1.setVrstaPiva(vrsta1);
		pivoS.save(pivo1);
		
		Pivo pivo2 = new Pivo();
		pivo2.setIbu(2.5);
		pivo2.setNaStanju(4);
		pivo2.setNaziv("Zajecarsko");
		pivo2.setProcenatAlkohola(2.0);
		pivo2.setPvara(pivara2);
		pivo2.setVrstaPiva(vrsta2);
		pivoS.save(pivo2);

	}

}
