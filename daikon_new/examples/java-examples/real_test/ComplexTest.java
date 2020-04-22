/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.math3.complex.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;  //

//import org.apache.commons.math3.TestUtils;
//import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;
import static org.junit.Assert.*; //
import org.junit.Test; //
import static  org.junit.Assume.*;
import org.junit.runner.RunWith; //
import com.pholser.junit.quickcheck.*; //
import com.pholser.junit.quickcheck.generator.*; //
import edu.berkeley.cs.jqf.fuzz.*;  //


@RunWith(JQF.class)
public class ComplexTest {

    private double inf = Double.POSITIVE_INFINITY;
    private double neginf = Double.NEGATIVE_INFINITY;
    private double nan = Double.NaN;
    private double pi = FastMath.PI;
    private Complex oneInf = new Complex(1, inf);
    private Complex oneNegInf = new Complex(1, neginf);
    private Complex infOne = new Complex(inf, 1);
    private Complex infZero = new Complex(inf, 0);
    private Complex infNaN = new Complex(inf, nan);
    private Complex infNegInf = new Complex(inf, neginf);
    private Complex infInf = new Complex(inf, inf);
    private Complex negInfInf = new Complex(neginf, inf);
    private Complex negInfZero = new Complex(neginf, 0);
    private Complex negInfOne = new Complex(neginf, 1);
    private Complex negInfNaN = new Complex(neginf, nan);
    private Complex negInfNegInf = new Complex(neginf, neginf);
    private Complex oneNaN = new Complex(1, nan);
    private Complex zeroInf = new Complex(0, inf);
    private Complex zeroNaN = new Complex(0, nan);
    private Complex nanInf = new Complex(nan, inf);
    private Complex nanNegInf = new Complex(nan, neginf);
    private Complex nanZero = new Complex(nan, 0);

    @Fuzz
    public void testConstructor(@From(ComplexGenerator.class)Complex x) {
        assertTrue(x == x);
	//assertEquals(x.getReal(),x.getReal());
        //assertEquals( x.getImaginary(),x.getImaginary());
    }

    @Fuzz
    public void testConstructorNaN(@From(ComplexGenerator.class)Complex x) {
	Complex z = new Complex(x.getReal(), Double.NaN);
	assertTrue(z.isNaN());

	z = new Complex(nan, x.getImaginary());
	assertTrue(z.isNaN());

	//z = new Complex(3.0, 4.0);
	assertFalse(x.isNaN());
    }


    @Fuzz 
    public void testAbs(@From(ComplexGenerator.class)Complex x)
    {
	Complex z = new Complex(3.0, 4.0);
	assertEquals(5.0, z.abs(), 1.0e-5);
   
    }
    
    @Fuzz 
    public void testAbsNaN(@From(ComplexGenerator.class)Complex x) {
       // assertTrue(Double.isNaN(Complex.NaN.abs()));
        assertTrue(Double.isNaN(x.abs()));
    }

   
    @Fuzz 
    public void testAbsInfinite() {
        Complex z = new Complex(inf, 0);
        assertEquals(inf, z.abs(), 0);
	z = new Complex(0, neginf);
        assertEquals(inf, z.abs(), 0);
        z = new Complex(inf, neginf);
        assertEquals(inf, z.abs(), 0);
    }

    @Fuzz 
    public void testAdd(@From(ComplexGenerator.class) Complex x, @From(ComplexGenerator.class)Complex y) {
	Complex z = x.add(y);
	double temp_real = x.getReal() + y.getReal();
	double temp_imaginary = x.getImaginary() + y.getImaginary();
	Complex temp = new Complex(temp_real, temp_imaginary);
	assertEquals(z,temp);
    
    }
    
    @Fuzz
    public void testAddNaN(@From(ComplexGenerator.class) Complex x) {
        Complex z = x.add(Complex.NaN);
        assertSame(Complex.NaN, z);
        z = new Complex(1, nan);
        Complex w = x.add(z);
        assertSame(Complex.NaN, w);
    }
    
    
    @Fuzz
    public void testAddInf(@From(ComplexGenerator.class)Complex x,@From(ComplexGenerator.class)Complex y) {
        Complex z = new Complex(inf, y.getImaginary());
        Complex w = x.add(z);
        assertEquals(w.getImaginary(), x.getImaginary() + z.getImaginary());
        assertEquals(inf, w.getReal());
        Complex k = new Complex(neginf, y.getImaginary());
        assertTrue(Double.isNaN(x.add(k).getReal()));
    }
}












