package com.landry.aws.lambda.dynamo.function;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.landry.aws.lambda.dynamo.dao.DynamoVendorShipTimeDAO;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

/**
 * Lambda function that returns all vendor ship time entries.
 */
public class GetVendorShipTimes implements RequestHandler<String, List<VendorShipTime>>
{

	private static final DynamoVendorShipTimeDAO vstDao = DynamoVendorShipTimeDAO.instance();

	@Override
	public List<VendorShipTime> handleRequest( String input, Context context )
	{
		if ( input==null )
			return null;
		List<VendorShipTime> data = vstDao.findAll();
		for ( VendorShipTime bean : data )
			if ( bean.getWarehouse() == null )
				bean.setWarehouse(":");
		return data;
	}
}