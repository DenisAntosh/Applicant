package ioservice;

import model.*;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.file.*;

public class JsonSerialize implements Serializer {
    @Override
    public void serialize(Applicant applicant, String path) throws IOException {
        File file = new File(path);
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        objMapper.writeValue(stringWriter, applicant);
        FileWriter fw = new FileWriter(file);
        fw.write(stringWriter.toString());
        fw.close();
    }

    @Override
    public Applicant deserialize(String path) throws IOException {
        File file = new File(path);
        byte[] mapData = Files.readAllBytes(Paths.get(file.toString()));
        Applicant appl = new ObjectMapper().readValue(mapData, Applicant.class);
        return appl;
    }
}