package ravi.services;

import Beans.*;
import Dao.DbConnectionSubscription;
public class CancelSubscriptionSer {

	
	public void CancelSubscritpionService(SubscriptionOrderBean myClass) {
		DbConnectionSubscription db = new DbConnectionSubscription();
		try {
			db.getFromDb(myClass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
