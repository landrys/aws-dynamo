package com.landry.aws.lambda.dynamo.invoker;

import java.util.Set;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.landry.aws.lambda.dynamo.domain.VendorShipTimeSupport;

public interface GentVendorShipTimeSupportsInvoker
{
	@LambdaFunction(functionName = "GetVendorShipTimeSupports")
	Set<VendorShipTimeSupport> getVendorShipTimeSupports( String input );
}