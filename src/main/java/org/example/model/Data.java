package org.example.model;

import lombok.AllArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
public class Data {
    private long account;
    private String name;
    private double value;

    public long getAccount() {
        return this.account;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (account != other.account)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (account ^ (account >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return "{ \n   account=" + this.getAccount() + "\n   name=" + this.getName() + "\n   value=" + this.getValue() + "\n }";
    }
}
