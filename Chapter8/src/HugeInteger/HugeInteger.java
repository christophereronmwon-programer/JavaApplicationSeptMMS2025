
package HugeInteger;


public class HugeInteger {

    private int[] digits = new int[40];

    // Default constructor
    public HugeInteger() {
    }

    // Parse a string into the array
    public void parse(String number) {

        if (number.length() > 40)
            throw new IllegalArgumentException("Number cannot exceed 40 digits.");

        // Clear the array
        for (int i = 0; i < digits.length; i++)
            digits[i] = 0;

        int index = 39;

        for (int i = number.length() - 1; i >= 0; i--) {

            char ch = number.charAt(i);

            if (!Character.isDigit(ch))
                throw new IllegalArgumentException("Invalid number.");

            digits[index--] = ch - '0';
        }
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        boolean started = false;

        for (int digit : digits) {

            if (digit != 0)
                started = true;

            if (started)
                result.append(digit);
        }

        return started ? result.toString() : "0";
    }

    // Add two HugeIntegers
    public HugeInteger add(HugeInteger other) {

        HugeInteger answer = new HugeInteger();

        int carry = 0;

        for (int i = 39; i >= 0; i--) {

            int sum = digits[i] + other.digits[i] + carry;

            answer.digits[i] = sum % 10;

            carry = sum / 10;
        }

        return answer;
    }

    // Subtract (assumes this >= other)
    public HugeInteger subtract(HugeInteger other) {

        HugeInteger answer = new HugeInteger();

        int borrow = 0;

        for (int i = 39; i >= 0; i--) {

            int difference = digits[i] - other.digits[i] - borrow;

            if (difference < 0) {

                difference += 10;
                borrow = 1;
            } else {

                borrow = 0;
            }

            answer.digits[i] = difference;
        }

        return answer;
    }

    // Comparison methods

    public boolean isEqualTo(HugeInteger other) {

        for (int i = 0; i < 40; i++)
            if (digits[i] != other.digits[i])
                return false;

        return true;
    }

    public boolean isNotEqualTo(HugeInteger other) {

        return !isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {

        for (int i = 0; i < 40; i++) {

            if (digits[i] > other.digits[i])
                return true;

            if (digits[i] < other.digits[i])
                return false;
        }

        return false;
    }

    public boolean isLessThan(HugeInteger other) {

        return other.isGreaterThan(this);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {

        return isGreaterThan(other) || isEqualTo(other);
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {

        return isLessThan(other) || isEqualTo(other);
    }

    public boolean isZero() {

        for (int digit : digits)

            if (digit != 0)
                return false;

        return true;
    }
}
