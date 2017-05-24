package com.landry.aws.lambda.dynamo.invoker;

import java.util.Set;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.dynamo.domain.VendorShipTime;

public interface GentVendorShipTimesInvoker
{
	@LambdaFunction(functionName = "LambdaDynamo-devstack-GetVendorShipTimes-QZ4TN34K093V")
	Set<VendorShipTime> getVendorShipTimes( String input );
}