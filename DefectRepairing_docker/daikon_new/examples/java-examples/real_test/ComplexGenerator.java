import org.apache.commons.math3.complex.*;
///home/changhyeon/test/DefectRepairing_docker/commons-math/src/main/java/org/apache/commons/math3/complex

//import org.apache.commons.math3.Complex;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import java.util.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
//import org.apache.commons.math3.TestUtils;
//import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;
import org.junit.Test;

public class ComplexGenerator extends Generator<Complex>{
    public ComplexGenerator() {
	super(Complex.class);
    }
    @Override
    public Complex generate(SourceOfRandomness random, GenerationStatus __ignore__) {
        //Initialize a complex object

	int  rangeMin = -100000;
	int rangeMax = 1000000;
	double temp_r = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
	double temp_i = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
	
	Complex ran_obj = new Complex(temp_r, temp_i);
	//System.out.println(temp_r);
	//System.out.println(temp_i);	
	return ran_obj;
    }


}
