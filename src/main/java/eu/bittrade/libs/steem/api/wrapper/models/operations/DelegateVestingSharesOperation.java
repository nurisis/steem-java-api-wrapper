package eu.bittrade.libs.steem.api.wrapper.models.operations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.enums.OperationType;
import eu.bittrade.libs.steem.api.wrapper.enums.PrivateKeyType;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.util.SteemJUtils;

/**
 * This class represents the Steem "delegate_vesting_shares_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class DelegateVestingSharesOperation extends Operation {
    private AccountName delegator;
    private AccountName delegatee;
    @JsonProperty("vesting_shares")
    private Asset vestingShares;

    /**
     * Create a new delegate vesting shares operation.
     * 
     * Delegate vesting shares from one account to the other. The vesting shares
     * are still owned by the original account, but content voting rights and
     * bandwidth allocation are transferred to the receiving account. This sets
     * the delegation to `vesting_shares`, increasing it or decreasing it as
     * needed. (i.e. a delegation of 0 removes the delegation)
     *
     * When a delegation is removed the shares are placed in limbo for a week to
     * prevent a satoshi of VESTS from voting on the same content twice.
     */
    public DelegateVestingSharesOperation() {
        // Define the required key type for this operation.
        super(PrivateKeyType.ACTIVE);
    }

    /**
     * Get the account name of the account who delegated the vesting shares.
     * 
     * @return The account name of the delegator.
     */
    public AccountName getDelegator() {
        return delegator;
    }

    /**
     * Set the account name of the account who delegated the vesting shares.
     * 
     * @param delegator
     *            The account name of the delegator.
     */
    public void setDelegator(AccountName delegator) {
        this.delegator = delegator;
    }

    /**
     * Get the account name of the account which received the vesting shares.
     * 
     * @return The account name of the delegatee.
     */
    public AccountName getDelegatee() {
        return delegatee;
    }

    /**
     * Set the account name of the account which received the vesting shares.
     * 
     * @param delegatee
     *            The account name of the delegatee.
     */
    public void setDelegatee(AccountName delegatee) {
        this.delegatee = delegatee;
    }

    /**
     * Get the amount of vesting shares delegated.
     * 
     * @return The amount of vesting shares delegated.
     */
    public Asset getVestingShares() {
        return vestingShares;
    }

    /**
     * Set the amount of vesting shares delegated.
     * 
     * @param vestingShares
     *            The amount of vesting shares delegated.
     */
    public void setVestingShares(Asset vestingShares) {
        this.vestingShares = vestingShares;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedDelegateVestingSharesOperation = new ByteArrayOutputStream()) {
            serializedDelegateVestingSharesOperation.write(SteemJUtils
                    .transformIntToVarIntByteArray(OperationType.DELEGATE_VESTING_SHARES_OPERATION.ordinal()));
            serializedDelegateVestingSharesOperation.write(this.getDelegator().toByteArray());
            serializedDelegateVestingSharesOperation.write(this.getDelegatee().toByteArray());
            serializedDelegateVestingSharesOperation.write(this.getVestingShares().toByteArray());

            return serializedDelegateVestingSharesOperation.toByteArray();
        } catch (IOException e) {
            throw new SteemInvalidTransactionException(
                    "A problem occured while transforming the operation into a byte array.", e);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
