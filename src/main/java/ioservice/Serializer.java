package ioservice;

import model.Applicant;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Serializer {
    void serialize(Applicant applicant, String path) throws IOException, JAXBException;

    Applicant deserialize(String path) throws IOException, JAXBException;
}
