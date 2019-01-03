/* Copyright 2018-2019 Wehe Web Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wwt.tools.mathtools.vector;

import java.util.Arrays;

/**
 * Immutable implementation of Vector as double array
 * @author benw@wwt
 */
public class ArrayVector implements Vector{

    private final double [] vector;
    private int hashCode;

    /**
     * protected constructor for subclassing, so that the implementation can be extended with new operations
     * For creation use the static factory method.
     * @param vector
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayVector(double [] vector) {
        this.vector = vector;
    }

    @Override
    public int getDimension() {
        return vector.length;
    }

    @Override
    public double getValueAt(int index) {
        return vector[index];
    }

    @Override
    public double getScalarProduct(Vector v) {
        if(this.getDimension() != v.getDimension()) throw new IllegalArgumentException("dimensions do not fit");
        double returnValue = 0;
        for(int i=0;i<this.getDimension();i++) {
            returnValue +=this.getValueAt(i)*v.getValueAt(i);
        }
        return returnValue;
    }

    @Override
    public Vector multiply(double scalar) {
        double [] returnValue = new double[this.getDimension()];
        for(int i=0;i<returnValue.length;i++) {
            returnValue[i] = getValueAt(i)*scalar;
        }
        return new ArrayVector(returnValue);
    }

    @Override
    public Vector add(Vector v) {
        if(this.getDimension()!= v.getDimension()) throw new IllegalArgumentException("vector dimensions are not equal");
        double [] returnValue = new double[this.getDimension()];
        for(int i=0;i<returnValue.length;i++) {
            returnValue[i] = this.getValueAt(i)+v.getValueAt(i);
        }
        return new ArrayVector(returnValue);
    }

    @Override
    public Vector switchValues(int index1, int index2) {
        if(0 > index1 || index1 > getDimension() -1 || 0 > index2 || index2 > getDimension() ) throw new IllegalArgumentException("index out of range");
        double [] returnValue = Arrays.copyOf(vector,vector.length);
        double tmp = returnValue[index1];
        returnValue[index1] = returnValue[index2];
        returnValue[index2] = tmp;
        return new ArrayVector(returnValue);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("ArrayVector{ \n");
        for(int i=0;i<this.getDimension();i++) {
            s.append(vector[i]);
            s.append("\n");
        }
        s.append("}");
        return s.toString();
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Vector))return false;
        Vector v = (Vector) other;
        if (v.getDimension() != this.getDimension()) return false;
        for (int i = 0; i < this.getDimension(); i++) {
            if(this.getValueAt(i) != v.getValueAt(i)) return false;
        }
        return(true);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(hashCode == 0) {
            for (int i = 0; i < this.getDimension(); i++) {
                result = result * 31 + Double.hashCode(this.getValueAt(i));
            }
            hashCode = result;
        }
        return result;
    }

    /**
     * Please note that a copy of the input array is created to guarantee immutability
     *
     * @param vector
     * @return
     */
    public static ArrayVector from(double [] vector) {
        double [] vectorCopy = Arrays.copyOf(vector,vector.length);
        return new ArrayVector(vectorCopy);
    }



}
