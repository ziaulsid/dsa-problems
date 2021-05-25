class MultiplyStrings {
    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();

        if(m == 0 || n == 0) return "0";

        int[] result = new int [m + n];
        int j_id = n-1;
        for(int i = m-1; i>=0;i--){
            for(int j=n-1; j>=0; j--){
                result[i+j+1] += ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                result[i + j] += result[i+j+1] / 10;
                result[i+j+1] %= 10;
            }
        }

        int idx = 0;
        while(idx < m+n && result[idx] == 0){
            idx++;
        }
        if(idx >= m+n) return "0";

        StringBuilder sb = new StringBuilder();
        String s = "";
        while(idx < m+n){
             s += result[idx++];
        }
        return s;
    }
}
