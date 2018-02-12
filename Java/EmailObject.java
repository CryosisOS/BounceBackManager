/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-12
 */

public abstract class EmailObject
{
    //CLASS FIELDS
    private String text;
    
    public abstract String setText(String inText);

    public String getText()
    {
        return text;
    }//END getText

    public String toString()
    {
        return text;
    }//END toString

}//END abstract class EmailObject