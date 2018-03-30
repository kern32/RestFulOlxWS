package soap.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "keyword")

public class Key implements Serializable {
    private String name;
    private Date from;
    private Date end ;

    public Key(){}

    public Key(String name, Date from, Date end) {
        this.name = name;
        this.from = from;
        this.end = end;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setFrom(Date from) {
        this.from = from;
    }

    @XmlElement
    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public Date getFrom() {
        return from;
    }

    public Date getEnd() {
        return end;
    }
}
