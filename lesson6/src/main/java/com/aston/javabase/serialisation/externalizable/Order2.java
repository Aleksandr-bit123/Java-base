package com.aston.javabase.serialisation.externalizable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Getter @Setter
@ToString
public class Order2 implements Externalizable {

    private int orderId;
    private Customer2 customer;

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {

        out.writeObject(this.getOrderId());
        out.writeObject(this.getCustomer());
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {

        orderId = (Integer) in.readObject();
        customer = (Customer2) in.readObject();
    }
}
