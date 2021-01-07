package mastermind.models;

public enum Error {

	WRONG_LENGTH,
	INVALID_COLORS,
	DUPLICATED,
	NULL;

	public boolean isNull() {
		return this == Error.NULL;
	}
}