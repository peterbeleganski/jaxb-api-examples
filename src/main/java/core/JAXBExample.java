package core;

import entities.Customer;
import entities.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class JAXBExample {

    static Customers customers = new Customers();

    static {
        customers.setCustomers(new ArrayList<Customer>());

        Customer customerOne = new Customer();
        customerOne.setName("Pepi");
        customerOne.setId(1);
        customerOne.setAge(20);

        Customer customerTwo = new Customer();

        customerTwo.setId(2);
        customerTwo.setAge(23);
        customerTwo.setName("Goshko");

        customers.getCustomers().add(customerOne);
        customers.getCustomers().add(customerTwo);
    }

    private static void marshalingExample() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(customers, System.out);


        jaxbMarshaller.marshal(customers, new File("customers.xml"));

    }

    private static void unMarshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();


        Customers customers = (Customers) unmarshaller.unmarshal( new File("customers.xml"));

        for (Customer custm :
                customers.getCustomers()) {
            System.out.print("id-> " + custm.getId() + " , name->");
            System.out.print(custm.getName() + ", age->");
            System.out.println(custm.getAge() + "\n");

        }
    }

    public static void main(String[] args) {
        try {
            marshalingExample();
            unMarshalingExample();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
