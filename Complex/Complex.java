package Complex;

public class Complex {
    private double r;
    private double i;

    Complex(double rr, double ii){
        r = rr;
        i = ii;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer().append(r);
        if(i>0){
            sb.append('+');

        }
        return sb.append(i).append('i').toString();
    }

    public double getReal(){
        return r;
    }
    public double getImaginary(){
        return i;
    }
    public double magnitude(){
        return Math.sqrt(r*r + i*i);
    }
    public Complex add(Complex other){
        return add(this, other);
    }

    public static Complex add(Complex c1, Complex c2){
        return new Complex(c1.r + c2.r , c1.i + c2.i);
    }

    public Complex subtract(Complex other)
    {
        return subtract(this, other);
    }
    public static Complex subtract (Complex c1, Complex c2)
    {
        return new Complex(c1.r - c2.r, c1.i - c2.i);
    }

    public Complex multiply(Complex other){
        return multiply(this, other);
    }

    public static Complex multiply(Complex c1, Complex c2){
        return new Complex(c1.r * c2.r - c1.i*c2.i, c1.r*c2.i+ c1.i*c2.r);
    }

    public static Complex divide(Complex c1, Complex c2){
        return new Complex(
                (c1. r*c2. r+c1. i*c2. i)/(c2. r*c2. r+c2. i*c2. i),
                (c1. i*c2. r- c1. r*c2. i)/(c2. r*c2. r+c2. i*c2. i));
    }
    public boolean equals(Object o){
        if(o.getClass() != Complex.class){
            throw new IllegalArgumentException("Complex.equals argument must be a Complex");
        }
        Complex other = (Complex)o;
        return r == other.r && i == other.i;
    }

    public int hashCode(){
        return (int)(r) | (int)i;
    }
}
