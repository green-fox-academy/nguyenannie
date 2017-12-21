class Write_Number_in_Expanded_Form {
    static String expandedForm(int num) {
        String numToString = Integer.toString(num);
        StringBuilder stringBuilder = new StringBuilder();
        int powerOf10 = numToString.length();
        String result;

        for(int i = 0; i < numToString.length(); i++) {
            if(num > (int) Math.pow(10, powerOf10 - 1)) {
                stringBuilder.append(Integer.toString((num / (int) Math.pow(10, powerOf10 - 1)) * (int) Math.pow(10, powerOf10 - 1)) + " + ");
            }
            num = num - num / (int) Math.pow(10, powerOf10 - 1) * (int) Math.pow(10,powerOf10 - 1);
            powerOf10 -= 1;
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 3);

        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2);
    }
}
