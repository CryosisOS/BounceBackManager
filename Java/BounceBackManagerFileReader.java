/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-08
 */

//IMPORTS
import java.nio.File;
import java.nio.Path;

public class BounceBackManagerFileReader
{
    //CLASS FIELDS
    private String filename;
    private List<EmailBody> emailBodies = new ArrayList<EmailBody>();

    // DEFAULT CONSTRUCTOR
    public BounceBackManagerFileReader()
    {
        filename = null;
    }//END DEFAULT CONSTRUCTOR

    public void setFileName(String inFilename)
    {
        inFilename = run.EMAIL_LIST_FILE_PATH+inFilename;
        if(validateFileName(inFilename))
        {
            filename = inFilename;
        }//ENDIF
    }//END setFileName

    public 

    private boolean validateFileName(String inFilename)
    {
        boolean isValid = false;
        Path pathToFile = Paths.get(inFilename);
        File file = new File(pathToFile.toString());
        if(file.exists() && !file.isDirectory())
        {
            isValid = true;
        }//ENDIF
        return isValid;
    }//END validateFileName
}//END class BounceBackManagerReadFile