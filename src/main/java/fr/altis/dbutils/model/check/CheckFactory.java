package fr.altis.dbutils.model.check;

import fr.altis.dbutils.model.schema.DBImage;
import fr.altis.dbutils.model.schema.SchemaHelper;

public class CheckFactory
{

    private final DBImage referenceDBImage;

    private final DBImage testedDBImage;

    public CheckFactory(DBImage referenceDBImage, DBImage testedDBImage)
    {
        this.referenceDBImage = referenceDBImage;
        this.testedDBImage = testedDBImage;
    }

    public Check getCheck(String name)
    {
        if (name.equals(Check.MISSING_TABLES))
        {
            return new MissingTablesCheck(SchemaHelper.getTableNames(referenceDBImage.getTables()), SchemaHelper.getTableNames(testedDBImage.getTables()));
        }
        else if (name.equals(Check.NO_LONGER_EXISTS_TABLES))
        {
            return new NoLongerExistsTablesCheck(SchemaHelper.getTableNames(referenceDBImage.getTables()), SchemaHelper.getTableNames(testedDBImage.getTables()));
        }
        else if (name.equals(Check.MISSING_FIELDS))
        {
            return new MissingFieldsCheck(referenceDBImage.getTables(), testedDBImage.getTables());
        }
        else if (name.equals(Check.NO_LONGER_EXISTS_FIELDS))
        {
            return new NoLongerExistsFieldsCheck(testedDBImage.getTables(), referenceDBImage.getTables());
        }
        else if (name.equals(Check.DIFFERENT_TYPES_FIELDS))
        {
            return new DifferentTypesFieldsCheck(referenceDBImage.getTables(), testedDBImage.getTables());
        }

        return null;
    }

}
