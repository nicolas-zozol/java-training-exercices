package io.robusta.birthday.implementations;

import io.robusta.birthday.interfaces.IPeople;

/**
 * Created by Nicolas Zozol on 05/10/2016.
 */
public class People implements IPeople {

	int birthday;
    public void setBirthday(int date) {
        this.birthday = date;
    }

    public int getBirthday() {
        return this.birthday;
    }

    public boolean equals(IPeople people) {
        // should be true if two people has same birthday
    		return false;
    }
}
