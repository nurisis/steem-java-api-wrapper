package eu.bittrade.libs.steemj.manual;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.AppliedOperation;
import eu.bittrade.libs.steemj.base.models.operations.Operation;
import eu.bittrade.libs.steemj.base.models.operations.UnknownOperation;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

public class ManualTests1 {

	private static final AccountName ACCOUNT_WAS_CLAIMED = new AccountName("bitker001");

	private static final Logger log = LogManager.getLogger(ManualTests1.class);

	private static SteemJ steemJ;

	public static void main(String[] args)
			throws SteemCommunicationException, SteemResponseException, JsonProcessingException {
		try {
			steemJ = new SteemJ();
		} catch (SteemCommunicationException | SteemResponseException e) {
			throw new RuntimeException("Could not create a SteemJ instance. - Test execution stopped.", e);
		}
		accountHistory();
	}

	private static void accountHistory()
			throws SteemCommunicationException, SteemResponseException, JsonProcessingException {
		log.info("=== accountHistory");
		final Map<Integer, AppliedOperation> accountHistory = steemJ.getAccountHistory(ACCOUNT_WAS_CLAIMED, 1000, 1000);
		Iterator<Integer> iKeys = new TreeSet<>(accountHistory.keySet()).iterator();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDefaultPropertyInclusion(Include.NON_NULL);
		while (iKeys.hasNext()) {
			AppliedOperation appliedOperation = accountHistory.get(iKeys.next());
			Operation op = appliedOperation.getOp();
			System.out.println("--- OP: " + op.getClass().getSimpleName());
			if (op instanceof UnknownOperation) {
				Map<String, Object> properties = op._getter();
				for (String key : properties.keySet()) {
					Object property = properties.get(key);
					String propertyType = property.getClass().getSimpleName();
					System.out.println("\t" + key + " [" + propertyType + "]:\n\t\t" + String.valueOf(property));
				}
			}
		}
	}

}
