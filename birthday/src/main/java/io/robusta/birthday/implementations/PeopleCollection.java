package io.robusta.birthday.implementations;

import io.robusta.birthday.interfaces.IPeople;
import io.robusta.birthday.interfaces.IPeopleCollection;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public class PeopleCollection extends ArrayList<IPeople>implements IPeopleCollection<IPeople> {

	public PeopleCollection() {

	}

	public PeopleCollection(int size) {
		super(size);
		for (int i = 0; i < size; i++) {
			IPeople people = new People();
			Random random = new Random();
			int date = random.nextInt(365) + 1;
			people.setBirthday(date);
			this.add(people);
		}
	}

	@Override
	public boolean hasSame() {
		
		for (int currentIndex = 0 ; currentIndex < this.size() ;currentIndex++){
			IPeople pCurrent = this.get(currentIndex);
			for (int j =  currentIndex +1 ; j< this.size() ; j++ ){
				IPeople pCompare = this.get(j);
				
				if (pCurrent.equals(pCompare)){
					return true;
				}
			}
		}
		
		return false;
	}

}
