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

	// XXX: Não usar fileName padrão. Bug no JNoSQL,
	// org.jnosql.artemis.configuration.json.ConfigurarableReaderJSON não carrega
	// por problema de dependencia. Provavelmente por causa do Vaadin
	@Inject
	@ConfigurationUnit(name = "document", fileName = "jnosql.yaml")
	private DocumentCollectionManagerFactory<MongoDBDocumentCollectionManager> entityManager;

	@Produces
	@Database(DatabaseType.DOCUMENT)
	public DocumentCollectionManager getManager() {
		return entityManager.get(DATABASE);
	}

	// XXX: Não inserir dois! Erro no CDI
	// @Produces
	// public MongoDBDocumentCollectionManager getMongoDBocumentCollectionManager()
	// {
	// return entityManager.get(DATABASE);
	// }
}
