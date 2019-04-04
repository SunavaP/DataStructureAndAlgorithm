// Java program to CountKSubStr number of substrings
// with exactly distinct characters in a given string
import java.util.Arrays;

public class CountKSubStr
{

    // Driver Program
    public static void main(String[] args)
    {
        CountKSubStr ob = new CountKSubStr();
        String ch = "abafg";
        int k = 2;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + countkDist(ch, k));
    }


    // Function to count number of substrings
    // with exactly num unique characters
    static int countkDist(String inputString, int num)
    {
        // Initialize result
        int result = 0;

        int length = inputString.length();

        // To store count of characters from 'a' to 'z'
        int countAlphabet[] = new int[26];

        // Consider all substrings beginning with
        // inputString[i]
        for (int i = 0; i < length; i++)
        {
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(countAlphabet, 0);

            // Consider all substrings between inputString[i..j]
            for (int j=i; j<length; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (countAlphabet[inputString.charAt(j) - 'a'] == 0)
                    dist_count++;

                // Increment count of current character
                countAlphabet[inputString.charAt(j) - 'a']++;

                // If distinct character count becomes num,
                // then increment result.
                if (dist_count == num)
                    result++;
            }
        }

        return result;
    }


}
