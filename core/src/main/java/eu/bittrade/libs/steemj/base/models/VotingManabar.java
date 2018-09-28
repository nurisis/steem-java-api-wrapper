package eu.bittrade.libs.steemj.base.models;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eu.bittrade.libs.steemj.interfaces.HasJsonAnyGetterSetter;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VotingManabar implements HasJsonAnyGetterSetter {
	private final Map<String, Object> _properties=new HashMap<>();
	@Override
	public Map<String, Object> _getter() {
		return _properties;
	}

	@Override
	public void _setter(String key, Object value) {
		_properties.put(key, value);
	}
	public BigInteger getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(String currentMana) {
		this.currentMana = new BigInteger(currentMana);
	}
	
	public void setCurrentMana(BigInteger currentMana) {
		this.currentMana = currentMana;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(int epochSeconds) {
		this.lastUpdateTime=new Date(epochSeconds);
	}
	
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	private BigInteger currentMana;
	private Date lastUpdateTime;
}
