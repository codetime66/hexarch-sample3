package br.com.stelo.vendedor.cadastro.models.constraints;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataAlteracao {

	private static final Logger log = LoggerFactory.getLogger(TelefoneValidator.class);

	public static boolean check(Date ultimaAlteracao) {

		//final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//dateFormat.format(currentDate);
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(ultimaAlteracao);
        c.add(Calendar.HOUR, 48);
        Date ultimaAlteracaoPlus48h = c.getTime();
        
        log.info("### DataAlteracao.check("+ultimaAlteracao+"): ultimaAlteracaoPlus48h="+ultimaAlteracaoPlus48h+"; currentDate="+currentDate);
        
        return currentDate.compareTo(ultimaAlteracaoPlus48h)>=0;
	}
	
}
