package com.example.demo.database;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManager;

@ApplicationScoped
public class MongoProducer {
	private static final String DATABASE = "database";

	@Inject
	@ConfigurationUnit(name = "document", fileName = "jnosql.yaml")
	private DocumentCollectionManagerFactory<MongoDBDocumentCollectionManager> entityManager;

	@Produces
	@Database(DatabaseType.DOCUMENT)
	public DocumentCollectionManager getManager() {
		return entityManager.get(DATABASE);
	}
}
