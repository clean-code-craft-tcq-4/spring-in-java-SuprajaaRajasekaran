package statisticker;

import java.util.Collections;
import java.util.List;

public class Statistics 
{
	public static class Stats{
		float minimum = Float.NaN;
		float maximum = Float.NaN;;
		float avg = Float.NaN;;
		
		Stats(List<Float> nos){
			if(!nos.isEmpty())
			{
				this.minimum = Collections.min(nos);
				this.maximum = Collections.max(nos);
				this.avg = Avrg(nos);
			}
		}
		
		private Float Avrg(List<Float> numbers){
			Float total=0.0f;
			for (Float i : numbers) {
		        total += i;
		    }
			return total/numbers.size();
		}
	}
    public static Stats getStatistics(List<Float> numbers) {
    	return new Stats(numbers);
    }
}

interface IAlerter{
	public void alertSetter(boolean bool);
}

class EmailAlert implements IAlerter{
	boolean flagSent = false;
	@Override
	public void alertSetter(boolean bool) {
		this.flagSent = bool;
	}
}

class LEDAlert implements IAlerter{
	boolean flagGlows = false;
	@Override
	public void alertSetter(boolean bool) {
		this.flagGlows = bool;
	}
}

class StatsChecker{
	private float maximum;
	private IAlerter[] alerts;
	StatsChecker(float max, IAlerter[] alerts){
		this.maximum = maximum;
		this.alerts = alerts;
	}
	
	public void checkAndAlert(List<Float> numbers){
		for (Float i : numbers) {
	        if(i > maximum){
	        	for(IAlerter j: alerts)
	        		j.alertSetter(true);
	        	return;
	        }
	    }
	}
}
