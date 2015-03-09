databaseChangeLog = {

	changeSet(author: "Simao (generated)", id: "1425637293054-1") {
		createTable(tableName: "meta_data") {
			column(autoIncrement: "true", name: "id", type: "bigserial") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "meta_data_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "data", type: "json")

			column(name: "taxon_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Simao (generated)", id: "1425637293054-2") {
		createTable(tableName: "taxon") {
			column(autoIncrement: "true", name: "id", type: "bigserial") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "taxon_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "cites_listing", type: "VARCHAR(255)")

			column(name: "class_name", type: "VARCHAR(255)")

			column(name: "description", type: "VARCHAR(255)")

			column(name: "family_name", type: "VARCHAR(255)")

			column(name: "gbif_id", type: "int4")

			column(name: "gbif_name", type: "VARCHAR(255)")

			column(name: "genus_name", type: "VARCHAR(255)")

			column(name: "kingdom_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "name_status", type: "VARCHAR(255)")

			column(name: "order_name", type: "VARCHAR(255)")

			column(name: "phylum_name", type: "VARCHAR(255)")

			column(name: "scientific_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "source_id", type: "int4")

			column(name: "species_plus_id", type: "int4")
		}
	}


	changeSet(author: "Simao (generated)", id: "1425637293054-9") {
		addUniqueConstraint(columnNames: "source_id", constraintName: "uk_9ggtl1fta81k4n62qb4benn4v", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "taxon")
	}

	changeSet(author: "Simao (generated)", id: "1425637293054-10") {
		addForeignKeyConstraint(baseColumnNames: "taxon_id", baseTableName: "meta_data", baseTableSchemaName: "public", constraintName: "fk_rlnsetf2sk6y8xlxjw7702sqq", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "taxon", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	include file: 'creating-autocomplete-view.groovy'
}
