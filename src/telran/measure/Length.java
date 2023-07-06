package telran.measure;

public class Length implements Comparable<Length> {
	private final float amount;
	private final LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}

	@Override
	public boolean equals(Object o) {
		
		return compareTo(((Length) o).convert(lengthUnit)) == 0;
	}

	@Override
	public String toString() {
		
		return String.format("%.1f%s", amount, lengthUnit);
	}

	@Override
	public int compareTo(Length leng) {
		
		return Float.compare(amount, leng.convert(lengthUnit).amount);
	}

	public Length convert(LengthUnit lengthUnit) {

		return new Length((amount * this.lengthUnit.getValue()) / lengthUnit.getValue(), lengthUnit);
	}

}
