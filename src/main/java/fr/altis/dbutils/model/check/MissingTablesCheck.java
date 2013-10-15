package fr.altis.dbutils.model.check;

import java.util.ArrayList;
import java.util.List;

public class MissingTablesCheck implements Check
{
    private List<String> referenceTables;
    private List<String> testedTables;

    public MissingTablesCheck(List<String> referenceTables, List<String> testedTables)
    {
        this.referenceTables = referenceTables;
        this.testedTables = testedTables;
    }

    @Override
    public List<Difference> check()
    {
        List<Difference> differences = new ArrayList<Difference>();
        List<String> missingTables = CheckHelper.getMissingElements(referenceTables, testedTables);

        for (String name : missingTables)
        {
            differences.add(new Difference(name, Check.MISSING_TABLES));
        }

        return differences;
    }

}
