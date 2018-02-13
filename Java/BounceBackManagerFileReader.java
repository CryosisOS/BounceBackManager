/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-12
 */

//IMPORTS
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Path;

public class BounceBackManagerFileReader
{
    //CLASS FIELDS
    private String filename;
    private Path thisPath;
    private File thisFile
    private List<EmailBody> emailBodies;

    // DEFAULT CONSTRUCTOR
    public BounceBackManagerFileReader()
    {
        filename = null;
        emailBodies = new ArrayList<EmailBody>();
    }//END DEFAULT CONSTRUCTOR

    public void setFileName(String inFilename)
    {
        inFilename = run.EMAIL_LIST_FILE_PATH+inFilename;
        if(validateFileName(inFilename))
        {
            filename = inFilename;
            setPath();
        }//ENDIF
    }//END setFileName

    private void setPath()
    {
        thisPath = Paths.get(filename);
        setFile();
    }//END setPath

    private void setFile()
    {
        thisFile = new File(thisPath.toString());
    }//END setFile

    public List<EmailBody> getEmailBodies()
    {
        List<EmailBody> copy = new ArrayList<EmailBody>();
        copy.addAll(emailBodies);
        return copy;
    }//END getEmailBodies

    public void read() throws IOException
    {
        String line;
        FileInputStream fileStream = null;
        FileReader rdr = null;
        BufferedReader bufRdr = null;

        try
        {
            fileStream = new FileInputStream(thisFile);
            rdr = new FileReader(fileStream);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            line = bufRdr.readLine();//Skip the first line.

            while(line != null)
            {
                EmailBody newEmailBody = new EmailBody(line);
                emailBodies.add(newEmailBody);
            }//END WHILE
            fileStream.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }//END TYR
                catch(IOException ioex2)
                {
                    //Can't do anything more
                }//END CATCH
            }//ENDIF
            throw new IOException("There was an error in the file processing.");
        }//END CATCH
    }//END read

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