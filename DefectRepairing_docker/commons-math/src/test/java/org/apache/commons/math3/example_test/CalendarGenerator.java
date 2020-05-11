import  java.util.GregorianCalendar;
import java.util.TimeZone;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import  com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.util.GregorianCalendar.*;

public class CalendarGenerator extends Generator<GregorianCalendar>{

	public CalendarGenerator(){
		super(GregorianCalendar.class);
	}

	@Override
	public GregorianCalendar generate(SourceOfRandomness random, GenerationStatus __ignore__  ){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setLenient(true);

		cal.set(DAY_OF_MONTH,random.nextInt(31)+1);
		cal.set(MONTH,random.nextInt(12)+1);
		cal.set(YEAR, random.nextInt(cal.getMinimum(YEAR), cal.getMaximum(YEAR)));
		
		if (random.nextBoolean()) {
			cal.set(HOUR, random.nextInt(24));
			cal.set(MINUTE, random.nextInt(60));
			cal.set(SECOND, random.nextInt(60));
		}

		String[] allTzIds = TimeZone.getAvailableIDs();
	
		
		String tzId = random.choose(allTzIds);
		TimeZone tz = TimeZone.getTimeZone(tzId);

		cal.setTimeZone(tz);

		return cal;
	}
}
