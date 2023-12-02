

public class InterestImplementation implements Interest{
	
	@Override
	public void interestCalculations(float rate,double time,double amount) {	
		System.out.println("interest calculation on "+ amount +"at the rate of: "+rate+" for amount of "+time+" is: "+ (rate*time*amount)/100);
		
	}
	
	

	

}
