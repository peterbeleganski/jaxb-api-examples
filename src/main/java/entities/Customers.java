package entities;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {

    @XmlElement(name = "customers")
    private List<Customer> customers = null;

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
