package ravi.services;
import Beans.*;

import Dao.*;

public class CreateSubscription {	
	public void CreateSubscritpionService(SubscriptionOrderBean myClass){
		DbConnectionSubscription db = new DbConnectionSubscription();
		try {
			db.setInDb(myClass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
