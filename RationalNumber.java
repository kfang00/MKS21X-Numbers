public class RationalNumber extends RealNumber {
  	private int numerator, denominator;

  	/**Initialize the RationalNumber with the provided values
  	*  if the denominator is 0, make the fraction 0/1 instead
  	*@param nume the numerator
  	*@param deno the denominator
  	*/
  	public RationalNumber(int nume, int deno){
    		super(0.0);//this value is ignored! 
		numerator = nume;
		denominator = deno;
		if (deno == 0) {
			numerator = 0;
			denominator = 1;
		}

  	}

  	public double getValue(){
    		return numerator / denominator + 0.0;
  	}

  	/**
  	*@return the numerator
  	*/
  	public int getNumerator(){
    		return numerator;
  	}
  	/**
  	*@return the denominator
  	*/
  	public int getDenominator(){
    		return denominator;
  	}
  	/**
  	*@return a new RationalNumber that has the same numerator
  	*and denominator as this RationalNumber but reversed.
  	*/
  	public RationalNumber reciprocal(){
		return new RationalNumber(this.getDenominator(), this.getNumerator());
  	}
  	/**
  	*@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  	*/
  	public boolean equals(RationalNumber other){
    		return (this.getNumerator() == other.getNumerator()) && (this.getDenominator() == other.getDenominator());
  	}


  	/**
  	*@return the value expressed as "3/4" or "8/3"
  	*/
  	public String toString(){
    		return this.getNumerator() + "/" + this.getDenominator();
  	}

  	/**Calculate the GCD of two integers.
  	*@param a the first integers
  	*@param b the second integer
  	*@return the value of the GCD
  	*/
  	private static int gcd(int a, int b){
    	/*use euclids method or a better one*/
    		int x = 0;
		int y = 0;
		int r = 0;
		if (a >= b) {
			x = a;
			y = b;
		}
		else {
			x = b;
			y = a;
		}
		while(x != 0) {
			r = a % b;
			x = y;
			y = r;
		}
		return y;
  	}

  	/**
  	*Divide the numerator and denominator by the GCD
  	*This must be used to maintain that all RationalNumbers are
  	*reduced after construction.
  	*/
  	private void reduce(){
		numerator = numerator / gcd(numerator, denominator);
		denominator = denominator / gcd(numerator, denominator);

  	}
  	/******************Operations Return a new RationalNumber!!!!****************/
  	/**
  	*Return a new RationalNumber that is the product of this and the other
  	*/
  	public RationalNumber multiply(RationalNumber other){
		return new RationalNumber((this.getNumerator() * other.getNumerator()),  (this.getDenominator() * other.getDenominator()));
  	}

  	/**
  	*Return a new RationalNumber that is the this divided by the other
  	*/
  	public RationalNumber divide(RationalNumber other){
		return new RationalNumber((this.getNumerator() * other.getDenominator()),  (this.getDenominator() * other.getNumerator()));
  	}

  	/**
  	*Return a new RationalNumber that is the sum of this and the other
  	*/
  	public RationalNumber add(RationalNumber other){
    		int comden = this.getDenominator() * other.getDenominator();
		int newnum1 = this.getNumerator() * other.getDenominator();
		int newnum2 = other.getNumerator() * this.getDenominator();
		return new RationalNumber((newnum1 + newnum2),  comden);
  	}
  	/**
  	*Return a new RationalNumber that this minus the other
  	*/
  	public RationalNumber subtract(RationalNumber other){
    		int comden = this.getDenominator() * other.getDenominator();
		int newnum1 = this.getNumerator() * other.getDenominator();
		int newnum2 = other.getNumerator() * this.getDenominator();
		return new RationalNumber((newnum1 - newnum2),  comden);
  	}
} 