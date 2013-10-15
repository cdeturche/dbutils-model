package fr.altis.dbutils.model.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.altis.dbutils.model.schema.Field;
import fr.altis.dbutils.model.schema.Table;

public class DifferentTypesFieldsCheck implements Check
{
    private List<Table> referenceTables;

    private Map<String, Table> testedTablesMap;

    public DifferentTypesFieldsCheck(List<Table> referenceTables, List<Table> testedTables)
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
        List<String> differentFields = new ArrayList<String>();
        Table testedTable;
        Map<String, Field> fieldsMap = new HashMap<String, Field>();

        for (Table referenceTable : referenceTables)
        {
            differentFields.clear();
            testedTable = testedTablesMap.get(referenceTable.getName());

            if (testedTable != null)
            {
                for (Field f : testedTable.getFields())
                {
                    fieldsMap.put(f.getName(), f);
                }

                for (Field referenceField : referenceTable.getFields())
                {
                    Field testedField = fieldsMap.get(referenceField.getName());
                    if (testedField != null)
                    {
                        if (!testedField.getType().equalsIgnoreCase(referenceField.getType()) || testedField.getSize() != referenceField.getSize())
                        {
                            differentFields.add(referenceField.getName() + " - " + referenceField.getType() + "/" + referenceField.getSize() + " - " + testedField.getType() + "/" + testedField.getSize());
                        }
                    }
                }
            }

            for (String differentField : differentFields)
            {
                differences.add(new Difference(referenceTable.getName() + "/" + differentField, Check.DIFFERENT_TYPES_FIELDS));
            }
        }

        return differences;
    }
}
