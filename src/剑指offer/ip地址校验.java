package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ip地址校验 {
    public static List<String> validateAddresses(List<String> addresses) {
        // Write your code here
        Pattern ipV4Pattern = Pattern.compile("((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))");
        Pattern ipV6Pattern = Pattern.compile("([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}");
        List<String> res = new ArrayList<>();
        for (String address : addresses) {
            Matcher matcher = ipV4Pattern.matcher(address);
            if (matcher.matches()) {
                res.add("IPv4");
                continue;
            }
            Matcher matcher1 = ipV6Pattern.matcher(address);
            if (matcher1.matches()) {
                res.add("IPv6");
                continue;
            }
            res.add("Neither");
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        addresses.add("121.18.19.20");
        addresses.add("2001:0db8:0000:0000:0000:ff00:0042:8329");
        addresses.add("000.012.234.23");
        List<String> strings = validateAddresses(addresses);
        System.out.println(strings);
    }
}
