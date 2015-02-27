package especies

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class ImportDataService {

	def dataSource
	
    def importData() {
		// import Brazil's species
		// File format:
		// kingdom, phylum, class, order, family, genus, scientific_name, source_id
		def file = new File('data/species_list_Brazil.csv')
		Sql sql = new Sql(dataSource)
		
		def query = "DROP TABLE IF EXISTS tmp_brazil_data;"
		sql.execute(query)
		
		query = "CREATE TABLE tmp_brazil_data (kingdom_name varchar,"+
			"phylum_name varchar, class_name varchar, order_name varchar,"+
			"family_name varchar, genus_name varchar, scientific_name varchar,"+
			"source_id integer);"
		sql.execute(query)
		
		//copy Brazil's data
		query = "COPY tmp_brazil_data (kingdom_name, phylum_name, class_name,"+
			"order_name, family_name, genus_name, scientific_name, source_id)"+
			" FROM '" + file.absolutePath + "'" +
			" WITH DELIMITER ','"+
			" ENCODING 'utf-8' CSV HEADER;"
		sql.execute(query)
		
		// clear taxon table and rebuild with imported data
		query = "DELETE FROM taxon;" +
			"INSERT INTO taxon (version, kingdom_name, phylum_name, class_name, order_name,"+
			"family_name, genus_name, scientific_name, source_id)"+
			"SELECT DISTINCT 0, kingdom_name, phylum_name, class_name,"+
			"order_name, family_name, genus_name, genus_name || ' ' || scientific_name,"+
			"source_id"+
			" FROM tmp_brazil_data;"
		sql.execute(query)
		
		
		file = new File('data/GBIF_Brazil_species_lookup.csv')
		
		query = "DROP TABLE IF EXISTS tmp_gbif_brazil_data;"+
			"CREATE TABLE tmp_gbif_brazil_data (gbif_id integer, gbif_name varchar,"+
			"rank varchar, provided_name varchar, brazils_id integer);"
		sql.execute(query)
		
		query = "COPY tmp_gbif_brazil_data (gbif_id, gbif_name, rank, provided_name,"+
			"brazils_id)"+
			" FROM '"+file.absolutePath+"'"+
			" WITH DELIMITER ','"+
			" ENCODING 'utf-8' CSV HEADER"
		sql.execute(query)
		
		query = "UPDATE taxon"+
			" SET gbif_id = tmp_gbif_brazil_data.gbif_id, gbif_name = tmp_gbif_brazil_data.gbif_name"+
			" FROM tmp_gbif_brazil_data"+
			" WHERE brazils_id = source_id AND tmp_gbif_brazil_data.gbif_id IS NOT NULL and brazils_id IS NOT NULL;"
		sql.execute(query)
		
		file = new File('data/GBIF_CITES_species_lookup.csv')
		
		query = "DROP TABLE IF EXISTS tmp_gbif_species_data;"+
			"CREATE TABLE tmp_gbif_species_data (gbif_id integer, gbif_name varchar,"+
			"rank varchar, kingdom varchar, provided_name varchar, species_id integer);"
		sql.execute(query)
		
		query = "COPY tmp_gbif_species_data (gbif_id, gbif_name, rank, kingdom,"+
			"provided_name, species_id)"+
			" FROM '"+file.absolutePath+"'"+
			" WITH DELIMITER ','"+
			" ENCODING 'utf-8' CSV HEADER"
		sql.execute(query)
		
		query = "UPDATE taxon"+
			" SET species_plus_id = species_id"+
			" FROM tmp_gbif_species_data"+
			" WHERE taxon.gbif_id = tmp_gbif_species_data.gbif_id AND"+
			" species_id IS NOT NULL AND tmp_gbif_species_data.gbif_id IS NOT NULL;"
			
		sql.execute(query)
		sql.close()
    }
}
