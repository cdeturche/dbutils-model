package fr.altis.dbutils.model.schema;

import java.util.ArrayList;
import java.util.List;

/**
 * DBImage represents the state of a database schema with :
 * <ul>
 *      <li>Tables</li>
 *      <li>Fields</li>
 *      <li>Primary keys</li>
 *      <li>Foreign keys</li>
 *      <li>Null constraints</li>
 *      <li>Check constraints</li>
 *      <li>Synonyms</li>
 *      <li>Sequences</li>
 * </ul>
 * @author Kelem
 *
 */
public class DBImage
{

    private List<Table> tables = new ArrayList<Table>();
    
    private List<Sequence> sequences = new ArrayList<Sequence>();
    
    private List<Synonym> synonyms = new ArrayList<Synonym>();

    public void setTables(List<Table> tables)
    {
        this.tables = tables;
    }

    public List<Table> getTables()
    {
        return tables;
    }

    public void setSequences(List<Sequence> sequences)
    {
        this.sequences = sequences;
    }

    public List<Sequence> getSequences()
    {
        return sequences;
    }

    public void setSynonyms(List<Synonym> synonyms)
    {
        this.synonyms = synonyms;
    }

    public List<Synonym> getSynonyms()
    {
        return synonyms;
    }
    
}
