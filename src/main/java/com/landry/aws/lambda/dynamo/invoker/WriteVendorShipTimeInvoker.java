package com.landry.aws.lambda.dynamo.invoker;


import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

public interface WriteVendorShipTimeInvoker
{
	@LambdaFunction(functionName = "writeVendorShipTime")
	void writeVendorShipTime( VendorShipTime input );
}