package ioservice;

import model.Applicant;

import javax.xml.bind.*;
import java.io.File;

public class XmlSerialize implements Serializer {
    @Override
    public void serialize(Applicant applicant, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Applicant.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(applicant, new File(path));
    }

    @Override
    public Applicant deserialize(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Applicant.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Applicant applicant = (Applicant) jaxbUnmarshaller.unmarshal(new File(path));
        return applicant;
    }
}
