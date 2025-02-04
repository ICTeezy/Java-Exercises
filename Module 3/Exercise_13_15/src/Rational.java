import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    private BigInteger numerator = BigInteger.valueOf(0);
    private BigInteger denominator = BigInteger.valueOf(1);

    public Rational() {

    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd( numerator, denominator );
        this.numerator = numerator.abs().divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.valueOf(1);

        for (int k = 1; k <= n1.intValue() && k <= n2.intValue(); k++) {
            if (n1.intValue() % k == 0 && n2.intValue() % k == 0) {
                gcd = BigInteger.valueOf(k);
            }
        }

        return gcd;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational rational) {
        BigInteger n = numerator.multiply(rational.getDenominator()).add(denominator.multiply(rational.getNumerator()));
        BigInteger d = denominator.multiply(rational.getDenominator());
        return new Rational(n, d);
    }

    public Rational subtract(Rational rational) {
        BigInteger n = numerator.multiply(rational.getDenominator()).subtract(denominator.multiply(rational.getNumerator()));
        BigInteger d = denominator.multiply(rational.getDenominator());
        return new Rational(n, d);
    }

    public Rational multiply(Rational rational) {
        return new Rational(numerator.multiply(rational.getNumerator()), denominator.multiply(rational.getDenominator()));
    }

    public Rational divide(Rational rational) {
        return new Rational(numerator.multiply(rational.getDenominator()), denominator.multiply(rational.getNumerator()));
    }

    @Override
    public String toString() {
        if (denominator.intValue() == 1) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) {
            return false;
        }

        return this.subtract((Rational)o).getNumerator().intValue() == 0;
    }

    @Override
    public int compareTo( Rational o ) {
        return Integer.compare( this.subtract( o ).getNumerator().intValue(), 0 );
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

}
