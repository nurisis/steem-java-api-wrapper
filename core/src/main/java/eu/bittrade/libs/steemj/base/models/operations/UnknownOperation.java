package eu.bittrade.libs.steemj.base.models.operations;

import java.util.HashMap;
import java.util.Map;

import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.enums.ValidationType;
import eu.bittrade.libs.steemj.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steemj.interfaces.SignatureObject;

public class UnknownOperation extends Operation {
	public UnknownOperation() {
		super(true);
	}

	@Override
	public byte[] toByteArray() throws SteemInvalidTransactionException {
		return new byte[0];
	}

	@Override
	public void validate(ValidationType validationType) {
		return;
	}

	@Override
	public Map<SignatureObject, PrivateKeyType> getRequiredAuthorities(
			Map<SignatureObject, PrivateKeyType> requiredAuthoritiesBase) {
		return new HashMap<>();
	}

}
