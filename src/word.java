package eduardo.prueba.restful;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class word {
	@XmlElement public String data;
}
