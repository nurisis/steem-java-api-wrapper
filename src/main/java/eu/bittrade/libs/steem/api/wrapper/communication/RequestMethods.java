package eu.bittrade.libs.steem.api.wrapper.communication;

/**
 * An enumeration for all existing API methods.
 * 
 * @author http://steemit.com/@dez1337
 */
public enum RequestMethods {
    // database_api
    GET_ACCOUNT_COUNT, GET_ACCOUNT_HISTORY, GET_ACCOUNT_VOTES, GET_ACTIVE_VOTES, GET_WITNESS_COUNT, LOOKUP_ACCOUNTS, LOOKUP_WITNESS_ACCOUNTS, GET_WITNESS_SCHEDULE, GET_CHAIN_PROPERTIES, GET_CONTENT, GET_CONTENT_REPLIES, GET_CURRENT_MEDIAN_HISTORY_PRICE, GET_MINER_QUEUE, GET_CONFIG, GET_TRENDING_TAGS, GET_HARDFORK_VERSION, GET_DYNAMIC_GLOBAL_PROPERTIES, GET_DISCUSSIONS_BY_ACTIVE, GET_DISCUSSIONS_BY_VOTES, GET_DISCUSSIONS_BY_BLOG, GET_DISCUSSIONS_BY_CHILDREN, GET_DISCUSSIONS_BY_COMMENTS, GET_DISCUSSIONS_BY_HOT, GET_DISCUSSIONS_BY_CREATED, GET_DISCUSSIONS_BY_FEED, GET_DISCUSSIONS_BY_TRENDING, GET_DISCUSSIONS_BY_TRENDING30, GET_DISCUSSIONS_BY_PROMOTED, GET_DISCUSSIONS_BY_PAYOUT, GET_DISCUSSIONS_BY_CASHOUT, GET_BLOCK_HEADER, GET_BLOCK, GET_COVERSATION_REQUEST, GET_FEED_HISTORY, GET_NEXT_SCHEDULED_HARDFORK, GET_OPEN_ORDERS, GET_ORDER_BOOK,
    // network_node_api (Not implemented as I am unable to test those methods)
    // GET_INFO, ADD_NODE, GET_CONNECTED_PEERS, GET_POTENTIAL_PEERS,
    // GET_ADVANCED_NODE_PARAMETERS, SET_ADVANCED_NODE_PARAMETERS,
    // login_api
    LOGIN, GET_API_BY_NAME, GET_VERSION,
    // network_broadcast_api
    BROADCAST_TRANSACTION, BROADCAST_TRANSACTION_SYNCHRONOUS;
}