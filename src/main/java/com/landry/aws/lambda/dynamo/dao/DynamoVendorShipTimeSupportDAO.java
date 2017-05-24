package com.landry.aws.lambda.dynamo.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;
import com.landry.aws.lambda.dynamo.manager.DynamoDBManager;

public class DynamoVendorShipTimeSupportDAO implements VendorShipTimeSupportDAO
{

	private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

	private static volatile DynamoVendorShipTimeSupportDAO instance;

	private DynamoVendorShipTimeSupportDAO()
	{
	}

	public static DynamoVendorShipTimeSupportDAO instance()
	{

		if (instance == null)
		{
			synchronized (DynamoVendorShipTimeSupportDAO.class)
			{
				if (instance == null)
					instance = new DynamoVendorShipTimeSupportDAO();
			}
		}
		return instance;
	}

	@Override
	public List<VendorShipTimeSupport> findAll()
	{
		return mapper.scan(VendorShipTimeSupport.class, new DynamoDBScanExpression());
	}

	@Override
	public void write( VendorShipTimeSupport vsts )
	{
		mapper.save(vsts, DynamoDBMapperConfig.builder()
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build());

	}

	@Override
	public void delete( VendorShipTimeSupport vsts )
	{
		mapper.delete(vsts);
	}

}
