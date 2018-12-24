package ioservice;

import model.*;

import java.io.*;

public class TxtSerialize implements Serializer {
    @Override
    public void serialize(Applicant applicant, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(applicant.toString());
        if (writer != null)
            writer.close();
    }

    @Override
    public Applicant deserialize(String path) throws IOException {
        FileInputStream inFile = new FileInputStream(path);
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);
        String[] args = text.split(";");
        Applicant applicant = new Applicant.Builder().buildApplicant(args);
        return applicant;
    }
}
