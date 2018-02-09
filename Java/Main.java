/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-08
 */

public class Main
{
    public static void next()
    {
        out.print("------------------------------------------------------------------------------\n");
        out.print("                         Author: Nathan van der Velde                         \n");
        out.print("                     Lakes Networking - Internal Software                     \n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("            This software is used for managing the subscriber list            \n");
        out.print("                   by removing un-subscribers from the list                   \n");
        out.print("------------------------------------------------------------------------------\n");
        /** DO ALL THE STUFF BETWEEN THESE TWO SECTIONS**/
        menu();


        /** END OF ALL INBETWEEN STUFF **/
        out.print("File has been written.\n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("                               Process Finished                               \n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("\n\n");
    }//END next

    public static void menu()
    {
        String inFilename;
        String outFIlename;
        String promptOne = "Please enter in the name of the CSV File that contains all the email bodies: ";
        String promptTwo = "Please enter in the name of the CSV File that you would like the required contents into: ";
        BounceBackManagerFileReader fileReader = new BounceBackManagerFileReader();

        inFilename = UserInput.getString(promptOne);
        fileReader.setFileName(inFilename);
        fileReader.readFile();
        outFilename = UserInput.getString(promptTwo);


    }//END menu
}//END class Main