public class CustomAtoi {
    public static int customAtoi(String str) {
        if (str == null || str.isEmpty()) return -1;

        int i = 0, n = str.length();
        int sign = 1;
        int result = 0;

        // Handle leading sign
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
            if (n == 1) return -1; // Only '-' is not valid
        }

        for (; i < n; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return -1; // Invalid character found
            }
            result = result * 10 + (c - '0');
        }

        return sign * result;
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "-123";
        String str3 = "1a23";
        String str4 = "-";
        String str5 = "";
        String str6 = "0";

        System.out.println(customAtoi(str1)); // 123
        System.out.println(customAtoi(str2)); // -123
        System.out.println(customAtoi(str3)); // -1
        System.out.println(customAtoi(str4)); // -1
        System.out.println(customAtoi(str5)); // -1
        System.out.println(customAtoi(str6)); // 0
    }
}
