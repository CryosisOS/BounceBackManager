/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-08
 * Date Last Modified: 2018-02-08
 */

public abstract class EmailObject
{
    //CLASS FIELDS
    private String text;
    
    public abstract String setText(String inText);

    public abstract String getText();

    public abstract String toString();

}//END abstract class EmailObject