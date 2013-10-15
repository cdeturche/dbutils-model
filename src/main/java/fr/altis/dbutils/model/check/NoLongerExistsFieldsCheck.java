package fr.altis.dbutils.model.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.altis.dbutils.model.schema.SchemaHelper;
import fr.altis.dbutils.model.schema.Table;

public class NoLongerExistsFieldsCheck implements Check
{
    private List<Table> referenceTables;

    private Map<String, Table> testedTablesMap;

    public NoLongerExistsFieldsCheck(List<Table> referenceTables, List<Table> testedTables)
    {
        this.referenceTables = referenceTables;
        this.testedTablesMap = new HashMap<String, Table>();
        for (Table i : testedTables)
        {
            testedTablesMap.put(i.getName(), i);
        }
    }

    @Override
    public List<Difference> check()
    {
        List<Difference> differences = new ArrayList<Difference>();
        List<String> missingFields = new ArrayList<String>();
        Table testedTable;

        for (Table referenceTable : referenceTables)
        {
            missingFields.clear();
            testedTable = testedTablesMap.get(referenceTable.getName());

            if (testedTable != null)
            {
                missingFields = CheckHelper.getMissingElements(SchemaHelper.getFieldNames(referenceTable), SchemaHelper.getFieldNames(testedTable));
            }

            for (String missingField : missingFields)
            {
                differences.add(new Difference(referenceTable.getName() + "/" + missingField, Check.NO_LONGER_EXISTS_FIELDS));
            }
        }

        return differences;
    }
}
