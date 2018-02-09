/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-08
 */

//IMPORTS
import java.util.Scanner;
import static java.lang.System.out;

public class UserInput
{
    public static String getString(String prompt)
    {
        String input;
        Scanner sc = new Scanner(System.in);

        out.println(prompt);
        input = sc.nextLine();
        return input;
    }//END getString
}//END class UserInput