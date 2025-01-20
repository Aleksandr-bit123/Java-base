package com.aston.javabase.serialisation.externalizable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.Base64;

@Getter @Setter
@ToString
public class Customer2 implements Externalizable {

    private int age;
    private String name;
    private String secretCode;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getAge());
        out.writeObject(this.getName());

        byte[] secretCodeBytes = secretCode.getBytes();
        String encodedCode = Base64.getEncoder().encodeToString(secretCodeBytes);
        out.writeObject(encodedCode);

        System.out.println("secretCode is: " + encodedCode);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = (Integer) in.readObject();
        name = (String) in.readObject();

        String readObject = (String) in.readObject();
        byte[] decode = Base64.getDecoder().decode(readObject);
        secretCode = new String(decode);
    }
}
