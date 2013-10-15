package fr.altis.dbutils.model.check;

import java.util.ArrayList;
import java.util.List;

public class CheckHelper
{

    public static List<String> getMissingElements(List<String> references, List<String> tested)
    {
        boolean found = false;
        int i = 0;
        List<String> missingElements = new ArrayList<String>();

        for (String reference : references)
        {
            found = false;
            i = 0;
            while (i < tested.size() && !found)
            {
                if (reference.equalsIgnoreCase(tested.get(i)))
                {
                    found = true;
                }
                i++;
            }

            if (!found)
            {
                missingElements.add(reference);
            }
        }

        return missingElements;
    }

}
