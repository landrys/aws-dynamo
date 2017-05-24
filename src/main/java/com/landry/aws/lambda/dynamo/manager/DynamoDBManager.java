package com.landry.aws.lambda.dynamo.manager;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBManager
{

	private static volatile DynamoDBManager instance;

	private DynamoDBMapper mapper;

	private DynamoDBManager()
	{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		mapper = new DynamoDBMapper(client);
	}

	public static DynamoDBManager instance()
	{

		if (instance == null)
		{
			synchronized (DynamoDBManager.class)
			{
				if (instance == null)
					instance = new DynamoDBManager();
			}
		}

		return instance;
	}

	public static DynamoDBMapper mapper()
	{
		DynamoDBManager manager = instance();
		return manager.mapper;
	}

}
