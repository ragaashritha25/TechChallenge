package ravi.web;

import Beans.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import ravi.model.ResponseSuccess;

import ravi.services.CreateSubscription;



/**
 * Servlet implementation class createSubscription
 */
@WebServlet("/createSubscription")
public class createSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public createSubscription() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		String eventUrl = (String) request.getParameter("eventUrl");
		
		PrintWriter out = response.getWriter();
		
		ResponseSuccess responseObject = new ResponseSuccess();
		responseObject.setSuccess(true);
		responseObject.setAccountIdentifier("AccountIdentifier");
			
		
		ObjectMapper mapper = new ObjectMapper();
		response.setStatus(200);
		//HttpURLConnection req= null;
		 String line = "";
		try{
			
		OAuthConsumer consumer = new DefaultOAuthConsumer("my-product-152774", "lXRDHkxmgZwMG2wu");
		URL url = new URL(eventUrl);
		
		HttpURLConnection req = (HttpURLConnection) url.openConnection();
		req.setRequestProperty("Accept", "application/json");
			consumer.sign(req);
			req.connect();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(req.getInputStream()));    
	       
	        
	        line = bf.readLine();
	        System.out.println(line);
	        
	        bf.close();


		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} 
		
		String json = mapper.writeValueAsString(responseObject);

		out.print(json);
		System.out.println(eventUrl);   

		 SubscriptionOrderBean myClass =  mapper.readValue(line,SubscriptionOrderBean.class);
		 System.out.println(myClass.getType());
		 System.out.println(myClass.getPayload().getCompany().getUuid());
		 CreateSubscription csobj = new CreateSubscription();
		 try {
			csobj.CreateSubscritpionService(myClass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
	}

}
