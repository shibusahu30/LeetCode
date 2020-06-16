/*
Validate IP Address

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:

Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:

Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".

Example 3:

Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.
*/
/*
Let's construct step by step regex for "IPv4" as it's described in the problem description. Note, that it's not a real-life IPv4 because of leading zeros problem as we've discussed above.

Anyway, we start to construct regex pattern by using raw string in Python r'' and standard string "" in Java. Here is how its skeleton looks like for Python

diff
<img src="https://leetcode.com/problems/validate-ip-address/Figures/468/regex_ipv4.png" width="600px">
and here is for Java
<img src="https://leetcode.com/problems/validate-ip-address/Figures/468/java_ipv4.png" width="600px">
diff

Now the problem is reduced to the construction of pattern to match each chunk. It's an integer in range (0, 255), and the leading zeros are not allowed. That results in five possible situations:

    Chunk contains only one digit, from 0 to 9.

    Chunk contains two digits. The first one could be from 1 to 9, and the second one from 0 to 9.

    Chunk contains three digits, and the first one is 1. The second and the third ones could be from 0 to 9.

    Chunk contains three digits, the first one is 2 and the second one is from 0 to 4. Then the third one could be from 0 to 9.

    Chunk contains three digits, the first one is 2, and the second one is 5. Then the third one could be from 0 to 5.

Let's use pipe to create a regular expression that will match either case 1, or case 2, ..., or case 5.

diff

The job is done. The same logic could be used to construct "IPv6" regex pattern.
*/
import java.util.regex.Pattern;
class Solution {
  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern pattenIPv4 =
          Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern pattenIPv6 =
          Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

  public String validIPAddress(String IP) {
    if (pattenIPv4.matcher(IP).matches()) return "IPv4";
    return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
  }
}
